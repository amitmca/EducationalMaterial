import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

	public class start extends JInternalFrame 
	{

		JPanel pane = new JPanel();
		JProgressBar current;
    		JTextArea out;
		Thread runner;
		int num = 0;
		
		public start ()
			{
			super("Start/Stop Successsful...");
			setFrameIcon(new ImageIcon("images/startstop.PNG"));
			setLocation(225,75);
			setSize (200,65);
		        current = new JProgressBar(0, 500);
       			current.setValue(0);
		        current.setStringPainted(true);
			pane.add(current);
		        setContentPane(pane);
			pane.setBackground(Color.yellow);
			setVisible(true);
			}
		 public void iterate()
		       {
      		       while (num < 2000) 
			{
            	        current.setValue(num);
      		       	try 
			  {
		          Thread.sleep(500);
            		  }
			catch (InterruptedException e) { }
	                num += 500;
      		        }
		       }		
	
	}	
