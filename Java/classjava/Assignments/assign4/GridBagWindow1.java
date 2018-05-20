/*
 * Swing version.
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GridBagWindow1 extends JFrame {
    boolean inAnApplet = true;
    final boolean shouldFill = true;
    final boolean shouldWeightX = true;
     
    public GridBagWindow1() {
        JTextArea ta;
	  JRadioButton rmale;
        JRadioButton rfemale;
        ButtonGroup cbg;
        Container contentPane = getContentPane();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        contentPane.setLayout(gridbag);
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL; 
        }
         cbg = new ButtonGroup();
        ta = new JTextArea(" ",10,10);
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(ta, c);
        contentPane.add(ta);

        rmale = new JRadioButton("Male", false);
        cbg.add(rmale);
        c.gridx =2;
        c.gridy =0;
        gridbag.setConstraints(rmale, c);
        contentPane.add(rmale);

        rfemale = new JRadioButton("Female", false);
        cbg.add(rfemale);
        c.gridx = 1;
        c.gridy = 2;
        gridbag.setConstraints(rfemale, c);
        contentPane.add(rfemale);

      /*  addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (inAnApplet) {
                    dispose();
                } else {
                    System.exit(0);
                }
            }
        });*/
    }

    public static void main(String args[]) {
        GridBagWindow1 window = new GridBagWindow1();
        window.inAnApplet = false;

        window.setTitle("GridBagLayout");
        window.pack();
        window.setVisible(true);
    }
}
