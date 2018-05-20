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
import java.beans.*;
import java.util.*;
import javax.swing.*;
import javax.swing.BorderFactory; 
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.datatransfer.*;

public class PopUpMessage  {

    public JFrame frame;
    public JTextArea text;
    
    /**
       * Get the value of text.
       * @return Value of text.
       */
    public String getText() {return text.getText();}
    
    /**
       * Set the value of text.
       * @param v  Value to assign to text.
       */
    public void setText(String  v) {this.text.setText(v);}
    

    public PopUpMessage(String m) {

	frame = new JFrame("PopUp-Message!");
	text = new JTextArea(10,20);
	text.setLineWrap(true);
	text.setFont(new Font("Monospaced", Font.PLAIN, 12));
	text.setEditable(false);
	setText(m);


	JScrollPane scp = new JScrollPane(text);
	frame.getContentPane().add(scp);
	frame.pack();
	frame.setVisible(true);

	frame.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {frame.dispose();}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});
	

    }
}
