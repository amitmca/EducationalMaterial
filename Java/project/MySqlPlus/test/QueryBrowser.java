import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;


class UndoableTextArea extends JTextArea implements UndoableEditListener, FocusListener,
    KeyListener {
  private UndoManager m_undoManager;

  public UndoableTextArea() {
    this(new String());
  }

  public UndoableTextArea(String text) {
    super(text);
    getDocument().addUndoableEditListener(this);
    this.addKeyListener(this);
    this.addFocusListener(this);
  }

  private void createUndoMananger() {
    m_undoManager = new UndoManager();
    m_undoManager.setLimit(10);
  }

  private void removeUndoMananger() {
    m_undoManager.end();
  }

  public void focusGained(FocusEvent fe) {
    createUndoMananger();
  }

  public void focusLost(FocusEvent fe) {
    removeUndoMananger();
  }

  public void undoableEditHappened(UndoableEditEvent e) {
    m_undoManager.addEdit(e.getEdit());
  }

  public void keyPressed(KeyEvent e) {
    if ((e.getKeyCode() == KeyEvent.VK_Z) && (e.isControlDown())) {
      try {
        m_undoManager.undo();
      } catch (CannotUndoException cue) {
        Toolkit.getDefaultToolkit().beep();
      }
    }

    if ((e.getKeyCode() == KeyEvent.VK_Y) && (e.isControlDown())) {
      try {
        m_undoManager.redo();
      } catch (CannotRedoException cue) {
        Toolkit.getDefaultToolkit().beep();
      }
    }
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
  }
}


public class QueryBrowser extends JInternalFrame implements ActionListener
 {
public static Login l;
public static String u=l.u;
public static String p=l.pass;	
    public static UndoableTextArea query = new UndoableTextArea();

    public static JScrollPane sp_query;
    JLabel limage;
    JLabel limage1;
    public static JTextArea result;
    JScrollPane sp_result;
    JButton btnclr;
    JButton btnexe;
    JButton btncel;
    ImageIcon i=new ImageIcon("images/b_selboard.png");
    String sub="",sub1="",sub2="",sub3="";	
    public static Note n,n1;
    public static Note1 n11,n12;
    
    public QueryBrowser()throws Exception 
	{
	super("Query Browser");
        QueryBrowserLayout customLayout = new QueryBrowserLayout();
	setFrameIcon(i);
	
	setLocation(200,75);

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        n=new Note();
	n.setVisible(true);
	MysqlPlus.desktop.add(n);
	
	n1=new Note();
	n1.setVisible(true);
	MysqlPlus1.desktop.add(n1);

	n11=new Note1();
        n11.setVisible(true);
	MysqlPlus.desktop.add(n11);
	
	n12=new Note1();
	n12.setVisible(true);	
	MysqlPlus1.desktop.add(n12);  

        query = new UndoableTextArea("");
	query.setFont(new Font("verdana", Font.BOLD, 14));
	query.setForeground(Color.red);
        sp_query = new JScrollPane(query);
        getContentPane().add(sp_query);

        limage = new JLabel("Query");
	limage.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(limage);

        limage1 = new JLabel("Result");
	limage1.setFont(new Font("verdana", Font.BOLD, 12));
        getContentPane().add(limage1);

        result = new JTextArea("");
	result.setFont(new Font("verdana", Font.BOLD, 14));
	result.setForeground(Color.blue);
        sp_result = new JScrollPane(result);
        getContentPane().add(sp_result);

        btnclr = new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("images\\def.png")));
	btnclr.setFont(new Font("verdana", Font.BOLD, 12));
	btnclr.addActionListener(this);
        getContentPane().add(btnclr);

        btnexe = new JButton("Execute",new ImageIcon(ClassLoader.getSystemResource("images\\execute1.gif")));
	btnexe.setFont(new Font("verdana", Font.BOLD, 12));
	btnexe.addActionListener(this);
        getContentPane().add(btnexe);

        btncel = new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("images\\cancel.PNG")));
	btncel.setFont(new Font("verdana", Font.BOLD, 12));
	btncel.addActionListener(this);
        getContentPane().add(btncel);

	Color c=new Color(220,180,170);
	getContentPane().setBackground(c);
        setSize(getPreferredSize());
      }
