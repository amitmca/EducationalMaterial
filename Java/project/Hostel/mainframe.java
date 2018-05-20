//creates mainframe
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;
import sun.jdbc.odbc.*;
import java.util.Calendar;
import java.io.*;

class mainframe extends JFrame implements ActionListener
{
   public JMenuItem addhostel,addcourse,addcomplaint,addfee,exit1;
   public JMenuItem deletehostel,deletecourse,deletecomplaint,deletefee;
   public JMenuItem modifystudent,modifycomplaint,modifyhostel,modifycourse;
   public JMenuItem viewstudent,viewcomplaint,viewhostel,viewcourse,viewstudentfee,viewtree;
   //for report
   public JMenuItem complaint,feedues,receipt,rcollegewise,rcoursewise,ind,totalfeer;
   public JMenuItem changepass,adduser,removeuser;
   public JMenuItem designers,product;
   public JMenuItem new1,cancel;
   public JMenuItem totalfee;
   public JMenu master,add,delete,modify,view,admission,report,admin,help,about,exit,student;
   String uname;
 //constructor of the mainframe
  mainframe(String user)
  {
	  	uname=user;
	  	String user1= "   Hostel Admission System      |      (Nowrosjee Wadia College,Pune-411001)           |         Current User : " + user;
	  	setTitle(user1);
	    setSize(800,740);
	  	setVisible(true);
	  	Container c= getContentPane();
	  	
	  	c.setBackground(new Color(169,167,168));
	 	//ImageIcon ii=new ImageIcon("c:\\java\\112.jpg");
	 	//JLabel image =new JLabel(ii);
	    //image.setBounds(0,0,800,740);
	 	//c.add(image);
	 	
	 	//adds menu bar to the frame
	  	JMenuBar mbar=new JMenuBar();
	  	setJMenuBar(mbar);
	  
		  master=new JMenu("Master");
		  mbar.add(master);
		  master.setMnemonic('M');
		 	  
		  add=new JMenu("Add    Entry");
		  add.setMnemonic('a');
		  add.add(addhostel=new JMenuItem("Hostel"));
		  addhostel.setMnemonic('h');
		  add.addSeparator();
		  add.add(addcourse=new JMenuItem("Course"));
		  addcourse.setMnemonic('c');
		  add.addSeparator();
		  add.add(addcomplaint=new JMenuItem("Complaint"));
		  addcomplaint.setMnemonic('o');
		  add.addSeparator();
		  add.add(addfee=new JMenuItem("Fee Details"));
		  addfee.setMnemonic('f');
		  master.add(add);
		  master.addSeparator();
		  
		  delete=new JMenu("Delete Entry");
		  delete.setMnemonic('d');
		  delete.add(deletehostel=new JMenuItem("Hostel"));
		  deletehostel.setMnemonic('h');
		  delete.addSeparator();
		  delete.add(deletecourse=new JMenuItem("Course"));
		  deletecourse.setMnemonic('c');
		  delete.addSeparator();
		  delete.add(deletecomplaint=new JMenuItem("Complaint"));
		  deletecomplaint.setMnemonic('o');
		  delete.addSeparator();
		  delete.add(deletefee=new JMenuItem("Fee Details"));
		  deletefee.setMnemonic('f');
		  //adds menu DELETE to the menu master
		  master.add(delete);
		  master.addSeparator();
		  
		  modify=new JMenu("Modify Entry");
		  modify.setMnemonic('m');
		  modify.add(modifystudent=new JMenuItem("Student"));
		  modifystudent.setMnemonic('s');
		  modify.addSeparator();
		  modify.add(modifycomplaint=new JMenuItem("Complaint"));
		  modifycomplaint.setMnemonic('o');
		  modify.addSeparator();
		  modify.add(modifyhostel=new JMenuItem("Hostel"));
		  modifyhostel.setMnemonic('h');
		  modify.addSeparator();
		  modify.add(modifycourse=new JMenuItem("Course"));
		  modifycourse.setMnemonic('c');
		  //adds menu MODIFY to the menu master
		  master.add(modify);
		  master.addSeparator();
		  
		  view=new JMenu("View");
		  view.setMnemonic('v');
		  view.add(viewstudent=new JMenuItem("Student"));
		  viewstudent.setMnemonic('s');
		  view.addSeparator();
		  view.add(viewcomplaint=new JMenuItem("Complaint"));
		  viewcomplaint.setMnemonic('o');
		  view.addSeparator();
		  view.add(viewhostel=new JMenuItem("Hostel"));
		  viewhostel.setMnemonic('h');
		  view.addSeparator();
		  view.add(viewcourse=new JMenuItem("Course"));
		  viewcourse.setMnemonic('c');
		  view.addSeparator();
		  view.add(viewstudentfee=new JMenuItem("Fee Details"));
		  viewstudentfee.setMnemonic('f');
		  view.addSeparator();
		  view.add(viewtree=new JMenuItem("Hostel Tree View"));
		  viewtree.setMnemonic('t');
		  //adds menu VIEW to the menu master
		  master.add(view);
		  
		  master.addSeparator();
		  master.add(totalfee=new JMenuItem("Total Fee Entry"));
		  totalfee.setMnemonic('t');
		  
		  admission=new JMenu("Admission");
		  admission.setMnemonic('A');
		  admission.add(new1=new JMenuItem("New Student"));
		  new1.setMnemonic('N');
		  admission.addSeparator();
		  admission.add(cancel=new JMenuItem("Cancel"));
		  cancel.setMnemonic('C');
		  mbar.add(admission);
		
		  report=new JMenu("Report");  
		  report.setMnemonic('R');
		  report.add(student=new JMenu("Student"));
		  student.setMnemonic('s');
		  student.add(rcoursewise=new JMenuItem("Course wise Student Report"));
		  rcoursewise.setMnemonic('c');
		  student.addSeparator();
		  student.add(rcollegewise=new JMenuItem("College wise Student Report"));
		  rcollegewise.setMnemonic('o');
		  student.addSeparator();
		  student.add(ind=new JMenuItem("Individual Student Report"));
		  ind.setMnemonic('i');
		  report.addSeparator();
		  report.add(receipt=new JMenuItem("Receipt"));
		  receipt.setMnemonic('r');
		  report.addSeparator();
		  report.add(feedues=new JMenuItem("Fee Dues Report"));
		  feedues.setMnemonic('f');
		  report.addSeparator();
		  report.add(totalfeer=new JMenuItem("Total Fee Report"));
		  totalfeer.setMnemonic('t');
		  report.addSeparator();
		  report.add(complaint=new JMenuItem("Complaint"));
		  complaint.setMnemonic('c');
		  mbar.add(report);
		
		  admin=new JMenu("Admin");
		  admin.setMnemonic('d');
		  mbar.add(admin);
		  admin.add(changepass=new JMenuItem("Change Password"));
		  changepass.setMnemonic('c');
		  admin.addSeparator();
		  admin.add(adduser=new JMenuItem("Add User"));
		  adduser.setMnemonic('a');
		  admin.addSeparator();
		  admin.add(removeuser=new JMenuItem("Remove User"));
		  removeuser.setMnemonic('r');
		      
		  help=new JMenu("Help");
		  help.setMnemonic('H');
		  about=new JMenu("About    ");
		  about.setMnemonic('a');
		  help.add(about);
		  about.add(designers=new JMenuItem("Designers"));
		  designers.setMnemonic('d');
		  about.addSeparator();
		  about.add(product=new JMenuItem("Product"));
		  product.setMnemonic('p');
		  mbar.add(help);
		  
		  exit=new JMenu("Exit");
		  exit.setMnemonic('x');
		  exit.add(exit1=new JMenuItem("Exit"));
		  exit1.setMnemonic('x');
		  mbar.add(exit);
		  
		 
		  addcomplaint.addActionListener(this);//complaint
		  addhostel.addActionListener(this);//hostel
		  addcourse.addActionListener(this);//course
		  addfee.addActionListener(this);//fee details
		  
		  deletecomplaint.addActionListener(this);//complaint
		  deletehostel.addActionListener(this);//hostel
		  deletecourse.addActionListener(this);//course
		  deletefee.addActionListener(this);//fee details
		  
		  modifystudent.addActionListener(this);//student
		  modifycomplaint.addActionListener(this);//complaint
		  modifyhostel.addActionListener(this);//hostel
		  modifycourse.addActionListener(this);//course
		  		  
		  viewstudent.addActionListener(this);
		  viewcourse.addActionListener(this);
		  viewhostel.addActionListener(this);
		  viewcomplaint.addActionListener(this);
		  viewstudentfee.addActionListener(this);
		  viewtree.addActionListener(this);
		  
		  totalfee.addActionListener(this);
		  
		  new1.addActionListener(this);
		  cancel.addActionListener(this);
		 
		  rcoursewise.addActionListener(this);
		  rcollegewise.addActionListener(this);
		  ind.addActionListener(this);
		  complaint.addActionListener(this);
		  receipt.addActionListener(this);
		  feedues.addActionListener(this);
		  totalfeer.addActionListener(this);
		  		  
		  changepass.addActionListener(this);
		  adduser.addActionListener(this);
		  removeuser.addActionListener(this);
		  
		  designers.addActionListener(this);
		  product.addActionListener(this);
		  
		  exit1.addActionListener(this);
		    
 }       //end of constructor of mainframe
 
