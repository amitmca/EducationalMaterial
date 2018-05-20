import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
public class DeleteCommittee extends JFrame
{
public DeleteCommittee()
	{
		setTitle("Delete Committee");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblName=new JLabel("Committee Id"); 		
 		lblName.setBounds(100,100,100,30);
 		contentPane.add(lblName);	
 		
 		JComboBox cboName = new JComboBox(); 		
 		cboName.setBounds(220,100,150,25); 		
 		contentPane.add(cboName);		
 		cboName.addItem("1");
 		cboName.addItem("1");
 		
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