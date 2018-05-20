import java.sql.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class mca118
{
public static void main(String[] args)
{
mca119 pp=new mca119();
pp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
pp.setSize(400,400);
pp.show();
}
}
class mca119 extends JFrame implements ActionListener
{
JTextField t1,t2,t3;
JLabel l1,l2,l3;
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
ResultSet rs,rs1;
Statement st;
mca119()
{
Container d=getContentPane();
d.setLayout(null);
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
String s="Jdbc:Odbc:mcastud";
Connection con=DriverManager.getConnection(s,"","");
st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs=st.executeQuery("select * from stud");
}
catch(Exception ee){
System.out.println("Connection Time"+ee);
}
t1=new JTextField(20);
t2=new JTextField(20);
t3=new JTextField(20);
l1=new JLabel("Enter Rollno",JLabel.LEFT);
l2=new JLabel("Enter Name",JLabel.LEFT);
l3=new JLabel("Enter Class",JLabel.LEFT);
b1=new JButton("First");
b2=new JButton("Last");
b3=new JButton("Next");
b4=new JButton("Prev");
b5=new JButton("Add");
b6=new JButton("Save");
b7=new JButton("Del");
b8=new JButton("Search");
b9=new JButton("Exit");
t1.setFont(new Font("Courier",Font.BOLD,22));
t2.setFont(new Font("Courier",Font.BOLD,22));
t3.setFont(new Font("Courier",Font.BOLD,22));
l1.setFont(new Font("Garamond",Font.BOLD,20));
l2.setFont(new Font("Garamond",Font.BOLD,20));
l3.setFont(new Font("Garamond",Font.BOLD,20));
b1.setFont(new Font("Garamond",Font.BOLD,20));
b2.setFont(new Font("Garamond",Font.BOLD,20));
b3.setFont(new Font("Garamond",Font.BOLD,20));
b4.setFont(new Font("Garamond",Font.BOLD,20));
b5.setFont(new Font("Garamond",Font.BOLD,20));
b6.setFont(new Font("Garamond",Font.BOLD,20));
b7.setFont(new Font("Garamond",Font.BOLD,20));
b8.setFont(new Font("Garamond",Font.BOLD,20));
b9.setFont(new Font("Garamond",Font.BOLD,20));
l1.setBounds(70,60,125,30);
t1.setBounds(205,60,125,30);

l2.setBounds(70,120,125,30);
t2.setBounds(205,120,125,30);

l3.setBounds(70,180,125,30);
t3.setBounds(205,180,125,30);

b1.setBounds(25,300,80,30);
b2.setBounds(115,300,80,30);
b3.setBounds(205,300,80,30);
b4.setBounds(295,300,80,30);

b5.setBounds(25,330,80,30);
b6.setBounds(115,330,80,30);
b7.setBounds(205,330,80,30);
b8.setBounds(295,330,80,30);
b9.setBounds(25,360,350,30);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
b6.addActionListener(this);
b7.addActionListener(this);
b8.addActionListener(this);
b9.addActionListener(this);
d.add(t1);
d.add(t2);
d.add(t3);
d.add(l1);
d.add(l2);
d.add(l3);
d.add(b1);
d.add(b2);
d.add(b3);
d.add(b4);
d.add(b5);
d.add(b6);
d.add(b7);
d.add(b8);
d.add(b9);
}
public void actionPerformed(ActionEvent tt)
{
boolean flag=false;
try
{
if(tt.getSource()==b1)
{
rs.first();
flag=true;
}
else
if(tt.getSource()==b2)
{
rs.last();
flag=true;
}
else
if(tt.getSource()==b3)
{
rs.next();
if(rs.isAfterLast())
rs.first();
flag=true;
}
else
if(tt.getSource()==b4)
{
rs.previous();
if(rs.isBeforeFirst())
rs.last();
flag=true;
}
else
if(tt.getSource()==b5)
{
t1.setText("");
t2.setText("");
t3.setText("");
}
else
if(tt.getSource()==b6)
{
rs.moveToInsertRow();
rs.updateInt("rollno",Integer.parseInt(t1.getText()));
rs.updateString("name",t2.getText());
rs.updateString("class",t3.getText());
rs.insertRow();
JOptionPane.showMessageDialog(null,"Saved","My Project",1);
}
else
if(tt.getSource()==b7)
{
int xx=Integer.parseInt(JOptionPane.showInputDialog("Enter Rollno To Delete"));
boolean delflag=false;
rs1=st.executeQuery("select * from stud");
while(rs1.next())
{
if(rs1.getInt("rollno")==xx)
{
delflag=true;
rs1.deleteRow();
JOptionPane.showMessageDialog(this,"Record Deleted","My proj",2);
}
}
if(delflag==false)
JOptionPane.showMessageDialog(this,"Record Not Found","My proj",2);
}
else
if(tt.getSource()==b8)
{
int xx=Integer.parseInt(JOptionPane.showInputDialog("Enter Rollno To Search"));
boolean searchflag=false;
rs1=st.executeQuery("select * from stud");
while(rs1.next())
{
if(rs1.getInt("rollno")==xx)
{
searchflag=true;
t1.setText(rs1.getInt("rollno")+"");
t2.setText(rs1.getString("name"));
t3.setText(rs1.getString("class"));
}
}
if(searchflag==false)
JOptionPane.showMessageDialog(this,"Record Not Found","My proj",2);
}
else
if(tt.getSource()==b9)
dispose();
if(flag==true)
{
t1.setText(rs.getInt("rollno")+"");
t2.setText(rs.getString("name"));
t3.setText(rs.getString("class"));
}
}
catch(Exception ee){
System.out.println(ee);
}
}
}


