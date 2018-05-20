/*
 * TableAreaRenderer.java
 *
 * Created on October 5, 2004, 10:31 AM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) October 5, 2004, Fredy Fischer
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

package gpl.fredy.sqltools;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.*;

/**
 *
 * @author  afs
 */
public class TableAreaRenderer extends JTextArea implements TableCellRenderer {
    
    /** Creates a new instance of TableAreaRenderer */
    public TableAreaRenderer(int rows, int columns) {
        this.setRows(rows);
        this.setColumns(columns);
    }
    
    public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setLineWrap(true);
        setWrapStyleWord(true);        
        setText(value.toString());
        
        //return this;
        return new JScrollPane(this);
    }
    
}
