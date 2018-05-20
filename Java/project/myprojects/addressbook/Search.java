package myprojects.addressbook;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Search{
public Search(){

final JFrame jf = new JFrame("Search");
jf.setSize(800,800);
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setLayout(null);

Font f1 = new Font("sansserif",Font.BOLD,24);
Label l3 = new Label("SHEKHAR'S ADDRESS BOOK");
l3.setBounds(150,10,800,40);
l3.setFont(f1);
jf.add(l3);

final TextArea ta = new TextArea();
ta.setBounds(10,120,1000,600);
ta.setEditable(false);
jf.add(ta);

Label l = new Label ("search by name:");
l.setBounds(10,60,100,30);
jf.add(l);

final TextField tf = new TextField();
tf.setBounds(120,60,100,30);
jf.add(tf);


Label l1 = new Label ("TELEPHONE:");
l1.setBounds(240,60,100,30);
jf.add(l1);

final TextField tf1 = new TextField();
tf1.setBounds(360,60,100,30);
jf.add(tf1);

Button b1 = new Button("SEARCH");
b1.setBounds(480,60,50,30);
b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                    try{
                String s6,s,s1,s3,s4,s0="1233";
                Date d;
                Long s2,s5;
                 s = tf.getText();
                s6=tf1.getText();
                                if(s6.equals(""))
                               s5=Long.parseLong(s0);
                            else
                            s5 = Long.parseLong(tf1.getText());

Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        final Connection con =
DriverManager.getConnection("jdbc:odbc:student","","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("Select * From addressb");
        while(rs.next()){
                s1 = rs.getString(1);
        s2 = rs.getLong(2);
        s3 = rs.getString(3);
        s4 = rs.getString(4);
        d =  rs.getDate(5);
        System.out.println("gotstring");
        if((s1.equals(s))||(s2.equals(s5))){
        System.out.println("string equal");
        ta.append(s1+"        "+ s2+ "        " + s3+ "        " + s4 + "        "+d);
        ta.append("");
        }//eoif
        }//eowhlie
        }
        catch(Exception e1){System.out.println("ERROR="+e1);}
        }
        });

jf.add(b1);
Button b2 = new Button("ADD");
b2.setBounds(550,60,50,30);
b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                //Add a = new Add();
                }
                catch(Exception e2){}
                }
                });
jf.add(b2);
Button b3 = new Button("EXIT");
b3.setBounds(620,60,50,30);
b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2) {
                try{
                System.exit(0);
            }
                catch(Exception e3){}
                }
                });
jf.add(b3);

jf.show();
}
}
