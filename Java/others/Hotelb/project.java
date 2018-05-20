import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;


public class project extends JFrame //implements ActionListener
{
 myListener1 mylist=new myListener1(); 
 JFrame fr1=new JFrame("HOTEL KRISHNA INTERNATIONAL");
 JFrame frn=new JFrame("BOOKING");
 JFrame frc=new JFrame("CANCEL");
 JFrame frcg=new JFrame("CHANGE");
 JFrame frall=new JFrame("ALL DETAILS");
 JFrame frunres=new JFrame("UNRESERVED ROOMS DETAILS");
 JFrame frone=new JFrame("ROOM STATUS");
 JFrame frname=new JFrame("DETAILS OF CUSTUMER");
 JFrame frdur=new JFrame("ALL CUSTUMER DETAILS");
 JFrame frbill=new JFrame("BILL");
 JFrame about =new JFrame("About");
   GridLayout lr=new GridLayout(12,2,5,5);
   JLabel lcinfo=new JLabel("CUSTOMERS DETAILS");
   JLabel lphoto=new JLabel("Photo");
   JLabel l1=new JLabel("");
   JLabel l2=new JLabel("");
   JLabel lname=new JLabel("Name");
   JLabel lcin=new JLabel("Check-in-date");
   JLabel lcout=new JLabel("Check-out-date");
   JLabel ladd=new JLabel("Address");
   JLabel lcon=new JLabel("Contact No.");
   JLabel lrtype=new JLabel("Room Type");
   JLabel lcno=new JLabel("Customer No.");
   JLabel locc=new JLabel("Occupation");
   JLabel lreson=new JLabel("Reson For Stay");
   JTextField name=new JTextField(25);
   JTextField add=new JTextField(25);
   JTextField con=new JTextField(25);
   JTextField rtype=new JTextField(25);
   JTextField cno=new JTextField(25);
   JTextField occ=new JTextField(25);
   JTextField reson=new JTextField(25);
   JTextField cin=new JTextField(25);
   JTextField cout=new JTextField(25);
   JButton reserv=new JButton("RESERVE");
   GridBagLayout gb=new GridBagLayout();
   GridBagConstraints gbc=new GridBagConstraints();
   JLabel lrno=new JLabel("Room No");
   JButton cancel=new JButton("CANCEL");
   JTextField ccno=new JTextField(25);
   JButton ok=new JButton("OK");
   JLabel lcgno=new JLabel("Room No");
   JTextField cgno=new JTextField(25);
   JButton ss=new JButton("SHOW STATUS");
   JLabel lonno=new JLabel("Enter Room No");
   JTextField onno=new JTextField(25);
   JButton sc=new JButton("SEARCH");
   JLabel lscnm=new JLabel("Enter Name");
   JTextField scnm=new JTextField(25); 
   JLabel lscfr=new JLabel("From ");
   JTextField scfr=new JTextField(25);
   JButton scd=new JButton("SEARCH ");
   JLabel lscto=new JLabel("To");
   JTextField scto=new JTextField(25);
 public project()
  { 
    JMenuBar mb1=new JMenuBar();
    JMenu mn1=new JMenu("Reservation");
    JMenuItem mr1=new JMenuItem("Reserve");
    JMenuItem mr2=new JMenuItem("Cancel");
    JMenuItem mr3=new JMenuItem("Change");
    mr1.addActionListener(new Reserve());
    mr2.addActionListener(new Cancel());
    mr3.addActionListener(new Change());
    mn1.add(mr1);
    mn1.add(mr2);
    mn1.add(mr3);
    mb1.add(mn1);
    JMenu mn2=new JMenu("Status");
    JMenuItem ms1=new JMenuItem("allRooms");
    JMenuItem ms2=new JMenuItem("Unserved");
    JMenuItem ms3=new JMenuItem("oneRoom");
    ms1.addActionListener(new All());
    ms2.addActionListener(new Unres());
    ms3.addActionListener(new One());
    mn2.add(ms1);
    mn2.add(ms2);
    mn2.add(ms3);
    mb1.add(mn2);
    JMenu mn3=new JMenu("SearchCust");
    JMenuItem msc1=new JMenuItem("byName");
    JMenuItem msc2=new JMenuItem("byDuration");
    msc1.addActionListener(new Name());
    msc2.addActionListener(new Duration());
    mn3.add(msc1);
    mn3.add(msc2);
    mb1.add(mn3);
    JMenu mn5=new JMenu("About");
    JMenuItem mi1=new JMenuItem("About");
    mi1.addActionListener(new About());
    mn5.add(mi1);
    mb1.add(mn5);
    
    JMenu mn4=new JMenu("Bill");
    JMenuItem mg1=new JMenuItem("GenerateBill");
    mg1.addActionListener(new Bill());
    mn4.add(mg1);
    mb1.add(mn4);
    fr1.setJMenuBar(mb1);
       frn.getContentPane().setLayout(lr);
       frn.getContentPane().add(lcinfo);
       frn.getContentPane().add(lphoto);
       frn.getContentPane().add(l1);
       frn.getContentPane().add(l2);
       frn.getContentPane().add(lname);
       frn.getContentPane().add(name);
       frn.getContentPane().add(ladd);
       frn.getContentPane().add(add);
       frn.getContentPane().add(lcon);
       frn.getContentPane().add(con);
       frn.getContentPane().add(lrtype);
       frn.getContentPane().add(rtype);
       frn.getContentPane().add(lcin);
       frn.getContentPane().add(cin);
       frn.getContentPane().add(lcout);
       frn.getContentPane().add(cout);
       frn.getContentPane().add(lcno);
       frn.getContentPane().add(cno);
       frn.getContentPane().add(locc);
       frn.getContentPane().add(occ);
       frn.getContentPane().add(lreson);
       frn.getContentPane().add(reson);
       frn.getContentPane().add(reserv);

       frc.getContentPane().setLayout(gb);	
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lrno,gbc);
       frc.getContentPane().add(lrno);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(ccno,gbc);
       frc.getContentPane().add(ccno);
       gbc.gridwidth=1;
       gb.setConstraints(cancel,gbc);
       frc.getContentPane().add(cancel);
     
