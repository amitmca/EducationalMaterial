/*
 * LengthTableCellEditor.java
 *
 * Created on October 3, 2004, 10:39 AM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) October 3, 2004, Fredy Fischer
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



/**
 *
 * @author  afs
 */
public class LengthTableCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    private JButton button;
    
    private JDialog dialog;
    
    private JSpinner lengthSpinner;
    
    protected static final String EDIT = "edit";
    
    private int value = 0;
    
    /** Creates a new instance of LengthTableCellEditor */
    public LengthTableCellEditor() {
        SpinnerModel lengthModel = new SpinnerNumberModel(0,0,255,1);
        lengthSpinner    = new JSpinner(lengthModel);
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
        lengthSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                value = ((Integer)lengthSpinner.getValue()).intValue();
                button.setText(Integer.toString(value));
            }}
        );
        
        
        dialog = new JDialog();
        dialog.setTitle("Field length");
        dialog.setLayout(new FlowLayout());
        dialog.add(lengthSpinner);
        
        JButton ok = new JButton("OK");
        ok.setActionCommand("OK");
        ok.addActionListener(this);
        
        dialog.add(ok);
    }
    
    
    public Object getCellEditorValue() {
        return new Integer(value);
    }
    
    public java.awt.Component getTableCellEditorComponent(JTable table, Object nv, boolean isSelected, int row, int column) {
        //lengthSpinner.setValue(nv);
        value = ((Integer)nv).intValue();
        //button.setText(((Integer)nv).toString());
        return button;
    }
    

    
    public void actionPerformed(ActionEvent e) {
        if ( EDIT.equals(e.getActionCommand() )) {
            button.setText(Integer.toString(value));
            
            dialog.pack();
            dialog.setLocationRelativeTo(button);
            dialog.setVisible(true);
            
            fireEditingStopped();
        } else {            
            value = ((Integer)lengthSpinner.getValue()).intValue();
            button.setText(Integer.toString(value));
            dialog.dispose();
        }
    }
    
}
