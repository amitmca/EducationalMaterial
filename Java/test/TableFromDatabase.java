import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
 
public class TableFromDatabase extends JFrame
{
    public TableFromDatabase()
    {
        Vector columnNames = new Vector();
        Vector data = new Vector();
 
        try
        {
            //  Connect to the Database
 
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

            Connection connection = DriverManager.getConnection("jdbc:odbc:mysql","root","amit12");
 
            //  Read data from a table
 
            String sql = "show databases";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = 1;//md.getColumnCount();
 
            /*  Get column names
 
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }*/
 
            //  Get row data
 
            while (rs.next())
            {
                Vector row = new Vector(columns);
 
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }
 
                data.addElement( row );
            }
 
            rs.close();
            stmt.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }
 
        //  Create table with database data
 
        JTable table = new JTable(data, columnNames);
 
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
 
        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
    }
 
    public static void main(String[] args)
    {
        TableFromDatabase frame = new TableFromDatabase();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}
