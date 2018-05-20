import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class SlotMgt
{
	public static void main(String args[])
	{	
	   SlotMgt S = new SlotMgt();	
	}	
	public SlotMgt()
	{
		SlotMgtFrame frame = new SlotMgtFrame();
		frame.init();			
	}
}

class SlotMgtFrame
{
	public void init()
	{
		JFrame frame = new JFrame();
		frame.setTitle("SLOT MANAGEMENT SYSTEM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
		
		//Adding MenuBar and Menu item
		JMenuBar mbar = new JMenuBar();
		frame.setJMenuBar(mbar);
		JMenu fileMenu = new JMenu("File");
		mbar.add(fileMenu);
		fileMenu.setMnemonic('F');		
		
		JMenuItem exitMenu = new JMenuItem("Exit");
		fileMenu.add(exitMenu);
		exitMenu.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_X,InputEvent.CTRL_MASK));
		
		exitMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		JMenu collegeMenu = new JMenu("College");
		mbar.add(collegeMenu);	
		collegeMenu.setMnemonic('C');	
		
		JMenuItem addBuilding = new JMenuItem("Add Building");
		collegeMenu.add(addBuilding);
		
		addBuilding.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_A,InputEvent.CTRL_MASK));
			
		JMenuItem modifyBuilding = new JMenuItem("Modify Building");
		collegeMenu.add(modifyBuilding);
		
		modifyBuilding.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_B,InputEvent.CTRL_MASK));
		
		JMenuItem deleteBuilding = new JMenuItem("Delete Building");
		collegeMenu.add(deleteBuilding);
		deleteBuilding.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_E,InputEvent.CTRL_MASK));
		
		collegeMenu.addSeparator();		
		
		JMenuItem addDept = new JMenuItem("Add Department");
		collegeMenu.add(addDept);		
		addDept.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_D,InputEvent.CTRL_MASK));

		
		JMenuItem modifyDept = new JMenuItem("Modify Department");
		collegeMenu.add(modifyDept);
		modifyDept.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_M,InputEvent.CTRL_MASK));
		
		JMenuItem deleteDept = new JMenuItem("Delete Department");
		collegeMenu.add(deleteDept);
		deleteDept.setAccelerator(KeyStroke.getKeyStroke(
			KeyEvent.VK_L,InputEvent.CTRL_MASK));

		
		JMenu classRoomMenu = new JMenu("ClassRoom");
		mbar.add(classRoomMenu);		
		classRoomMenu.setMnemonic('R');		
		JMenuItem addClassRoomMenu = new JMenuItem("Add Classroom");
		classRoomMenu.add(addClassRoomMenu);
		
		JMenuItem modifyClassRoomMenu = new JMenuItem("Modify Classroom");
		classRoomMenu.add(modifyClassRoomMenu);
		
		JMenuItem deleteClassRoomMenu = new JMenuItem("Delete Classroom");
		classRoomMenu.add(deleteClassRoomMenu);		
		
		
		JMenu TeacherJMenu = new JMenu("Teacher");
		mbar.add(TeacherJMenu);
		TeacherJMenu.setMnemonic('T');
		
		JMenuItem AllocTeacherMenu = new JMenuItem("Allocate Teacher");
		TeacherJMenu.add(AllocTeacherMenu);
		JMenuItem ModiTeacherMenu = new JMenuItem("Modify Teacher");
		TeacherJMenu.add(ModiTeacherMenu);
		
		JMenu committeeMenu = new JMenu("Committee");
		mbar.add(committeeMenu);
		committeeMenu.setMnemonic('o');
		
		JMenuItem addCommitteeMenu = new JMenuItem("Add Committee");
		committeeMenu.add(addCommitteeMenu);
		
		JMenuItem modifyCommitteeMenu = new JMenuItem("Modify Committee");
		committeeMenu.add(modifyCommitteeMenu);
		
		JMenuItem deleteCommitteeMenu=new JMenuItem("Delete Comittee");
		committeeMenu.add(deleteCommitteeMenu);
		
		JMenu aboutMenu = new JMenu("Help");
		mbar.add(aboutMenu);
		aboutMenu.setMnemonic('H');
		
		JMenuItem a = new JMenuItem("About");
		aboutMenu.add(a);
		
		
		
		a.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AboutForm AboutFormFrame = new AboutForm();
				AboutFormFrame.show(true);
			}
		});
		
		deleteCommitteeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DeleteCommittee DeleteCommitteeFrame = new DeleteCommittee();
				DeleteCommitteeFrame.show(true);
			}
		});
		modifyCommitteeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ModifyCommittee ModifyCommitteeFrame = new ModifyCommittee();
				ModifyCommitteeFrame.show(true);	
			}				
				
		});
		//ActionListener for addCommitteeMenu
		addCommitteeMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AddCommittee AddCommitteeFrame = new AddCommittee();
				AddCommitteeFrame.show(true);
			}
		});
		//ActionListener for ModifyTeacher
		ModiTeacherMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				ModifyTeacher ModifyTeacherFrame = new ModifyTeacher();
				ModifyTeacherFrame.show(true);
			}
		});
		//ActionListener for AllocTeacherMenu
		AllocTeacherMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				AllocateTeacher AllocateTeacherFrame = new AllocateTeacher();
				AllocateTeacherFrame.show(true);
			}
		});
		//ActionListener for ModifyClassRoom
		modifyClassRoomMenu.addActionListener(new ActionListener()
		{			
			public void actionPerformed(ActionEvent e)
			{
				ModifyClassRoom ModifyClassRoomFrame = new ModifyClassRoom();
				ModifyClassRoomFrame.show();
			}
		});
		
		//ActionListener for DelDept
		deleteClassRoomMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DeleteClassRoom DeleteClassRoomFrame = new DeleteClassRoom();
				DeleteClassRoomFrame.show(true);
			}
		});
		deleteDept.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				DeleteDept DeleteDeptFrame = new DeleteDept();
				DeleteDeptFrame.show(true);
			}
			
		});
		
		//ActionListener for DeleteClassRoom
		
		//ActionListener for ModifyDept
		modifyDept.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				modifyDept modifyDeptFrame = new modifyDept();
				modifyDeptFrame.show(true);
			}
		});
		//ActionListener for add Dept
		addDept.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addDept addDeptFrame = new addDept();
				addDeptFrame.show(true);
			}
		});
		//ActionListener for addClassRoomMenu
		addClassRoomMenu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addClassRoom addClassRoomFrame = new addClassRoom();
				addClassRoomFrame.show(true);
			}
		});
		//ActionListener for deleteBuilding
		deleteBuilding.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				deleteBuilding deleteBuildingFrame = new deleteBuilding();
				deleteBuildingFrame.show(true);
			}
		});
		//ActionListener for ModifyBuilding
		modifyBuilding.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				modifyBuilding modifyBuildingFrmae= new modifyBuilding();				
				modifyBuildingFrmae.show(true);
			}
		});
		//ActionListener for addBuilding
		addBuilding.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				addBuilding buildingFrame = new addBuilding();				
				buildingFrame.show(true);
			}
		});
		
		frame.setSize(800,575);
		frame.show(true);
	}
}

