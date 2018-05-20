package applications.basics;

/**

  ...Reads a file and it's content can be retrieved by getText()
     or a Vector containing every single line by getLines()

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
import java.util.Vector;


public class ReadFile {


    private String text;
    private Vector v;


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
    

    public ReadFile (String fileName) {
        text="";
	v = new Vector();
	String s;

	// open the file and read it in
	try
	{
	    DataInputStream ipstr = new DataInputStream(
					new BufferedInputStream(
					new FileInputStream(fileName)));

	    BufferedReader bufrd = new BufferedReader(
				   new InputStreamReader(ipstr));
	    while ((s = bufrd.readLine()) != null) {
		text = text + s + "\n";
		v.addElement(s);
	    }				
	    ipstr.close();
	} catch(IOException exep) {
	    System.out.println("IO Fehler");
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
