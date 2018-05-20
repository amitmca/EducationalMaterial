package gpl.fredy.generate;
/**
 * This interpretes the XML-File generated and modified by Admin
 */

/*
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

 */
import java.io.*;
import java.util.List;
import java.util.Iterator;
import java.util.Calendar;
import java.util.StringTokenizer;
import gpl.fredy.metadata.*;
import gpl.fredy.share.*;
import gpl.fredy.io.*;
import gpl.fredy.ui.*;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.input.DOMBuilder;
import org.jdom.Namespace;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.*;

import gpl.fredy.share.*;
import gpl.fredy.ui.*;
//import applications.basics.*;

public class FormInterpreter extends JFrame {

    private JTabbedPane tabbedPane;
    boolean secondTime = false;

    private Document doc;

    public void setDocument(Document doc) {
	this.doc = doc;
	init();
    }

    private Namespace ns;
    
    String primaryKeys;
    public void setPrimaryKeys(String v) { primaryKeys = v; }
    public String getPrimaryKeys() { return primaryKeys; }

    
    private String firstUpper(String s) {
	s = s.substring(0,1).toUpperCase() + s.substring(1);
	return s;
    }
    
    
    private String toDay() {
	
	Calendar c = Calendar.getInstance();
	
	return  Integer.toString(c.get(Calendar.YEAR)) + "-" +
	    Integer.toString(c.get(Calendar.MONTH)+1)+ "-" +
	    Integer.toString(c.get(Calendar.DATE));
	
    }
    
    String host;
    
    /**
       * Get the value of host.
       * @return Value of host.
       */
    public String getHost() {return host;}

    /**
       * Set the value of host.
       * @param v  Value to assign to host.
       */
    public void setHost(String  v) {this.host = v;}

    String user;

    /**
       * Get the value of user.
       * @return Value of user.
       */
    public String getUser() {return user;}

    /**
       * Set the value of user.
       * @param v  Value to assign to user.
       */
    public void setUser(String  v) {this.user = v;}

    String password;

    /**
       * Get the value of password.
       * @return Value of password.
       */
    public String getPassword() {return password;}

    /**
       * Set the value of password.
       * @param v  Value to assign to password.
       */
    public void setPassword(String  v) {this.password = v;}

    String database;

    /**
       * Get the value of database.
       * @return Value of database.
       */
    public String getDatabase() {return database;}

    /**
       * Set the value of database.
       * @param v  Value to assign to database.
       */
    public void setDatabase(String  v) {this.database = v;}

    String table;

    /**
       * Get the value of table.
       * @return Value of table.
       */
    public String getTable() {return table;}

    /**
       * Set the value of table.
       * @param v  Value to assign to table.
       */
    public void setTable(String  v) {this.table = v;}



  public FormInterpreter(String host, 
			 String user, 
			 String password, 
			 String file) {

	  super("XML-Form-Interpreter");

	  this.setHost(host);
	  this.setUser(user);
	  this.setPassword(password);



	  try {
	      SAXBuilder builder = new SAXBuilder();	      
	      doc     = builder.build(new File(file));
	      
	  } catch (JDOMException e) {
	      e.printStackTrace();
	  }
	  init();
  }


    public FormInterpreter(String host, 
			   String user, 
			   String password,
			   Document doc) {
	  super("XML-Form-Interpreter");

	  this.setHost(host);
	  this.setUser(user);
	  this.setPassword(password);

	  this.doc = doc;
	  init();
    }


    public FormInterpreter(String host, 
			   String user, 
			   String password) {
	  super("XML-Form-Interpreter");

	  this.setHost(host);
	  this.setUser(user);
	  this.setPassword(password);

    }

    public FormInterpreter() {

    }


    private void init() {

	if (secondTime ) {
	    secondTime = true;
	    this.remove(tabbedPane);	   
	}

	tabbedPane = new JTabbedPane();
	Element database = doc.getRootElement();
	setDatabase(database.getAttributeValue("name"));
	
	List tables = database.getChildren();
	tableTreater(tables);
	this.getContentPane().setLayout(new BorderLayout());
	    
	this.getContentPane().add(BorderLayout.CENTER,tabbedPane);

	//this.setContentPane(tabbedPane);
	this.pack();
	this.setVisible(true);

	secondTime = true;
    }


