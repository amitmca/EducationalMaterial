import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class client extends JFrame    {



private JTextField entercommand;
private JTextArea displayarea,displayarea1;
private Socket clconnection;
private String servern;
private ObjectOutputStream output ;
private ObjectInputStream  input ;
private String msg;

       
public client ( String host ) {

super("Client's Application");
servern = host;
Container container = getContentPane();
entercommand = new JTextField( "Enter Command here");
container.add(entercommand, BorderLayout.SOUTH);
displayarea = new JTextArea();
container.add(new JScrollPane (displayarea), BorderLayout.CENTER);

setSize( 500, 500);
setVisible (true);

entercommand.addActionListener(

new ActionListener() {
  public void actionPerformed( ActionEvent event) {
     String ord =      entercommand.getText();

     
  try {
      sendData (ord);
      }

catch ( IOException ioException ) {
displayarea.append ("ERROR IN WRITING\n");
             }

   
               }
});



}

//          -------------------------------------

public void runClient()

{

try {

connectToServer();

getstreams();

pconnection();

close();

   }


catch ( IOException ioException ) {
ioException.printStackTrace();

                                 }
}



//          -------------------------------------

private void connectToServer() throws IOException

{

try {

displayarea.setText ("Attempting Connection ...\n");
clconnection = new Socket( InetAddress.getByName ( servern ), 600);
displayarea.append( "Connected To: " + clconnection.getInetAddress().getHostName() );
   }

catch ( IOException d ) {
System.out.println(d);
System.out.println("Exception for Connection");
                      }

}


//          -------------------------------------





public void getstreams() throws IOException {


try {

output = new ObjectOutputStream (clconnection.getOutputStream() );
output.flush();

input = new ObjectInputStream (clconnection.getInputStream() );
displayarea.append("\nGot I/O Streams \n");

  }

catch (IOException s) {
System.out.println(s);
System.out.println("Exception from GETSTREAM()");
                     }

                  }



//          -------------------------------------

public void pconnection() throws IOException {




do {

  try{
      msg = (String) input.readObject();
      displayarea.append("\n" + msg);
      }



catch (ClassNotFoundException classNotFoundException ) {
displayarea.append("UNKNOWN TEXT");
                                                      }


  }

while (!msg.equals("TERMINATE")  );

                            
                                             }

//          -------------------------------------


public void sendData (String x)  throws IOException {

output.writeObject ( x );
entercommand.setText("");
output.flush();

}




//          -------------------------------------


public void close() throws IOException {

displayarea.append("\n DISCONNECTING ... ");
output.close();
input.close();
clconnection.close();

            }





//          -------------------------------------




public static void main( String[] args ) {

client app;

if (args.length == 0 )
app = new client("127.0.0.1");
else
app = new client( args [0] ) ;

app.runClient();

app.setDefaultCloseOperation(
JFrame.EXIT_ON_CLOSE );


                                         }
}

