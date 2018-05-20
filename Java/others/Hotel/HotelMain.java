import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotelMain extends JFrame implements ActionListener
{

    Container cc;
    Frame f;

        HotelMain(String title)
        {
        super(title);
	setBackground(Color.pink);
        cc = getContentPane();
        cc.setLayout(null );
        setSize(500,500);
        setVisible(true);
        setLayout(null);

            JButton b1;
    JLabel nm,add,add1,ph;



    Font ft = new Font("Arial",Font.BOLD,15);
    Font ft1 = new Font("ALGERIAN",Font.BOLD,25);

        setLayout(null);

        b1 = new JButton("Enter");
        b1.setFont(ft);
            b1.addActionListener(this);

        nm = new JLabel("HOTEL SIDDHI");
        nm.setFont(ft1);
        add = new JLabel("Add:-Bhigawan Road,");
        add.setFont(ft);
        add1 = new JLabel("Baramati (Pune).");
        add1.setFont(ft);
        ph = new JLabel("02112-623523");
        ph.setFont(ft);

       add(add1);
       add(add);
       add(ph);
       add(b1);
       add(nm);

        b1.addActionListener(this);

        nm.setBounds(50,60,400,50);
        add.setBounds(100,120,300,30);
        add1.setBounds(110,160,250,30);
        ph.setBounds(116,200,200,30);
        b1.setBounds(120,300,100,40);

       setDefaultCloseOperation(EXIT_ON_CLOSE );
        }

    public void actionPerformed(ActionEvent e)
	{
        if(e.getActionCommand()=="Enter")
        {
           options o=new options("Selecting An Option");
             setVisible(false);
        }
    }
 }

