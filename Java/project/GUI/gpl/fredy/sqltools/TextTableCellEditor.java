/*
 * TextTableCellEditor.java
 *
 * Created on October 5, 2004, 11:10 AM
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
public class TextTableCellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    private JButton button;
    
    private JDialog dialog;
    
    private JTextArea area;
    
    private String buffer;
    
    protected static final String EDIT   = "edit";
    protected static final String ACCEPT = "accept";
    protected static final String CANCEL = "cancel";
    
    /** Creates a new instance of TextTableCellEditor */
    public TextTableCellEditor(String title,int rows, int columns) {
        area = new JTextArea(rows,columns);
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(false);
        dialog = new JDialog();
        dialog.setTitle(title);
        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(BorderLayout.CENTER,new JScrollPane(area));
        dialog.getContentPane().add(BorderLayout.SOUTH,buttonPanel());
        dialog.setModal(true);
        
    }
    
    private JPanel buttonPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        ImageButton ok = new ImageButton(null,"ok.gif","accept entries");
        ok.setActionCommand(ACCEPT);
        ok.addActionListener(this);
        
        ImageButton cancel = new ImageButton(null,"cancel.gif","revert entries");
        cancel.setActionCommand(CANCEL);
        cancel.addActionListener(this);
        
        panel.add(ok);
        panel.add(cancel);
        
        panel.setBorder(new EtchedBorder());
        return panel;
    }
    
    public void actionPerformed(ActionEvent e) {
        if ( EDIT.equals(e.getActionCommand() )) {
            button.setText(area.getText());
            
            dialog.pack();
            dialog.setLocationRelativeTo(button);
            dialog.setVisible(true);
            
            fireEditingStopped();
        } else {
            if ( ACCEPT.equals(e.getActionCommand() )) {
                button.setText(area.getText());
                dialog.dispose();
                fireEditingStopped();
            }
            if ( CANCEL.equals(e.getActionCommand() )) {
                area.setText(buffer);
                dialog.dispose();
                fireEditingStopped();
            }
        }
        
        
    }
    
    public Object getCellEditorValue() {
        return area.getText();
    }
    
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        buffer = (String) value;
        area.setText((String)value);
        return button;
    }
    
}
