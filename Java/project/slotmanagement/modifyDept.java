import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class modifyDept extends JFrame
{
	public  modifyDept()
	{
		setTitle("Add ClassRoom");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblMDeptId=new JLabel("Dept Id"); 		
 		lblMDeptId.setBounds(100,100,100,30);
 		contentPane.add(lblMDeptId);	
 		
 		JTextField txtMDeptId=new JTextField(5);
 		txtMDeptId = new JTextField(15);
 		txtMDeptId.setBounds(220,100,150,25); 		
 		contentPane.add(txtMDeptId);		
 		
 		JLabel lblMDeptName=new JLabel("Dept Name"); 		
 		lblMDeptName.setBounds(100,150,100,30);
 		contentPane.add(lblMDeptName);	
 		
 		JComboBox cboMDeptName = new JComboBox(); 		
 				
 		cboMDeptName.setBounds(220,150,150,25);
 		contentPane.add(cboMDeptName);		 		
 		
 		
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
