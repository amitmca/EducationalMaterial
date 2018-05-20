import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class fileaccess extends JFrame implements ActionListener,ItemListener
	{
	JLabel lname,lage,lquali;
	JTextField tname,tage;
	JRadioButton btech,mca;
	Container cp;
	ButtonGroup cbg;
	JButton bsave,bexit,breset;
	OutputStream fout;	
	String name,age,quali;
	JOptionPane jop;

	
	public  fileaccess()
		{
		cp=getContentPane();
		cp.setLayout(null);
		cp.setFont(new Font("verdana",Font.BOLD,13));
		cp.setBackground(Color.green);
		cbg=new ButtonGroup();

		lname=new JLabel("Name");
		lname.setBounds(15,15,100,50);
		cp.add(lname);
		

		tname=new JTextField(10);
		tname.setBounds(150,25,100,25);
		cp.add(tname);	

		lage=new JLabel("Age");
		lage.setBounds(15,60,100,50);
		cp.add(lage);

		tage=new JTextField(10);
		tage.setBounds(150,70,100,25);
		cp.add(tage);


		lquali=new JLabel("Qualification");
		lquali.setBounds(15,105,100,50);
		cp.add(lquali);

		btech=new JRadioButton("BTECH",false);
		btech.setBackground(Color.green);
		cbg.add(btech);
		btech.setBounds(150,115,100,25);
		cp.add(btech);

		mca=new JRadioButton("MCA",false);
		mca.setBackground(Color.green);
		cbg.add(mca);
		mca.setBounds(250,115,100,25);
		cp.add(mca);

		bsave=new JButton("SAVE");
		bsave.setBounds(15,175,75,25);
		cp.add(bsave);

		breset=new JButton("RESET");
		breset.setBounds(135,175,75,25);
		cp.add(breset);

		bexit=new JButton("EXIT");
		bexit.setBounds(260,175,75,25);
		cp.add(bexit);

		btech.addItemListener(this);
		mca.addItemListener(this);
		bsave.addActionListener(this);
		breset.addActionListener(this);
		bexit.addActionListener(this);
		}

	public void itemStateChanged(ItemEvent ie)
		{
		if(ie.getItemSelectable()==btech)
			{
			quali="BTECH";
			}
		else if(ie.getItemSelectable()==mca)
			{
			quali="MCA";
			}
		}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==bexit)
			{
			System.exit(0);	
			}
		if(ae.getSource()==bsave)
			{
			name=tname.getText();
			age=tage.getText();
			byte [] name1=name.getBytes();
			byte [] age1=age.getBytes();
			byte [] space1="     ".getBytes();
			byte [] quali1=quali.getBytes();
			
			try
				{
				fout=new FileOutputStream("amit.txt",true);
				PrintWriter pw=new PrintWriter(fout,true);

				for(int i=0;i<name1.length;i++)
					fout.write(name1[i]);
				for(int i=0;i<space1.length;i++)
					fout.write(space1[i]);
				for(int i=0;i<age1.length;i++)
					fout.write(age1[i]);
				for(int i=0;i<space1.length;i++)
					fout.write(space1[i]);
				for(int i=0;i<quali1.length;i++)
					fout.write(quali1[i]);
				pw.println();

				JOptionPane.showMessageDialog(null,"Added","Addes",jop.PLAIN_MESSAGE);			
				}
			catch(FileNotFoundException e)
				{
				}
			catch(IOException e2)
				{
				}
			catch(ArrayIndexOutOfBoundsException e1)
				{
				return;
				}
			}
		if(ae.getSource()==breset)
			{
			tname.setText("");
			tage.setText("");
			}
		}
	public static void main(String args[])
		{
		fileaccess f=new fileaccess();
		f.setSize(350,250);
		f.show();
		}
	}