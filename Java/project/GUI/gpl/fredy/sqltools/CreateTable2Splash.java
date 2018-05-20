/*
 * CreateTable2Splash.java
 *
 * Created on October 7, 2004, 8:47 AM
 *
 * This software is part of the Admin-Framework and under LGPL
 *
 * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 *
 *
 *   Copyright (C) October 7, 2004, Fredy Fischer
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

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import gpl.fredy.ui.*;

/**
 *
 * @author  afs
 */
public class CreateTable2Splash extends Window{
    
    /** Creates a new instance of CreateTable2Splash */
    public CreateTable2Splash() {
        super(new Frame());
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(BorderLayout.CENTER,new ImageLabel(null,"collmeta.jpg",null));
        panel.setBorder(new BevelBorder(BevelBorder.RAISED));
        add(panel);
        pack();
        Dimension WindowSize=getSize(),
        ScreenSize=Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((ScreenSize.width-WindowSize.width)/2,
        (ScreenSize.height-WindowSize.height)/2,WindowSize.width,
        WindowSize.height);
        setVisible(true);        
    }
    
    public void close() {
        setVisible(false);
        dispose();
    }
    
}
