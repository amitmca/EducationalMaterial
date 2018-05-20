package gpl.fredy.generate;

/*
 * this is the representation of a TreeObject and part of the XML-Editor
 * The XMLEditor is a GUI to modify a generated XML-file and to change the 
 * look of a GUI
 *
 * It is part of Fredy's Admin Framework
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
 */

import java.awt.GridBagConstraints;

public class TreeObject {


    GridBagConstraints gbc;
    
    /**
       * Get the value of gbc.
       * @return value of gbc.
       */
    public GridBagConstraints getGbc() {return gbc;}
    
    /**
       * Set the value of gbc.
       * @param v  Value to assign to gbc.
       */
    public void setGbc(GridBagConstraints  v) {this.gbc = v;}
    

    String name;
    
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
    
    
    int number;
    
    /**
       * Get the value of number.
       * @return value of number.
       */
    public int getNumber() {return number;}
    
    /**
       * Set the value of number.
       * @param v  Value to assign to number.
       */
    public void setNumber(int  v) {this.number = v;}
    

    
    String title;
    
    /**
       * Get the value of title.
       * @return value of title.
       */
    public String getTitle() {return title;}
    
    /**
       * Set the value of title.
       * @param v  Value to assign to title.
       */
    public void setTitle(String  v) {this.title = v;}
    

    
    String type;
    
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
    
    
    String fieldType;
    
    /**
       * Get the value of fieldType.
       * @return value of fieldType.
       */
    public String getFieldType() {return fieldType;}
    
    /**
       * Set the value of fieldType.
       * @param v  Value to assign to fieldType.
       */
    public void setFieldType(String  v) {this.fieldType = v;}
    
    
    
    GridBagConstraints labelConstraints;
    
    /**
       * Get the value of labelConstraints.
       * @return value of labelConstraints.
       */
    public GridBagConstraints getLabelConstraints() {return labelConstraints;}
    
    /**
       * Set the value of labelConstraints.
       * @param v  Value to assign to labelConstraints.
       */
    public void setLabelConstraints(GridBagConstraints  v)
    {this.labelConstraints = v;}
    

    
    String label;
    
    /**
       * Get the value of label.
       * @return value of label.
       */
    public String getLabel() {return label;}
    
    /**
       * Set the value of label.
       * @param v  Value to assign to label.
       */
    public void setLabel(String  v) {this.label = v;}
    
    
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
    

    


    public TreeObject() {
	init();

    }

    public TreeObject(String name,int number,GridBagConstraints gbc) {
	init();
	setName(name);
	setNumber(number);
	setGbc(gbc);

    }

    private void init() {
	gbc  = new GridBagConstraints();
	name = "";
	number = 0;
    }

}
	    
