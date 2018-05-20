import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class DropTrigger extends JInternalFrame implements ActionListener,ItemListener
 {
    JLabel l;
    JLabel l1;
    JComboBox dbcombo;
    JButton btndrop;
    JButton btncel;
    JTextField textfield_1;
    JButton btnclr;
    public static String db="";
    public static Login l2;
    public static String u=l2.u;
    public static String p=l2.pass;

    public DropTrigger() 
	{
	super("Drop Trigger");
	setLocation(275,150);
	ImageIcon i=new ImageIcon("images/submitS.PNG");
 	setFrameIcon(i);

        DropTriggerLayout customLayout = new DropTriggerLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        l = new JLabel("Select Database Name :");		
	l.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l);

        l1 = new JLabel("Trigger Name :");
	l1.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l1);

        dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana",Font.BOLD,12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        btndrop = new JButton("Drop",new ImageIcon(ClassLoader.getSystemResource("images\\checkmark_orange.gif")));
	btndrop.setFont(new Font("verdana",Font.BOLD,12));
	btndrop.addActionListener(this);
        getContentPane().add(btndrop);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

        textfield_1 = new JTextField("");
	textfield_1.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(textfield_1);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\goccc.gif")));
	btnclr.setFont(new Font("verdana",Font.BOLD,12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

        setSize(getPreferredSize());
        Color c1=new Color(220,231,170);
	getContentPane().setBackground(c1);
    }
public void itemStateChanged(ItemEvent ie)
	{
	
	if(ie.getSource()==dbcombo)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			db=(String)dbcombo.getSelectedItem();
			}
		}
	}
	public void actionPerformed(ActionEvent ae)
	{	
	String trigname=textfield_1.getText();
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnclr)
		{
		if(trigname.equals(""))
			{
			JOptionPane.showMessageDialog(null,"Already Empty","Error",JOptionPane.ERROR_MESSAGE);		
			}
		else
			{
			textfield_1.setText("");		
			}
		}
	if(ae.getSource()==btndrop)
		{
		if(trigname.equals(""))
		   {
		   JOptionPane.showMessageDialog(null,"Please Enter Trigger Name","Error",JOptionPane.ERROR_MESSAGE);	
		   }
		else	
		   {
		   try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");	
			
			Statement st=conn.createStatement();

			String sql="drop trigger "+db+"."+trigname;

			st.executeUpdate(sql);

			JOptionPane.showMessageDialog(null,"Trigger Dropped","Trigger",JOptionPane.INFORMATION_MESSAGE);

			textfield_1.setText("");
			
			conn.close();
			}

		   catch(Exception e)
			{
			String str = e.getMessage();
			JOptionPane.showMessageDialog(null,str,"Error", JOptionPane.ERROR_MESSAGE);
			}
		    }
		}
	}
   
}

class DropTriggerLayout implements LayoutManager {

    public DropTriggerLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 400 + insets.left + insets.right;
        dim.height = 129 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+24,160,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+24,160,16);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+48,160,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,104,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+96,112,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+224,insets.top+48,160,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+96,120,24);}
    }
}
