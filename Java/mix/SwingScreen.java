import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SwingScreen extends JFrame implements ActionListener
{
	JDialog jdSwing;
	Container cSwing;

	JTextField tfText1;
	JTextField tfText2;
	JTextField tfText3;
	JTextField tfText4;
	JTextField tfText5;
	
	JLabel l1;
	JLabel l2;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	
	Font f;
	
	SwingScreen()
	{
		jdSwing = new JDialog();
		jdSwing.setBounds(0,45,400,390);
		cSwing = jdSwing.getContentPane();
		cSwing.setLayout(null);
		jdSwing.setTitle("Swing Screen");
		
		l1 = new JLabel("String Operations:");
		l1.setBounds(20,45,130,25);
		
		l2 = new JLabel("Enter String:");
		l2.setBounds(20,95,130,25);
		
		b1 = new JButton("LOWER");
		b1.setBounds(20,150,150,25);
		
		b2 = new JButton("UPPER");
		b2.setBounds(20,200,150,25);
		
		b3 = new JButton("Italic");
		b3.setBounds(20,250,150,25);
		
		b4 = new JButton("Bold");
		b4.setBounds(20,300,150,25);
		
		tfText1 = new JTextField();
		tfText1.setBounds(225,95,150,25);
		
		tfText2 = new JTextField();
		tfText2.setBounds(225,150,150,25);
		tfText2.setEditable(false);
		
		tfText3 = new JTextField();
		tfText3.setBounds(225,200,150,25);
		tfText3.setEditable(false);
		
		tfText4 = new JTextField();
		tfText4.setBounds(225,250,150,25);
		tfText4.setEditable(false);
		
		tfText5 = new JTextField();
		tfText5.setBounds(225,300,150,25);
		tfText5.setEditable(false);
		
		cSwing.add(tfText1);
		cSwing.add(tfText2);
		cSwing.add(tfText3);
		cSwing.add(tfText4);
		cSwing.add(tfText5);
		
		cSwing.add(l1);
		cSwing.add(l2);
		
		cSwing.add(b1);
		cSwing.add(b2);
		cSwing.add(b3);
		cSwing.add(b4);
		
		jdSwing.show();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		jdSwing.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				jdSwing.dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[])
	{
		SwingScreen rn = new SwingScreen();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String btnCaption;
		
		btnCaption = ae.getActionCommand();
		
		if(btnCaption.equals("LOWER"))
		{
			tfText2.setText((tfText1.getText()).toLowerCase());
		}
		
		else
		if(btnCaption.equals("UPPER"))
		{
			tfText3.setText((tfText1.getText()).toUpperCase());
		}
		
		else
		if(btnCaption.equals("Italic"))
		{
			f = new Font(tfText1.getText(),Font.ITALIC,14);
			
			tfText4.setFont(f);
			tfText4.setText(tfText1.getText());
		}
		
		else
		if(btnCaption.equals("Bold"))
		{
			f = new Font(tfText1.getText(),Font.BOLD,14);
			
			tfText5.setFont(f);
			tfText5.setText(tfText1.getText());
		}
	}
}
