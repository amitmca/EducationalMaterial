import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;



public class USER1 extends JFrame implements ActionListener , Runnable
{
JTextField text_field;
JTextArea text_area;
JButton send,receive;
ReceiveMessage rm;
SendMessage sm;
Thread t=null;
boolean flag;

public USER1()
{

try{
rm = new ReceiveMessage();
sm = new SendMessage();
}catch(Exception e){}

setLayout(new FlowLayout());
setTitle("USER1"); 

text_area=new JTextArea(15,40);
text_area.setEditable(false); 


JScrollPane scroll = new JScrollPane(text_area);
add(scroll); 

text_field=new JTextField(20);
text_field.addKeyListener(new KeyAdapter()
{
public void keyPressed(KeyEvent ke)
{
if(ke.getKeyCode() == KeyEvent.VK_ENTER)
{
try{ 
String msg = new String(getTitle());
msg = msg + " : ";
msg = msg + text_field.getText(); 
sm.sendMessage(msg);
text_area.append( "\n " + msg); 
text_field.setText("");
}catch(Exception e){}
}
}
}); 


addWindowListener(new WindowAdapter()
{ 
public void windowClosing(WindowEvent we)
{
flag=true; 
}

});


add(text_field);

send=new JButton("Send");
send.setMnemonic('S');
send.addActionListener(this);
add(send); 

setSize(500,350);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setResizable(false); 
setVisible(true);

flag=false;
t=new Thread(this);
t.start(); 

}


public void run() 
{ 
for(;;)
{
try{ 
String message=rm.getMessage();
if(!message.equalsIgnoreCase("null_value")) 
{text_area.append( "\n " + message);}

if(flag)
break; 
}catch(Exception e){} 
}

}


public void actionPerformed(ActionEvent ae) 
{ 
if(ae.getSource()==send) 
{
try{
String msg = new String(getTitle());
msg = msg + " : "; 
msg = msg + text_field.getText(); 
sm.sendMessage(msg); 
text_area.append( "\n " + msg); 
text_field.setText(""); 
text_field.requestFocus(); 
}catch(Exception e){} 
}

}


public static void main(String[] args) 
{
USER1 u1 = new USER1();
u1.text_field.requestFocus();
}

}

