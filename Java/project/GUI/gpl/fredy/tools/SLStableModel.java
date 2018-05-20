package gpl.fredy.tools;

/**
   SLSTableModel is the TableModel used within the
   SLS (SimpleLogServer)
   
   SimpleLogServer is part of Admin and under GPL

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
import java.util.StringTokenizer;

public class SLStableModel extends AbstractTableModel {

// Fredy's make Version
private static String fredysVersion = "Version 1.0  18. Jan. 2003";

public String getVersion() {return fredysVersion; }
public Vector  data;

    public static final int DATE         = 0;
    public static final int SOURCECLASS  = 1;
    public static final int SOURCEMETHOD = 2;
    public static final int LEVEL        = 3;
    public static final int MESSAGE      = 4;

public String[] columnNames = { "Date",
		       	       "Source class",
		       	       "Source method",
		       	       "Log Level",
			       "Log Message"
                              };

    public SLStableModel () {

	data   = new Vector();
    }

    public void clearData() {
	data.removeAllElements(); 
	fireTableDataChanged();
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
	try {
	    Vector rowData = (Vector)data.elementAt(row);
	    return rowData.elementAt(col);
	} catch (Exception e) { return " ";}
    }

    public boolean isCellEditable(int row, int col) { return false; }

    public void setValueAt(Object value, int row, int col) {
	Vector rowData = (Vector)data.elementAt(row);
	rowData.setElementAt(value,col);
	data.setElementAt(rowData,row);
	fireTableCellUpdated(row, col);
    }

    public void setTextData(String s) {
	clearData();

	StringTokenizer st = new StringTokenizer(s,"\n");
	while (st.hasMoreTokens()) {
	    addSingleRow(st.nextToken());
	}
    }
    public void addSingleRow(String s) {
	StringTokenizer st = new StringTokenizer(s,"|");
	Vector v = new Vector();
	while (st.hasMoreTokens()) {
	    v.addElement((String)st.nextToken());
	}
	addRow(v);    
    }

    public String getDataAsText() {
	StringBuffer s = new StringBuffer();
	for (int i=0;i < data.size();i++) {
	    for (int j = 0;j <= getColumnCount();j++) {
		if ( j > 0)  s.append(" |");
		s.append((String)getValueAt(i,j));
	    }
	    s.append("\n");
	}
	return s.toString();
    }

    public void half() {
	for (int i=0;i < getRowCount();i++) data.remove(i);
    }
}
