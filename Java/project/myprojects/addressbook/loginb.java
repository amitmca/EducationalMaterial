package myprojects.addressbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class loginb{
public static void main(String args[]){
try{
final TextField tf1,tf2;
Label l1,l2,l3;
Button b1;


final JFrame f = new JFrame("address book");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
f.setSize(800,800);
f.setLayout(null);

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
final Connection con =
DriverManager.getConnection("jdbc:odbc:student","","");//student is the(data source name) /*procedure:go to cntrl panel,then select administrative services ,then select odbc,then select or add the dsn.*/
final Statement st = con.createStatement();

Font f1 = new Font("sansserif",Font.BOLD,24);
l3 = new Label("SHEKHAR'S ADDRESS BOOK");
l3.setBounds(150,10,800,40);
l3.setFont(f1);
f.add(l3);


l1= new Label("USER NAME :");
l1.setBounds(200,200,100,30);
f.add(l1);

 tf1 = new TextField();
tf1.setBounds( 400,200,100,30);
f.add(tf1);

l2= new Label("PASSWORD :");
l2.setBounds(200,250,100,30);
f.add(l2);

 tf2 = new TextField();
tf2.setEchoChar('*');
tf2.setBounds( 400,250,100,30);
f.add(tf2);

b1 = new Button("LOGIN");
b1.setBounds(300,350,50,30);
f.add(b1);
b1.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
            try{
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            System.out.println("got data ");
            ResultSet rs = st.executeQuery("Select * From login");
            System.out.println("table select");
            while(rs.next())
            {String s3= rs.getString(1);
            String s4=rs.getString(2);
            System.out.println("data entered"+s1+"    "+s2);
            System.out.println("inside while"+s3+"    "+s4);
            if(s3.equals(s1) && s4.equals(s2))
            { try{
             f.hide();
             Start s = new Start();

                }
                catch(Exception e3){}
            }
            }
            tf1.setText("");
            tf2.setText("");
            }
            catch(Exception e1){System.out.println("ERROR 1"+e1);}
            }
            });
f.show();
}
catch(Exception e2){System.out.println("ERROR 2"+e2);}
}
}
