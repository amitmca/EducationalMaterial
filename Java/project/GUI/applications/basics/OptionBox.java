/**
 * This OptionBox creates a HTML-Form Select-Element
 * where the element and values are read out of the DB
 *
 * the connection to the DB is done by the name of a datasource
 * therefore OptionBox has to run inside a container delivering
 * the capability to lookup up JNDI
 *
 * call the element as follows:
 * getOption(String datasourcename, String HTML-Name of the Element,
 *           String default element to select,
 *           String SQL-Query)
 * the SQL-query must return 2 attributes, while the first attribute
 * is put as the value-key of the HTML-Select-Element and the second
 * attribute is displayed in the select-box
 *
 * Version 1.0
 * Copyright (c) 2003 Fredy Fischer
 * sql@hulmen.ch
 *
 * Fredy Fischer
 * Hulmenweg 36
 * 8405 Winterthur
 * Switzerland
 *
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser  General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 **/
package applications.basics;
import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import applications.basics.*;
import javax.sql.DataSource;
import java.util.logging.*;

public class OptionBox {
    
    private Logger logger=Logger.getLogger("applications.basics");
    
    public OptionBox() {
        
    }
    
    // returns field 1 while displaying field 2
    public String getOption(String datasource, String name,String def, String query) {
        Connection con = null;
        Statement stmt = null;
        StringBuffer s = new StringBuffer("<select name=\"" + name +"\">\n");
        try {
            InitialContext initCtx = new InitialContext();
            DataSource ds = (javax.sql.DataSource) initCtx.lookup(datasource);
            con  = ds.getConnection();
            stmt = con.createStatement();
        }  catch (javax.naming.NamingException nme) {
            logger.log(Level.WARNING,"can not get datasource");
            logger.log(Level.FINE,"Namingexception: " + nme.getMessage());
        }  catch (SQLException sqle) {
            logger.log(Level.WARNING,"can not connect to datasource");
            logger.log(Level.FINE,"SQLException: " + sqle.getMessage());
        }
        try {
            ResultSet rs   = stmt.executeQuery(query);
            while (rs.next() ) {
                s.append("<option value=\""+ rs.getString(1) + "\"");
                if ( rs.getString(1).equals(def) ) s.append(" SELECTED");
                s.append(">" + rs.getString(2) + "\n");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
          logger.log(Level.WARNING,"can not get SELECT-Element");
          logger.log(Level.FINE,"SQL-Exception: " + e.getMessage());
        }
        s.append("</select>\n");
        
        return s.toString();
    }
}