 public void actionPerformed(ActionEvent ae)
 {
 	   
 	    //shows frame for adding students details
		if(ae.getSource()==new1)
		{
			studentframe sf=new studentframe(this);
	    }
	    //shows frame for adding hostel details
		if(ae.getSource()==addhostel)
		{
			hostelframe hf=new hostelframe(this);
		}
		//shows frame for adding course details
		if(ae.getSource()==addcourse)
		{
			courseframe cf=new courseframe(this);
		}
		//shows frame for adding students complaints
		if(ae.getSource()==addcomplaint)
		{
			complaintframe cf=new complaintframe(this);
		}
		//shows frame for adding fees complaints
		if(ae.getSource()==addfee)
		{
			feedetailframe fdf=new feedetailframe(this);
		}
		
		//shows frame for modifying student details
		if(ae.getSource()==modifystudent)
		{
			mdstudentframe mdsf=new mdstudentframe(this,true);
		}
		//shows frame for modifying students complaints
		if(ae.getSource()==modifycomplaint)
		{
			mdcomplaintframe mdcf=new mdcomplaintframe(this,true);
		}
		//shows frame for modifying course details
		if(ae.getSource()==modifycourse)
		{
			mdcourseframe mdcf=new mdcourseframe(this,true);
		}
		//shows frame for modifying hostel details
		if(ae.getSource()==modifyhostel)
		{
			mdhostelframe mdhf=new mdhostelframe(this,true);
		}
		
		//shows frame for deleting students complaints
		if(ae.getSource()==deletecomplaint)
		{
			mdcomplaintframe mdcf=new mdcomplaintframe(this,false);
		}
		//shows frame for deleting course details
		if(ae.getSource()==deletecourse)
		{
			mdcourseframe mdcf=new mdcourseframe(this,false);
		}
		//shows frame for deleting hostel details
		if(ae.getSource()==deletehostel)
		{
			mdhostelframe mdhf=new mdhostelframe(this,false);
		}
		//shows frame for deleting fee details
		if(ae.getSource()==deletefee)
		{
			dfeedetailframe dfdf=new dfeedetailframe(this);
		}

		//shows frame for viewing student details
		if(ae.getSource()==viewstudent)
		{
			vstudentframe vsf=new vstudentframe(this);
		}
		//shows frame for viewing course details
		if(ae.getSource()==viewcourse)
		{
			vcourseframe vcf=new vcourseframe(this);
		}
		//shows frame for viewing hostel details
		if(ae.getSource()==viewhostel)
		{
			vhostelframe vhf=new vhostelframe(this);
		}
		//shows frame for viewing complaint details
		if(ae.getSource()==viewcomplaint)
		{
			vcomplaintframe vcf=new vcomplaintframe(this);
		}
		//shows frame for viewing student fee details
		if(ae.getSource()==viewstudentfee)
		{
			vfeeframe vff=new vfeeframe(this);
		}
		//shows frame for tree view of hostel
		if(ae.getSource()==viewtree)
		{
			treeview tv=new treeview(this);
		}
		
		//shows frame for modifying total fee
		if(ae.getSource()==totalfee)
		{
			totalfeeframe tff=new totalfeeframe(this);
	    }
		
		//shows frame for canceling student admission
		if(ae.getSource()==cancel)
		{
			mdstudentframe mdsf=new mdstudentframe(this,false);
		}
		
		//shows report
		if(ae.getSource()==rcoursewise)
		{
			repstudcourse rs=new repstudcourse(this);
		}
		if(ae.getSource()==rcollegewise)
		{
			repstudcollege rs=new repstudcollege(this);
		}
		if(ae.getSource()==ind)
		{
			repstudind rs=new repstudind(this);
		}
		if(ae.getSource()==receipt)
		{
			reprec rs=new reprec(this);
		}
		if(ae.getSource()==feedues)
		{
			repdues rs=new repdues();
		}
		if(ae.getSource()==totalfeer)
		{
			reptotfee rs=new reptotfee();
		}
		if(ae.getSource()==complaint)
		{
			repcomp rs=new repcomp();
		}
		
		
		//shows frame for changing password
		if(ae.getSource()==changepass)
		{
			changepassframe cpf=new changepassframe(this,uname);
	    }
		//shows frame for adding new user	    
	    if(ae.getSource()==adduser)
		{
			adduserframe auf=new adduserframe(this);
	    }
		//shows frame for removing user	    
	    if(ae.getSource()==removeuser)
		{
			removeuser auf=new removeuser(this);
	    }
		//shows the designers frame
		if(ae.getSource()==designers)
		{
			designerframe df=new designerframe(this);
		}
		//shows the product frame
		if(ae.getSource()==product)
		{
			productframe pf=new productframe(this);
		}
		
		//quits the application
		if(ae.getSource()==exit1)
		{
		  dispose();
	    }
  }
}
