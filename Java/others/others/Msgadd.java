import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Msgadd extends JFrame implements ActionListener
{
    JLabel l3;
    JButton bok;
    Container cc;
    JFrame ch;
    Msgadd(String title)
    {
        super(title);
        setSize(500,500);
        setVisible(true);
        cc = getContentPane();
        cc.setLayout(null );

	    setLayout(null);
        l3=new JLabel("Record Saved Successfully...!");
        add(l3);
        l3.setBounds(60,0,150,50);

        bok=new JButton("Ok");
        add(bok);
        bok.setBounds(100,80,60,20);
        bok.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

public void actionPerformed(ActionEvent e)
	{
        String arg=e.getActionCommand();
        if(arg.equals("Ok"))
        {
         Menu m=new Menu("Menu Screen");
            setVisible(false);
			
        }

    }


}

