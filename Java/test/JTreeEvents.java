import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.sql.*;


public class JTreeEvents extends JInternalFrame
	{
	JTree tree;
	JTextField jtf;
	ImageIcon i;
	DefaultMutableTreeNode top;
	DefaultMutableTreeNode a,a1;

	public JTreeEvents()
		{
		Container cp=getContentPane();
		i=new ImageIcon("images/star.gif");
		setFrameIcon(i);
		setBackground(new Color(146,183,213));
		cp.setLayout(new BorderLayout());

		top=new DefaultMutableTreeNode("Databases");

		tree=new JTree(top);
		int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp=new JScrollPane(tree,v,h);
		cp.add(jsp,BorderLayout.CENTER);
		
		jtf=new JTextField("",20);
		cp.add(jtf,BorderLayout.SOUTH);

		tree.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e)
			{
			doMouseClicked(e);
			}
		});
		}
	void doMouseClicked(MouseEvent e)
		{
		TreePath tp=tree.getPathForLocation(e.getX(),e.getY());
		if(tp!=null)
			{
			jtf.setFont(new Font("Verdana, Arial, Helvetica",Font.BOLD,12));
			jtf.setText(tp.toString());
			}
			
		else
			jtf.setText("");	

		try
		  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		  String url="jdbc:odbc:mysql";
			
		  Connection conn=DriverManager.getConnection(url,"root","amit12");		
		
		  Statement st=conn.createStatement();

		  String sql="show databases";

		  ResultSet rs=st.executeQuery(sql);

		  String text=" ";
		
  		  int count=0;

		  while(rs.next())
		     {
		     text=rs.getString(1);
		     a=new DefaultMutableTreeNode(text);
	             top.add(a);						
		     }

		  Statement st1=conn.createStatement(); 	
		
		  String sql1="show tables";

		  ResultSet rs1=st1.executeQuery(sql1);

		  String text1=" ";

	          while(rs1.next())
		     {
		     text=rs1.getString(1);
		     a1=new DefaultMutableTreeNode(text1);
	             a.add(a1);
		     }
		 }
		 catch(Exception e1)
		  {
		  String str2=e1.getMessage();
		  JOptionPane.showMessageDialog(null,str2,str2,JOptionPane.ERROR_MESSAGE); 		
		  }
		}
	}