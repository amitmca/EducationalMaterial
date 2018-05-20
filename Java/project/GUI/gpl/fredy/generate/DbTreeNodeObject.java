package gpl.fredy.generate;

/** DbTreeNodeObject
 *  represents the Database for the XMLEditor
 *  it contains the following Info:
 *  - databaseName
 **/




/** XMLEditor edits the XML-file used for Generate Code
 *  and is a part of Admin...
 *  Version 1.0  23. March 2002
 *  Fredy Fischer 
 *
 **/


/**  * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
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


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Attribute;
import org.jdom.Namespace;

public class DbTreeNodeObject {

    String database;
    
    /**
       * Get the value of database.
       * @return value of database.
       */
    public String getDatabase() {return database;}
    
    /**
       * Set the value of database.
       * @param v  Value to assign to database.
       */
    public void setDatabase(String  v) {this.database = v;}

    public Namespace ns  = Namespace.getNamespace("admin","Fredys-Admintool");

    Element element = new Element("component",ns);
    public Element getElt() {       
        element = new Element("database",ns);
        element.setAttribute(new Attribute("name",getDatabase()));
	return element;
    }

    public void setElt(Element v) {
	setDatabase((String)v.getAttributeValue("name"));
    }


    public DbTreeNodeObject(String v) {
	this.setDatabase(v);
    }

    
}