  private void tableTreater(List tables) {
    Iterator itr = tables.iterator();
    while (itr.hasNext()) {
      Element table = (Element)itr.next();
      setTable(table.getAttributeValue("name"));
      tabbedPane.add(getTable(),new JScrollPane(panelTreater(table.getChildren(),table.getNamespace())));
    }
  }

  private JPanel panelTreater(List panels, Namespace ns) {

    JPanel masterPanel = new JPanel();
    masterPanel.setLayout(new GridBagLayout());
    Iterator itr = panels.iterator();
    while (itr.hasNext()) {
      Element panel = (Element)itr.next();
      GridBagConstraints gbc  = new GridBagConstraints();
      gbc = gridBagTreater(panel.getChild("gridBagConstraints",ns));
      JPanel aPanel = new JPanel();
      aPanel.setLayout(new GridBagLayout());

      // the Border-Thing
      String border = panel.getChildText("border",ns);
      aPanel.setBorder(getTheBorder( panel.getChildText("border",ns) ,  panel.getChildText("title",ns)));
      

      aPanel = componentTreater(panel.getChildren("component",ns),ns, aPanel);
      // treat borders here
      masterPanel.add(aPanel,gbc);
    }

    return masterPanel;
  }

 
    private Border getTheBorder(String s,String t) {
	  Border border = new EtchedBorder();
	  if (s.startsWith("EtchedBorder") )  
	      border = new TitledBorder(new EtchedBorder(),t);
          if (s.startsWith("BevelBorder(BevelBorder.RAISED)") )
	     border = new TitledBorder(new BevelBorder(BevelBorder.RAISED),t);
          if (s.startsWith("BevelBorder(BevelBorder.LOWERED)") )
	     border = new TitledBorder(new BevelBorder(BevelBorder.LOWERED),t);
	  if (s.startsWith("thin"        ) )
	      border = new TitledBorder(new LineBorder(Color.black,1),t);
	  if (s.startsWith("medium"      ) )
	      border = new TitledBorder(new LineBorder(Color.black,2),t);
	  if (s.startsWith("thick"       ) ) 
	      border = new TitledBorder(new LineBorder(Color.black,3),t);
	  if (s.startsWith("Empty"       ) ) 
	      border = new EmptyBorder(1,1,1,1);
      
	  return border;
    }


  private JPanel componentTreater(List components,Namespace ns,JPanel panel) {

    Iterator itr = components.iterator();
    while (itr.hasNext()) {

      Element component = (Element)itr.next();

      Element parameter=component.getChild("parameter",ns);
      panel = labelTreater((Element)component.getChild("labelConstraints",ns),parameter.getAttributeValue("label"),panel);

      GridBagConstraints gbc = new GridBagConstraints();

      gbc = gridBagTreater(component.getChild("gridBagConstraints",ns));

      if ( component.getAttributeValue("fieldType").equals("FieldPanel"))
	  panel = fieldPanel(parameter,component.getAttributeValue("name"),panel,gbc);

      if ( component.getAttributeValue("fieldType").equals("AreaPanel") )
	  panel = areaPanel(parameter,component.getAttributeValue("name"),panel,gbc);

      if ( component.getAttributeValue("fieldType").equals("DBcomboBoxPanel") )
	  panel = dBcomboBoxPanel(parameter,component.getAttributeValue("name"),panel,gbc);

      if ( component.getAttributeValue("fieldType").equals("TwinBoxPanel") )
	  panel = twinBoxPanel(parameter,component.getAttributeValue("name"),panel,gbc);

      if ( component.getAttributeValue("fieldType").equals("DateFieldPanel") )
	  panel = dateFieldPanel(parameter,component.getAttributeValue("name"),panel,gbc);

      if ( component.getAttributeValue("fieldType").equals("DateButtonPanel") )
	  panel = dateButtonPanel(parameter,component.getAttributeValue("name"),panel,gbc);
	}
	  return panel;

  }


