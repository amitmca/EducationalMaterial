package gpl.fredy.share;

/**
    ReadParameter is a part of Admin and done for reading in a bunch
    of Parameters out of a File

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



import java.io.*;
import java.util.*;


public class ReadParameter {

// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002";

public String getVersion() {return fredysVersion; }


    String param;
    
    /**
       * Get the value of param.
       * @return Value of param.
       */
    public String getParam() {return param;}
    
    /**
       * Set the value of param.
       * @param v  Value to assign to param.
       */
    public void setParam(String  v) {this.param = v;}
    


    public String[] getParameter() {

	int i = 0;
	StringTokenizer st = new StringTokenizer(param," ");
	String[] arg= new String[st.countTokens()];
	while (st.hasMoreTokens()) {
	    arg[i]=st.nextToken();
	    System.out.println("Argument " + i + " " + arg[i]);
	    i++;
	}
	return arg;

    }


    public ReadParameter(String file) {

	String line="";
	param ="";

	try
	{
	    DataInputStream ipstr = new DataInputStream(
					new BufferedInputStream(
					new FileInputStream(file)));

	    BufferedReader bufrd = new BufferedReader(
				   new InputStreamReader(ipstr));
	    while ((line = bufrd.readLine()) != null) {

		if ( ! line.startsWith("#") && (line.trim().length() != 0))
		  param = param + " " + line;
	    }  
	} catch(IOException exep) {
	   param = "Can no read file " + file;
	}
    }
}