public void actionPerformed(ActionEvent ae)
	{
	
	
	if(ae.getSource()==btncel)
		{
		n.setVisible(false);
		n1.setVisible(false);	
		n11.setVisible(false);
		n12.setVisible(false);		
		this.setVisible(false);
		}

	if(ae.getSource()==btnexe)
		{
		
		if(query.getText().equals(""))
  		  {
		  String str2="Query Cannot Be Empty";
                  JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 			
		  }
		else
		  { 
		  sub=query.getText().substring(0,6); 
		  sub1=query.getText().substring(0,4);	
		  sub2=query.getText().substring(0,14);	
	   	  sub3=query.getText().substring(0,5);	 	

		  if(sub.equals("create") || sub1.equals("drop") )
		  {	
			try
		    	  {
   		      Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
	
		          Statement stmt=conn.createStatement();

		          String sql=query.getSelectedText();

		          int b=stmt.executeUpdate(sql);

			  result.setText(sub + " Successful");
			  }
		     catch(Exception e)
		       { 
		       String str="Error In Query"; 
		       result.setText(str);
		       }
                  }
		  else if(sub2.equals("show databases"))
  		  {
		    try
		    {
   		    Class.forName("com.mysql.jdbc.Driver");
	
  		    String url="jdbc:mysql://localhost:3306/";
					
		    Connection conn=DriverManager.getConnection(url,u,p);
	
		    Statement stmt=conn.createStatement();

		    String sql=query.getSelectedText();

		    ResultSet rs=stmt.executeQuery(sql);	

		    String r="";	

		    while(rs.next())
		      {
		      r=r+rs.getString(1)+"\n";
 	              }	
		    result.setText(r);
		    }		
		    catch(Exception e)
		    { 
		    String str="Error In Query"; 
		    result.setText(str);
		    }		
		  }
		  		
		  else if(sub.equals("select"))
		  {	
		  try
		    {
   		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
	
		    Statement stmt=conn.createStatement();

		    String sql=query.getSelectedText();

		    ResultSet rs=stmt.executeQuery(sql);

		    ResultSetMetaData md = rs.getMetaData();

		    int col = md.getColumnCount();

		    String r="";	
		 
		    
		       while(rs.next())
		        { 
			for(int i=1;i<=col;i++)
		          {	
                          r=r + rs.getString(i)+"\t";
		       	  }  
			 r=r+"\n";
			 result.setText(r);
			} 			
		    }		
		  catch(Exception e)
		    { 
		    String str="Error In Query"; 
		    result.setText(str);
		    }
		
		   }
		else if(sub3=="alter")
		   {
		   try
		    	  {
   		          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
		          Statement stmt=conn.createStatement();

		          String sql=query.getSelectedText();

		          stmt.executeUpdate(sql);

			  result.setText(sub + " Successful");
			  }
		     catch(Exception e)
		       { 
		       String str="Error In Query"; 
		       result.setText(str);
		       }	
                   }	
		else
		    {
		    if(sub.equals("insert") || sub.equals("delete") || sub.equals("update") || sub.equals("rename")) 	
			{
			try
		    	  {
   		          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				
					String url="jdbc:odbc:mysql";
				
					Connection conn=DriverManager.getConnection(url,"root","");
	
		          Statement stmt=conn.createStatement();

		          String sql=query.getSelectedText();

		          stmt.executeUpdate(sql);

			  String print="1 Row "+sub+"ed";

			  JOptionPane.showMessageDialog(null,print,"Result",JOptionPane.INFORMATION_MESSAGE); 				

			  result.setText(sub + " Successful");
			  }
		     catch(Exception e)
		       { 
		       String str="Error In Query"; 
		       result.setText(str);
		       }
		   
		      } 
		    else
			{
			String str="Error In Query"; 
		        result.setText(str);
		        }
		       		
  		    }
		}
 				
		}
	if(ae.getSource()==btnclr)
		{
		if(query.getText().equals("") || result.getText().equals(""))
			{
			String str2="Already Empty";
 	                JOptionPane.showMessageDialog(null,str2,"Error",JOptionPane.ERROR_MESSAGE); 			
			}
		else
			{
			query.setText("");
			result.setText("");
			}
		}
	}

}

class QueryBrowserLayout implements LayoutManager {

    public QueryBrowserLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 607 + insets.left + insets.right;
        dim.height = 457 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+40,536,168);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+8,168,24);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+248,184,24);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+32,insets.top+280,536,168);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+216,136,24);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+216,128,24);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+400,insets.top+216,128,24);}
    }
}

