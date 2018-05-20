import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guical implements ActionListener
{
      JFrame f;
      JLabel l1,l2,l3,l4;
      JTextField t1,t2,t3,t4;
      JPanel p1,p2;
      JButton b1,b2;
      
      public guical()
      {
            f=new JFrame();
            f.setVisible(true);
            f.setSize(500, 800);
            f.setLayout(new BorderLayout());
            f.getContentPane().setBackground(Color.YELLOW);
      
            l1=new JLabel("Decimal");
            l2=new JLabel("Binary");
            l3=new JLabel("Octal");
            l4=new JLabel("Hexadecimal");
      
            t1=new JTextField(20);
            t2=new JTextField(20);
            t3=new JTextField(20);
            t4=new JTextField(20);
      
            p1=new JPanel(new GridLayout(4, 2));
            p2=new JPanel(new GridLayout(1, 2));
      
      		p1.add(l1);
      		p1.add(t1);
      		
      		p1.add(l2);
      		p1.add(t2);
      		
      		p1.add(l3);
   	 	p1.add(t3);
      		
      		p1.add(l3);
      		p1.add(t3);
      		
      		p1.add(l4);
      		p1.add(t4);
      		
      		b1=new JButton("Calculate");
      		b2=new JButton("Exit");
      		
      		p2.add(b1);
      		p2.add(b2);
      		
      		f.add(p1, BorderLayout.CENTER);
      		f.add(p2, BorderLayout.SOUTH);
      		f.pack();
      		
      		b1.addActionListener(this);
      		b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
      if(ae.getSource()==b1)
      {
            if(!t1.getText().trim().equals(""))
            {
            		int n=Integer.parseInt(t1.getText().trim());
            		t2.setText(Integer.toBinaryString(n));
            		t3.setText(Integer.toOctalString(n));
            		t4.setText(Integer.toHexString(n));
            }
      }
        if(ae.getSource()==b2)
        {
              System.exit(0);
        }
  }
  public static void main(String[] args)
  {
        new guical();
  }
}

