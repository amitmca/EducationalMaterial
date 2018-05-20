package gpl.fredy.generate;

/** PanelTreeNodeObject
 *  represents the Panel for the XMLEditor
 *  it contains the following Info:
 *  - PanelName
 *  - Title
 *  - Border
 *  - GridBagConstraints
 **/




/** XMLEditor edits the XML-file used for Generate Code
 *  and is a part of Admin...
 *  Version 1.0  23. March 2002
 *  Fredy Fischer 
 *
 * 
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


import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import org.jdom.Namespace;


public class PanelTreeNodeObject {


    
    String name="";
    
    /**
       * Get the value of name.
       * @return value of name.
       */
    public String getName() {return name;}
    
    /**
       * Set the value of name.
       * @param v  Value to assign to name.
       */
    public void setName(String  v) {this.name = v;}
    

    
    String title="";
    
    /**
       * Get the value of title.
       * @return value of title.
       */
    public String getTitle() {return title;}
    
    /**
       * Set the value of title.
       * @param v  Value to assign to title.
       */
    public void setTitle(String  v) {this.title = v;}
    

    
    String border="EtchedBorder()";
    
    /**
       * Get the value of border.
       * @return value of border.
       */
    public String getBorder() {return border;}
    
    /**
       * Set the value of border.
       * @param v  Value to assign to border.
       */
    public void setBorder(String  v) {this.border = v;}
    

    
    GridBagObject gbc = new GridBagObject() ;
    
    /**
       * Get the value of gbc.
       * @return value of gbc.
       */
    public GridBagObject getGbc() {return gbc;}
    
    /**
       * Set the value of gbc.
       * @param v  Value to assign to gbc.
       */
    public void setGbc(GridBagObject  v) {this.gbc = v;}
    

    Element elt= new Element("panel",getNs());
    
    /**
       * Get the value of elt.
       * @return value of elt.
       */
    public Element getElt() {
	elt = new Element("panel",getNs());
	elt.setAttribute("name",getName());

	// the GridBagConstraints
	elt.addContent((Element)getGbc().getElt());

	// the Border
	Element bElt = new Element("border",getNs());
	bElt.addContent(getBorder());
	elt.addContent(bElt);

	// the Title
	Element tElt = new Element("title",getNs());
	tElt.addContent(getTitle());
	elt.addContent(tElt);

	return elt;

    }
    
    /**
       * Set the value of elt.
       * @param v  Value to assign to elt.
       */
    public void setElt(Element  v) {
	this.elt = v;
	setName((String)elt.getAttributeValue("name"));
        setTitle(v.getChildText("title",ns));
	setBorder(v.getChildText("border",ns));
	setGbc(new GridBagObject((Element)v.getChild("gridBagConstraints",getNs())));

    }


    Namespace ns = Namespace.getNamespace("admin","Fredys-Admintool");
    
    /**
       * Get the value of ns.
       * @return value of ns.
       */
    public Namespace getNs() {return ns;}
    
    /**
       * Set the value of ns.
       * @param v  Value to assign to ns.
       */
    public void setNs(Namespace  v) {this.ns = v;}
        

    public PanelTreeNodeObject(Element e) {
	this.setElt(e);
    }

    public PanelTreeNodeObject(Element e, Namespace n) {
	this.setNs(n);
	this.setElt(e);
    }

    public PanelTreeNodeObject() {
	setName("newPanel");
	GridBagObject g = new GridBagObject();
	setGbc(g);
	setBorder("EtchedBorder()");
	setTitle("");
    }

    public PanelTreeNodeObject(String n) {
	setName(n);
	GridBagObject g = new GridBagObject();
	setGbc(g);
	setBorder("EtchedBorder()");
	setTitle("");  
    }
}