    private JPanel labelTreater(Element l,String text,JPanel panel) {
      if ( l == null ) text = null;
	if ( text != null) {
		panel.add(new JLabel(text),gridBagTreater(l));
	}
	return panel;
    }



      private JPanel fieldPanel(Element parameter,String name,JPanel panel,GridBagConstraints gbc) {

        int    l = Integer.parseInt(parameter.getAttributeValue("length"));
 	    String s = parameter.getAttributeValue("text");

 	    String f = parameter.getAttributeValue("filter");

 	    boolean titled = false;
 	    if ( parameter.getAttributeValue("titled") == "true" ) titled = true;

 	    String t = parameter.getAttributeValue("title");
	    Integer la = new Integer(parameter.getAttributeValue("layout"));

 	    panel.add(new FieldPanel(null,l,s,f,titled,t,la.intValue()),gbc);

        return panel;

      }

      private JPanel areaPanel(Element parameter, String name,JPanel panel, GridBagConstraints gbc) {

      	int rows = Integer.parseInt(parameter.getAttributeValue("rows") );
      	int cols = Integer.parseInt(parameter.getAttributeValue("cols") );
	  	boolean lineWrap = false;
	  	if ( parameter.getAttributeValue("lineWrap")  == "true" ) lineWrap = true;
	  	String text = parameter.getAttributeValue("text");
	  	boolean titled = false;
	  	if (parameter.getAttributeValue("titled") == "true") titled = true;
	  	String title = parameter.getAttributeValue("title");
	  	int layout = Integer.parseInt(parameter.getAttributeValue("layout"));

	  	panel.add(new AreaPanel(null,rows,cols,lineWrap,text,titled,title,layout),gbc);
	  	return panel;

      }

    private JPanel dBcomboBoxPanel(Element parameter, String name,JPanel panel, GridBagConstraints gbc) {

		String query = parameter.getAttributeValue("query") ;
			String label = parameter.getAttributeValue("label") ;
			String text  = parameter.getAttributeValue("text")  ;
			String title = parameter.getAttributeValue("title") ;

	  		boolean titled = false;
		    if (parameter.getAttributeValue("titled") == "true") titled = true;
	     	int layout = Integer.parseInt(parameter.getAttributeValue("layout"));

		    panel.add(new DBcomboBoxPanel(getHost(),getUser(),getPassword(),getDatabase(),query,null,text,titled,title,layout),gbc);
        return panel;
    }

    private JPanel twinBoxPanel(Element parameter, String name, JPanel panel, GridBagConstraints gbc) {

		String query = parameter.getAttributeValue("query") ;
		String label = parameter.getAttributeValue("label") ;
		String text  = parameter.getAttributeValue("text")  ;
		String title = parameter.getAttributeValue("title") ;

  		boolean titled = false;
	    if (parameter.getAttributeValue("titled") == "true") titled = true;
     	int layout = Integer.parseInt(parameter.getAttributeValue("layout"));

	    panel.add(new TwinBoxPanel(getHost(),getUser(),getPassword(),getDatabase(),query,null,text,titled,title,layout),gbc);
        return panel;
    }



    private JPanel dateFieldPanel(Element parameter, String name, JPanel panel, GridBagConstraints gbc) {

		String label = parameter.getAttributeValue("label") ;
		String text  = parameter.getAttributeValue("text")  ;
		String title = parameter.getAttributeValue("title") ;

  		boolean titled = false;
	    if (parameter.getAttributeValue("titled") == "true") titled = true;
     	int layout = Integer.parseInt(parameter.getAttributeValue("layout"));

     	panel.add(new DateFieldPanel(null,text,titled,title,layout),gbc);
     	return panel;

    }

    private JPanel dateButtonPanel(Element parameter, String name, JPanel panel, GridBagConstraints gbc) {

		String label = parameter.getAttributeValue("label") ;
		String text  = parameter.getAttributeValue("text")  ;
		String title = parameter.getAttributeValue("title") ;

  		boolean titled = false;
	    if (parameter.getAttributeValue("titled") == "true") titled = true;
     	int layout = Integer.parseInt(parameter.getAttributeValue("layout"));

     	panel.add(new gpl.fredy.ui.DateButtonPanel(null,text,titled,title,layout),gbc);
     	return panel;
    }



