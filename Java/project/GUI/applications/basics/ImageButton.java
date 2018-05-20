package applications.basics;

/**

   ImageButton creates a Button containing an Image
   The Image is grayed out and gets full color if the mouse points
   onto it.

   ImageButton button = new ImageButton(String Text,
                                        String image-file-Name,
					String toolTipText)

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

public class ImageButton extends JButton {


    public ImageButton() {

    }

public ImageButton(String text, String image, String toolTip) {
 
	if ( image != null ) {
	    try {
                ImageIcon img = getImageIcon(image);
		this.setIcon(grayed(img.getImage()));
		this.setRolloverIcon(img);
		this.setRolloverEnabled(true);
	    } catch (Exception e) { 
		//System.out.println("Can not load Image " + image);
	    }
	}
	if (text != null ) this.setText(text);
	if (toolTip != null ) this.setToolTipText(toolTip);
 
}


    public String getInfo() {


	return "This is a ImageButton\n" +
               "done for Fredy's Java-things\n" +
	       "parameters are: text-on-button,image,toolTip-Text\n" +
	       "it loads Images either from the device.images\n" +
	       "where it resides or from the property given over by \n" +
	       "-D image=<path-to-images>";


    }

    public ImageIcon getImageIcon(String image) {

	ImageIcon img = new ImageIcon();

	if ( image != null ) {
	    LoadImage li = new LoadImage(image);
            img = li.getImage();
	}
	return img;

    }

   
 


    public ImageIcon grayed(Image orig) {
	ImageFilter filter = new GrayFilter();
	ImageProducer producer = new FilteredImageSource(orig.getSource(), filter);
	ImageIcon imgIcon = new ImageIcon( createImage(producer) ) ;
	return imgIcon;
    }
    

    public static void main(String args[]) {

	System.out.println("Fredy's ImageButton\n" +
			   "is based on JButton and does a Rollover-Image\n" +
			   "use it as follows: java -D admin.image=<path-to-images> gpl.fredy.ui.ImageButton <text> <image> <tooltip>\n");
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

class GrayFilter extends RGBImageFilter {
    public GrayFilter() { canFilterIndexColorModel = true; }
    public int filterRGB(int x, int y, int rgb) {
	int a = rgb & 0xff000000;
	int r = (((rgb & 0xff0000) + 0x1800000)/3) & 0xff0000;
	int g = (((rgb & 0x00ff00) + 0x018000)/3) & 0x00ff00;
	int b = (((rgb & 0x0000ff) + 0x000180)/3) & 0x0000ff;
	return a | r | g | b;
    }
}
