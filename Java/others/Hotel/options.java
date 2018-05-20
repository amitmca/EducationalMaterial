import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class options extends JFrame implements ActionListener
{
    JLabel l3;
    JButton add,del,check;
    Container cc;
    JFrame ch;
    options(String title)
    {
        super(title);
        setSize(500,500);
        setVisible(true);
        cc = getContentPane();
        cc.setLayout(null );

	setLayout(null);
        l3=new JLabel("Select the operation to do");
        add(l3);
        l3.setBounds(60,0,150,50);

        add=new JButton("ADD");
        add(add);
        add.setBounds(100,80,60,20);
        add.addActionListener(this);

        del=new JButton("DELETE");
        add(del);
        del.setBounds(100,120,80,20);
        del.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

public void actionPerformed(ActionEvent e)
	{
        String arg=e.getActionCommand();
        if(arg.equals("ADD"))
        {
         FormAdd f=new FormAdd("Customer Details");
	 f.setVisible(true);	
         this.setVisible(false);
			
        }

    }


}

