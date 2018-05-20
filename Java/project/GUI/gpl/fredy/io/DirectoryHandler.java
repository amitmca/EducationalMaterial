package gpl.fredy.io;

/**
 * This is a supporting class I need to handle directories within the GenerateTool environment
 * It is part of Fredy's Admin Framework
 *
 * *
 Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
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

import java.io.File;

public class DirectoryHandler {

  private File dir;
  String directory;
    /**
       * Get the value of the Directory.
       * @return value of  the Directory.
       */
    public String getDirectory() {return directory;}
    
    /**
       * Set the value of the Directory.
       * @param v  Value to assign to the Directory.
       */
  public void setDirectory(String  v) {
     this.directory = v; 
     dir = new File(v);
     if ( ! dir.exists() ) dir.mkdir();
  }

  public void emptyDirectory() {
      try {
	  File f[];
	  f = dir.listFiles();
	  for (int i = 0; i < f.length; i++) f[i].delete();
      } catch (Exception exception) { }
  }

  public  DirectoryHandler(String name) {
     this.setDirectory(name) ;
  }
  public  DirectoryHandler() {
  }

}
