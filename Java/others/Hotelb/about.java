import java.awt.*;
import javax.swing.*;
import java.*;
import java.awt.event.*;
import javax.swing.event.*;



public class about
{
	public static void main(String agrs[])
	{
		about ac=new about();
	}
	
	public about()
	{
		abt frame=new abt();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
    }
}

class abt extends JFrame
{
	public abt()
	{
		
      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);      
      JPanel panel2 = new JPanel();      
      contentPane.add(panel2);  
      JPanel panel3 = new JPanel();
      contentPane.add(panel3);      
      contentPane.setLayout (new GridLayout(3,2));
      ImageIcon i = new ImageIcon("collegelogo.jpg");
	  JLabel Logo = new JLabel("", i, JLabel.CENTER);
      JLabel Heading=new JLabel("Hotel Reservation System",JLabel.CENTER);
      JLabel Credit=new JLabel("By : Amol(51) , Amit(46) , Uttam(36)",JLabel.CENTER);      
      panel1.add(Logo);      
      panel2.add(Heading);
      panel3.add(Credit);
      Heading.setFont (f1);
      Credit.setFont (f2);
      Color color=new Color(202,228,255);
      Heading.setForeground (Color.red);
      panel1.setBackground (color);
      Credit.setForeground (Color.blue);
      panel2.setBackground (color);
      panel3.setBackground (color);
      JButton ok = new JButton("Ok");
   	  Cursor Pen1 = new Cursor(HAND_CURSOR);
      ok.setCursor(Pen1);
      ok.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
               setVisible(false); 
            } 
         });      
      panel3.add(ok);
      ok.setBackground (color);
      ok.setForeground (Color.red);
      setSize(300, 450);
      setLocation(40,60);

}
private Font f1 = new Font("Tahoma",Font.BOLD,22);   
 private Font f2 = new Font("Arial",Font.BOLD,14);   
 public static final int	HAND_CURSOR	= 12;
}