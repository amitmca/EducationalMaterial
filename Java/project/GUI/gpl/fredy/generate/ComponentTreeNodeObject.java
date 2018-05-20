package gpl.fredy.generate;

/** ComponentTreeNodeObject
 *  represents the Component for the XMLEditor
 *  it contains the following Info:
 *  - ComponentName
 *  - Java Type
 *  - FieldType
 *  - FieldTypeParameters
 *  - LabelConstraints
 *  - GridBagConstraints
 **/

/** FieldTypeParameters
 *  this delivers parameters for all possible fields
 *  - label
 *  - length
 *  - text
 *  - filter
 *  - titled
 *  - title
 *  - layout (0,1,2)
 *  - rows
 *  - cols
 *  - linewrap
 *  - query


/** XMLEditor edits the XML-file used for Generate Code
 *  and is a part of Admin...
 *  Version 1.0  23. March 2002
 *  Fredy Fischer 
 *
 **/


/**  * Admin is a Tool around JDBC-enabled SQL-Databases to do basic jobs
 * for DB-Administrations, as create / delete / alter and query tables
 * it also creates indices and generates simple Java-Code to access DBMS-tables
 * and exports data into various formats
 *
 *
 *   Copyright (C) August 9, 2003, Fredy Fischer
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


public class ComponentTreeNodeObject {

    
    String name;
    
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
   

    
    String type;
    
    /**
       * Get the value of type.
       * @return value of type.
       */
    public String getType() {return type;}
    
    /**
       * Set the value of type.
       * @param v  Value to assign to type.
       */
    public void setType(String  v) {this.type = v;}
    

    GridBagObject gbc;
    
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
        
    GridBagObject labelGbc;
    
    /**
       * Get the value of labelGbc.
       * @return value of labelGbc.
       */
    public GridBagObject getLabelGbc() {
	return labelGbc;
    }
    
    /**
       * Set the value of labelGbc.
       * @param v  Value to assign to labelGbc.
       */
    public void setLabelGbc(GridBagObject  v) {this.labelGbc = v;}
    
 
    
    String guiType;
    
    /**
       * Get the value of guiType.
       * @return value of guiType.
       */
    public String getGuiType() {return guiType;}
    
    /**
       * Set the value of guiType.
       * @param v  Value to assign to guiType.
       */
    public void setGuiType(String  v) {this.guiType = v;}
    
   
    
    FieldTypeParameters parameter;
    
    /**
       * Get the value of parameter.
       * @return value of parameter.
       */
    public FieldTypeParameters getParameter() {return parameter;}
    
    /**
       * Set the value of parameter.
       * @param v  Value to assign to parameter.
       */
    public void setParameter(FieldTypeParameters  v) {this.parameter = v;}
    


    Element elt= new Element("component",getNs());
    
    /**
       * Get the value of elt.
       * @return value of elt.
       */
    public Element getElt() {
	elt = new Element("component",getNs());

	elt.setAttribute("name",getName());
	elt.setAttribute("type",getType());
	//elt.setAttribute("fieldType",parameter.getType());
	elt.setAttribute("fieldType",getGuiType());

	// LabelConstraints
	Element label = new Element("labelConstraints",getNs());
	labelGbc.setName("labelConstraints");
	label.addContent((Element)getLabelGbc().getElt());
	elt.addContent((Element)getLabelGbc().getElt());

	// Parameters
	elt.addContent((Element)parameter.getElt());

	// the GridBagConstraints
	elt.addContent((Element)getGbc().getElt());

	return elt;

    }
    
    /**
       * Set the value of elt.
       * @param v  Value to assign to elt.
       */
    public void setElt(Element v) {
	this.elt = v;
	setName((String)elt.getAttributeValue("name"));
        setType((String)elt.getAttributeValue("type"));
        setGuiType((String)elt.getAttributeValue("fieldType"));

	Element label = v.getChild("labelConstraints",getNs());
	GridBagObject go = new GridBagObject((Element)label);
	go.setName("labelConstraints");
        setLabelGbc(go);

	FieldTypeParameters pm = new FieldTypeParameters(getGuiType(),
							 getType(),
							 (Element) v.getChild("parameter",getNs()));
	setParameter(pm);

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
        
    public ComponentTreeNodeObject(Element v) {
	this.setElt(v);
    }
    public ComponentTreeNodeObject() {
    }

}
