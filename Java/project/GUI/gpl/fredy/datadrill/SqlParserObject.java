package gpl.fredy.datadrill;
/**
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C) August 9, 2003, Fredy Fischer
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

import gpl.fredy.share.*;
import gpl.fredy.ui.*;
import javax.swing.*;
import javax.swing.text.*;

public class SqlParserObject {

    public String parameter;
    public String value;
    public int DATEFIELD=0;
    public int TEXTFIELD=1;
    public int NUMBERFIELD=2;
    public int COMBOBOX =3;
    public int TWINBOX  =4;


    String origText;
    
    /**
     * Get the value of origText.
     * @return value of origText.
     */
    public String getOrigText() {
	return origText;
    }
    
    /**
     * Set the value of origText.
     * @param v  Value to assign to origText.
     */
    public void setOrigText(String  v) {
	this.origText = v;
    }
    


    int fieldType = TEXTFIELD;
    
    /**
     * Get the value of fieldType.
     * @return value of fieldType.
     */
    public int getFieldType() {
	return fieldType;
    }
    
    /**
     * Set the value of fieldType.
     * @param v  Value to assign to fieldType.
     */
    public void setFieldType(int  v) {
	this.fieldType = v;
    }

    public void setTyp(String v) {
	setFieldType(TEXTFIELD);
	if ( v.toLowerCase().equals("date") ) setFieldType(DATEFIELD);
	if ( v.toLowerCase().equals("alpha") ) setFieldType(TEXTFIELD);
	if ( v.toLowerCase().equals("numeric") ) setFieldType(NUMBERFIELD);
	if ( v.toLowerCase().equals("combo") ) setFieldType(COMBOBOX);
	if ( v.toLowerCase().equals("twin") ) setFieldType(TWINBOX);

    }

    String query;
    
    /**
     * Get the value of query.
     * @return value of query.
     */
    public String getQuery() {
	return query;
    }
    
    /**
     * Set the value of query.
     * @param v  Value to assign to query.
     */
    public void setQuery(String  v) {
	this.query = v;
    }
    
    t_connect con;
    
    /**
     * Get the value of con.
     * @return value of con.
     */
    public t_connect getCon() {
	return con;
    }
    
    /**
     * Set the value of con.
     * @param v  Value to assign to con.
     */
    public void setCon(t_connect  v) {
	this.con = v;
    }
    

    public String getText() {
	String s = "";
	if ( getFieldType() == DATEFIELD ) s = ((DateButtonPanel)component).getText();
	if ( getFieldType() == TEXTFIELD ) s = ((JTextField)component).getText();
	if ( getFieldType() == NUMBERFIELD ) s = ((JTextField)component).getText();
	if ( getFieldType() == COMBOBOX  ) s = ((DBcomboBox)component).getText();
	if ( getFieldType() == TWINBOX   ) s = ((TwinBox)component).getText();

	return s;

    }
    
    Object component;
    
 
    public String getValue() {
	String s="";
	if ( getFieldType() == DATEFIELD   ) s = ((DateButtonPanel)component).getText();
	if ( getFieldType() == TEXTFIELD   ) s = ((JTextField)component).getText();
	if ( getFieldType() == NUMBERFIELD ) s = ((JTextField)component).getText();
	if ( getFieldType() == COMBOBOX    ) s = ((DBcomboBox)component).getText();
	if ( getFieldType() == TWINBOX     ) s = ((TwinBox)component).getText();

	return s;
    }
    
    /**
     * Set the value of component.
     * @param v  Value to assign to component.
     */
    public void setComponent() {
	if ( getFieldType() == DATEFIELD   ) component = new DateButtonPanel(null);
	if ( getFieldType() == TEXTFIELD   ) {
	    JTextField jtf = new JTextField(20);
	    jtf.setDocument(new JTextFieldFilter(JTextFieldFilter.ALPHA_NUMERIC));
	    component = jtf;
	}
	if ( getFieldType() == NUMBERFIELD ) {
	    JTextField jtf = new JTextField(20);
	    jtf.setDocument(new JTextFieldFilter("0123456789."));  
	    component = jtf;
	}
	if ( getFieldType() == COMBOBOX ) {
	    DBcomboBox dbco = new DBcomboBox(getCon().getStmt(),getQuery());
	    component = dbco;
	}
	if ( getFieldType() == TWINBOX ) {
	    gpl.fredy.ui.TwinBox twb = new gpl.fredy.ui.TwinBox(getCon().getStmt(),getQuery());
	    component = twb;
	}

    }
    
    public Object getComponent() { return component; }

    public SqlParserObject() {
	
	parameter = null;
	value     = null;
	
    }
    
}
