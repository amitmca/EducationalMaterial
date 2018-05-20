/*
 * FileExec.java
 *
 * Created on October 1, 2007, 3:57 PM
 *
 * FileExec is to send a file to he DBMS. For example a dataexport can
 * so simply be sent to the dbms to reload a database.  Commands are separated
 * by ';' and lines starting with '#', '--' or '/*' are marked as comments and not sent to the DB
 *
 *  explain here, what this class does...
 *
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
 
 */

package gpl.fredy.sqltools;

import java.sql.*;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.logging.*;

import gpl.fredy.io.ReadFile;
import gpl.fredy.share.t_connect;

/**
 *
 * @author afs
 */
public class FileExec {
    
    /** Creates a new instance of FileExec */
    public FileExec() {
    }
    
    private String fileName = null;;
    
    private java.sql.Connection con = null;
    
    private Logger logger = Logger.getLogger("gpl.fredy.sqltools");
    
    public String getFileName() {
        return fileName;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public java.sql.Connection getCon() {
        return con;
    }
    
    public void setCon(java.sql.Connection con) {
        this.con = con;
        try {
            stmt = con.createStatement();
        } catch (java.sql.SQLException sqlex) {
            logger.log(Level.WARNING,"SQLException - Can not create connection: " + sqlex.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Something went wrong: " + e.getMessage());
        }
    }
    
    public FileExec(String fileName, java.sql.Connection con) {
        setFileName(fileName);
        setCon(con);
    }
    
    /*
     * this constructor ist used to launch the app from the commandline
     */
    public FileExec(String fileName, String host, String user, String password, String db) {
        tc = new t_connect(host,user,password,db);
        setCon(tc.getCon());
        this.stmt = tc.getStmt();
        setFileName(fileName);
    }
    
    /*
     * this closes the connection created via t_connect
     */
    public void closeTcon(){
        try {
            stmt.close();
            tc.closeCon();
        } catch (java.sql.SQLException sqlex) {
            logger.log(Level.WARNING,"SQLException - Can not close connection: " + sqlex.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Something went wrong: " + e.getMessage());
        }
    }
    
    /*
     *  this closes the connection handed over to these class
     */
    
    public void close() {
        try {
            stmt.close();
            con.close();
        } catch (java.sql.SQLException sqlex) {
            logger.log(Level.WARNING,"SQLException - Can not close connection: " + sqlex.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE,"Something went wrong: " + e.getMessage());
        }
        
    }
    
    /*
     * I'm only able to do the job if I have a filename and a connection
     * so this is checked here. And only executed if they exist. They are
     * not validate, just checking if they have been initialised
     */
    
    public void doIt() {
        if ( (getCon() == null) || (getFileName() == null)) {
            logger.log(Level.INFO,"missing connection or filename, giving up");
        } else {
            exec();
        }
    }
    
    
    /*
     * try to execute the file:  I'm reading it in, eliminating all the lines starting
     * with one of the defined comment-signs '#', '--' or '/*' . Every line is added to a Stringbuffer
     * this Stringbuffer is then parsed by a StringTokenizer with the delimiter ';'. So I'm finally
     * getting all the commands.
     */
    private void exec() {
        ReadFile rf = new ReadFile(getFileName());
        
        // these are all lines
        Vector lines = rf.getLines();
        StringBuffer cmd = new StringBuffer();
        
        for (int i = 0; i < lines.size(); i++) {
            String s = (String)lines.elementAt(i);
            if ( ( s.trim().startsWith("#")  )  ||
                    ( s.trim().startsWith("--") )  ||
                    ( s.trim().startsWith("/*") )
                    ) {
                logger.log(Level.FINEST,"leaving alone: " + s);
            } else {
                cmd.append(s + "\n");
            }
        }
        
        StringTokenizer st = new StringTokenizer(cmd.toString(),";");
        while (st.hasMoreTokens()) {
            sqlCmd(st.nextToken());
        }
    }
    
    
    private void sqlCmd(String sql) {
        if (sql.trim().length() > 2) {
            try {
                int i = stmt.executeUpdate(sql);
                logger.log(Level.INFO,sql);
            } catch (SQLException sqle) {
                logger.log(Level.WARNING,"error while executing: " + sql);
                logger.log(Level.WARNING,"Message is:" + sqle.getMessage());
            } catch (Exception e) {
                logger.log(Level.SEVERE,"Something went wrong while doing SQL: " + e.getMessage());
            }
        }
    }
    
    private t_connect tc;
    private Statement stmt;
    
    
    public String getInfo() {
        StringBuffer s = new StringBuffer();
        s.append("Fredy's tool to execute a file into a DB\n");
        s.append("Usage:\n\n");
        s.append(" -f file   (or -file)\n");
        s.append(" -h host   (or -host)\n");
        s.append(" -u user   (or -user)\n");
        s.append(" -p pwd    (or -pwd)\n");
        s.append(" -d db     (or -db)\n");
        s.append(" -help this output    \n\n");
        
        
        return s.toString();
    }
    
    
    public static void main(String args[]) {
        
        String host = "localhost";
        String user = System.getProperty("user.name");
        String pwd  = "";
        String db   = "";
        String file = "";
        
        int i = 0;
        while ( i < args.length) {
            
            if ( (args[i].equals("-h"))  || (args[i].equals("-host")) ) {
                i++;
                host = args[i];
            }
            if ( (args[i].equals("-f"))  || (args[i].equals("-file")) ) {
                i++;
                file = args[i];
            }
            
            if ( (args[i].equals("-u"))  || (args[i].equals("-user")) ) {
                i++;
                user = args[i];
            }
            if ( (args[i].equals("-p"))  || (args[i].equals("-pwd")) ) {
                i++;
                pwd = args[i];
            }
            
            if ( (args[i].equals("-d"))  || (args[i].equals("-db")) ) {
                i++;
                db = args[i];
            }
            
            if ( args[i].equals("-help") ) {
                
                StringBuffer s = new StringBuffer();
                s.append("Fredy's tool to execute a file into a DB\n");
                s.append("Usage:\n\n");
                s.append(" -f file   (or -file)\n");
                s.append(" -h host   (or -host)\n");
                s.append(" -u user   (or -user)\n");
                s.append(" -p pwd    (or -pwd)\n");
                s.append(" -d db     (or -db)\n");
                s.append(" -help this output    \n\n");
                System.out.println(s.toString());
                System.exit(0);
            }
            i++;
        }
        
        FileExec fe  = new FileExec(file,host,user,pwd,db);
        fe.doIt();
        fe.closeTcon();
        
        
    }
    
}
