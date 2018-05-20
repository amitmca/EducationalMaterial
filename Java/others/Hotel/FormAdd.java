import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class FormAdd extends JFrame implements ActionListener
{
    JLabel lno1,lname1,laddr,lcity,lcontact,larrival,lday,lno;
    JTextField tno1,tname1,taddr,tcity,tcontact,tarrival,tday,tno;
    JButton bok,bk;
    JFrame r;
    JComboBox tvt;
     String lt[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturaday","Sunday"};
    FormAdd(String title)
    {
        super(title);
	setBackground(Color.pink);
        setVisible(true);
        setSize(600,600);
        Container cc;
        cc = getContentPane();
        cc.setLayout(null );
        setVisible(true);
        setSize(500,500);
        setLayout(null);
	
 	

        lname1=new JLabel("ROOM NO");
        cc.add(lno1);
        lname1.setBounds(20,20,100,10);
        tname1=new JTextField(20);
        add(tno1);
        tname1.setBounds(110,18,180,20);


        lno1=new JLabel("FULL NAME");
        add(lname1);
        lno1.setBounds(20,50,100,10);
        tno1=new JTextField(50);
        add(tname1);
        tno1.setBounds(110,50,80,20);

	laddr =new JLabel("ADDRESS");
        add(laddr);
        laddr.setBounds(20,80,100,20);
        taddr=new JTextField(30);
        add(taddr);
        taddr.setBounds(110,80,300,50);

        lcity=new JLabel("CITY");
        add(lcity);
        lcity.setBounds(20,135,100,10);
        tcity=new JTextField(20);
        add(tcity);
        tcity.setBounds(110,135,80,20);
	
	lcontact=new JLabel("CONTACT NO");
        add(lcontact);
        lcontact.setBounds(20,175,100,10);
        tcontact=new JTextField(20);
        add(tcontact);
        tcontact.setBounds(110,175,80,20);
	
	larrival=new JLabel("ARRIVAL DATE ");
        add(larrival);
        larrival.setBounds(20,215,100,10);
        tarrival=new JTextField(60);
        add(tarrival);
        tarrival.setBounds(110,215,80,20);
	
	lday=new JLabel("DAY");
        add(lday);
        lday.setBounds(20,255,80,20);
        tvt=new JComboBox(lt);
        add(tvt);
        tvt.setBounds(110,255,80,20);
	
	lno=new JLabel("NO.OF MEMBERS");
        add(lno);
        lno.setBounds(20,295,100,10);
        tno=new JTextField(20);
        add(tno);
        tno.setBounds(120,295,80,20);
	       
        bok=new JButton("Ok");
        add(bok);
        bok.setBounds(80,350,90,25);
        bok.addActionListener(this);

         bk=new JButton("Back");
        add(bk);
        bk.setBounds(230,350,90,25);
        bk.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e)
	{

      String arg=e.getActionCommand();
      if(arg.equals("Ok"))
      {

	Connection con1=null;
	Statement stmt;
	String val,mess1="",s1;
	try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String url="jdbc:odbc:SQLITE";
		con1=DriverManager.getConnection(url," "," ");
		stmt=con1.createStatement();

//		tno1,tname1,tcity,tcontact,tarrival,tday,tno;

		String rno=tno1.getText();
		String fname=tname1.getText();
		String addr=taddr.getText();
		String city=tcity.getText();
		String contact=tcontact.getText();
		String arrival=tarrival.getText();
		String day=tday.getText();
		String no=tno.getText();
				
		s1="insert into hotel values('"+rno+"',"+"'"+fname+"',"+"'"+addr+"',"+"'"+city+"',"+"'"+contact+"',"+"'"+arrival+"',"+"'"+day+"',"+"'"+no+"')";
		stmt.executeUpdate(s1);
		/*val="Record Added";
		ta.setText(val);*/
		}
	catch(SQLException e2)
		{
		mess1=mess1+e2;
		}
	catch(ClassNotFoundException e3)
		{
		mess1=mess1+e3;
		}


	String msg="";	
 	Msgadd m=new Msgadd("Messege");
	m.setVisible(true);
        this. setVisible(false);
       }
       if(arg.equals("Back"))
       {
            options o=new options("Options Screen");
            //o.setVisible(true);
	    this.setVisible(false);
       }
    }

 }

