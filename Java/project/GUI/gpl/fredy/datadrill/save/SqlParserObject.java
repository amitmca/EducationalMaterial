package osec.crm;
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

import applications.basics.*;
import javax.swing.*;

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
    


    public String getText() {
	String s = "";
	if ( getFieldType() == DATEFIELD ) s = ((DateFieldPanel)component).getText();
	if ( getFieldType() == TEXTFIELD ) s = ((FieldPanel)component).getText();
	if ( getFieldType() == COMBOBOX  ) s = ((DBcomboBoxPanel)component).getText();
	if ( getFieldType() == TWINBOX   ) s = ((TwinBoxPanel)component).getText();

	return s;

    }
    
    JComponent component;
    
 
    public String getValue() {
	String s="";
	if ( getFieldType() == DATEFIELD   ) s = ((DateFieldPanel)component).getText();
	if ( getFieldType() == TEXTFIELD   ) s = ((FieldPanel)component).getText();
	if ( getFieldType() == NUMBERFIELD ) s = ((FieldPanel)component).getText();

	return s;
    }
    
    /**
     * Set the value of component.
     * @param v  Value to assign to component.
     */
    public void setComponent() {
	if ( getFieldType() == DATEFIELD   ) component = new DateFieldPanel(parameter);
	if ( getFieldType() == TEXTFIELD   ) component = new FieldPanel(parameter,20,JTextFieldFilter.ALPHA_NUMERIC);
	if ( getFieldType() == NUMBERFIELD ) component = new FieldPanel(parameter,20,JTextFieldFilter.NUMERIC);
  
    }
    
    public JComponent getComponent() { return component; }

    public SqlParserObject() {
	
	parameter = null;
	value     = null;
	
    }
    
}
