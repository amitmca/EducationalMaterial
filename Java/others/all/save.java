import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class save extends JFrame implements ActionListener,Runnable
 {
    JLabel mess;
    JTextArea ta;
    JScrollPane sp_ta;
    JButton bshow;
    Thread t;	
    JProgressBar jpb=new JProgressBar();	
    Container cp;	
    public save() {
        saveLayout customLayout = new saveLayout();
	cp=getContentPane();
        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);
	t=new Thread(this,"SAVE");
	t.start();
        mess = new JLabel("Record Saved Successfully");
        getContentPane().add(mess);

        ta = new JTextArea("");
        sp_ta = new JScrollPane(ta);
        getContentPane().add(sp_ta);
	
	jpb.setStringPainted(true);


        bshow = new JButton("SHOW");
	bshow.addActionListener(this);
        getContentPane().add(bshow);
	getContentPane().add(jpb);
        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
public void run()
	{
	}


	public void actionPerformed(ActionEvent e)
	{
	Connection con1=null;
	Statement stmt;
	String val,mess1="",s1;
	
	if(e.getSource()==bshow)
		{
		try
			{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			String url="jdbc:odbc:SQLITE";

			String text=new String();
					
			con1=DriverManager.getConnection(url,"","");

			stmt=con1.createStatement();

			String sql="select * from emp order by eno";

			ResultSet rs=stmt.executeQuery(sql);

			int count=0;
			ta.setFont(new Font("verdana",Font.BOLD,16));
			while(rs.next())
				{
				text=text + rs.getString(1) +"     |    " + rs.getString(2) + "\n";
				Thread.sleep(100);
				ta.setText(text);
				count++;
				}
			String p = Integer.toString(count);
			
			ta.setFont(new Font("verdana",Font.BOLD,20));
			ta.append("Total Rows"+" : "+p);
			rs.close();
			}
		catch(Exception e1)
			{
			ta.setText(e1.getMessage());
			}
		}	
	}

    public static void main(String args[]) {
        save window = new save();

        window.setTitle("SAVE");
        window.pack();
        window.show();
    }
}

class saveLayout implements LayoutManager {

    public saveLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 320 + insets.left + insets.right;
        dim.height = 240 + insets.top + insets.bottom;

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
        if (c.isVisible()) {c.setBounds(insets.left+48,insets.top+24,232,24);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+16,insets.top+96,288,136);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+120,insets.top+64,72,24);}
    }
}
