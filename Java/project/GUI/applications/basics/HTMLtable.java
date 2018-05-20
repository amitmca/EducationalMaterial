package applications.basics;

/** 
   HTML-Table generates HTML-around a SQL-Query


    Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Vector;
import java.sql.*;

public class HTMLtable extends HttpServlet {


    String query;
    
    /**
       * Get the value of query.
       * @return Value of query.
       */
    public String getQuery() {return query;}
    
    /**
       * Set the value of query.
       * @param v  Value to assign to query.
       */
    public void setQuery(String  v) {this.query = v;}
    

    
    String host;
    
    /**
       * Get the value of host.
       * @return Value of host.
       */
    public String getHost() {return host;}
    
    /**
       * Set the value of host.
       * @param v  Value to assign to host.
       */
    public void setHost(String  v) {this.host = v;}
    
    
    String user;
    
    /**
       * Get the value of user.
       * @return Value of user.
       */
    public String getUser() {return user;}
    
    /**
       * Set the value of user.
       * @param v  Value to assign to user.
       */
    public void setUser(String  v) {this.user = v;}
    
    
    String password;
    
    /**
       * Get the value of password.
       * @return Value of password.
       */
    public String getPassword() {return password;}
    
    /**
       * Set the value of password.
       * @param v  Value to assign to password.
       */
    public void setPassword(String  v) {this.password = v;}
    
    
    String database;
    
    /**
       * Get the value of database.
       * @return Value of database.
       */
    public String getDatabase() {return database;}
    
    /**
       * Set the value of database.
       * @param v  Value to assign to database.
       */
    public void setDatabase(String  v) {this.database = v;}
    


    private HttpServletRequest req;
    private HttpServletResponse res;
 
    private Connection  connection;
    private Statement   statement;
    private ResultSet   resultSet;
    private Vector      columnNames = new Vector();
    private Vector	rows = new Vector();
    private ResultSetMetaData   metaData;
    private ResultSet sqlresult;


    /**
    public void init(ServletConfig config)
	throws ServletException
    {
	super.init(config);
	setHost(getInitParameter("host"));
	setUser(getInitParameter("user"));
	setPassword(getInitParameter("password"));
	setDatabase(getInitParameter("database"));
	setQuery(getInitParameter("query"));
       
    }
    **/
  public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
    {

	this.req=req;
	this.res=res;
    }


  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
      this.req=request;
      this.res=response;

      setHost("gotzenwil");
      setUser("afs");
      setPassword("cher0kee");
      setDatabase("dns");
      setQuery("Select * from hosts");

      openConnection();
      PrintWriter out = res.getWriter();
      out.println(getHTMLheader());
      boolean cont =true;
      while (cont) {
	  Vector v = new Vector();
	  v = getNextRow();
	  if ( v == null) {
	      cont = false;
	  } else {
	      out.println(getHTMLrow(v));
	  }

      }
      out.println(getHTMLfooter());
      out.close();
  }
  
  private boolean openConnection() {
     boolean ok = true;
     t_connect c = new t_connect(getHost(),getUser(),getPassword(),getDatabase());
     if (c.getError() != null) {
        ok=false;
     }
     statement  = c.stmt;
     connection = c.con;  
     return ok;
  }


    private boolean execQuery() {

        if (connection == null || statement == null) {
            //System.err.println("There is no database to execute the query.");
            return false;
        }  
        try {
            resultSet = statement.executeQuery(query);
            metaData = resultSet.getMetaData();

            for(int column = 0; column < metaData.getColumnCount(); column++) {
                columnNames.addElement(metaData.getColumnLabel(column+1));
            }

       }
        catch (SQLException ex) {
            System.err.println("Error in executeQuery: " +ex);
	    return false;
       }
	return true;
    }
       

    public Vector getHeader() { return columnNames; }
    public Vector getNextRow() {
	Vector row = new Vector();
	row = null;
	try {
	if (sqlresult.next()) {
	    for (int i = 0; i < metaData.getColumnCount(); i++) {
		switch (metaData.getColumnType(i+1) ) {		
		case java.sql.Types.INTEGER:
		     row.addElement( Integer.toString(sqlresult.getInt(i+1)));
		     break;
		case java.sql.Types.FLOAT:
		     row.addElement(Float.toString(sqlresult.getFloat(i+1)));
		     break;
		case java.sql.Types.DOUBLE:
		     row.addElement(sqlresult.getDate(i+1).toString());
		     break;
		default:
		     row.addElement( sqlresult.getString(i+1) );
		     break;
                }		
	    }
	}
	}  catch (Exception excp) { ; }
        return row;
    }

    private String getTableName() {

	String tn = "Table";
	try {
	    tn = metaData.getTableName(0);
	} catch (Exception excp) { ; }
        return tn;
    }



    private String getHTMLrow(Vector v) {

	String htmlrow="<TR>";
	for (int i=0; i < v.size();i++) htmlrow = htmlrow + "<TD>" + (String)v.elementAt(i) + "</TD>";
        htmlrow = htmlrow + "/TR>";
	return htmlrow;
    }


    private String getTableHeader() {
	Vector v = new Vector();
	v = getHeader();
	String tableHeader="<TR>";
	for (int i=0; i < v.size();i++) tableHeader = tableHeader + "<TD>" + (String)v.elementAt(i) + "</TD>";
        tableHeader = tableHeader + "</TR>";
	return tableHeader;
    }


    private String getHTMLheader() {

	String htmlheader;

	htmlheader= "<!DOCTYPE HTML PUBLIC \"-//IETF//DTD HTML//EN\">\n" +
	"<html>\n" +
        "<head>\n" +
        "<title>" + getTableName() + "</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>" + getTableName() + "</h1>\n"+
        "<p>\n" +
        "<Table>\n";
	return htmlheader;     
    }


    private String getHTMLfooter() {

	String htmlfooter;
	htmlfooter= "</Table>\n</body>\n</html>\n";
	return htmlfooter;
    }

}
