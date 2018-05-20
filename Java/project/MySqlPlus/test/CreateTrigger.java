import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class CreateTrigger extends JInternalFrame implements ActionListener,ItemListener
{
    JLabel l1;
    JComboBox dbcombo;
    JTextArea txttrigger;
    JScrollPane sp_txttrigger;
    JButton btncreate;
    JButton btncel;
    JButton btnclr;
    public static String db="";
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;	  

    public CreateTrigger() 
	{
        super("Create New Trigger");
	setLocation(275,25);
	ImageIcon i=new ImageIcon("images/asterisk_orange.PNG");
 	setFrameIcon(i);	
	CreateTriggerLayout customLayout = new CreateTriggerLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        l1 = new JLabel("Databases :");
	l1.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(l1);

	dbcombo = new JComboBox();
	dbcombo.setFont(new Font("verdana",Font.BOLD,12));
	dbcombo.addItemListener(this);
        getContentPane().add(dbcombo);

        txttrigger = new JTextArea("");	
	txttrigger.setFont(new Font("verdana",Font.BOLD,12));
        sp_txttrigger = new JScrollPane(txttrigger);
        getContentPane().add(sp_txttrigger);

        btncreate = new JButton("Create",new ImageIcon(ClassLoader.getSystemResource("images\\checkmark_orange.gif")));
	btncreate.setFont(new Font("verdana",Font.BOLD,12));
	btncreate.addActionListener(this);
        getContentPane().add(btncreate);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana",Font.BOLD,12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

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
	String sql=txttrigger.getText();
	if(ae.getSource()==btncel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnclr)
		{
		if(sql.equals(""))
			{
			JOptionPane.showMessageDialog(null,"Already Empty","Error",JOptionPane.ERROR_MESSAGE);		
			}
		else
			{
			txttrigger.setText("");		
			}
		}
	if(ae.getSource()==btncreate)
		{
		if(sql.equals(""))
		   {
		   JOptionPane.showMessageDialog(null,"Please Enter Trigger Code","Error",JOptionPane.ERROR_MESSAGE);	
		   }
		else	
		   {
		   try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
			Statement st=conn.createStatement();

			st.executeUpdate(sql);

			JOptionPane.showMessageDialog(null,"Trigger Created","Trigger",JOptionPane.INFORMATION_MESSAGE);

			txttrigger.setText("");
			
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

class CreateTriggerLayout implements LayoutManager
 {

    public CreateTriggerLayout() 
	{
        }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 474 + insets.left + insets.right;
        dim.height = 467 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+50,insets.top+34,176,16);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+136,insets.top+32,176,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+80,416,328);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+424,112,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+328,insets.top+424,120,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+176,insets.top+424,120,24);}
    }
}
