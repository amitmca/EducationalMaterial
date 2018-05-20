import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass1 extends JPanel {
  Color colors[] = { Color.black, Color.blue, Color.cyan, Color.darkGray,
      Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange,
      Color.pink, Color.red, Color.white, Color.yellow };

  public void paint(Graphics g) {
    int deltax = 260 / colors.length;
    for (int i = 0; i < colors.length; i++) {
      g.setColor(colors[i]);
      g.fillRect(i * deltax, 0, (i + 1) * deltax, 260);
    }

  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new MainClass1());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200, 200);
    frame.setVisible(true);
  }
}


