import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;



public class CreateTable extends JInternalFrame implements ActionListener,ItemListener
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
    JLabel lsize;	
    JLabel lnull;
    JLabel lpk;
    JLabel lfk;
    JTable table;
    DefaultTableModel model;		
    public String db="",mytype="",values="";
    JComboBox type,mydatatype;
    public static String colname="",coltype="",size="",ntype="";	
    public static Login l;
    public static String u=l.u;
    public static String p=l.pass;

    public CreateTable()
        {
	super("Create New Table");
        CreateTableLayout customLayout = new CreateTableLayout();
	setLocation(200,100);
	model = new DefaultTableModel();
	model.addColumn("Col1             ");
        model.addColumn("Col2             ");
	model.addColumn("Col3             ");
        model.addColumn("Col4             ");
	model.addColumn("Col5             ");
	model.addColumn("Col6             ");
	
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

	ImageIcon i=new ImageIcon("images/table.PNG");
 	setFrameIcon(i);

        ldatabase = new JLabel("Select Database Name :",new ImageIcon("images/star.gif"),JLabel.LEFT);
	ldatabase.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(ldatabase);

        combodb = new JComboBox();
	combodb.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(combodb);
	combodb.addItemListener(this);

        ltable = new JLabel("Table Name :",new ImageIcon("images/star.gif"),JLabel.LEFT);
	ltable.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(ltable);

        txttable = new JTextField("");
	txttable.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(txttable);

        panel = new JPanel();
        panel.setBackground(Color.gray);	
        getContentPane().add(panel);

        lcolname = new JLabel("Column Name");
	lcolname.setForeground(Color.red);
	lcolname.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lcolname);

    	btnAdd = new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("images\\insertrow.PNG")));
	btnAdd.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnAdd);
	btnAdd.addActionListener(this);

        btnDel = new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("images\\deleterow.PNG")));
	btnDel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnDel);
	btnDel.addActionListener(this);

        btnSave = new JButton("Save",new ImageIcon(ClassLoader.getSystemResource("images\\save.PNG")));
	btnSave.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnSave);
	btnSave.addActionListener(this);

        btnCel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btnCel.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(btnCel);
	btnCel.addActionListener(this);

        lcoltype = new JLabel("Column Type");
	lcoltype.setForeground(Color.red);
	lcoltype.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lcoltype);

	lsize = new JLabel("    Size");
	lsize.setForeground(Color.red);
	lsize.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lsize);

        lnull = new JLabel("Nullable");
	lnull.setForeground(Color.red);
	lnull.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lnull);

        lpk = new JLabel("Primary Key");
	lpk.setForeground(Color.red);
	lpk.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lpk);

        lfk = new JLabel("  Foreign Key");
	lfk.setForeground(Color.red);
	lfk.setFont(new Font("verdana",Font.BOLD,12));
        getContentPane().add(lfk);

	table = new JTable(model){
        public Component prepareRenderer(TableCellRenderer renderer,int row, int col) {
        Component comp = super.prepareRenderer(renderer, row, col);
        JComponent jcomp = (JComponent)comp;
        if (comp == jcomp) {
          jcomp.setToolTipText((String)getValueAt(row, col));
	  Color c77=new Color(140,196,170);
	  jcomp.setBackground(c77);
        }
        return comp;
      }
    };

	table.setForeground(Color.yellow);
	table.setFont(new Font("verdana",Font.BOLD,14));
	table.setRowHeight(25);

	panel.add(table);
	Color c1=new Color(220,249,255);
	panel.setBackground(c1);

	Color c=new Color(220,231,170);
	getContentPane().setBackground(c);

	Vector col1 = new Vector();
	
        col1.add("INT");
        col1.add("INTEGER");
        col1.add("TINYINT");
        col1.add("SMALLINT");
        col1.add("BIGINT");
        col1.add("CHAR");
        col1.add("VARCHAR");
        col1.add("TEXT");
	col1.add("BOOL");
	col1.add("DATE");
	col1.add("TIME");
	col1.add("DATETIME");
	col1.add("FLOAT");
	col1.add("DOUBLE");
	col1.add("REAL");
	col1.add("CURRENCY");
	col1.add("BINARY");
	col1.add("BLOB");
	col1.add("BLOB-INT");
        col1.add("BLOB-TINYINT");
        col1.add("BLOB-SMALLINT");
        col1.add("BLOB-BIGINT");
        col1.add("BLOB-CHAR");
        col1.add("BLOB-VARCHAR");
        col1.add("BLOB-TEXT");
	col1.add("BLOB-BOOL");
	col1.add("BLOB-DATE");
	col1.add("BLOB-DATETIME");
	col1.add("BLOB-FLOAT");

	TableColumnModel model1 = table.getColumnModel();
        TableColumn col = model1.getColumn(1);
	mydatatype=new JComboBox(col1);
	mydatatype.addItemListener(this);
	col.setCellEditor(new DefaultCellEditor(mydatatype));
	
	Vector col2 = new Vector();
	col2.add("Not Null");
	col2.add("Null");
	TableColumn col3 = model1.getColumn(3);
	type=new JComboBox(col2);
	type.addItemListener(this);
        col3.setCellEditor(new DefaultCellEditor(type));

	TableColumn c11 = table.getColumnModel().getColumn(0);
	TableColumn c2 = table.getColumnModel().getColumn(1);
	TableColumn c3 = table.getColumnModel().getColumn(2);
	TableColumn c4 = table.getColumnModel().getColumn(3);
	TableColumn c5 = table.getColumnModel().getColumn(4);
	TableColumn c6 = table.getColumnModel().getColumn(5);
	

	c11.setPreferredWidth(100);
	c2.setPreferredWidth(100);
	c3.setPreferredWidth(100);
	c4.setPreferredWidth(100);
	c5.setPreferredWidth(100);
	c6.setPreferredWidth(100);

	
        setSize(getPreferredSize());
        }

