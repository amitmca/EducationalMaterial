package gpl.fredy.metadata;



/** 
 * Columns is a wrapper about columns in a given Table
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


public class Columns {

// Fredy's make Version
private static String fredysVersion = "Version 1.4   2. Jan.2002";

public String getVersion() {return fredysVersion; }

 
    int number;
    
    /**
       * Get the value of number.
       * @return Value of number.
       */
    public int getNumber() {return number;}
    
    /**
       * Set the value of number.
       * @param v  Value to assign to number.
       */
    public void setNumber(int  v) {this.number = v;}
    

    
    String name;
    
    /**
       * Get the value of name.
       * @return Value of name.
       */
    public String getName() {return name;}
    
    /**
       * Set the value of name.
       * @param v  Value to assign to name.
       */
    public void setName(String  v) {this.name = v;}
    


    int lng;
    
    /**
       * Get the value of lng.
       * @return Value of lng.
       */
    public int getLng() {return lng;}
    
    /**
       * Set the value of lng.
       * @param v  Value to assign to lng.
       */
    public void setLng(int  v) {this.lng = v;}
    
 
    
    int decDigits;
    
    /**
       * Get the value of decDigits.
       * @return Value of decDigits.
       */
    public int getDecDigits() {return decDigits;}
    
    /**
       * Set the value of decDigits.
       * @param v  Value to assign to decDigits.
       */
    public void setDecDigits(int  v) {this.decDigits = v;}
    


   
    String  type;
    
    /**
       * Get the value of type.
       * @return Value of type.
       */
    public String  getType() {return type;}
    
    /**
       * Set the value of type.
       * @param v  Value to assign to type.
       */
    public void setType(String   v) {this.type = v;}
    
    
    String table;
    
    /**
       * Get the value of table.
       * @return Value of table.
       */
    public String getTable() {return table;}
    
    /**
       * Set the value of table.
       * @param v  Value to assign to table.
       */
    public void setTable(String  v) {this.table = v;}
    
    public Columns() {

    }

    public  Columns(int no, String name, String type, int lng, int decDigits, String table) {


	setTable(table);
	setNumber(no);
	setName(name);
	setType(type);
	setLng(lng);
	setDecDigits(decDigits);

    }


}

