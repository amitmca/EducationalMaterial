import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class ModifyClassRoom extends JFrame
{
	ModifyClassRoom()
	{
		setTitle("Modify ClassRoom");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel lblMCRoomNo=new JLabel("Room No"); 		
 		lblMCRoomNo.setBounds(100,100,100,30);
 		contentPane.add(lblMCRoomNo);	
 		
 		JTextField txtMCRoomNo = new JTextField(5);
 		txtMCRoomNo = new JTextField(15);
 		txtMCRoomNo.setBounds(220,100,150,25); 		
 		contentPane.add(txtMCRoomNo);		
 		
 		JLabel lblMCNoOfFloors=new JLabel("No of Floors"); 		
 		lblMCNoOfFloors.setBounds(100,150,100,30);
 		contentPane.add(lblMCNoOfFloors);	
 		
 		JTextField cboMCName = new JTextField(); 		
 				
 		cboMCName.setBounds(220,150,150,25);
 		contentPane.add(cboMCName);		
 		
 		
 		JLabel lblMCCapacity=new JLabel("Capacity"); 		
 		lblMCCapacity.setBounds(100,200,100,30);
 		contentPane.add(lblMCCapacity);	
 		
 		JTextField txtMCCapacity= new JTextField(10); 		
 		txtMCCapacity.setBounds(220,200,150,25); 		
 		contentPane.add(txtMCCapacity);		
 		
 		JLabel lblMCProjector = new JLabel("Projector");
 		lblMCProjector.setBounds(100,250,100,30);
 		contentPane.add(lblMCProjector);
 		
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