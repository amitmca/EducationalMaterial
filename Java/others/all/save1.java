/****************************************************************/
/*                      save1	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

/**
 * Summary description for save1
 *
 */
public class save1 extends JFrame
{
	// Variables declaration
	private JLabel jLabel3;
	private JTextArea ta;
	private JScrollPane jScrollPane1;
	private JProgressBar jpb;
	private JButton bshow;
	private JPanel contentPane;
	// End of variables declaration


	public save1()
	{
		super();
		initializeComponent();
		//
		// TODO: Add any constructor code after initializeComponent call
		//

		this.setVisible(true);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always regenerated
	 * by the Windows Form Designer. Otherwise, retrieving design might not work properly.
	 * Tip: If you must revise this method, please backup this GUI file for JFrameBuilder
	 * to retrieve your design properly in future, before revising this method.
	 */
	private void initializeComponent()
	{
		jLabel3 = new JLabel();
		ta = new JTextArea();
		jScrollPane1 = new JScrollPane();
		jpb = new JProgressBar();
		bshow = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// jLabel3
		//
		jLabel3.setText("RECORD ADDED SUCCESSFULLY");
		//
		// ta
		//
		//
		// jScrollPane1
		//
		jScrollPane1.setViewportView(ta);
		//
		// jpb
		//
		//
		// bshow
		//
		bshow.setText("SHOW");
		bshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bshow_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(226, 216, 236));
		addComponent(contentPane, jLabel3, 88,22,292,18);
		addComponent(contentPane, jScrollPane1, 11,117,359,125);
		addComponent(contentPane, jpb, 118,92,100,22);
		addComponent(contentPane, bshow, 126,52,83,28);
		//
		// save1
		//
		this.setTitle("save1 - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(390, 300));
	}

	/** Add Component Without a Layout Manager (Absolute Positioning) */
	private void addComponent(Container container,Component c,int x,int y,int width,int height)
	{
		c.setBounds(x,y,width,height);
		container.add(c);
	}

	//
	// TODO: Add any appropriate code in the following Event Handling Methods
	//
	private void bshow_actionPerformed(ActionEvent e)
	{
		Connection con1=null;
	Statement stmt;
	String val,mess1="",s1;
	
	
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
				jpb.setValue(jpb.getValue()+10);
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

	//
	// TODO: Add any method code to meet your needs in the following area
	//






























 

//============================= Testing ================================//
//=                                                                    =//
//= The following main method is just for testing this class you built.=//
//= After testing,you may simply delete it.                            =//
//======================================================================//
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Exception ex)
		{
			System.out.println("Failed loading L&F: ");
			System.out.println(ex);
		}
		new save1();
	}
//= End of Testing =


}
