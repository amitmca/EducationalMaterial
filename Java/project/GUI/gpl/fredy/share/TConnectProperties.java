package gpl.fredy.share;

/** 

    TConnectProperties is used by t_connect and contains
    Information about the JDBC-Connections. It looks as 
    this: (in this example it is for MySQL

    #Properties for t_connect
    #Thu Jan 09 18:32:04 CET 2003
    usePassword=yes                    <-- is the password send to the DB
    DatabasePort=3306                  <-- TCP-Port where the RDBMS is listening
    DebugMode=off                      <-- for the developer 
    JDBCdriver=org.gjt.mm.mysql.Driver <-- the JDBC-Driver
    JDBCurl=jdbc:mysql://              <-- JDBC-URL


    This file is stored in one of the following locations:
    - System.getProperty("user.home")
    - System.getProperty("admin.work")

    where the user.home in a Unix is the Home-Directory of the
    Unix-user launching java. I do not know, where Windows-OSses
    are putting it, but it works.
    You can set these values while starting the applications with
    the following parameters:
    -Dadmin.work=adirectroy  or -Duser.home=D:\java\share
   
    where admin.work has more weight then user.home, that means
    if admin.home is set it ignores user.home

    Questions? send a E-Mail: sql@hulmen.ch
    

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

import java.util.Properties;
import java.util.logging.*;
import java.io.*;


public class TConnectProperties {

    private Logger logger;
    private String defaultDriver = "com.mysql.jdbc.Driver";
    private String defaultUrl    = "jdbc:mysql://";
    private String defaultPort   = "3306";
    private String defaultAuth   = "yes";
    	    
    Properties prop;
    
    /**
     * Get the value of prop.
     * @return value of prop.
     */
    public Properties getProp() {
	return prop;
    }
    
    /**
     * Set the value of prop.
     * @param v  Value to assign to prop.
     */
    public void setProp(Properties  v) {
	this.prop = v;
    }
    


    public void init() {
	prop = new Properties();


	String directory = System.getProperty("user.home");
	if ( System.getProperty("admin.work") != null )
	    directory = System.getProperty("admin.work");

	try {
	    FileInputStream input = new FileInputStream(directory +
						      File.separator +
						      "t_connect.props");	
	    prop.load(input);
	} catch (Exception ioex) {

	logger.log(Level.INFO," can not load " + directory + File.separator +
		   "t_connect.props using standard values");
    
	prop.put("JDBCdriver",defaultDriver);
	prop.put("JDBCurl",defaultUrl);
	prop.put("DatabasePort",defaultPort);
	prop.put("usePassword",defaultAuth);
	prop.put("DebugMode","off");
	save();
	}
    }

    public void save() {

	String directory = System.getProperty("user.home");
	if ( System.getProperty("admin.work") != null )
	    directory = System.getProperty("admin.work");

	try {
	    FileOutputStream output = new FileOutputStream(directory +
						      File.separator +
						      "t_connect.props");	
	    prop.store(output,"Properties for t_connect");
	    output.close();
	} catch (Exception ioex) {

	logger.log(Level.WARNING," can not save " + directory + File.separator +
		   "t_connect.props");
    

	}
    }
	
    public void setDriver(String v) {
	prop.put("JDBCdriver",v);
    }
    public void setUrl(String v) {
	prop.put("JDBCurl",v);
    }
    public void setDatabasePort(String v) {
	prop.put("DatabasePort",v);
    }
    public void setUsePwd(boolean v) {
	if ( v ) {
	    prop.put("usePassword","yes");
	} else {
	    prop.put("usePassword","no");
	}
    }
    public void setDebug(boolean v) {
	if ( v ) {
	    prop.put("DebugMode","on");
	} else {
	    prop.put("DebugMode","off");
	}
    }

    public String getDriver() { return prop.getProperty("JDBCdriver"); }
    public String getUrl() { return prop.getProperty("JDBCurl"); }
    public String getDatabasePort() { return prop.getProperty("DatabasePort"); }
    public String getUsePwd() { return prop.getProperty("usePassword"); }
    public String getDebug() { return prop.getProperty("DebugMode"); }

    public TConnectProperties() {
	logger = Logger.getLogger("gpl.fredy.admin");
	init();
    }

}
