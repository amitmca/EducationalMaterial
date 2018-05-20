import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;



import javax.swing.*;

public class Server extends JFrame {

private JTextArea displayarea;
private JTextField textfield = null;
private Socket connection;
private ServerSocket server;
private int counter = 1;
private ObjectInputStream input;
private ObjectOutputStream output;
private String msg;
private String xxx;



public Server()

{

super ("Server's Application");
Container container = getContentPane();

textfield = new JTextField();



textfield.addActionListener(

new ActionListener() {
  public void actionPerformed( ActionEvent event) {
     String mout =      textfield.getText();
               textfield.setText("");

     
  try {
      sendData (mout);
      }

catch ( IOException ioException ) {
displayarea.append ("ERROR IN WRITING");
             }

   
               }
});


container.add(textfield , BorderLayout.NORTH);

displayarea = new JTextArea();
container.add(new JScrollPane (displayarea), BorderLayout.CENTER);
setSize( 400, 400);
setVisible (true);
}

//          -------------------------------------


public void runServer()

{

try {

server = new ServerSocket(600,10);

while ( true ) {

waitforconnection();

getstreams();

pconnection();

close();

++ counter;

}
}


catch ( IOException ioException ) {
ioException.printStackTrace();

}
}


//          -------------------------------------


private void waitforconnection() throws IOException

{
displayarea.append ("Waiting for connection...\n");
connection = server.accept();
displayarea.append( "Connection " + counter +
        " received from: " +
        connection.getInetAddress().getHostName() );


}

//          -------------------------------------



public void getstreams() throws IOException {

output = new ObjectOutputStream (connection.getOutputStream() );
output.flush();

input = new ObjectInputStream (connection.getInputStream() );
displayarea.append("\nGot I/O Streams \n");

                  }

//          -------------------------------------


public void pconnection() throws IOException{



msg = "CONNECTED...";
output.writeObject ( msg );
output.flush();

do {

try{
      msg = (String) input.readObject();
      displayarea.append("\n<< CLIENT REQUESTED <<  " + msg);
       excommand(msg);
      }

catch (ClassNotFoundException classNotFoundException ) {
displayarea.append("UNKNOWN");
                                                      }
  }

while  (!msg.equals("TERMINATE") );


}




//          -------------------------------------

public void excommand(String z) {

try {

int exitv;
int pstatus;
int l;
String ll;
String cmd;

// you can write the next 20 lines in a very simpler way,using 1 command,but i was demonstrating some string functions//
String check = new String( ".exe");

String c = z;

l = z.length();


if (l<5 )
cmd = "cmd.exe /c "+ c;
else

{

ll = c.substring( l-4 , l );
if ( ll.regionMatches (true,0,check,0,4) )
cmd = c;
else
cmd = "Command.com /c "+ c;

}


Process p = Runtime.getRuntime().exec(cmd);

try {
pstatus = p.waitFor();

   }

catch (InterruptedException e) {
pstatus = -1;
                              }

BufferedReader subp = new BufferedReader  (new InputStreamReader(p.getInputStream() ));
BufferedReader gar =  new BufferedReader  (new InputStreamReader(p.getErrorStream() ));


String str;

while ( ( str = subp.readLine() ) != null ) {
//System.out.println(str);
sendData (str);
//displayarea.append(str+"\n");
                  }
     
while ( ( str = gar.readLine() ) != null ) {
//System.out.println(str);
sendData (str);
//displayarea.append(str+"\n");
                 }

//try {

//p.wait(300);

//   }

//catch (InterruptedException kt) {
//System.err.println(kt);
//p.destroy();
//                }


//catch (IllegalMonitorStateException ktz) {
//System.err.println(ktz);
//p.destroy();
     //          }

exitv = p.exitValue();


System.out.println();
if (pstatus == 0 ){
//System.out.println("Process Successfully Completed");
String xxx = new String ("\nCommand> " + c +" < "+ " Process Successfully Completed\n");
sendData (xxx);
displayarea.append( xxx);
                }

else
{
//System.out.println("Process Not Completed");
displayarea.append("Command> " + c + " <"+ " \nProcess Not Completed \n");
sendData("Command> " + c + " <"+ " \nProcess Not Completed \n");
}


//System.out.println();
//System.out.println("Process Value After Exiting Is: " + exitv );
displayarea.append("Process Value After Exiting Is: " + exitv +"\n" );
sendData("Command> " + c + " <"+ " Process Value After Exiting Is: " + exitv +"\n");

//subp.close();

 }

catch (IOException e) {
System.err.println(e);
           }

//p.setTimeout(3000);


}




//          -------------------------------------





public void sendData (String x)  throws IOException {

output.writeObject ( x );
//displayarea.append ("\nServer >>:  " + x );
output.flush();

}




//          -------------------------------------




public void close() throws IOException{

displayarea.append("\nDISCONNECTING ... \n");
sendData ("\nDISCONNECTED");
output.close();
input.close();
connection.close();

           }


//          -------------------------------------



public static void main ( String args[] )

{
Server application = new Server();

application.setDefaultCloseOperation(
JFrame.EXIT_ON_CLOSE );

application.runServer();

}

} 
