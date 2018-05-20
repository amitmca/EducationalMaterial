package gpl.fredy.generate;

/** TableTreeNodeObject
 *  represents the Table for the XMLEditor
 *  it contains the following Info:
 *  - TableName
 *  - PrimaryKeys
 **/




/** XMLEditor edits the XML-file used for Generate Code
 *  and is a part of Admin...
 *  Version 1.0  23. March 2002
 *  Fredy Fischer 
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
**/

import java.util.Vector;
import java.util.StringTokenizer;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import org.jdom.Namespace;


public class TableTreeNodeObject {


    String table;
    
    /**
       * Get the value of table.
       * @return value of table.
       */
    public String getTable() {return table;}
    
    /**
       * Set the value of table.
       * @param v  Value to assign to table.
       */
    public void setTable(String  v) {this.table = v;}
    

    
    Vector primaryKey = new Vector();
    
    /**
       * Get the value of primaryKey.
       * @return value of primaryKey.
       */
    public Vector getPrimaryKey() {return primaryKey;}
    
    /**
       * Set the value of primaryKey.
       * @param v  Value to assign to primaryKey.
       */
    public void setPrimaryKey(Vector  v) {this.primaryKey = v;}
    
    public void addKey(String k) {
	primaryKey.addElement((String) k );
    }

    public void doPrimaryKey(String s) {
	StringTokenizer st = new StringTokenizer(s,";");
	while (st.hasMoreTokens()) addKey(st.nextToken());	    
    }


    public String getPK() {
	String s="";
	for (int i =0; i < primaryKey.size() ; i++) {
	    if (i == 0 ) {
		s = (String) primaryKey.elementAt(i);
	    } else {
		s = s + ";" + (String) primaryKey.elementAt(i);
	    }
	}
	return s;
    }

    
    Element elt= new Element("table",getNs());
    
    /**
       * Get the value of elt.
       * @return value of elt.
       */
    public Element getElt() {
	elt = new Element("table",getNs());
	elt.setAttribute("name",getTable());
	elt.setAttribute("primaryKeys",getPK());

	return elt;

    }
    
    /**
       * Set the value of elt.
       * @param v  Value to assign to elt.
       */
    public void setElt(Element  v) {
	this.elt = v;
	setTable((String)elt.getAttributeValue("name"));
        doPrimaryKey((String)elt.getAttributeValue("primaryKeys"));	   
    }


    Namespace ns = Namespace.getNamespace("admin","Fredys-Admintool");
    
    /**
       * Get the value of ns.
       * @return value of ns.
       */
    public Namespace getNs() {return ns;}
    
    /**
       * Set the value of ns.
       * @param v  Value to assign to ns.
       */
    public void setNs(Namespace  v) {this.ns = v;}
    
    public TableTreeNodeObject(String t, String p) {
	setTable(t);
	doPrimaryKey(p);
    }

    public TableTreeNodeObject(Element e) {
	setElt(e);
    }

    public TableTreeNodeObject (Namespace ns, Element e) {
	setNs(ns);
	setElt(e);
    }
}
