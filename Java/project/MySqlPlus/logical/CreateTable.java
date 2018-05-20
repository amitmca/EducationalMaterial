import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class CreateTable extends JInternalFrame implements ActionListener
 {
    JLabel ldatabase;
    JComboBox combodb;
    JLabel ltable;
    JTextField txttable;
    JPanel panel;
    JLabel lcolname;
    JButton btnAdd;
    JButton btnDel;
    JButton btnSave;
    JButton btnCel;
    JLabel lcoltype;
    JLabel lnull;
    JLabel lpk;
    JLabel lfk;
    JTable table;
    DefaultTableModel model;		
    public String str="";

    public CreateTable()
        {
	super("Create New Table");
        CreateTableLayout customLayout = new CreateTableLayout();

	model = new DefaultTableModel();
	model.addColumn("Col1             ");
        model.addColumn("Col2             ");
	model.addColumn("Col3             ");
        model.addColumn("Col4             ");
	model.addColumn("Col5             ");

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

	ImageIcon i=new ImageIcon("images/table.PNG");
 	setFrameIcon(i);

        ldatabase = new JLabel("Select Database Name :");
        getContentPane().add(ldatabase);

        combodb = new JComboBox();
        combodb.addItem("item1");
        combodb.addItem("item2");
        getContentPane().add(combodb);

        ltable = new JLabel("Table Name :");
        getContentPane().add(ltable);

        txttable = new JTextField("");
        getContentPane().add(txttable);

        panel = new JPanel();
        getContentPane().add(panel);

        lcolname = new JLabel("Column Name");
        getContentPane().add(lcolname);

    	btnAdd = new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("images\\insertrow.PNG")));
        getContentPane().add(btnAdd);
	btnAdd.addActionListener(this);

        btnDel = new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("images\\deleterow.PNG")));
        getContentPane().add(btnDel);
	btnDel.addActionListener(this);

        btnSave = new JButton("Save",new ImageIcon(ClassLoader.getSystemResource("images\\save.PNG")));
        getContentPane().add(btnSave);
	btnSave.addActionListener(this);

        btnCel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
        getContentPane().add(btnCel);
	btnCel.addActionListener(this);

        lcoltype = new JLabel("Column Type");
        getContentPane().add(lcoltype);

        lnull = new JLabel("Nullable");
        getContentPane().add(lnull);

        lpk = new JLabel("PK");
        getContentPane().add(lpk);

        lfk = new JLabel("FK");
        getContentPane().add(lfk);

	table = new JTable(model);
	panel.add(table);
	Color c=new Color(146,183,213);
	getContentPane().setBackground(c);

        setSize(getPreferredSize());
        }

 public void itemStateChanged(ItemEvent ie)
	{
	try
	    {
	    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
	    String url="jdbc:odbc:mysql";
				
	    Connection conn=DriverManager.getConnection(url,"root","amit12");		

            Statement st=conn.createStatement();
			
  	    str=(String)ie.getItem();

            String sql="use "+str;
	
            st.execute(sql);
		
	    }
	catch(Exception e)
	   {
	   String str2=e.getMessage();
	   JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
	   }	
	}

public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnCel)
		{
		this.setVisible(false);
		}
	if(ae.getSource()==btnAdd)
		{
		model.insertRow(0, new Object[]{""});
		
		}
	if(ae.getSource()==btnDel)
		{
		model.removeRow(table.getRowCount()-1);
		if(table.getRowCount()==0)
	 	  {
          	  JOptionPane.showMessageDialog(null,"No Rows To Delete","No Rows To Delete",JOptionPane.INFORMATION_MESSAGE);
           	  }	
    		}	
	if(ae.getSource()==btnSave)
		{
		String tablename=txttable.getText();
		if(tablename.equals(""))
			{
			JOptionPane.showMessageDialog(null,"Please enter Table Name","Please enter Table Name",JOptionPane.ERROR_MESSAGE);
			}
		/*Vector data = model.getDataVector();
		
		String a=data.toString();
		System.out.println(a);*/
		//String a=model.GetData(0);
		//System.out.println(a);
		}

	}

}

class CreateTableLayout implements LayoutManager {

    public CreateTableLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 623 + insets.left + insets.right;
        dim.height = 413 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+8,232,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,192,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+8,216,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+360,insets.top+40,160,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+112,488,224);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+80,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+376,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+376,136,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+376,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+472,insets.top+376,144,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+152,insets.top+80,104,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+256,insets.top+80,88,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+80,88,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,88,24);}
    }
}
