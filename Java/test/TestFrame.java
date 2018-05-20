/****************************************************************/
/*                      TestFrame	                            */
/*                                                              */
/****************************************************************/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Summary description for TestFrame
 *
 */
public class TestFrame extends JFrame
{
	// Variables declaration
	private JLabel lname;
	private JTextField tname;
	private JButton bclick;
	private JPanel contentPane;
	// End of variables declaration


	public TestFrame()
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
		lname = new JLabel();
		tname = new JTextField();
		bclick = new JButton();
		contentPane = (JPanel)this.getContentPane();

		//
		// lname
		//
		lname.setForeground(new Color(203, 31, 31));
		lname.setText("Enter Your Name :");
		//
		// tname
		//
		tname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tname_actionPerformed(e);
			}

		});
		//
		// bclick
		//
		bclick.setBackground(new Color(0, 0, 0));
		bclick.setForeground(new Color(153, 0, 0));
		bclick.setText("Click It");
		bclick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				bclick_actionPerformed(e);
			}

		});
		//
		// contentPane
		//
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(216, 230, 236));
		addComponent(contentPane, lname, 41,37,104,28);
		addComponent(contentPane, tname, 172,40,100,22);
		addComponent(contentPane, bclick, 111,107,83,28);
		//
		// TestFrame
		//
		this.setTitle("TestFrame - extends JFrame");
		this.setLocation(new Point(0, 0));
		this.setSize(new Dimension(327, 199));
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
	private void tname_actionPerformed(ActionEvent e)
	{
		System.out.println("\ntname_actionPerformed(ActionEvent e) called.");
		// TODO: Add any handling code here

	}

	private void bclick_actionPerformed(ActionEvent e)
	{
		String txt=tname.getText();
		JOptionPane.showMessageDialog(null,"Hello "+txt,"Hello",JOptionPane.INFORMATION_MESSAGE);

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
		new TestFrame();
	}
//= End of Testing =


}
