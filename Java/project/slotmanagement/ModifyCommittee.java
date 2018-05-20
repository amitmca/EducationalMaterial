import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
public class ModifyCommittee extends JFrame
{
	public ModifyCommittee()
	{
		setTitle("Modify Committee");
		setSize(500,450);				
		setLocation(150,100);
		
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
		JLabel lblCommitteeId = new JLabel("Committee Id");
		lblCommitteeId.setBounds(100,100,100,30);
		contentPane.add(lblCommitteeId);
		
		JTextField txtCommitteeId = new JTextField(10);
		txtCommitteeId.setBounds(220,100,150,25);
		contentPane.add(txtCommitteeId);
		
		JLabel lblCommitteeName = new JLabel("Committee Name");
		lblCommitteeName.setBounds(100,150,100,30);
		contentPane.add(lblCommitteeName);
		
		JTextField txtCommitteeName = new JTextField(10);
		txtCommitteeName.setBounds(220,150,150,25);
		contentPane.add(txtCommitteeName);
		
		JLabel lblNoOfMember = new JLabel("No Of Member");
		lblNoOfMember.setBounds(100,200,100,30);
		contentPane.add(lblNoOfMember);
		
		JTextField txtNoOfMember = new JTextField(10);
		txtNoOfMember.setBounds(220,200,150,25);
		contentPane.add(txtNoOfMember);
		
		JLabel lblComitteeHead = new JLabel("Committee Head");
		lblComitteeHead.setBounds(100,250,100,30);
		contentPane.add(lblComitteeHead);
		
		JTextField txtComitteeHead = new JTextField(10);
		txtComitteeHead.setBounds(220,250,150,25);
		contentPane.add(txtComitteeHead);		
		
		JButton btnSave =new JButton("Save"); 		 		
 		btnSave.setBounds(210,300,150,25);
 		btnSave.setSize(80,30);
 		contentPane.add(btnSave);
 		
 		JButton btnCancel = new JButton("Cancel");
 		btnCancel.setBounds(290,300,150,25);
 		btnCancel.setSize(80,30);
 		contentPane.add(btnCancel);
 		
 			//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"Information");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,380,320);
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