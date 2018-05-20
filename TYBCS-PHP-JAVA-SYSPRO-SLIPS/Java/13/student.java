import java.sql.*;
import javax.swing.*;

class Student
{
	JFrame f;
	static JTable t;
	public Student()
	{
		f=new JFrame("Student record");
		t=new JTable(10,3);

		f.setVisible(true);
		f.setSize(400,400);
		f.add(t);
	}
	public static void main(String args[])  throws Exception
	{
		new Student();
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/std","postgres","");
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from student");
		int row=0;
		while(rs.next())
		{	
			t.setValueAt(rs.getInt(1),row,0);
               		t.setValueAt(rs.getString("name"),row,1);
			t.setValueAt(rs.getFloat(3),row,2);
			row++;
		}
		con.close(); 
	}
}
