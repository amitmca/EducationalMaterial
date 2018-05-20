import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class addDept extends JFrame
{
	JLabel lblDeptId,lblDeptName;
	JTextField txtDeptId;
	JComboBox cboDeptName;
	public addDept()
	{
		setTitle("Add ClassRoom");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		lblDeptId=new JLabel("Dept Id"); 		
 		lblDeptId.setBounds(100,100,100,30);
 		contentPane.add(lblDeptId);	
 		
 		txtDeptId=new JTextField(5);
 		txtDeptId = new JTextField(15);
 		txtDeptId.setBounds(220,100,150,25); 		
 		contentPane.add(txtDeptId);		
 		
 		JLabel lblDeptName=new JLabel("Dept Name"); 		
 		lblDeptName.setBounds(100,150,100,30);
 		contentPane.add(lblDeptName);	
 		
 		cboDeptName = new JComboBox(); 		
 				
 		cboDeptName.setBounds(220,150,150,25);
 		contentPane.add(cboDeptName);		 		
 		
 		
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