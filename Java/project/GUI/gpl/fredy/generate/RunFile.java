package gpl.fredy.generate;

/*
 * This executes a Java-Application and is part of Fredy's Admin Framework
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

**/

import java.util.logging.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;


public class RunFile {   
    private Logger logger;

 

    public void  run(String file, String args[]) {

	logger = Logger.getLogger("gpl.fredy.generate");
        logger.log(Level.INFO,"Trying to run:  " + file );
	try {            
	    Class cls = Class.forName(file);
	    Method main = cls.getMethod("main", new Class[] { String[].class });
	    main.invoke(null, new Object[] { args });
	    logger.log(Level.INFO,"Launched: " + file);
	} catch (InvocationTargetException ex) {
	    // Exception in the main method we just tried to run
	    showMsg("Exception in main: " + ex.getTargetException());
	    ex.getTargetException().printStackTrace();
	} catch (Exception ex) {
	    showMsg(ex.toString());
	}

    }

    private void showMsg(String m) {
	logger.log(Level.WARNING,m);
    }
    public static void main(String args[] ) {
	String f = args[0];
	String[] a = new String[ args.length -1 ];
	for (int i = 0; i< args.length -1;i++)
	     a[i] = args[i+1];

	RunFile rf = new RunFile();
	rf.run(f,a);
    }
        


}