class addClassRoom extends JFrame
{
	addClassRoom()
	{
		setTitle("Add ClassRoom");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblRoomNo=new JLabel("Room No"); 		
 		lblRoomNo.setBounds(100,100,100,30);
 		contentPane.add(lblRoomNo);	
 		
 		JTextField txtRoomNo = new JTextField(5);
 		txtRoomNo = new JTextField(15);
 		txtRoomNo.setBounds(220,100,150,25); 		
 		contentPane.add(txtRoomNo);		
 		
 		JLabel lblNoOfFloors=new JLabel("No of Floors"); 		
 		lblNoOfFloors.setBounds(100,150,100,30);
 		contentPane.add(lblNoOfFloors);	
 		
 		JComboBox cboName = new JComboBox(); 		
 				
 		cboName.setBounds(220,150,150,25);
 		contentPane.add(cboName);		
 		cboName.addItem("1");
 		cboName.addItem("2");
 		cboName.addItem("3");
 		cboName.addItem("4");
 		cboName.addItem("5");
 		
 		JLabel lblCapacity=new JLabel("Capacity"); 		
 		lblCapacity.setBounds(100,200,100,30);
 		contentPane.add(lblCapacity);	
 		
 		JTextField txtCapacity= new JTextField(10); 		
 		txtCapacity.setBounds(220,200,150,25); 		
 		contentPane.add(txtCapacity);		
 		
 		JLabel lblProjector = new JLabel("Projector");
 		lblProjector.setBounds(100,250,100,30);
 		contentPane.add(lblProjector);
 		
 		ButtonGroup gr2 = new ButtonGroup();
 		
 		JRadioButton yes2 = new JRadioButton("Yes");
 		contentPane.add(yes2);
 		yes2.setBounds(220,250,100,25);
 		
 		JRadioButton no2 = new JRadioButton("No");
 		no2.setBounds(330,250,100,25); 		
 		contentPane.add(no2);
 		
 		gr2.add(yes2);
 		gr2.add(no2); 		
 
 		JButton btnSave =new JButton("Save"); 		 		
 		btnSave.setBounds(220,300,100,25);
 		btnSave.setSize(80,30);
 		contentPane.add(btnSave);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(300,300,100,25);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 		//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,400,300);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);
 		
 		//Adding actionListener on btnCancel
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
			{														 						
				dispose();			
 			}
 		}); 	

	}
}
class deleteBuilding extends JFrame
{
	public deleteBuilding()
	{
		setTitle("Modify Building");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblName=new JLabel("Building Name"); 		
 		lblName.setBounds(100,100,100,30);
 		contentPane.add(lblName);	
 		
 		JComboBox cboName = new JComboBox();
 		
 		cboName.setBounds(220,100,150,25); 		
 		contentPane.add(cboName);		
 		cboName.addItem("OK");
 		cboName.addItem("OK1");
 		
 		JButton btnDelete =new JButton("Delete"); 		 		
 		btnDelete.setBounds(210,250,150,25);
 		btnDelete.setSize(80,30);
 		contentPane.add(btnDelete);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(290,250,150,25);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 		//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,380,270);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);
 		
 		//Adding actionListener on btnDelete
 		btnDelete.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				JFrame f = new JFrame(); 				
 				JOptionPane.showConfirmDialog(f,"Delete Record?");
 			}
 		});
 		//Adding actionListener on btnCancel
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
			{														 				
				//setVisible(false);
				dispose();			
 			}
 		}); 					
 		
	}
}
class modifyBuilding extends JFrame
{
	public modifyBuilding()
	{
		setTitle("Modify Building");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblMbName=new JLabel("Building Name"); 		
 		lblMbName.setBounds(100,100,100,30);
 		contentPane.add(lblMbName);	
 		
 		JTextField txtMBName = new JTextField(5);
 		
 		txtMBName.setBounds(220,100,150,25); 		
 		contentPane.add(txtMBName);		
 		
 		JLabel lblNoOfFloors=new JLabel("No Of Floors"); 		
 		lblNoOfFloors.setBounds(100,150,100,30);
 		contentPane.add(lblNoOfFloors);	
 		
 		JTextField txtNoOfFloors = new JTextField(10);
 		
 		txtNoOfFloors.setBounds(220,150,150,25); 		
 		contentPane.add(txtNoOfFloors);	
 		
 		JButton btnSave =new JButton("Save"); 		 		
 		btnSave.setBounds(210,250,150,25);
 		btnSave.setSize(80,30);
 		contentPane.add(btnSave);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(290,250,150,25);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 		//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,380,270);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);
 		
 		//Adding actionListener on btnCancel
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
			{														 				
				//setVisible(false);
				dispose();			
 			}
 		}); 					
	}
}
class addBuilding extends JFrame
{	
JLabel lblroomNo,lblnoofFloors,lblroomNo1,lblnoofFloors1;
JTextField txtfloorNo,txtfloorNo1;
JComboBox txtnoofFlowers,txtnoofFlowers1;
	public addBuilding()
	{		
		setTitle("Add Building");
		setSize(800,700);				
		//setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel l1= new JLabel("Building Id"); 		
 		l1.setBounds(100,100,100,30);
 		contentPane.add(l1);	
 		
 		JTextField t1 = new JTextField(5);
 		t1 = new JTextField(15);
 		t1.setBounds(220,100,150,30); 		
 		contentPane.add(t1);		
 		
 		JLabel l2=new JLabel("BuildIng Name"); 		
 		l2.setBounds(100,150,100,30); 		
 		contentPane.add(l2);	
 		
 		JComboBox t2 = new JComboBox(); 		
 		t2.setBounds(220,150,150,25);
 		t2.addItem("Computer"); 		
 		t2.addItem("Chemistry");
 		t2.addItem("Physics");
 		t2.addItem("Mathematics");
 		contentPane.add(t2);		
 		
 		JLabel l3=new JLabel("No of Floors"); 		
 		l3.setBounds(100,200,100,30);
 		contentPane.add(l3);	
 		
 		JComboBox t3 = new JComboBox(); 		
 		t3.setBounds(220,200,150,25); 		
 		t3.addItem("1");
 		t3.addItem("2");
 		t3.addItem("3");
 		t3.addItem("4");
 		contentPane.add(t3);	
 		
 		JLabel l4 = new JLabel("Store Room");
 		l4.setBounds(100,250,100,30);
 		contentPane.add(l4);	
 		
 		ButtonGroup gr = new ButtonGroup();
 		JRadioButton yes = new JRadioButton("Yes");
 		contentPane.add(yes);
 		yes.setBounds(220,250,100,30);
 		
 		JRadioButton no = new JRadioButton("No");
 		contentPane.add(no);
 		no.setBounds(320,250,100,30);
 		gr.add(yes);
 		gr.add(no);
 		
 		
 		lblroomNo = new JLabel("Room No");
 		contentPane.add(lblroomNo);
 		lblroomNo.setBounds(100,300,100,30);
 		
 		txtfloorNo = new JTextField(10);
 		contentPane.add(txtfloorNo);
 		txtfloorNo.setBounds(220,300,150,30);
 		
 		lblnoofFloors = new JLabel("Floor No");
 		lblnoofFloors.setBounds(100,350,150,30);
 		contentPane.add(lblnoofFloors);
 		
 		txtnoofFlowers = new JComboBox();
 		contentPane.add(txtnoofFlowers);
 		txtnoofFlowers.addItem("1");
 		txtnoofFlowers.addItem("2");
 		txtnoofFlowers.addItem("3");
 		txtnoofFlowers.addItem("4");
 		txtnoofFlowers.setBounds(220,350,150,30);
 		
 	
 		
 		JLabel lblsemiroom = new JLabel("Seminar Room");
 		lblsemiroom.setBounds(100,400,200,30);
 		contentPane.add(lblsemiroom);	
 	
		
		ButtonGroup gr1 = new ButtonGroup();		
 		JRadioButton yes1 = new JRadioButton("Yes");
 		contentPane.add(yes1);
 		yes1.setBounds(220,400,100,30);
 		
 		JRadioButton no1 = new JRadioButton("No");
 		contentPane.add(no1);
 		no1.setBounds(320,400,100,30);
 		gr1.add(yes1);
 		gr1.add(no1);
 		
 		// 		
 		lblroomNo1 = new JLabel("Room No");
 		contentPane.add(lblroomNo1);
 		lblroomNo1.setBounds(100,450,150,30);
 		
 		txtfloorNo1 = new JTextField(10);
 		contentPane.add(txtfloorNo1);
 		txtfloorNo1.setBounds(220,450,100,30);
 		
 		lblnoofFloors1 = new JLabel("Floor No");
 		lblnoofFloors1.setBounds(100,500,150,30);
 		contentPane.add(lblnoofFloors1);
 		
 		txtnoofFlowers1 = new JComboBox();
 		contentPane.add(txtnoofFlowers1);
 		txtnoofFlowers1.addItem("1");
 		txtnoofFlowers1.addItem("2");
 		txtnoofFlowers1.addItem("3");
 		txtnoofFlowers1.addItem("4");
 		txtnoofFlowers1.setBounds(220,500,100,30);
 		
 		JButton btnSave =new JButton("Save"); 		 		
 		btnSave.setBounds(520,470,350,50);
 		btnSave.setSize(80,30);
 		contentPane.add(btnSave);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(520,500,350,50);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 	
 		//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,460,490);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel); 		
 		
 		yes1.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				txtnoofFlowers1.setVisible(true); 				
 				txtfloorNo1.setVisible(true);
				lblroomNo1.setVisible(true); 				
				lblnoofFloors1.setVisible(true);				
 			}
 		});
 		
 		no1.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				txtnoofFlowers1.setVisible(false);
 				txtfloorNo1.setVisible(false);
				lblroomNo1.setVisible(false); 				
				lblnoofFloors1.setVisible(false);				
 						
 			}
 		});
 		//
 		yes.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				lblroomNo.setVisible(true);
 				lblnoofFloors.setVisible(true);
 			    txtfloorNo.setVisible(true);
				txtnoofFlowers.setVisible(true);
 			}
 		});
 		
 		no.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				lblroomNo.setVisible(false);
 				lblnoofFloors.setVisible(false);
 				txtfloorNo.setVisible(false);
				txtnoofFlowers.setVisible(false);
 						
 			}
 		});
 		//Adding actionListener on btnCancel
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
			{														 				
				//setVisible(false);
				dispose();			
 			}
 		}); 		
 		
	}
}
