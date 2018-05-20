package gpl.fredy.generate;

/** XMLTreeNode
 *  Represents a single Node within the XMLEdtior's tree
 *  This class is implemented by:
 *  - DbTreeNode
 *  - TableTreeNode
 *  - PanelTreeNode
 *  - ComponentTreeNode
 * 
 * it has these methods:
 * - setName / getName   the Name of the Object
 * - setText / getText   the Text to be displayed by the renderer
 * - setType / getType   what object does it contain (DB,TABLE,Panel,Component)
 * - setNode / getNode   the type-related object used 
 *
 * related classes:
 * - DbObject
 * - TableObject
 * - PanelObject
 * - ComponentObject
 *
 **/




/** XMLEditor edits the XML-file used for Generate Code
 *  and is a part of Admin...
 *  Version 1.0  23. March 2002
 *  Fredy Fischer 
 *
 **/


/* 
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

import javax.swing.*;

public class XMLTreeNode {
    
    String name="";
    
    /**
       * Get the value of name.
       * @return value of name.
       */
    public String getName() {return name;}
    
    /**
       * Set the value of name.
       * @param v  Value to assign to name.
       */
    public void setName(String  v) {this.name = v;}
   


    String text;
    
    /**
       * Get the value of text.
       * @return value of text.
       */
    public String getText() {return text;}
    
    /**
       * Set the value of text.
       * @param v  Value to assign to text.
       */
    public void setText(String  v) {this.text = v;}
    
 

    String type="";
    
    /**
       * Get the value of type.
       * @return value of type.
       */
    public String getType() {return type;}
    
    /**
       * Set the value of type.
       * @param v  Value to assign to type.
       */
    public void setType(String  v) {this.type = v;}
    
    
    Object node;
    
    /**
       * Get the value of node.
       * @return value of node.
       */
    public Object getNode() {return node;}
    
    /**
       * Set the value of node.
       * @param v  Value to assign to node.
       */
    public void setNode(Object  v) {this.node = v;}
    

}
