import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;

public class Main extends JFrame implements ActionListener
   {
    JLabel query;
    JLabel hand;
    JTextArea taquery;
    JScrollPane sp_taquery;
    JButton btnexe;
    JTextArea resultset;
    JScrollPane sp_resultset;
    JLabel top;
    JLabel bottom;
    JLabel left;
    JLabel right;
    JButton btnclr;
    JTextField txtcmd;
    JLabel cmd;
    JButton btnexit;
    ImageIcon i1,i2,i3,i4,i5,i6;	
    JOptionPane jop;

    public Main() {
        MainLayout customLayout = new MainLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

	i1=new ImageIcon("images/up.gif");
	i2=new ImageIcon("images/left.gif");
	i3=new ImageIcon("images/right.gif");
	i4=new ImageIcon("images/bttm.gif");
	i5=new ImageIcon("images/query.jpg");
	i6=new ImageIcon("images/next.gif");

        query = new JLabel(i5);
        getContentPane().add(query);

        hand = new JLabel(i6);
        getContentPane().add(hand);

        taquery = new JTextArea("");
        sp_taquery = new JScrollPane(taquery);
        getContentPane().add(sp_taquery);
	taquery.setFont(new Font("Verdana, Arial, Helvetica", Font.BOLD, 20));
	taquery.setForeground(Color.blue);
	taquery.setBackground(Color.yellow);

        btnexe = new JButton("EXECUTE");
        getContentPane().add(btnexe);

        resultset = new JTextArea("");
        sp_resultset = new JScrollPane(resultset);
        getContentPane().add(sp_resultset);
	resultset.setFont(new Font("Verdana, Arial, Helvetica", Font.BOLD, 20));
	resultset.setForeground(Color.magenta);
	resultset.setBackground(Color.yellow);	

        top = new JLabel(i1);
        getContentPane().add(top);

        bottom = new JLabel(i4);
        getContentPane().add(bottom);

        left = new JLabel(i2);
        getContentPane().add(left);

        right = new JLabel(i3);
        getContentPane().add(right);

        btnclr = new JButton("CLEAR");
        getContentPane().add(btnclr);

        txtcmd = new JTextField("");
        getContentPane().add(txtcmd);
   

        cmd = new JLabel("First Specify Command Here");
        getContentPane().add(cmd);

        btnexit = new JButton("EXIT");
        getContentPane().add(btnexit);
	btnexe.addActionListener(this);
	btnclr.addActionListener(this);
	btnexit.addActionListener(this);
	
        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


 

    public static void main(String args[]) {
        Main window = new Main();

        window.setTitle("Welcome to Mysql GUI ");
        window.pack();
        window.show();
    }

 public void actionPerformed(ActionEvent ae)
	{
	String command=txtcmd.getText();

	if(ae.getSource()==btnexit)
		{
		System.exit(0);
		}
	if(ae.getSource()==btnexe)
		{
		if(command.equals("insert") || command.equals("delete"))
			{
			try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
				String url="jdbc:odbc:mysql";
			
				Connection conn=DriverManager.getConnection(url,"root","");
		
				Statement st=conn.createStatement();

				String sql=taquery.getText();

				st.executeUpdate(sql);

				resultset.setText("Query OK, 1 row affected (0.05 sec)");
				}
			catch(Exception e)
				{
				System.out.print(e);
				}
			}
		if(command.equals("select"))
			{
			try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
				String url="jdbc:odbc:mysql";
			
				Connection conn=DriverManager.getConnection(url,"root","");
		
				Statement st=conn.createStatement();

				
				String sql=taquery.getText();

				boolean r=st.execute(sql);

				if(r)
				{
				ResultSet res=st.getResultSet();
				if(res!=null)
					{
					ResultSetMetaData rm=res.getMetaData();
					int n=rm.getColumnCount();
					String ok=Integer.toString(n);
					//jop.showMessageDialog(null,ok,ok, jop.ERROR_MESSAGE);
					String text="";
					/*for(int i=1;i<=n;++i)	
						{
						if(i<=n)
							text=text+rm.getColumnName(i)+"|";
						else
							text=text+rm.getColumnName(i)+"|";
						}*/
					text=" ";
			
					while(res.next())
						{
						for(int i=1;i<=n;++i)
							{
							if(i<=n)
								text=res.getString(i)+"|";
							else 
								text=res.getString(i)+"|";
							}
						text="\n";
						jop.showMessageDialog(null,text,text, jop.ERROR_MESSAGE);
		//				resultset.setText(text);
						}
					
					}
				}	
				}
			catch(Exception e)
				{
				System.out.print(e);
				}
			}
		
		}
	
	}
}

class MainLayout implements LayoutManager {

    public MainLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 734 + insets.left + insets.right;
        dim.height = 627 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+64,120,40);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+216,insets.top+64,48,40);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+64,376,88);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+264,insets.top+160,96,32);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+216,560,328);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+0,720,40);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+576,720,48);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+8,insets.top+40,64,544);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+672,insets.top+40,56,544);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+384,insets.top+160,104,32);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+120,168,24);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+88,insets.top+160,168,16);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+512,insets.top+160,96,32);}
    }
}
