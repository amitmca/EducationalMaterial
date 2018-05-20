import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

public class JTreeStructure extends JInternalFrame
	{
	Connection con = null;

	ImageIcon i;

	Statement st = null,st1=null;

	ResultSet rs = null,rs1=null;
   
	 public static Login l;
public static String u=l.u;
public static String p=l.pass;

	public JTreeStructure() throws Exception 
		{
		super("Object Browser ");
		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:mysql";
		ArrayList list = new ArrayList();
		ArrayList list1 = new ArrayList();
		list.add("Databases");

		Class.forName(driver);
		
		
				
					con=DriverManager.getConnection(url,"root","");

		try {
		    String sql = "show databases";
  		    st = con.createStatement();
		    rs = st.executeQuery(sql);
  		    while (rs.next()) 
			{
			Object value[] = { rs.getString(1)};
			list.add(value);
			}
		   }
		catch (Exception e) 
		   {
		   String str=e.getMessage(); 			
                   JOptionPane.showMessageDialog(null,str,"Error",JOptionPane.ERROR_MESSAGE);
		   }
		rs.close();
		st.close();
		con.close();

		Object hierarchy[] = list.toArray();
		Object hierarchy1[] = list1.toArray();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = getContentPane();

		DefaultMutableTreeNode database = processHierarchy(hierarchy);
			
		JTree tree = new JTree(database);

		content.add(new JScrollPane(tree), BorderLayout.CENTER);
			
		i=new ImageIcon("images/object.PNG");
		Color c=new Color(220,249,255);
		content.setBackground(c);
		setFrameIcon(i);
		setSize(175,625);
		setVisible(true);

	}

	private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
		DefaultMutableTreeNode node = new DefaultMutableTreeNode(hierarchy[0]);
		DefaultMutableTreeNode child;
		for (int i = 1; i < hierarchy.length; i++) {
			Object nodeSpecifier = hierarchy[i];
			if (nodeSpecifier instanceof Object[]) // Ie node with children
			{
				child = processHierarchy((Object[]) nodeSpecifier);
			} else {
				child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf

			}
			node.add(child);
		}
		return (node);
	}
}
