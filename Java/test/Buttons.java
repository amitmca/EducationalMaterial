import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

/*
<applet code="Buttons" width="250" height="250">
</applet>
*/

public class Buttons extends JApplet {
  private JButton jb = new JButton("JButton");

  private BasicArrowButton up = new BasicArrowButton(BasicArrowButton.NORTH),
      down = new BasicArrowButton(BasicArrowButton.SOUTH),
      right = new BasicArrowButton(BasicArrowButton.EAST),
      left = new BasicArrowButton(BasicArrowButton.WEST);

  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(jb);
    cp.add(new JToggleButton("JToggleButton"));
    cp.add(new JCheckBox("JCheckBox"));
    cp.add(new JRadioButton("JRadioButton"));
    JPanel jp = new JPanel();
    jp.setBorder(new TitledBorder("Directions"));
    jp.add(up);
    jp.add(down);
    jp.add(left);
    jp.add(right);
    cp.add(jp);
  }

  public static void main(String[] args) {
    run(new Buttons(), 350, 100);
  }

  public static void run(JApplet applet, int width, int height) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(applet);
    frame.setSize(width, height);
    applet.init();
    applet.start();
    frame.setVisible(true);
  }
} ///:~

