package gpl.fredy.share;

/** 
    SelectDriver is a part of Admin and done for loggin in to it...
    It creates a ComboBox out of a file called rdbms.dat in the
    Admin InstallDir

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


import java.util.*;
import javax.swing.ImageIcon;
import java.io.File;
import gpl.fredy.ui.LoadImage;

public class JdbcStuff {

// Fredy's make Version
private static String fredysVersion = "Version 1.4  2. Jan. 2002";

public String getVersion() {return fredysVersion; }

  LoadImage loadImage = new LoadImage();

  public String name, jdbcDriver, dbUrl, port, gif;
 
    public JdbcStuff() { ; }

    public void setObject(String line) {

      try {
	  StringTokenizer st = new StringTokenizer(line,"^");
	  setName(st.nextToken());
	  setJDBCDriver(st.nextToken());
	  setDbUrl(st.nextToken());
	  setPort(st.nextToken());
	  setGif(st.nextToken());
      } catch (NoSuchElementException nse) { ; }

  }


    public void setName(String name) { this.name=name; }
    public void setJDBCDriver(String jdbcDriver) { this.jdbcDriver = jdbcDriver; }
    public void setDbUrl(String dbUrl) { this.dbUrl = dbUrl; }
    public void setPort(String port ) { this.port = port; }
    public void setGif(String gif) { this.gif = gif; }

    public String getName() { return name; }
    public String getJDBCDriver() { return jdbcDriver; }
    public String getDbUrl() { return dbUrl; }
    public String getPort() { return port; }
    public int getPortAsInt() {
	int i=0;
	try {
	    i = Integer.parseInt(port);
	} catch ( NumberFormatException nfe) { ; }
	return i;
    }
    public String getGif() { return gif; }
    public ImageIcon getImage() {
	String image = getGif();
	ImageIcon img = null;
	if ( image != null ) {
	    img = loadImage.getImage(image);
         
	}
        return img;
    }


}
