package gpl.fredy.ui;

/** 
 *
 * RDBMSTreeRenderer is a part of Admin and is used to display the RDBMS as a
 * tree
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


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;


public class RDBMSTreeRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent( JTree tree, 
						    Object value, 
						    boolean selected,
						    boolean expanded,
						    boolean leaf,
						    int row,
						    boolean hasFocus ) {
	super.getTreeCellRendererComponent(tree,
					   value,
					   selected,
					   expanded,
					   leaf,
					   row,
					   hasFocus);

	if (row == 0 ) setIcon(loadImage.getImage("dbtreetop.gif"));

	//System.err.println(((DefaultMutableTreeNode) value).toString() + " row is "  + row   + " index is " +  tree.getIndex( (DefaultMutableTreeNode) value) );




	return this;
    }


     LoadImage loadImage = new LoadImage();

}

						    
