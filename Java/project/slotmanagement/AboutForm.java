import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
public class AboutForm extends JFrame
{
public AboutForm()
	{
		setTitle("Slot Management System");
		setSize(500,400);				
		setLocation(150,100);
	
		Container contentPane =getContentPane();
 		contentPane.setLayout(null);
 		
 		JLabel l1 = new JLabel("THIS PRODUCT IS LICENSED TO:");
 		l1.setBounds(90,80,500,30); 		 		
 		l1.setForeground(Color.blue);
 		contentPane.add(l1);
 		
 		JLabel l7 = new JLabel("Nowrosjee Wadia College");
 		l7.setBounds(150,110,500,30); 		
 		contentPane.add(l7); 		
 		
 		JLabel l2 = new JLabel("DEVELOPED BY:");
 		l2.setBounds(90,140,500,30);
 		l2.setForeground(Color.blue);
 		contentPane.add(l2);
 		
 		JLabel l3 = new JLabel("Laxmikant G Pawar");
 		l3.setBounds(150,170,500,30);
 		contentPane.add(l3);
 		
 		JLabel l4 = new JLabel("Swapnil S Changade");
 		l4.setBounds(150,200,500,30);
 		contentPane.add(l4);
 		
 		JLabel l5 = new JLabel("Balasaheb Gawade");
 		l5.setBounds(150,230,500,30);
 		contentPane.add(l5);
 		
 		JLabel l6 = new JLabel("VERSION:"); 		
 		l6.setBounds(90,260,500,30); 
 		l6.setForeground(Color.blue);		
 		contentPane.add(l6);
 		
 		JLabel l8 = new JLabel("1.0");
 		l8.setBounds(150,260,100,30);
 		contentPane.add(l8);
 		
 		//Creating button
 		JButton btnOk =new JButton("Ok"); 		 		
 		btnOk.setBounds(360,280,150,25);
 		btnOk.setSize(50,30);
 		contentPane.add(btnOk);
 		
 		//ActionListener for btnOk
 		btnOk.addActionListener(new ActionListener()
 		{
 			public void actionPerformed(ActionEvent e)
 			{
 				dispose();
 			}
 		});
 		//Creating Border
 		
 		Border etched = BorderFactory.createEtchedBorder();
 		Border titled = BorderFactory.createTitledBorder
 		(etched,"About Software");
 		
 		JPanel buttonPanel = new JPanel();
 		buttonPanel.setBounds(50,50,380,270);
 		buttonPanel.setBorder(titled);
 		contentPane.add(buttonPanel);		
	 }
}