  private GridBagConstraints gridBagTreater(Element g) {
	GridBagConstraints gbc = new GridBagConstraints();

    if ( g != null) {

	   StringTokenizer st = new StringTokenizer(g.getAttributeValue("insets"),",");
	   gbc.insets = new Insets(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

	   int anchor = GridBagConstraints.CENTER;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.NORTH" )     )   anchor = GridBagConstraints.NORTH;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.SOUTH" )     )   anchor = GridBagConstraints.SOUTH;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.WEST" )      )   anchor = GridBagConstraints.WEST;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.EAST" )      )   anchor = GridBagConstraints.EAST;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.NORTHWEST" ) )   anchor = GridBagConstraints.NORTHWEST;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.NORTHEAST" ) )   anchor = GridBagConstraints.NORTHEAST;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.SOUTHWEST" ) )   anchor = GridBagConstraints.SOUTHWEST;
	   if ( g.getAttributeValue("anchor").startsWith("GridBagConstraints.SOUTHEAST" ) )   anchor = GridBagConstraints.SOUTHEAST;

	   gbc.anchor    = anchor;
	   int fill      = GridBagConstraints.NONE;

	   if ( g.getAttributeValue("fill") == "GridBagConstraints.HORIZONTAL" ) fill = GridBagConstraints.HORIZONTAL;
	   if ( g.getAttributeValue("fill") == "GridBagConstraints.VERTICAL" )   fill = GridBagConstraints.VERTICAL;
	   if ( g.getAttributeValue("fill") == "GridBagConstraints.BOTH" )       fill = GridBagConstraints.BOTH;

	   gbc.fill = fill;

	   gbc.weightx    = Double.valueOf(g.getAttributeValue("weightx")).doubleValue();
	   gbc.weighty    = Double.valueOf(g.getAttributeValue("weighty")).doubleValue();
	   gbc.gridheight = Integer.parseInt(g.getAttributeValue("gridheight"));
	   gbc.gridwidth  = Integer.parseInt(g.getAttributeValue("gridwidth"));
	   gbc.gridx      = Integer.parseInt(g.getAttributeValue("gridx"));
	   gbc.gridy      = Integer.parseInt(g.getAttributeValue("gridy"));


    }
    return gbc;
  }



  public static void main(String args[]) {
    String uri="";

    boolean help = false;
    String host = "localhost";
    String user = System.getProperty("user.name");
    String password = "";


    if ( args.length < 2) {
	help = true;
    }  else {


	int i = 0;

	while ( i < args.length) {
	    if ((args[i].equals("-help") ) || (args[i].equals("--h")) ) {
		help=true;
	    }

	    if ((args[i].equals("-f") ) || (args[i].equals("-file")) ) {
		i++;
		uri=args[i];
	    }
	    if ((args[i].equals("-h") ) || (args[i].equals("-host")) ) {
		i++;
		host=args[i];
	    }

	    if ((args[i].equals("-u") ) || (args[i].equals("-user")) ) {
		i++;
		user=args[i];
	    }

	    if ((args[i].equals("-p") ) || (args[i].equals("-password")) ) {
		i++;
		password=args[i];
	    }
	    i++;
	}
    }

    if ( help ) {
	System.out.println("\nFredy's Form Interpreter\n" +
			   "------------------------\n" +
			   "Interprets the forms out of a XML file containing the DB-description\n" +
			   "Syntax: FormInterpreter -help this screen\n" +
			   "                     -f    the XML-file to use\n" +
			   "                     -h    host\n" +
			   "                     -u    user\n" +
			   "                     -p    password\n");

	System.exit(0);
    }
    FormInterpreter f = new FormInterpreter(host,user,password,uri);
    f.addWindowListener(new WindowAdapter() {
		public void windowActivated(WindowEvent e) {}
		public void windowClosed(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {System.exit(0);}
		public void windowDeactivated(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowOpened(WindowEvent e) {}});



  }
}
