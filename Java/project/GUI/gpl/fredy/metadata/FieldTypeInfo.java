/*
 * FieldTypeInfo.java
 *
 * Created on January 25, 2004, 1:30 PM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) January 25, 2004, Fredy Fischer
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

package gpl.fredy.metadata;

/**
 *
 * @author  afs
 */
public class FieldTypeInfo {
    
    private String typName = null;
    
    private boolean autoIncrement = false;
    
    /** Creates a new instance of FieldTypeInfo */
    public FieldTypeInfo() {
    }
    
    /** Getter for property autoIncrement.
     * @return Value of property autoIncrement.
     *
     */
    public boolean isAutoIncrement() {
        return autoIncrement;
    }
    
    /** Setter for property autoIncrement.
     * @param autoIncrement New value of property autoIncrement.
     *
     */
    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }
    
    /** Getter for property typName.
     * @return Value of property typName.
     *
     */
    public java.lang.String getTypName() {
        return typName;
    }
    
    /** Setter for property typName.
     * @param typName New value of property typName.
     *
     */
    public void setTypName(java.lang.String typName) {
        this.typName = typName;
    }
    
}
