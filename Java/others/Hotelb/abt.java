import java.awt.*;
import javax.swing.*;
import java.*;

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

class  abt extends JDialog
{
	public abt(JFrame owner)
	{
		super(owner, "About College Placement", true);         
      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);      
      JPanel panel2 = new JPanel();      
      contentPane.add(panel2);  
      JPanel panel3 = new JPanel();
      contentPane.add(panel3);      
      contentPane.setLayout (new GridLayout(3,2));
      ImageIcon i = new ImageIcon("Flow1.gif");
	  JLabel Logo = new JLabel("", i, JLabel.CENTER);
      JLabel Heading=new JLabel("College Placement",JLabel.CENTER);
      JLabel Credit=new JLabel("By : Pallavi(37) , Supriya(39) , Rohini(48)",JLabel.CENTER);      
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
      setSize(315, 335);
      setLocation(20,60);
   }
  
   private Font f1 = new Font("Tahoma",Font.BOLD,22);   
   private Font f2 = new Font("Arial",Font.BOLD,14);   
   public static final int	HAND_CURSOR	= 12;
}