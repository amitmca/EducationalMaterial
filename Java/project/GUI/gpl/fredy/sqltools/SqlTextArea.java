package gpl.fredy.sqltools;
/*
 * This software is part of David Good's contribution to the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C) August 9, 2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.lang.reflect.*;
import gpl.fredy.share.t_connect;






public class SqlTextArea extends JPanel implements SqlTab
{


    t_connect con=null;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
        if ( con == null) {
	    con = new t_connect(getHost(),
				getUser(),
				getPassword(),
				getDatabase());
	    if ( ! con.acceptsConnection() ) con = null;
	}
	return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(t_connect  v) {
	this.con = v;
	setUser(con.getUser());
	setHost(con.getHost());
	setPassword(con.getPassword());
	setDatabase(con.getDatabase());
    }   


    String host="localhost";

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
    
    public JButton cancel;

    /** to find out, when the user wants to close
     *  this application, set a listener onto (JButton)AutoForm.cancel 
     **/

    private String user;
    
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
    

    private String password;
    
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


    private String database;
    
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
    
    private String query;
    
    /**
       * Get the value of query.
       * @return Value of query.
       */
    public String getQuery() {
        return query;
    }
    
    /**
       * Set the value of dbTable.
       * @param v  Value to assign to dbTable.
       */
    public void setQuery(String  v) {this.query = v;}
  
    
    String schema;
    
    /**
       * Get the value of schema.
       * @return Value of schema.
       */
    public String getSchema() {return schema;}
    
    /**
       * Set the value of schema.
       * @param v  Value to assign to schema.
       */
    public void setSchema(String  v) {this.schema = v;}
  

	public JTextArea TextArea = new JTextArea(20,80);
	
	String szError;
	int iNumRows = 0;
	JScrollPane scrollpane;
		
	public SqlTextArea()
	{}
	
	
	public SqlTextArea (String host, String user, String password,String db, String query)
	{

	  setHost(host);
	  setUser(user);
	  setPassword(password);
	  setDatabase(db);
	  setQuery(query);
	  init();
	}

       public SqlTextArea(t_connect con, String query) {
         setCon(con);
         setQuery(query);
         init();
       }




        private void init() {
        
	  setLayout(new FlowLayout());
	  TextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
	  getCon();
	  execQuery(query);
	  scrollpane = new JScrollPane(TextArea);
	  add(scrollpane);
	}
	
	public void setViewPortSize(Dimension d)
	{
		//scrollpane.setPreferredSize(d);
	}
	
	private void execQuery(String query)
	{
		try
		{
			ResultSet rs = con.stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
						
			SqlResults s = new SqlResults(rs,rsmd,rsmd.getColumnCount());
			s.loadText(TextArea);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public String getSQLError()
	{
		return szError;
	}

	public int getNumRows()
	{
		return iNumRows;
	}
	

	
	class SqlColumn extends LinkedList
	{
		int maxLength = 0;
		
		SqlColumn(String colName, int width)
		{
			super();
			maxLength = width;
			add(colName);
			char[] underline = new char[colName.length()];
			Arrays.fill(underline,'-');
			add(new String(underline));
		}
		public Object get(int index)
		{
			String szData = (super.get(index)).toString();
			
			char[] filler = new char[maxLength - szData.length()];
			Arrays.fill(filler,' ');
			
			return szData + new String(filler);
			
		}
		
		public boolean add(Object o)
		{
			super.add(o);
			if (o.toString().length() >= maxLength)
				maxLength = o.toString().length()+1;
				
			return true;
		}
	}
	
	class SqlResults extends Vector
	{
		private int size;
		
		SqlResults(ResultSet rs, ResultSetMetaData rsmd,int size)
		{
			super(size);
			this.size = size;
			
			try
			{
				for (int y = 1;y <= size ;y++)
					add(new SqlColumn(rsmd.getColumnName(y),rsmd.getColumnDisplaySize(y)));
				
				while(rs.next())
				{
					for (int y = 0;y < size ;y++)
					{
						if (rs.getObject(y+1) == null)
							((SqlColumn)get(y)).add("null");
						else
							((SqlColumn)get(y)).add(rs.getObject(y+1));
						
					}
					iNumRows++;
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		void loadText(JTextArea TextArea)
		{
			int listLength = iNumRows + 2;//takes account of row header
						
			for (int i = 0;i < listLength;i++)
			{
				for (int j = 0;j < size; j++)
				{
					TextArea.append((((SqlColumn)get(j)).get(i)).toString());
				}
				TextArea.append("\n");
			}
		}
	}

    protected void finalize() { 
      //con.close();
    }
			
	
}
