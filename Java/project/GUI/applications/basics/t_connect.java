package applications.basics;


/**
 *
 * t_connect is the connection-Object to the Database.
 * I'm using it for the mySQL-stuff, but it works as well
 * with other JDBC-Drivers.
 * It in fact is something similar to the backbone of Admin.
 *
 * Admin is a Tool around mySQL to do basic jobs
 * for DB-Administrations, like:
 * - create/ drop tables
 * - create  indices
 * - perform sql-statements
 * - simple form
 * - a guided query
 * and a other usefull things in DB-arena
 *
 * Admin V1.1
 * Copyright (c) 1999 Fredy Fischer
 * sql@hulmen.ch
 *
 * Fredy Fischer
 * Hulmenweg 36
 * 8405 Winterthur
 * Switzerland
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 **/

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.*;
import javax.naming.*;
import applications.basics.*;
//import applications.ticket.*;
import javax.sql.DataSource;



public class t_connect {
    
    
    // Fredy's make Version
    private static String fredysVersion = "Version 1.5 12. May 2003";
    
    public String getVersion() {return fredysVersion; }
    
    public Statement stmt;
    public Connection con;
    public String excpt=null, iJDBC, iURL,url="";
    private boolean dbg = false;
    private Logger logger = Logger.getLogger("applications.basics");;
    
    
    /**
     * Get the value of stmt.
     * @return value of stmt.
     */
    public Statement getStmt() {
        return stmt;
    }
    
