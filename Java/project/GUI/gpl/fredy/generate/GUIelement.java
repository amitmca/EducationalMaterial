package gpl.fredy.generate;

/** 
    GUIelement is part of the generator in Admin

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


**/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JPanel; 
import javax.swing.JFrame;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import gpl.fredy.share.*;
import gpl.fredy.ui.*;

public class GUIelement extends JDialog {


  private String[] filter = { "JTextFilter.NUMERIC",
			      "JTextFilter.FLOAT",
			      "JTextFilter.ALPHA",
			      "JTextFilter.ALPHA_NUMERIC",
			      "JTextFilter.LOWERCASE",
			      "JTextFilter.UPPERCASE"  };

  private String[] fieldString = { "FieldPanel",
				   "AreaPanel",
				   "DBcomboBoxPanel",
				   "TwinBoxPanel" };

  private String[] fieldNoArea = { "FieldPanel",
				   "DBcomboBoxPanel",
				   "TwinBoxPanel" };

  private String[] fieldDate   = { "DateButtonPanel",
				   "DateFieldPanel" };


  private JComboBox fieldType,textFilter;

  private JPanel comp(String typ) {
    JPanel panel = new JPanel();

    textFilter = new JComboBox(filter);
    textFilter.setEditable(true);
    textFilter.setAlignmentX(Component.LEFT_ALIGNMENT);
    textFilter.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String newSelection = (String)cb.getSelectedItem();
		System.out.println("ComboBox Content: " + newSelection);
            }
    });    
    panel.add(textFilter);
    return panel;
  }

  public GUIelement() {
    this.getContentPane().setLayout(new BorderLayout());
    this.getContentPane().add(BorderLayout.CENTER,comp("int"));
  }
  public static void main(String args[] ) {
    CloseableFrame cf = new CloseableFrame();
    GUIelement ge = new GUIelement();
    ge.pack();
    ge.setVisible(true);
  }
}

