import java.sql.*;
import java.util.*;
class studdb
{
	public static void main(String args[])  throws Exception
	{
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:Mysql://localhost/std","root","");
		Statement smt=con.createStatement();
		System.out.println("Enter choice: 1.Insert 2.Modify 3.Delete 4.Search 5.Viewall 6.Exit");
		int ch=sc.nextInt();
		switch(ch)
		{
			case 1:
				System.out.println("Enter");
				int Rno=sc.nextInt();
				String Name=sc.next();
				Float per=sc.nextFloat();
				String qry1="insert into student values("+Rno +",'"+Name+"',"+per+")";
				int r1=smt.executeUpdate(qry1);
				if(r1==1)
				System.out.println("Record inserted");
				else
				System.out.println("Record not inserted");
			break;
			case 2:
				System.out.println("Enter rollno percentage:");
				int rollno=sc.nextInt();
				Float percentage=sc.nextFloat();
				String qry2="update student set per=" +percentage+ "where Rno="+rollno;                 
				int r2=smt.executeUpdate(qry2);
				if(r2==1)
				System.out.println("Record update");
				else
				System.out.println("Record not update");
			break;
			case 3 :
				System.out.println("Enter rollno");
				int Rno1=sc.nextInt();
				String qry3="Delete from student where Rno="+Rno1;
				int r3=smt.executeUpdate(qry3);
				if(r3==1)
				System.out.println("Record delete");
				else
				System.out.println("Record not delete");
			break;
			case 4 :
				System.out.println("Enter rollno");
				int Rno2=sc.nextInt();
				String qry4="select * from student where Rno="+Rno2;
				ResultSet rs=smt.executeQuery(qry4);
				while(rs.next())
				{
					System.out.println("Rollno. :"+rs.getInt(1) +"\t"+ "Name :"+rs.getString(2) +"\t"+ "Percentage :"+rs.getFloat(3));
				}
			break;
			case 5 :
				String qry5="select * from student";
				rs=smt.executeQuery(qry5);
				while(rs.next())
				{
					System.out.println("Rollno. :"+rs.getInt(1) +"\t"+ "Name :"+rs.getString(2) +"\t"+ "Percentage :"+rs.getFloat(3));
				}
			break;
				
			case 6:
				System.exit(0);
				
		}
	}
}
		