public Object GetData(JTable table, int row_index, int col_index){
    return table.getModel().getValueAt(row_index, col_index);
  }  


 public void itemStateChanged(ItemEvent ie)
	{

	if(ie.getSource()==combodb)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			db=(String)ie.getItem();
			}	
		}
	/*if(ie.getSource()==type)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			b=(String)ie.getItem();
			}	
		}
	if(ie.getSource()==mydatatype)
		{
		if(ie.getStateChange()==ItemEvent.SELECTED)
			{
			a=(String)ie.getItem();
			}	
		}*/
	}


public void actionPerformed(ActionEvent ae)
	{
	
	if(ae.getSource()==btnCel)
		{
		this.setVisible(false);
		}

	if(ae.getSource()==btnAdd)
		{
		model.insertRow(0,new Object[]{""});
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
			JOptionPane.showMessageDialog(null,"Please enter Table Name","Error",JOptionPane.ERROR_MESSAGE);
			}
		else
			{
			int row=table.getRowCount();
			String str[]=new String[50];
	 	        int k=0;

			for(int i=0;i<row;i++)
				{
				for(int j=0;j<4;j++)
					{
					Object obj1=GetData(table,i,j);
					values=obj1.toString();
					str[k++]=values;	
					}
				}
			int a=0,b=1,c=2,d=3;
			for(int i=0;i<k;i=i+4)
				{
				for(int j=i;j<i+4;j++)
					{
					if(j==a || j==a+4)
						{
						colname=str[j];
						}
					else if(j==b || j==b+4)
						{
						coltype=str[j];
						}
					else if(j==c || j==c+4)
						{
						size=str[j];
						}
					else if(j==d || j==d+4)
						{
						ntype=str[j];
						}
					a=a+4;b=b+4;c=c+4;d=d+4;	
					System.out.println(colname+"\t"+coltype+"\t"+size+"\t"+ntype+"\n");		
					}
				
				}
			JOptionPane.showMessageDialog(null,"Table Created","Create",JOptionPane.INFORMATION_MESSAGE);
			}	
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
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+120,600,240);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+80,112,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+376,136,24);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+160,insets.top+376,136,24);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+312,insets.top+376,144,24);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+472,insets.top+376,144,24);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+80,112,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+240,insets.top+80,104,24);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+344,insets.top+80,88,24);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+432,insets.top+80,88,24);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+520,insets.top+80,96,24);}
    }
}
