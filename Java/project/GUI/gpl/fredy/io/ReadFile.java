package gpl.fredy.io;

/**
   ReadFile reads a file (only for those who did not realize it)
   
   Created by:  Fredy Fischer
   Date      :  05. Dec. 2001
   Version   :  1.0
                1.1 14. Sept. 2002, added JFileChooser and FileFilter 



   Constructors:

   ReadFile()
        this is just to instantiate it, so you can then set a Filer
       ReadFile.setFilter(new String[]{ "xml", "XML"});
	and then you can ReadFile let display the filechooser:
       ReadFile.setFileName("?");
        and finally get the filecontent as text:
       ReadFile.getText();


   ReadFile(String fileName)
       instantiate it and get the content as text:
       ReadFile.getText();

 
                 
   this tool is part of the Admin-Suite

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
             

import java.io.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.text.*;


public class ReadFile {


    private String text;
    private Vector v;


    String fileName;
    
    /**
     * Get the value of fileName.
     * @return value of fileName.
     */
    public String getFileName() {
	return fileName;
    }
    
    /**
     * Set the value of fileName.
     * @param v  Value to assign to fileName.
     */
    public void setFileName(String  v) {
	if (v != "?" ) {
	    this.fileName = v;
	} else {
	    selectFile();
	}
	    
    }
    
    public void selectFile() {	
	JFileChooser chooser = new JFileChooser();
	chooser.setDialogType(JFileChooser.OPEN_DIALOG);
	chooser.setDialogTitle("Open File");
	if (getFilter() != null) chooser.setFileFilter(getFilter());

	chooser.setVisible(true);
	int returnVal = chooser.showOpenDialog(null);
	if(returnVal == JFileChooser.APPROVE_OPTION) {
	    setFileName(chooser.getSelectedFile().getParent()
			+ File.separator +
			chooser.getSelectedFile().getName());
	} else { setFileName(null); }
	readIt();
    }   

    MyFileFilter filter = null;
    
    /**
     * Get the value of filter.
     * @return value of filter.
     */
    public MyFileFilter getFilter() {
	return filter;
    }
    
    /**
     * Set the Filefilter 
     * @param extensions are the desired File-extensions
     * @param description the description of the filter
     */
    public void setFilter(String f[]) {
	filter = new MyFileFilter(f);
    }
    




    public Vector getLines() { return v;}

    
    /**
       * Get the value of text.
       * @return Value of text.
       */
    public String getText() {return text;}
    
    /**
       * Set the value of text.
       * @param v  Value to assign to text.
       */
    public void setText(String  v) {this.text = v;}
    
    public ReadFile() {
    }

    public ReadFile (String fileName) {

	setFileName(fileName);
	readIt();

    }
    public void readIt() {
	if (getFileName() != null ){
	    text="";
	    v = new Vector();
	    String s;
	    
	    // open the file and read it in
	    try
		{
		    DataInputStream ipstr = new DataInputStream(
					    new BufferedInputStream(
				      	    new FileInputStream(getFileName())));
		    
		    BufferedReader bufrd = new BufferedReader(
							      new InputStreamReader(ipstr));
		    while ((s = bufrd.readLine()) != null) {
			text = text + s + "\n";
			v.addElement(s);
		    }				
		    ipstr.close();
		} catch(IOException exep) {
		    System.out.println("IO Error for " + fileName);
		}
	}
    }


    

    public static void main(String args[]) {

	if (args.length != 1) {
	    System.out.println("Syntax: java file");
	    System.exit(0);
	}
	ReadFile rf = new ReadFile(args[0]);
        System.out.println(rf.getText());
    }
}
