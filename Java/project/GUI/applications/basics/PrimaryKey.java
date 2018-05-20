package applications.basics;

/** 

    PrimaryKeys is a part of Admin and returns the Primary keys of a table

    Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin Version see below
    Copyright (c) 1999 Fredy Fischer
                       sql@hulmen.ch

		       Fredy Fischer
		       Hulmenweg 36
		       8405 Winterthur
		       Switzerland

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

**/




public class PrimaryKey   {


    public PrimaryKey() {


    }
 

    public PrimaryKey(String tableName, String columnName, short keySeq, String pkName) {
	this.setTableName(tableName);
	this.setColumnName(columnName);
	this.setKeySeq(keySeq);
	this.setPkName(pkName);
    }


    
    String tableName;
    
    /**
       * Get the value of tableName.
       * @return Value of tableName.
       */
    public String getTableName() {return tableName;}
    
    /**
       * Set the value of tableName.
       * @param v  Value to assign to tableName.
       */
    public void setTableName(String  v) {this.tableName = v;}
    
    
    String columnName;
    
    /**
       * Get the value of columnName.
       * @return Value of columnName.
       */
    public String getColumnName() {return columnName;}
    
    /**
       * Set the value of columnName.
       * @param v  Value to assign to columnName.
       */
    public void setColumnName(String  v) {this.columnName = v;}
    
    
    short keySeq;
    
    /**
       * Get the value of keySeq.
       * @return Value of keySeq.
       */
    public short getKeySeq() {return keySeq;}
    
    /**
       * Set the value of keySeq.
       * @param v  Value to assign to keySeq.
       */
    public void setKeySeq(short  v) {this.keySeq = v;}
    

    
    String pkName;
    
    /**
       * Get the value of pkName.
       * @return Value of pkName.
       */
    public String getPkName() {return pkName;}
    
    /**
       * Set the value of pkName.
       * @param v  Value to assign to pkName.
       */
    public void setPkName(String  v) {this.pkName = v;}

}