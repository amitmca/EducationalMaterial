import java.sql.*;

class postgresql
	{
	public static void main(String args[])
		{
		try
			{
			Class.forName("org.postgresql.Driver");
		    String url="jdbc:postgresql:postgres";
			Connection conn=DriverManager.getConnection(url,"postgres","123456");
			String selectSQL = "select master.billno,  master.custname, master.billdate, details.itemname, details.qty, details.rate from BillMaster master, BillDetails details where master.billno = details.billno and master.billno = ? ";
			
			PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setInt(1, 100);
						
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
			System.out.println("Bill No: "+rs.getString("billno")+"\t\t\tBill Date:  "+rs.getString(3)+"\nCustomer Name : "+rs.getString(2));
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("Sr No\tItem Name\tQuantity\tRate\tTotal");
			int i=0;
			float sum = 0;
			rs.close();
			rs = preparedStatement.executeQuery();
			System.out.println("-----------------------------------------------------");
				while(rs.next()) {
					float total = rs.getInt(5)*rs.getInt(6);
					System.out.println(++i+"\t"+rs.getString(4)+"\t\t"+rs.getInt(5)+"\t"+rs.getInt(6)+"\t"+total);
					sum=sum + total;
				}
			System.out.println("-----------------------------------------------------");
			System.out.println("Net Bill :"+sum);
			}
		catch(ClassNotFoundException e)
			{
			System.out.println(e.getMessage());
			}

		catch(SQLException e1)
			{
			System.out.println(e1.getMessage());
			}
		}
	}
