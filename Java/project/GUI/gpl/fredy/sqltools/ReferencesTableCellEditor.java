/*
 * ReferencesTableCellEditor.java
 *
 * Created on October 5, 2004, 2:10 PM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) October 5, 2004, Fredy Fischer
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
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import gpl.fredy.ui.*;

/**
 *
 * @author  afs
 */
public class ReferencesTableCellEditor  extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    private JButton button;
    
    private JDialog dialog;
    
    private JTextArea area = new JTextArea();
    
    private String reference;
    
    protected static final String EDIT   = "edit";
    
    /** Creates a new instance of ReferencesTableCellEditor */
    public ReferencesTableCellEditor(String title, String schema, java.sql.Connection con) {
        button = new JButton();
        button.setActionCommand("");
        button.addActionListener(this);
        button.setBorderPainted(false);
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.getContentPane().setLayout(new BorderLayout());
        
        SqlPickList sqlPicklist = new SqlPickList(con,this,schema);
        dialog.getContentPane().add(BorderLayout.CENTER,sqlPicklist);
        dialog.setModal(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
            button.setText(e.getActionCommand());
            reference = e.getActionCommand();
            dialog.pack();
            dialog.setLocationRelativeTo(button);
            dialog.setVisible(true);                        
            fireEditingStopped();
            if (e.getActionCommand() != "") dialog.dispose();
    }
    public Object getCellEditorValue() {
        return reference.trim();
        
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        reference = (String) value;
        
        return button;
    }
    
}
