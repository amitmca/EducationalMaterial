import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class connectsee extends Frame implements ActionListener
{
public static Connection con=null;
public Statement stmt;
static String s1;
public static Frame f; 
public TextField t1,t2,t3;
public Button b1;
public Label l1,l2,l3;

public connectsee()
{
t1=new TextField(10);
t2=new TextField(10);
t3=new TextField(10);
l1=new Label("Roll NO ");
l2=new Label("NAME OF Student ");
l3=new Label("Address Of  Student");
b1=new Button("Save");
this.setLayout(new GridLayout(4,4));

this.add(l1);
this.add(t1);
this.add(l2);
this.add(t2);
this.add(l3);
this.add(t3);
this.add(b1);
b1.addActionListener(this);
//setVisible(true);
}

public void actionPerformed(ActionEvent e)
{
try
{
Class.forName("org.postgresql.Driver");
con=DriverManager.getConnection("jdbc:odbc:salim");
stmt=con.createStatement();
if(e.getSource()==b1)
{
String r=t1.getText();
String n=t2.getText();
String a=t3.getText();
s1="insert into stud values('"+r+"',"+"'"+n+"','"+a+"')";
stmt.executeUpdate(s1);
System.out.println("New Record Added");
con.close();
}}
catch(Exception e1)
{
System.out.println(e1);
}
}
//con.close();

public static void main(String args[])
{
connectsee f=new connectsee();
f.setSize(300,300);
f.setTitle("my frame");
f.show();
}
}

