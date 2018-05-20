package gpl.fredy.share;

/**
    SelectDRiver is a part of Admin and done for loggin in to it...
    It creates a ComboBox out of a file called rdbms.dat in the
    Admin InstallDir

 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C)     2003, Fredy Fischer
 *                           sql@hulmen.ch
 *   Postal: Fredy Fischer
 *           Hulmenweg 36
 *           8405 Winterthur
 *           Switzerland
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Lesser General Public
 *   License as published by the Free Software Foundation; either
 *   version 2.1 of the License, or any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public
 *   License along with this library; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.net.*;
import gpl.fredy.ui.PopUpMessage;
import java.util.logging.*;

public class SelectDriver extends JComboBox {

/* Modifications by Kwutchak (http://empty.com/trent), 99.8.21
		- ensure that a blank rdbms line doesn't throw program
		- select first match as default
*/


// Fredy's make Version
 private static String fredysVersion = "Version 1.4.2  17. May 2007";
 Logger logger = Logger.getLogger("gpl.fredy.share");


public String getVersion() {return fredysVersion; }

    private Vector v;

    public SelectDriver(String selected) {

	selected = selected.toLowerCase();
	String line="";
	String tmp = "";
      	v = new Vector();
        int sel=0;
	int idx = -1;

        
       InputStream rdbmsFile = null;
        try {
           //rdbmsFile = SelectDriver.class.getResource("rdbms.dat").getFile();
           rdbmsFile = this.getClass().getClassLoader().getResourceAsStream("gpl/fredy/share/rdbms.dat");
        } catch (Exception exception) {
            logger.log(Level.WARNING,"Could not load file");
            try {
            FileInputStream fis = new FileInputStream(System.getProperty("admin.share") + File.separator + "rdbms.dat");            
            rdbmsFile = fis;
            } catch (FileNotFoundException fne) {
                logger.log(Level.WARNING,"Something went wrong, I can not find rdbms.dat at the expected location. Admin works either");
            }
        }
	
       /**     
	   BufferedReader in  = new BufferedReader(
				new InputStreamReader(
				     SelectDriver.class.getResourceAsStream("rdbms.dat")));
          **/  
       try {
	   BufferedReader in  = new BufferedReader(
				new InputStreamReader( rdbmsFile )); 
		while (line != null) {
			try  {
				line = in.readLine();

				if (line != null)
				{
					if ( ! line.startsWith("#") && (line.trim().length() != 0))
					{
						idx = idx + 1;
						JdbcStuff js = new JdbcStuff() ;
						js.setObject(line);
						v.addElement(js);
						this.addItem(js.getName());
						tmp = js.getName().toLowerCase();


						if ((idx == -1) && tmp.startsWith(selected))
							sel = idx;

// System.out.println("Found: " + tmp);
// System.out.println("sel: " + new Integer(sel));
// System.out.println("idx: " + new Integer(idx));
					}
				}
			} catch (IOException iox) { line=null; }		
		}

	} catch (Exception excpt) {
	    System.out.println(fileMessage()); 
	    PopUpMessage pum = new PopUpMessage(fileMessage());
	}
	if (sel > 0)this.setSelectedIndex(sel);
    }
	
    public JdbcStuff getData(int i) {
	return (JdbcStuff) v.elementAt(i);
    }

    private String fileMessage() {
        String rdbmsFile="";
        try {
           rdbmsFile = SelectDriver.class.getResource("rdbms.dat").getFile();
        } catch (Exception exception) {
            rdbmsFile = System.getProperty("admin.share") + File.separator + "rdbms.dat";  
        }
        
	String s = "===========================================\n" +
	    "--- Missing File, functionality ignored ---\n" +
	    "===========================================\n" +
            "Searching in: " + rdbmsFile + "\n" +
	    "The file rdbms.dat helpingyou with the JDBC-\n" +
	    "things is missing\n" +
	    "Location should be where you load admin from\n" +
	    "even if you are loading admin out of a jar-File you have to put it there\n" +
	    "and the content is something like:\n\n" +
            "# this is the Database Information File for Fredy's Admin-Tool\n" +
            "# insert the following entries to use it in Admin\n" +
            "#\n" +
            "# Version from 28. Oct. 2001, sql@hulmen.ch\n" +
	    "#\n" +
	    "# Database-Product-Name^jdbc_driver^database-URL^Database-Port^image-file \n" +
	    "# image  must be in images/\n" +
	    "# if you set the port to 0 then it will ignore Network stuff\n" +
	    "#\n" +
	    "mySQLmm^org.gjt.mm.mysql.Driver^jdbc:mysql://^3306^mysql.gif\n" +
	    "#\n" +
	    "PointBase^com.pointbase.jdbc.jdbcUniversalDriver^jdbc:pointbase://^9092^pointbase.gif\n" +
	    "#\n" +
	    "PostgreSQL^org.postgresql.Driver^jdbc:postgresql://^5432^sql.gif\n" +
	    "#\n" +
	    "mSQL^com.imaginary.sql.msql.MsqlDriver^jdbc:msql://^1114^sql.gif\n" +
	    "#\n" +
	    "ORACLE^oracle.jdbc.driver.OracleDriver^jdbc:oracle:thin:^1521^oracle.gif\n\n";

	    return s;
    }

}



