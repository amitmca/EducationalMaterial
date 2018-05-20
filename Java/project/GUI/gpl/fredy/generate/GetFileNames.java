package gpl.fredy.generate;


/**  *
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

    This creates a list of the generated FileNames of a DB so I know, what files are to compile


**/

import java.util.logging.*;
import java.util.Vector;
import java.io.File;
import gpl.fredy.share.t_connect;
import gpl.fredy.metadata.*;

public class GetFileNames {

    private Logger logger;


    String baseDir;
    
    /**
     * Get the value of baseDir.
     * @return value of baseDir.
     */
    public String getBaseDir() {
	return baseDir;
    }
    
    /**
     * Set the value of baseDir.
     * @param v  Value to assign to baseDir.
     */
    public void setBaseDir(String  v) {
	this.baseDir = v;
    }
    public GetFileNames() { setBaseDir(""); }
    public GetFileNames(String bd) { setBaseDir(bd); }

    private String firstUpper(String s) {
	// I do not want to have spaces within the name
        s = s.replace(' ','_');
	s = s.substring(0,1).toUpperCase() + s.substring(1);
	return s;
    }

    public String[] getNames(t_connect con) {

	logger = Logger.getLogger("gpl.fredy.generate");

	DbInfo dbi = new DbInfo(con);

	Vector v = dbi.getTables(con.getDatabase());

        // for each Table we have 3 files: Row, Form; TableModel
	String[] names = new String[v.size() * 3];

	int j = 0;
	for (int i=0;i < v.size();i ++ ) {
	    String s = getBaseDir() + 
		File.separator + 
		firstUpper((String)v.elementAt(i));
	    names[j] = s + "Row.java";
	    j++;
	    names[j] = s + "TableModel.java";
	    j++;
	    names[j] = s + "Form.java";
	    j++;
	    
	}

	return names;
    }

    public String[] getFormNames(t_connect con) {
	logger = Logger.getLogger("gpl.fredy.generate");

	DbInfo dbi = new DbInfo(con);

	Vector v = dbi.getTables(con.getDatabase());

        // for each Table we have 3 files: Row, Form; TableModel
	String[] names = new String[v.size()];


	for (int i=0;i < v.size();i ++ ) {
	    String s = firstUpper((String)v.elementAt(i));
	    names[i] = "applications." + con.getDatabase()+ "." + s + "Form";
	    logger.log(Level.INFO,"Name is: " + names[i]);
	}
	return names;
    }
}


