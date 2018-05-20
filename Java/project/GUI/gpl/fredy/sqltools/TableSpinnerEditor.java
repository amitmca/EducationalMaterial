/*
 * TableSpinnerEditor.java
 *
 * Created on October 4, 2004, 11:54 AM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) October 4, 2004, Fredy Fischer
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.*;
/**
 *
 * @author  afs
 */
public class TableSpinnerEditor extends AbstractCellEditor implements TableCellEditor {
    
                          
        final JSpinner spinner = new JSpinner();
    
        // Initializes the spinner.
        public TableSpinnerEditor(int value, int minimum, int maximum,int stepSize) {
            SpinnerModel lengthModel = new SpinnerNumberModel(value, minimum,maximum,stepSize);    
            spinner.setModel(lengthModel);
        }
    
        // Prepares the spinner component and returns it.
        public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
            spinner.setValue(value);
            return spinner;
        }
    
        // Enables the editor only for single-clicks.
        public boolean isCellEditable(EventObject evt) {
            if (evt instanceof MouseEvent) {
                return ((MouseEvent)evt).getClickCount() >= 1;
            }
            return true;
        }
    
        // Returns the spinners current value.
        public Object getCellEditorValue() {
            return spinner.getValue();
        }
    }
