import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class DeleteClassRoom extends JFrame
{
	public DeleteClassRoom()
	{
		setTitle("Delete ClassRoom");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblDeleteClassRoomNo=new JLabel("ClassRoom No"); 		
 		lblDeleteClassRoomNo.setBounds(100,100,100,30);
 		contentPane.add(lblDeleteClassRoomNo);	
 		
 		JTextField txtDeleteClassRoomName = new JTextField(10); 		
 		txtDeleteClassRoomName.setBounds(220,100,150,25); 		
 		contentPane.add(txtDeleteClassRoomName);		
 		
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
 		
 		//Addading actionLister on Delete
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