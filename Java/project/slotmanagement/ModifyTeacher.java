import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;

public class ModifyTeacher extends JFrame
{
	public ModifyTeacher()
	{
		setTitle("Modify Teacher");
		setSize(500,500);				
		setLocation(150,50);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblTeacherId=new JLabel("Teacher Id"); 		
 		lblTeacherId.setBounds(100,100,100,30);
 		contentPane.add(lblTeacherId);	
 		
 		JTextField txtTeacherName = new JTextField(10); 		
 		txtTeacherName.setBounds(220,100,150,25); 		
 		contentPane.add(txtTeacherName);
 		
 		JLabel lblDay = new JLabel("Day");
 		lblDay.setBounds(100,150,100,30);
 		contentPane.add(lblDay);
 		
 		JTextField txtDay = new JTextField(10);
 		txtDay.setBounds(220,150,150,25);
 		contentPane.add(txtDay);
 		
 		JLabel lblFrom = new JLabel("From");
 		lblFrom.setBounds(100,200,100,30);
 		contentPane.add(lblFrom);
 		
 		JTextField txtFrom = new JTextField(5);
 		txtFrom.setBounds(220,200,50,25);
 		contentPane.add(txtFrom);
 		
 		JLabel lblTo = new JLabel("To");
 		lblTo.setBounds(300,200,100,30);
 		contentPane.add(lblTo);
 		
 		JTextField txtTo = new JTextField(5);
 		txtTo.setBounds(320,200,50,25);
 		contentPane.add(txtTo);
 		
 		JLabel lblCourse = new JLabel("Course");
 		lblCourse.setBounds(100,250,100,30);
 		contentPane.add(lblCourse);
 		
 		JTextField txtCourse = new JTextField(10);
 		txtCourse.setBounds(220,250,150,25);
 		contentPane.add(txtCourse);
 		
 		JLabel lblRoomNo = new JLabel("Room No");
 		lblRoomNo.setBounds(100,300,100,30);
 		contentPane.add(lblRoomNo);
 		
 		JTextField txtRoomNo = new JTextField(10);
 		txtRoomNo.setBounds(220,300,150,25);
 		contentPane.add(txtRoomNo);
 		
 		JButton btnModifyTeacher = new JButton("Modify");
 		btnModifyTeacher.setBounds(220,350,100,30);
 		btnModifyTeacher.setSize(80,30);
 		contentPane.add(btnModifyTeacher);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(300,350,100,30);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 		//Creating Border
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,380,350);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);
 		
 		//ActionListener for btnCancel
 		btnCancel.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				dispose();
 			}
 		});
 		
 }
}