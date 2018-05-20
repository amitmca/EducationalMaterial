package applications.basics;

/**
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.*;
import javax.swing.event.*;
import java.io.*;

public class ButtonPanel extends JPanel {


    public ImageButton  insert, update, delete, clear, cancel,nextRecord,prevRecord;

    public ButtonPanel() {

	this.setLayout(new FlowLayout());
	insert   = new ImageButton("Insert","insert.gif","Inserts a new row");
	update   = new ImageButton("Update","update.gif","Update existing row");
	delete   = new ImageButton("Delete","delete.gif",null);
	clear    = new ImageButton("Clear","clear.gif",null);
	cancel   = new ImageButton("Cancel","exit.gif",null);
	prevRecord = new ImageButton(null,"vcrback.gif","back");
	nextRecord = new ImageButton(null,"vcrforward.gif","next");

	//this.add(prevRecord);
	this.add(insert);
	this.add(update);
	this.add(delete);
	this.add(clear);
	this.add(cancel);
	//this.add(nextRecord);

	this.setBorder(BorderFactory.createEtchedBorder());
    }


    private ImageIcon loadImage(String image) {
	String admin_img = System.getProperty("admin.image");
	ImageIcon img = null;
	if (admin_img == null) {
	    img = new ImageIcon(ButtonPanel.class.getResource("images"+ File.separator + image));
	} else {
	    img = new ImageIcon(admin_img + File.separator + image);
	}
	    
        return img;
    }


    public static void main(String args[]) {

	JFrame frame = new JFrame("Button Panel");
	ButtonPanel bp = new ButtonPanel();
	frame.getContentPane().setLayout(new BorderLayout());
	frame.getContentPane().add("Center",bp);
	bp.cancel.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}});
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	frame.pack();
	frame.setVisible(true);

	
    }


}
