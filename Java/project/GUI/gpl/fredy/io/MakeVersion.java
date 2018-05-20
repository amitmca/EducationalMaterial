package gpl.fredy.io;

/**
   Makes a new Version of a file, means renames the File with
   accelerating numbers....

   this tool is part of the Admin-Suite

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
                 
   

import java.util.*;
import java.io.*;    

public class MakeVersion {

    String fileName;
    
    /**
     * Get the value of fileName.
     * @return value of fileName.
     */
    public String getFileName() {return fileName;}
    
    /**
     * Set the value of fileName.
     * @param v  Value to assign to fileName.
     */
    public void setFileName(String  v) {
	   this.fileName = v;
	   this.file = new File(v);	
    }
    
    
    String path;
    
    /**
     * Get the value of path.
       * @return value of path.
       */
    public String getPath() {
	return getFile().getParent();
    }
    
    File file=null;
    
    /**
       * Get the value of file.
       * @return value of file.
       */
    public File getFile() {return file;}
    
    /**
       * Set the value of file.
       * @param v  Value to assign to file.
       */
    public void setFile(String v) {
	this.file = new File(v);
    }

    public void setFile(File v) {
	this.file =v;
    }

    public MakeVersion(String s) {
	setFileName(s);
	doIt();
    }
    public MakeVersion(File f) {
	setFile(f);
	doIt();
    }
    

    private void doIt() {
	if ( file.exists() ) {
	    int i=0;
	    boolean v = false;
	    while ( ! v) {
		i++;
		File f = new File(getFile().getParent() + File.separator + 
				  getFile().getName() + "." + Integer.toString(i));
		if ( ! f.exists() )  v = getFile().renameTo(f);
	    }
	}
    }

    public static void main(String args[]) {
	System.out.println("File Versioner Version 1.0\n" +
			   "use java gpl.fredy.io.MakeVersion full-file-name");

	if ( args.length == 1) {
	    System.out.println("Makeing new Version of " + args[0]);
	    MakeVersion m = new MakeVersion(args[0]);
	}

    }
}