    /**
     * Set the value of stmt.
     * @param v  Value to assign to stmt.
     */
    public void setStmt(Statement  v) {
        this.stmt = v;
    }
    
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public Connection getCon() {
        return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(Connection  v) {
        this.con = v;
    }
    
    
    
    String host=null;
    
    /**
     * Get the value of host.
     * @return value of host.
     */
    public String getHost() {
        return host;
    }
    
    /**
     * Set the value of host.
     * @param v  Value to assign to host.
     */
    public void setHost(String  v) {
        this.host = v;
    }
    
    String user=null;
    
    /**
     * Get the value of user.
     * @return value of user.
     */
    public String getUser() {
        return user;
    }
    
    /**
     * Set the value of user.
     * @param v  Value to assign to user.
     */
    public void setUser(String  v) {
        this.user = v;
    }
    
    
    String password=null;
    
    /**
     * Get the value of password.
     * @return value of password.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Set the value of password.
     * @param v  Value to assign to password.
     */
    public void setPassword(String  v) {
        this.password = v;
    }
    
    
    
    String database=null;
    
    /**
     * Get the value of database.
     * @return value of database.
     */
    public String getDatabase() {
        return database;
    }
    
    /**
     * Set the value of database.
     * @param v  Value to assign to database.
     */
    public void setDatabase(String  v) {
        this.database = v;
    }
    
    TConnectProperties prop;
    
    /**
     * Get the value of prop.
     * @return value of prop.
     */
    public TConnectProperties getProp() {
        return prop;
    }
    
    /**
     * Set the value of prop.
     * @param v  Value to assign to prop.
     */
    public void setProp(TConnectProperties  v) {
        this.prop = v;
        init();
    }
    
    
    
    /**
     * connect to the Database:
     * @host = a String that contains the DB-Server-hostname e.g. gotzenwil.eidberg.ch
     * @user = a String that represents the user as it is in the grant-table of the db
     * @password = a String that contains the users password: Attention: not encrypted,
     *             is going in plaintext over the network, (Yes, there is some room for improvement)
     * @database = the name of the database you want to connect to
     *
     * the JDBC-Driver stuff is in a property-file stored in the users -home-dir
     * named: t_connect.props
     */
    
    
    public t_connect(String host, String user, String password, String database) {
        
        this.setHost(host);
        this.setUser(user);
        this.setPassword(password);
        this.setDatabase(database);
        
        prop = new TConnectProperties();
        
        
        // are we in a debug mode
        if ( prop.getDebug().startsWith("on") ) dbg = true;
        
        if ( dbg ) {
            dbgMessage("JDBCdriver " + prop.getDriver());
            dbgMessage("JDBCUrl " +  prop.getUrl());
            dbgMessage("DatabasePort " +  prop.getDatabasePort());
            dbgMessage("usePassword " + prop.getUsePwd());
        }
        
        init();
    }
    
    public t_connect(java.sql.Connection con) {
        setCon(con);
        try {
            stmt = con.createStatement();
        }
        catch (SQLException sqle) {
            excpt = "SQLException while opening "+
            database + " on " + host + " : " +
            sqle.getMessage() + "\n" +
            "url: " + url;
            logger.log(Level.WARNING,"Exception: " + excpt);
            if ( dbg ) {
                sqle.printStackTrace();
                dbgMessage(excpt);
                dbgMessage(sqle.getMessage().toString());
            }
        }
    }
    
    /**
     * call this constructor with a String representing the name of
     * the datasource you are using
     **/
    private DataSource datasource;
    public t_connect(String ds) {
        
        try {  
	    Context init = new InitialContext();
	    Context ctx = (Context) init.lookup("java:comp/env");
	    datasource = (DataSource) ctx.lookup(ds);        
            //InitialContext initCtx = new InitialContext();
            //DataSource datasource = (javax.sql.DataSource) initCtx.lookup(ds);
            con  = datasource.getConnection();
            stmt = con.createStatement();
        }  catch (javax.naming.NamingException nme) {
            logger.log(Level.WARNING,"can not get datasource");
            logger.log(Level.FINE,"Namingexception: " + nme.getMessage());                
        }  catch (SQLException sqle) {
            logger.log(Level.WARNING,"can not connect to datasource");
            logger.log(Level.FINE,"SQLException: " + sqle.getMessage());
            sqle.printStackTrace();
        }        
    }
    
    public void init() {
        int port=0;
        
        try {
            
            //------------- start JDBC-Driver instantiation --------
            Class.forName(prop.getDriver()).newInstance();
            iJDBC = prop.getDriver();
            //------------- end JDBC-Driver instantiation ----------
            
            
            //------------- Start URL-generation -------------------
            url    = prop.getUrl() ;
            iURL  = prop.getUrl() ;
            
            // For non networked stuff set Port to 0
            try {
                port= Integer.parseInt(prop.getDatabasePort());
                if ( dbg ) dbgMessage("Networked, using port: " + prop.getDatabasePort() );
            } catch (NumberFormatException nfe) {
                port = 0;
                if ( dbg ) dbgMessage("not networked, no Port in use");
            }
            
            
            if (port > 0 ) {
                
                // ORACLE speciality
                if ( prop.getDriver().startsWith("oracle") ) {
                    url = url +
                    user + "/" +
                    password +
                    "@" + host +
                    ":" + prop.getDatabasePort() +
                    ":" + database;
                    
                    iURL = url;
                    if ( dbg ) dbgMessage("Using ORACLE, URL: " + url);
                } else {
                    
                    // EMPRESS speciality
                    if ( prop.getDriver().startsWith("empress") ) {
                        url = url + "/SERVER=" + host + ";PORT=" +  prop.getDatabasePort() +
                        ";DATABASE=" + database;
                        iURL = url;
                        if ( dbg ) dbgMessage("Using Empress, URL: " + url);
                        
                    } else {
                        // Standard JDBC things (whatever standard means)
                        url = url + host + ":" + prop.getDatabasePort() + "/" + database;
                        iURL = url;
                    }
                }
            } else {
                url = url + database;
                iURL = url;
            }
            
            if ( dbg ) dbgMessage("URL: " + url);
            
            
            // these Properties are sent to the RDBMS
            Properties p = new Properties();
            
            boolean diffUserPwdMgmt = false;
            if ( prop.getDriver().startsWith("oracle")) diffUserPwdMgmt = true;
            if ( prop.getDriver().startsWith("empress")) diffUserPwdMgmt = true;
            
            if ( ! diffUserPwdMgmt ) {
                
                // this is 'standard' user / password handling
                p.put("user",user);
                if ( prop.getUsePwd().equalsIgnoreCase("yes") ) {
                    p.put("password", password);
                }
                con = DriverManager.getConnection(url,p);
            } else {
                
                // but needs some change for Oracle and Empress
                if (prop.getDriver().startsWith("empress")) {
                    con = DriverManager.getConnection(url,user,password);
                } else {
                    con  = DriverManager.getConnection(url);
                }
            }
            try {
                stmt = con.createStatement();
            }
            catch (SQLException sqle) {
                excpt = "SQLException while opening "+
                database + " on " + host + " : " +
                sqle.getMessage() + "\n" +
                "url: " + url;
                logger.log(Level.WARNING,"Exception: " + excpt);
                if ( dbg ) {
                    sqle.printStackTrace();
                    dbgMessage(excpt);
                    dbgMessage(sqle.getMessage().toString());
                }
            }
        }
        catch ( Exception e ) {
            excpt = "SQLException while opening "+ database + " on " + host + " : " + e.getMessage() + "\n" +
            "url: " + url;
            logger.log(Level.SEVERE,"User: " + getUser() +
            " Exception in t_connect " + excpt);
            if ( dbg ) {
                e.printStackTrace();
                dbgMessage(excpt);
                dbgMessage(e.getMessage().toString());
            }
        }
    }
    
    public boolean acceptsConnection() {
        try {
            Driver drv =  DriverManager.getDriver(url);
            return drv.acceptsURL(url);
        } catch (SQLException e) {
            logger.log(Level.WARNING,"This connection does not accept connections! " + getHost() +
            "," + getUser() + "," + getDatabase() +
            " Err: " + e.getMessage().toString());
            return false;
        }
        
        
    }
    
    
    
    
    
    public boolean isClosed() {
        try {
            return con.isClosed();
        } catch (Exception e) {
            return true;
        }
    }
    
    public void close() {
        
        /**
         * we do not close because of Postgres!!!
         * Closeing is done at centrally!!!
         **/
        
    }
    
    public void closeCon() {
        try  {
            stmt.close();
            con.close();
            
        } catch (SQLException e) {
            excpt = "Exception while closing connection: " +
            e.getMessage().toString();
            if ( dbg ) dbgMessage(excpt);
        }  catch (Exception e) {
            logger.log(Level.INFO,"User: " + getUser() +
            " " + e.getMessage().toString());
        }
    }
    
    
    public String getError() {
        
        return excpt;
        
    }
    
    private void dbgMessage( String msg ) {
        logger.log(Level.FINEST,"User: " + getUser() + " " + msg);
    }
    protected void finalize() {
        
        excpt = null;
        try {
            //stmt.close();
            //con.close();
        }
        catch (Exception e) {
            excpt = "Exception while closing databse: " +
            e.getMessage().toString();
            if ( dbg ) dbgMessage(excpt);
        }
        
        
    }
    
    
    public static void main(String args[]) {
        String host     = "localhost";
        String user     = System.getProperty("user.name");
        String schema   = "%";
        String database = null;
        String password = null;
        
        System.out.println("t_connect\n" +
        "---------\n" +
        "Syntax: java gpl.fredy.share.t_connect\n" +
        "        Parameters: -h Host (default: localhost)\n" +
        "                    -u User (default: " +
        System.getProperty("user.name") + ")\n" +
        "                    -p Password\n" +
        "                    -d database\n" +
        "                    -s Schema (default: %)\n");
        
        int i = 0;
        while ( i < args.length) {
            if (args[i].equals("-h")) {
                i++;
                host = args[i];
            }
            if (args[i].equals("-u")) {
                i++;
                user = args[i];
            }
            if (args[i].equals("-p")) {
                i++;
                password = args[i];
            }
            if (args[i].equals("-d")) {
                i++;
                database = args[i];
            }
            
            if (args[i].equals("-s")) {
                i++;
                schema = args[i];
            }
            i++;
        };
        
        if ( database == null) {
            System.out.println("No database provided. Program stopped!");
            System.exit(0);
        }
        t_connect con = new t_connect(host,user,password,database);
        if ( ! con.acceptsConnection() ) {
            System.out.println("I'm not able to connect. Error:\n" + con.getError());
        } else {
            System.out.println("This DB accepts connection with these parameters!");
        }
        
        System.exit(0);
    }
    
}
