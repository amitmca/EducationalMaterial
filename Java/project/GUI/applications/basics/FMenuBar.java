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

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class FMenuBar extends JMenuBar {


    public ImageMenuItem insert, update, delete, clear, cancel, search;


    public FMenuBar() {

	insert   = new ImageMenuItem("Insert","insert.gif","Inserts a new row");
	update   = new ImageMenuItem("Update","update.gif","Update existing row");
	delete   = new ImageMenuItem("Delete","delete.gif","removes this row");
	clear    = new ImageMenuItem("Clear","clear.gif","clear the fields");
	cancel   = new ImageMenuItem("Cancel","exit.gif","leave...");
	search   = new ImageMenuItem("Search","search.gif","search");

	ImageMenu  fileMenu = new ImageMenu("File","open.gif",null);
	ImageMenu  editMenu = new ImageMenu("Edit","edit.gif",null);	
	
	fileMenu.add(cancel);
	editMenu.add(insert);
	editMenu.add(update);
	editMenu.add(new JSeparator());	
	editMenu.add(clear);
	editMenu.add(search);

	this.add(fileMenu);
	this.add(editMenu);

    }
}
