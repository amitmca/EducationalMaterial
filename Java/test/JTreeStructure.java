import java.awt.*;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;

public class JTreeStructure extends JFrame {

	Connection con = null;

	Statement st = null;

	ResultSet rs = null;

	public static void main(String args[]) throws Exception {
		new JTreeStructure();
	}

	public JTreeStructure() throws Exception {

		super("Retrieving data from database ");

		String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:mysql";
		String db = "Student";

		ArrayList list = new ArrayList();
		list.add("Roll Numbers");

		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "amit12");

		try {
			String sql = "Select * from stu_info";

			st = con.createStatement();
			rs = st.executeQuery(sql);

			while (rs.next()) {
				Object value[] = { rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4) };
				list.add(value);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		rs.close();
		st.close();
		con.close();

		Object hierarchy[] = list.toArray();

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container content = getContentPane();

		DefaultMutableTreeNode root = processHierarchy(hierarchy);
		JTree tree = new JTree(root);
		content.add(new JScrollPane(tree), BorderLayout.CENTER);
		setSize(275, 300);
		setLocation(300, 100);
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
