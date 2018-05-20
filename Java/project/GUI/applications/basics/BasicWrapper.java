package applications.basics;

/**
 *
 * BasicWrapper contains all common things of the Wrapper-Classes
 *
 * Admin is a Tool around SQL-Databases to do basic jobs
 * for DB-Administrations, like:
 * - create/ drop tables
 * - create  indices
 * - perform sql-statements
 * - simple form
 * - a guided query
 * and a other usefull things in DB-arena
 *
 * Admin Version see below
 * Copyright (c) 1999 Fredy Fischer
 * sql@hulmen.ch
 *
 * Fredy Fischer
 * Hulmenweg 36
 * 8405 Winterthur
 * Switzerland
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser  General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 **/

import java.sql.*;
import java.util.Calendar;
import java.util.logging.*;

public class BasicWrapper extends BasicAdmin {
    
    Logger logger;
    public ResultSet sqlresult;
    
    String query;
    
    public boolean useLookup = false;
    
    /**
     * Get the value of query.
     * @return value of query.
     */
    public String getQuery() {return query;}
    
    /**
     * Set the value of query.
     * @param v  Value to assign to query.
     */
    public void setQuery(String  v) {this.query = v;}
    
    public String execQuery() {
        
        if (con == null) openConnection();
        
        
        try {
            int records = con.stmt.executeUpdate(getQuery());
        } catch (SQLException e) {
            return e.getMessage().toString();
        }
        return "ok";
    }
    
    public String execQuery(PreparedStatement stmt) {
        if (con == null) openConnection();
        try {
            int records = stmt.executeUpdate();
        } catch (SQLException e) {
            return e.getMessage().toString();
        }
        return "ok";
    }
    
    
    public String selectQuery() {
        
        if (con == null) openConnection();
        try {
            sqlresult = con.stmt.executeQuery(getQuery());
        } catch (SQLException e) {
            return e.getMessage().toString();
        }
        return "ok";
    }
    
    // only useful if running MySQL
    // returns the lates ID if using an auto increment tablekey
    public int getLastInsertID() {
        int lId = 0;
        try {
            ResultSet sqlresult = con.stmt.executeQuery("select last_insert_id()");
            sqlresult.next();
            if (sqlresult != null) lId = sqlresult.getInt(1);
        } catch (SQLException e) { lId = 0; }
        return lId;
    }
    
    
    
    
    public String selectQuery(PreparedStatement stmt) {
        
        try {
            sqlresult = stmt.executeQuery();
        } catch (SQLException e) {
            return e.getMessage().toString();
        }
        return "ok";
    }
    
    
    public PreparedStatement tempStatement(String q) {
        try {
            PreparedStatement pstmt = con.con.prepareStatement(q);
            return pstmt;
        } catch (SQLException sqlexception) {
            return null;
        }
    }
    
    
    public String toDay() {
        
        Calendar c = Calendar.getInstance();
        
        return  Integer.toString(c.get(Calendar.YEAR)) + "-" +
        Integer.toString(c.get(Calendar.MONTH)+1)+ "-" +
        Integer.toString(c.get(Calendar.DATE));
    }
    
    
    private void openConnection() {
        if ( ! useLookup ) {
            getCon();
            if (con.getError() != null) {
                logger.log(Level.WARNING,"Can not connect to DB: " + con.getError());
                con = null;
            }
        }
    }
    
    public void initPreparedStatements(){
        
        
    }
    
    
    public void init() {
        logger = Logger.getLogger("applications.basics");
        if ( con == null ) openConnection();
        initPreparedStatements();
        
        
    }
    
    public void finalize() {
        // if (con	!= null) con.close();
    }
    
    public BasicWrapper(t_connect con) {
        super(con.getHost(),con.getUser(),con.getPassword(),con.getDatabase(),"%");
        init();
    }
    public BasicWrapper(t_connect con,
    String schema) {
        
        super(con.getHost(),
        con.getUser(),
        con.getPassword(),
        con.getDatabase(),
        schema);
        init();
    }
    public BasicWrapper(t_connect con,
    String table,
    String schema) {
        super(con.getHost(),
        con.getUser(),
        con.getPassword(),
        con.getDatabase(),
        schema);
        setTable(table);
        init();
    }
    
    public BasicWrapper(String host,
    String user,
    String password,
    String database,
    String schema) {
        
        super(host,user,password,database,schema);
        init();
    }
    public BasicWrapper(String host,
    String user,
    String password,
    String database) {
        
        super(host,user,password,database,"%");
        init();
    }
    
    public BasicWrapper(String host,
    String user,
    String password,
    String database,
    String table,
    String schema) {
        
        super(host,user,password,database,schema);
        setTable(table);
        init();
    }
    
    public BasicWrapper(java.sql.Connection c) {
        super(new t_connect(c));
        init();
    }
    public BasicWrapper(java.lang.String datasource) {
        super(new t_connect(datasource)) ;
        useLookup = true;
        init();
    }
    
}


