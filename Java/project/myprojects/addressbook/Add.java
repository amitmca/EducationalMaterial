package myprojects.addressbook;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add {

public Add() throws Exception{

final TextField tf1,tf2,tf3,tf4,tf5;
Label l1,l2,l3,l4,l5,l6;
Button b1,b2,b3;
final JFrame f;

f= new JFrame("ADDRESS BOOK");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(800,800);
f.setLayout(null);

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
final Connection con =
DriverManager.getConnection("jdbc:odbc:student","","");

Font f1 = new Font("sansserif",Font.BOLD,24);
l6 = new Label("SHEKHAR'S ADDRESS BOOK");
l6.setBounds(150,10,800,40);
l6.setFont(f1);
f.add(l6);

l1= new Label("NAME :");
l1.setBounds(200,200,100,30);
//l1.setFont(f1);
f.add(l1);

 tf1 = new TextField();
tf1.setBounds( 400,200,100,30);
f.add(tf1);

l2= new Label("PHONE NO. :");

l2.setBounds(200,250,100,30);
f.add(l2);

 tf2 = new TextField();
tf2.setBounds( 400,250,100,30);
f.add(tf2);


l3= new Label("Address :");
l3.setBounds(200,300,100,30);
f.add(l3);

 tf3 = new TextField();
tf3.setBounds( 400,300,100,30);
f.add(tf3);

l4= new Label("Email id:");
l4.setBounds(200,350,100,30);
f.add(l4);

 tf4 = new TextField();
tf4.setBounds( 400,350,100,30);
f.add(tf4);

l5= new Label("Birth date:");
l5.setBounds(200,400,100,30);
f.add(l5);

 tf5 = new TextField();
tf5.setBounds( 400,400,100,30);
f.add(tf5);

b1 = new Button("ENTER");
b1.setBounds(300,450,50,30);
b1.addActionListener( new ActionListener()
            { public void actionPerformed(ActionEvent e){
                try{
                String s1,s2,s3,s4,s5;
                s1 = tf1.getText();
                s2 = tf2.getText();
                s3 = tf3.getText();
                s4 = tf4.getText();
                s5 = tf5.getText();
PreparedStatement ps = con.prepareStatement("insert into addressbvalues(?,?,?,?,?)");
                    ps.setString(1,s1);
                ps.setString(2,s2);
                 ps.setString(3,s3);
                ps.setString(4,s4);
                ps.setString(5,s5);
            int i = ps.executeUpdate();
            System.out.println("Row Updated:"+i);
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            }
            catch(Exception e1){System.out.println("ERROR:"+e1);
	}
            }
            });

f.add(b1);

b2 = new Button("SEARCH");
b2.setBounds(400,450,50,30);
b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2) {
                try{
                Search b = new Search();
            }
                catch(Exception e3){}
                }
                });
f.add(b2);
b3 = new Button("EXIT");
b3.setBounds(480,450,50,30);
b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2) {
                try{
                System.exit(0);
            }
                catch(Exception e3){}
                }
                });
f.add(b3);
f.show();
}
} 
