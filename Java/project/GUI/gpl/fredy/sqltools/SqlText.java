package gpl.fredy.sqltools;
/*
 * This software is part of tDavid Good's contribution to he Admin-Framework and under LGPL
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
 *
 */

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.lang.reflect.*;
import gpl.fredy.share.t_connect;


public class SqlText extends JPanel implements SqlTab
{
	public JTextArea TextArea = new JTextArea(20,80);
	private String query;
	String szError;
	int iNumRows = 0;
	t_connect con;
	JScrollPane scrollpane;
        private Statement stmt;	
	public SqlText()
	{}
	
	
	public SqlText (Connection con, Statement stmt, String query)
	{
	    this.stmt = stmt;
		setLayout(new FlowLayout());
		this.query = query;
		TextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		execQuery(query);
		scrollpane = new JScrollPane(TextArea);
		add(scrollpane);
		// because of instantDB
		try {
		    stmt.close();
		    con.close();
		} catch (SQLException sqlexception) { ; }
	}

	
	public void setViewPortSize(Dimension d)
	{
		//scrollpane.setPreferredSize(d);
	}
	
	private void execQuery(String query)
	{
		try
		{
			ResultSet rs = stmt.executeQuery(query);
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
	
	public String getQuery()
	{
		return query;
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
	try {
	    stmt.close();
	    con.close();
	} catch (SQLException e) { ; } 
    }
				
}
