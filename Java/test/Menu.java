import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Menu extends JFrame implements ActionListener, ItemListener {
    JLabel l1,l2;
    JRadioButton r1,r3,r4,r5;
    JButton bk1;
    ButtonGroup gp;
    Container cc;
    JLabel l3;
    JFrame m;
    Font ft = new Font("Arial",Font.BOLD ,25);
    Font ft1 = new Font("Arial",Font.BOLD,15);
    Menu(String title)
    {
        super(title);
        cc = getContentPane();
        cc.setLayout(null);
        setLayout(null);
        gp=new ButtonGroup();
        setSize(400,400);
        setVisible(true);

        l1=new JLabel("MAIN MENU");
        l1.setFont(ft);
        add(l1);
        l1.setBounds(120,10,190,30);

        l2=new JLabel("OPTIONS");
        add(l2);
        l2.setBounds(120,50,90,30);
        l2.setFont(ft1);
        l3=new         JLabel("--------------------------------------------------------------");
        add(l3);
        l3.setBounds(5,75,600,5);
        l3.setFont(ft1);
        //Redio Buttons
        r1=new JRadioButton("Add new");
        gp.add(r1);
        r1.setBounds(120,90,90,30);
        r3=new JRadioButton("Search");
        gp.add(r3);
        r3.setBounds(120,120,90,30);

        r4=new JRadioButton("Delete");
        gp.add(r4);
        r4.setBounds(120,150,90,30);

        r5=new JRadioButton("Exit");
        gp.add(r5);
        r5.setBounds(120,180,90,30);

        bk1=new JButton("Back");
        add(bk1);
        bk1.setBounds(230,270,90,25);

        r1.addItemListener(this);
        r3.addItemListener(this);
        r4.addItemListener(this);
        r5.addItemListener(this);

        
          cc.add(r1);
          cc.add(r3);
          cc.add(r4);
          cc.add(r5);
        bk1.addActionListener(this);



        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

public static void main(String args[])
	{
	Menu m=new Menu();
	m.setSize(500,500);
	m.setVisible(true);
	m.show();	
	}		

public void actionPerformed(ActionEvent e)
	{

      String arg=e.getActionCommand();
        if(arg.equals("Back"))
        {
         Choice ch = new Choice();
         setVisible(false);
        }


    }

    public void itemStateChanged(ItemEvent e)
    {
         if(e.getItemSelectable()==r1)
         {
            Conditions cond=new Conditions("Condition Screen");
             setVisible(false);
         }
         if(e.getItemSelectable()==r3)
         {
           Search s =new Search("Search screen ");
             setVisible(false);
         }
        if(e.getItemSelectable()==r4)
        {
          Delete Del=new Delete("Delete Screen");
            setVisible(false);

        }
        if(e.getItemSelectable()==r5)
        {
            setVisible(false);
      
        }

    }
}

