package applications.basics;

/**
   ImageLabel creates a Label containing an Image


    It tries to open a Image as a Icon from different locations:
    1) the directory given over with -Dadmin.image=[DIRECTORY]
    2) the directory ../images
    3) the directory ./images
    
    (this is done by LoadImage)



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
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;

public class ImageLabel extends JLabel {


    public ImageLabel() {

    }

    public ImageLabel(String text,String image, String toolTip) {
 
	if ( image != null ) {
	    try {
                ImageIcon img = getImageIcon(image);
		this.setIcon(img);
	    } catch (Exception e) {
		//System.out.println("Can not load Image " + image);
	    }
	}
	if (text != null ) this.setText(text);
	if (toolTip != null ) this.setToolTipText(toolTip);
 
    }


    public String getInfo() {


	return "This is a ImageLabel\n" +
               "done for Fredy's Java-things\n" +
	       "parameters are: text-on-label,image,toolTip-Text\n" +
	       "it loads Images either from the device.images\n" +
	       "where it resides or from the property given over by \n" +
	       "-D image=<path-to-images>";


    }

    public ImageIcon getImageIcon(String image) {

	ImageIcon img = null;

	if ( image != null ) {
	    LoadImage li = new LoadImage(image);
            img = li.getImage();
	}
	return img;

    }


    public static void main(String args[]) {

	System.out.println("Fredy's ImageLabel\n" +
			   "is based on JLabel \n" +
			   "use it as follows: java -D admin.image=<path-to-images> gpl.fredy.ui.ImageLabel <text> <image> <tooltip>\n");
	if (args.length != 3 ) System.exit(0);
	JFrame frame = new JFrame("TEST");
	ImageButton imgB = new ImageButton(args[0],args[1],args[2]);
	frame.getContentPane().add(imgB);
	frame.pack();
	frame.setVisible(true);
	frame.addWindowListener(new WindowAdapter() {
	    public void windowActivated(WindowEvent e) {}
	    public void windowClosed(WindowEvent e) {}
	    public void windowClosing(WindowEvent e) {System.exit(0);}
	    public void windowDeactivated(WindowEvent e) {}
	    public void windowDeiconified(WindowEvent e) {}
	    public void windowIconified(WindowEvent e) {}
	    public void windowOpened(WindowEvent e) {}});
	
    }


}
