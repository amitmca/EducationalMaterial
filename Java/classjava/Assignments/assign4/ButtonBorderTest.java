
 
 
import javax.swing.*;
import java.awt.*; 
import javax.swing.border.Border;


public class ButtonBorderTest {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Fourth Button");
    Container contentPane = frame.getContentPane();
    Icon icon = new ImageIcon("default-icon.ico");
    JButton b = new JButton("Button!");
    Border bored = BorderFactory.createMatteBorder(10, 5, 10, 5, icon);
    b.setBorder(bored);
    contentPane.add(b, BorderLayout.CENTER);
    frame.setSize(350, 200);
    frame.show();
  }
} 
 
 