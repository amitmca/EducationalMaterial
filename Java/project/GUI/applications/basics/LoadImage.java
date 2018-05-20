package applications.basics;


/** 

    LoadImage is a part of Admin

    It tries to open a Image as a Icon from different locations:
    1) the directory given over with -Dadmin.image=[DIRECTORY]
    2) the directory ../images
    3) the directory ./images


    Admin is a Tool around mySQL to do basic jobs
    for DB-Administrations, like:
    - create/ drop tables
    - create  indices
    - perform sql-statements
    - simple form
    - a guided query
    and a other usefull things in DB-arena

    Admin Version see below
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


import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import java.net.*;
import java.awt.Toolkit;
import java.awt.Image;

import javax.swing.*;


public class LoadImage {

    private File file=null;

    String image=null;
    public void setImage(String v) {
	this.image = v;
    }
    
    public LoadImage() {
	image =null;
    }
    
    public LoadImage(String image) {
	this.setImage(image);
    }

    // Debug
   
    private void addImage(ImageIcon i) {
	JFrame frame = new JFrame(i.toString()); 
	frame.getContentPane().add(new JLabel(i));
	frame.pack();
	frame.setVisible(true);
    }


    public ImageIcon getImage() {
	String admin_img = System.getProperty("admin.image");

        /**
	 *  we try to find the image a three places:
	 *  1) at the location defined by the System-Property admin.image
	 *  2) at the directory ../images
	 *  3) at the directory ./images
	 *  
	 *  new for this Version is the use of a URL, so images can be
	 *  loaded over the net
	 **/

	String url1   = System.getProperty("admin.image") + File.separator + image;

	// did the user deliver a correct URL?
	if ( System.getProperty("admin.image") != null ) {
	    if (  ! isImageLoadable(url1) ) {
		try {
		    File f = new File(url1);
		    if ( f.exists() ) {
			url1 = f.toURL().toString();
		    } 
		} catch (Exception ioException ) { url1 = null ; }
	    }
	}



	String url2=null, url3=null;

        if ( System.getProperty("admin.image") == null ) {
	    try {
		url2   = LoadImage.class.getResource(".."
			+ File.separator + "images"
		        + File.separator + image).toString();

		url3   = LoadImage.class.getResource(
		          File.separator + "images" 
		        + File.separator + image).toString();
	    } catch (NullPointerException npe) {
		// not found
	    }
	}

	String url = null;

	// now we go the order and find out, if the image exists
	if ( isImageLoadable( url1 ) ) {
	    url = url1;
	} else {
	    if ( isImageLoadable( url2 )) {
		url = url2 ;
	    } else {
		if ( isImageLoadable( url3 )) {
		    url = url3; 
		}		
	    }
	}

	if (  url != null ) {
            
	    try {
		URL u = new URL(url);
		ImageIcon img = new ImageIcon(u);
		//addImage(img);
		return img;
	    } catch (Exception ecp1) { 
		ecp1.printStackTrace(); 
	    }

	}
	return null;        
    }

    private boolean isImageLoadable(String u) {
	boolean loadable=true;
        try {
	    URL url        = new URL(u);
            InputStream is = url.openStream();
	} catch ( MalformedURLException mfue ) {
            loadable= false;
	} catch ( IOException ioex ) {
	    loadable = false;
	}

	return loadable;
    }
}
