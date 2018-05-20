package gpl.fredy.io;
/*
 * Gives info about a file it needs a OS-depending binary to create a checksum,
 * this is the second parameter to give
 *
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
 */
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;

public class FileInfo {

 private File file;
 public static int ERROR=0, DIRECTORY=1, FILE=2, BINARY=3;
 private String check=null;
    // private DateFormat  dateFormatter = DateFormat.getTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

public FileInfo (String file, String m) {

        setFile(file);
	setCheckMethode(m);
}

public void setFile(String file) { this.file = new File(file);}
public String getName() { return file.getName(); }
public String getPath() { return file.getParent(); }
public boolean isReadable() { return file.canRead(); }
public boolean isWriteable() { return file.canWrite(); }
public int getTyp() {
 try {
     if ( file.isFile() ) 	return FILE;
     if ( file.isDirectory() )  return DIRECTORY;
     return BINARY;
 } catch (SecurityException sex) { return ERROR; }
 
}
public long getTime() { return file.lastModified(); }
public long getSize() { return file.length(); }
public int  getHashCode() { return file.hashCode(); }

public void setCheckMethode(String s) { check = s; }
public String getCheckSum() {

  if (check.equals(null) ) {
     return null;
  } else {
     return checkSum();
  }
}
private String checkSum() {
    String s="";
    if ( isReadable() )  {  
	try {
	    Runtime rt = Runtime.getRuntime();
	    Process prcs = rt.exec(check + " " + getPath() + File.separator + getName());
	    BufferedReader d = new BufferedReader(new InputStreamReader( prcs.getInputStream()));
	    String line;
	    while ( (line=d.readLine() ) != null ) {
	      s=s+line;
	    }
	}
	catch (IOException ioe) {
	    System.out.println("IO-Exception: " +ioe);
	    s=null;
	}
    } else { 
        s = "file not readable";
    }
  
    return s;
}

public static void main(String args[]) {
    System.out.println("File-Info\n"+
                       "---------\n"+
                       "Version 1.1, Jan 2002\n"+
                       "Fredy Fischer ");                      

 if (args.length !=2 ) {
  System.out.println("Syntax: java gpl.fredy.io.FileInfo filename ChecksumMethode(e.g. /usr/bin/sum)");
  System.exit(0);
 }
 FileInfo f = new FileInfo(args[0],args[1]);
 
 String typ ="";
 if (f.isReadable()) typ="r";
 if (f.isWriteable()) {
     typ=typ+"w";
 } else { typ = typ+"-"; }
 
 
 
 System.out.println("\nInfos about " + f.getPath() + File.separator + f.getName() + "\n"+
                    "-----------\n"+
                    "Filename      : " + f.getName() + "\n"+
                    "Path          : " + f.getPath() + "\n"+
                    "HashCode      : " + f.getHashCode() + "\n"+
                    "Checksum      : " + f.getCheckSum() + "\n"+
                    "Typ           : " + f.getTyp() + "\n"+
                    "                0 = Error, 1 = Directory, 2 = File\n"+
                    "Size          : " + f.getSize() + " Bytes\n"+
                    "Last Modified : " + f.getTime() + "\n"+
                    "Flags         : " + typ);
 }
 }
