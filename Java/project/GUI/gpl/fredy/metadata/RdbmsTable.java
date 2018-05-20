package gpl.fredy.metadata;

/** 
 * RdbmsTable is part of Admin and is a TableModel with the info
 * of a table 
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
import javax.swing.JTable;
import javax.swing.table.*;
import java.util.Vector;

public class RdbmsTable extends AbstractTableModel {

// Fredy's make Version
private static String fredysVersion = "Version 1.4   2. Jan.2002";

public String getVersion() {return fredysVersion; }

public Vector  data;
public String[] columnNames = { "Product Name",
		       	       "JDBC-Driver",
		       	       "DB-Url",
		       	       "DB Port",
                               "Image"};

    public RdbmsTable () {

	data   = new Vector();
    }

    public void addRow(Vector v) {

	data.addElement(v);
	fireTableChanged(null);
    }


    public String getColumnName(int i) {

	return columnNames[i];
    }


    public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
    }

    public int getColumnCount() { return columnNames.length; }

    public int getRowCount() { return data.size(); }

    public Object getValueAt(int row, int col) {
	Vector rowData = (Vector)data.elementAt(row);
	return rowData.elementAt(col);
    }

    public boolean isCellEditable(int row, int col) { return true; }

    public void setValueAt(Object value, int row, int col) {
	// to be implemented...
	Vector rowData = (Vector)data.elementAt(row);
	rowData.setElementAt(value,col);
	data.setElementAt(rowData,row);
	fireTableCellUpdated(row, col);
    }

}
