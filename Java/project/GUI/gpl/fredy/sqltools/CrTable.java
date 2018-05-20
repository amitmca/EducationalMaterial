package gpl.fredy.sqltools;

/** 
    CrTable is apart of Admin

    Admin is a Tool around JDBC-enablec SQL-RDBMS to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin 
    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

   
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA


**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.JTable;
import javax.swing.table.*;
import java.util.Vector;

public class CrTable extends AbstractTableModel {

// Fredy's make Version
private static String fredysVersion = "Version 1.5  24. Nov. 2002";

public String getVersion() {return fredysVersion; }
public Vector  data;
public String[] columnNames = { "Field Name",
				"Typ of the field",
				"not NULL",
				"length or enumeration/set",
				"other Parameters" };

    public CrTable () {

	data   = new Vector();
    }

    public void addRow(Vector v) {

	data.addElement(v);
	fireTableChanged(null);
    }

    public void clearData() {
	data.removeAllElements(); 
	fireTableDataChanged();
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
