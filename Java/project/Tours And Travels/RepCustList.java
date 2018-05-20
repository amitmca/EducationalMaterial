import java.lang.Runtime.*;
import java.io.*;
import java.sql.*;



public class RepCustList
{

 RepCustList()
 {
	showList();
 }


 public static void showList()
 {
   Runtime iexp;
   Process pro;
   iexp = Runtime.getRuntime();
   Statement stmt = null;
   Connection con = null;
   String[] en = {"c:\\program files\\internet explorer\\IEXPLORE.EXE","D:\\Tours And Travels\\Tours And Travels\\CustList.html"};
   try
   {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        con = DriverManager.getConnection("jdbc:odbc:Tours",null,null);
        stmt = con.createStatement();
        String sql ="Select * from Customer";
        ResultSet rs = stmt.executeQuery(sql);

        File outFile = new File("D:\\Tours And Travels\\Tours And Travels\\CustList.html");
        FileWriter out = new FileWriter(outFile);

		java.util.Date now = new java.util.Date();
        out.write("<html><head><title>Customer Listing</title></html><body bgcolor=#d3d3d3><h4>");
        out.write("<table border=0 ><tr><td></td><td><h2><center>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<u>CUSTOMER LISTING</u> </center></h2></td></tr><p>");
        out.write("<table border=0 align=right><tr><td > Date: "+now + "</tr></table>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<p>");
        out.write("<table border = 1 width=100% bgcolor = #EEEEFF>");


		out.write("<th>Number &nbsp;&nbsp;");
		out.write("<th>Name &nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Phone#1</th>");
		out.write("<th>Occupation&nbsp;&nbsp;&nbsp;&nbsp; </th>");
		out.write("<th>Phone#2&nbsp;&nbsp; </th>");
		out.write("<th>Email&nbsp;&nbsp;   </th>");
		out.write("<th>Age&nbsp;&nbsp; </th>");
		out.write("<th>Fax&nbsp;&nbsp; </th>");
		out.write("<th>Health Constraints&nbsp;&nbsp;  </th>");

while (rs.next())
        {

		out.write("<tr> <td>" +rs.getString(1)+"</td> <td>" +rs.getString(2) +"&nbsp;"+rs.getString(3) +"</td> <td>" +rs.getInt(7)+"</td> <td>" +rs.getString(5)+"</td> <td>" +rs.getString(8)+"</td> <td>" +rs.getString(9)+"</td> <td>" +rs.getString(6)+"</td> <td>" +rs.getString(10)+"</td> <td>" +rs.getString(11)+"</td> " );
	}
		out.write("</table>");
		out.write("</body></html>");
        out.close();
        pro = iexp.exec(en);

       pro.waitFor();
	stmt.close();
	con.close();

   } // end of try

   catch(Exception e)
   {
        System.out.println(e);
   }

  }//end
  }