       frcg.getContentPane().setLayout(gb);	
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lcgno,gbc);
       frcg.getContentPane().add(lcgno);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(cgno,gbc);
       frcg.getContentPane().add(cgno);
       gbc.gridwidth=1;
       gb.setConstraints(ok,gbc);
       frcg.getContentPane().add(ok);
 
       frone.getContentPane().setLayout(gb);	
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lonno,gbc);
       frone.getContentPane().add(lonno);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(onno,gbc);
       frone.getContentPane().add(onno);
       gbc.gridwidth=1;
       gb.setConstraints(ss,gbc);
       frone.getContentPane().add(ss);

       frname.getContentPane().setLayout(gb);	
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lscnm,gbc);
       frname.getContentPane().add(lscnm);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(scnm,gbc);
       frname.getContentPane().add(scnm);
       gbc.gridwidth=1;
       gb.setConstraints(sc,gbc);
       frname.getContentPane().add(sc);    

       frdur.getContentPane().setLayout(gb);	
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lscfr,gbc);
       frdur.getContentPane().add(lscfr);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(scfr,gbc);
       frdur.getContentPane().add(scfr);
       gbc.fill=GridBagConstraints.HORIZONTAL;
       gbc.gridwidth=1;
       gb.setConstraints(lscto,gbc);
       frdur.getContentPane().add(lscto);
       gbc.gridwidth=GridBagConstraints.REMAINDER;;
       gbc.weightx=2.0;
       gb.setConstraints(scto,gbc);
       frdur.getContentPane().add(scto);
       gbc.gridwidth=1;
       gb.setConstraints(scd,gbc);
       frdur.getContentPane().add(scd);    
    myListener mylist1=new myListener();
    fr1.addWindowListener(mylist1);
    fr1.setSize(400,400);
    fr1.setVisible(true);
    fr1.show();
  }
 
 class myListener extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
     {
       System.exit(0);
     }
  }
  
 class myListener1 extends WindowAdapter
  {
    public void windowClosing(WindowEvent e)
     {
       fr1.setVisible(true);
       frn.setVisible(false);
       frc.setVisible(false);
       frcg.setVisible(false);
       frall.setVisible(false);
       frone.setVisible(false);
       frunres.setVisible(false);
       frname.setVisible(false);
       frdur.setVisible(false);
       frbill.setVisible(false);
      
     }
  }

 class Reserve implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frn.addWindowListener(mylist);
       frn.setSize(400,400);
       frn.setVisible(true);
       frn.show();
       fr1.setVisible(false);
       
     }
  }
 
 class Cancel implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frc.addWindowListener(mylist);
       frc.setSize(400,400);
       frc.setVisible(true);
       frc.show();
       fr1.setVisible(false);
     }
  }
 class Change implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frcg.addWindowListener(mylist);
       frcg.setSize(400,400);
       frcg.setVisible(true);
       frcg.show();
       fr1.setVisible(false);
     }
  }
  class About implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
  {
  	about.addWindowListener(mylist);
  	about.setSize(315,335);
  	about.setVisible(true);
  	about.setLocation(20,60);
  	about.show();
  	fr1.setVisible(false);
  }
}

 class Unres implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frunres.addWindowListener(mylist);
       frunres.setSize(400,400);
       frunres.setVisible(true);
       frunres.show();
       fr1.setVisible(false);
     }
  }
 class One implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frone.addWindowListener(mylist);
       frone.setSize(400,400);
       frone.setVisible(true);
       frone.show();
       fr1.setVisible(false);
     }
  }
 class All implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
    ht ac=new ht();
	     }
  }
 class Duration implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frdur.addWindowListener(mylist);
       frdur.setSize(400,400);
       frdur.setVisible(true);
       frdur.show();
       fr1.setVisible(false);
     }
  }
 class Name implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frname.addWindowListener(mylist);
       frname.setSize(400,400);
       frname.setVisible(true);
       frname.show();
       fr1.setVisible(false);
     }
  }
 class Bill implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       frbill.addWindowListener(mylist);
       frbill.setSize(400,400);
       frbill.setVisible(true);
       frbill.show();
       fr1.setVisible(false);
     }
  }
 
 
 public static void main(String a[])
  {
    project p=new project();
    p.project();
  }
}