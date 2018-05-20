import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Company extends JFrame implements ActionListener,ItemListener
	{
	JLabel lcode,laddr,ltype,lcname,lestr,lcno,lcper,lcinfo;
	JTextField tcode,tcname,testr,tcno,tcper;
	JTextArea taddr,ta;
	Container cp;
	Choice ctype;
	JButton bsave,breset,bexit,bshow;
	JOptionPane jop;
	String ccode1,cname1,ctype1,caddr1,cestr1,cno1,cper1,text;

	public Company()
		{
		cp=getContentPane();
		cp.setLayout(null);   //Very important
		cp.setFont(new Font("verdana",Font.BOLD,12));

		lcinfo=new JLabel("COMPANY INFORMATION");
		lcinfo.setBounds(40,0,200,20);	// component.setBounds(x,y,width,height);
		cp.add(lcinfo);

		lcode=new JLabel("Company Code");
		lcode.setBounds(15,15,100,50);
		cp.add(lcode);	

		tcode=new JTextField(10);
		tcode.setBounds(125,25,100,25);
		cp.add(tcode);				
		
		laddr=new JLabel("Company Address");
		laddr.setBounds(15,50,125,50);
		cp.add(laddr);

		taddr=new JTextArea("",10,30);
		taddr.setBounds(125,60,150,75);
		cp.add(taddr);
		
		ltype=new JLabel("Company Type");
		ltype.setBounds(15,130,100,50);
		cp.add(ltype);
		
		ctype=new Choice();
		ctype.add("IT");
		ctype.add("Manufacturing");
		ctype.add("Service");
		ctype.add("organization");
		ctype.setBounds(125,150,100,50);
		ctype.addItemListener(this);
		cp.add(ctype);

		lcname=new JLabel("Company Name");
		lcname.setBounds(15,165,100,50);
		cp.add(lcname);

		tcname=new JTextField(10);
		tcname.setBounds(125,180,100,25);
		cp.add(tcname);
		
		lestr=new JLabel("Employee Strength");
		lestr.setBounds(15,185,125,80);
		cp.add(lestr);

		testr=new JTextField(10);
		testr.setBounds(125,210,100,25);
		cp.add(testr);

		lcno=new JLabel("Contact No");
		lcno.setBounds(15,230,100,50);
		cp.add(lcno);

		tcno=new JTextField(10);
		tcno.setBounds(125,240,100,25);
		cp.add(tcno);

		lcper=new JLabel("Contact person");
		lcper.setBounds(15,260,100,50);
		cp.add(lcper);

		tcper=new JTextField(10);
		tcper.setBounds(125,270,100,25);
		cp.add(tcper);
			
		bsave=new JButton("SAVE");
		bsave.setBounds(15,310,75,25);
		cp.add(bsave);

		breset=new JButton("RESET");
		breset.setBounds(95,310,75,25);
		cp.add(breset);

		bexit=new JButton("EXIT");
		bexit.setBounds(175,310,75,25);
		cp.add(bexit);

		bshow=new JButton("SHOW");
		bshow.setBounds(255,310,75,25);
		cp.add(bshow);

		ta=new JTextArea("",10,50);
		ta.setBounds(15,350,450,400);
		cp.add(ta);
	
		bsave.addActionListener(this);
		breset.addActionListener(this);
		bexit.addActionListener(this);
		bshow.addActionListener(this);
		}
	public void itemStateChanged(ItemEvent ie)
		{
		ctype1="";
		if(ctype.getSelectedIndex()==0)
			{
			ctype1="IT";
			}
		else if(ctype.getSelectedIndex()==1)
			{
			ctype1="Manufacturing";
			}
		else if(ctype.getSelectedIndex()==2)
			{
			ctype1="Service";
			}
		else if(ctype.getSelectedIndex()==3)
			{
			ctype1="Organization";
			}
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==bexit)
			{
			jop.showMessageDialog(null,"Bye bye","Bye bye",jop.INFORMATION_MESSAGE);
			System.exit(0);
			}
		
		if(ae.getSource()==bsave)
			{
			ccode1=tcode.getText();
			cname1=tcname.getText();
			caddr1=taddr.getText();
			cestr1=testr.getText();
			cno1=tcno.getText();
			cper1=tcper.getText();

			try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				jop.showMessageDialog(null,"Driver Loaded","Driver Loaded",jop.PLAIN_MESSAGE);

				Connection conn=DriverManager.getConnection("jdbc:odbc:wodbc");

				jop.showMessageDialog(null,"Connection Created","Connection Created",jop.PLAIN_MESSAGE);

				Statement stmt=conn.createStatement();

				String sql="insert into company values('"+ccode1+"','"+cname1+"','"+caddr1+"','"+ctype1+"','"+cestr1+"','"+cno1+"','"+cper1+"')";
								
				stmt.executeUpdate(sql);

				String str="Inserted";
				
				jop.showMessageDialog(null,str,str,jop.INFORMATION_MESSAGE);
				}
			catch(SQLException e)
				{
				}
			catch(ClassNotFoundException e1)
				{
				}
			}
		if(ae.getSource()==bshow)
			{
			try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				Connection conn=DriverManager.getConnection("jdbc:odbc:wodbc");

				Statement stmt=conn.createStatement();

				String sql="select ccode,cname,caddr from company order by ccode";
								
				ResultSet rs=stmt.executeQuery(sql);

				text="";

				ta.setFont(new Font("verdana",Font.BOLD,12));

				int c=0;
		
				while(rs.next())
					{
					text=text+rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\n";
					c++;
					ta.setText(text);
					}
				String str="Total Rows:"+c;
				jop.showMessageDialog(null,str,str,jop.PLAIN_MESSAGE);
				}
			catch(SQLException e)
				{
				}
			catch(ClassNotFoundException e1)
				{
				}
			}
		if(ae.getSource()==breset)
			{
			tcode.setText("");
			tcname.setText("");
			taddr.setText("");
			testr.setText("");
			tcno.setText("");
			tcper.setText("");
			jop.showMessageDialog(null,"Cleared","Cleared",jop.INFORMATION_MESSAGE);
			}
		}
	public static void main(String args[])
		{
		Company c=new Company();
		c.setSize(500,700);
		c.show();
		}
	}



