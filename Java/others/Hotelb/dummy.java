import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;

class dummy extends JFrame //implements ActionListener
{
 myListener1 mylist=new myListener1(); 
 //all frames
 
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
 JFrame reports=new JFrame("Reports");
    
   
   
   
 	
 	//main function
 	
 	public  void dummy()
  	{ 
  	
  		ImageIcon ii = new ImageIcon("lor22d.jpg");
	  	JLabel jl = new JLabel("", ii, JLabel.CENTER);
	  	fr1.add(jl);
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
    
    
    
    //Current Status
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
   
    //Searching
    JMenu mn3=new JMenu("SearchCust");
    JMenuItem msc1=new JMenuItem("byName");
    JMenuItem msc2=new JMenuItem("byDuration");
    msc1.addActionListener(new Name());
    msc2.addActionListener(new Duration());
    mn3.add(msc1);
    mn3.add(msc2);
    mb1.add(mn3);
   
   
   //reports
 	JMenu mn5=new JMenu("Reports");
 	JMenuItem mi2=new JMenuItem("Information of Customer");
 	JMenuItem mi3=new JMenuItem("Information of Rooms");
 	JMenuItem mi4=new JMenuItem("Information of Employees");
    mi2.addActionListener(new infocust());
    mi3.addActionListener(new inforoom());
    mi4.addActionListener(new infoemp());
    mn5.add(mi2);
    mn5.add(mi3);
    mn5.add(mi4);
    mb1.add(mn5);
   
   
   //about us
    JMenu mn6=new JMenu("About");
    JMenuItem mi1=new JMenuItem("About");
    mi1.addActionListener(new About());
    mn6.add(mi1);
    mb1.add(mn6);
 
 
    
    
    //bill
    JMenu mn4=new JMenu("Bill");
    JMenuItem mg1=new JMenuItem("GenerateBill");
    mg1.addActionListener(new Bill());
    mn4.add(mg1);
    mb1.add(mn4);
    fr1.setJMenuBar(mb1);
          
      
          
    myListener mylist1=new myListener();
    fr1.addWindowListener(mylist1);
    fr1.setSize(800,575);
    fr1.setVisible(true);
    fr1.setResizable(false);
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
      frc.setVisible(false);
       frcg.setVisible(false);
       frunres.setVisible(false);
       frname.setVisible(false);
        frbill.setVisible(false);
      
     }
  }

 class Reserve implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
       reserve re=new reserve();
       
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
  
  //about us
  class About implements ActionListener
  {
  public void actionPerformed(ActionEvent e)
  {
  	about abt=new about();
  }
}

//info about customers
class infocust implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		customer ac=new customer();
	}
}

//info about employees
class infoemp implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		emp ac=new emp();
	}
}



class inforoom implements ActionListener
{
	public void actionPerformed(ActionEvent e)
     {
    rooms ac=new rooms();
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
  
  //all details of rooms
 class All implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
     {
    rooms ac=new rooms();
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
  
  //generate bill
 
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
    dummy p=new dummy();
    p.dummy();
  }
}