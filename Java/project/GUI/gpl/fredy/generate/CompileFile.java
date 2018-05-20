package gpl.fredy.generate;


/** 
    This javac's a File into the destination it's source is

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

**/

import java.util.logging.*;
import java.io.File;


public class CompileFile {

    private Logger logger;

    public CompileFile(String sourceDirectory,
		       String targetDirectory,
		       String [] files) {
	
	//com.sun.tools.javac.Main javac = new com.sun.tools.javac.Main();
	
	logger = Logger.getLogger("gpl.fredy.generate");
	logger.log(Level.INFO,"Source Dir: " + sourceDirectory );
	logger.log(Level.INFO,"Target Dir: " + targetDirectory );
	for (int i = 0;i < files.length;i++) {
	    String[] args = new String[] {
		"-d",
		targetDirectory,
		sourceDirectory + File.separator + files[i]
	    };
            int status = 1;
	    // status = javac.compile(args);
	    logger.log(Level.INFO,"Compile Status of " + files[i] + " = " +
		       Integer.toString(status));
	}
    }
    
}
