import java.awt.*;
import java.awt.event.*;

public class ImageFrame extends Frame  {

 private Image image;

 ImageFrame() {
   super("");
   try {
      MediaTracker mt = new MediaTracker (this);
      // for Applet, change the method to retrieve the image
      // and of course use your own image!
      image = Toolkit.getDefaultToolkit().getImage("images/fhh.bmp");
      mt.addImage(image, 0);
      mt.waitForID(0);
   }
   catch (Exception e) {
       e.printStackTrace();
   }

   setLayout(new FlowLayout());

   add(new TextField(10));
   add(new Button("hello"));
   add(new List(20));
   add(new TextArea(20,20));
   // Label may not look too good ...
   add(new Label("Hello"));
   setSize(500, 500);

   addWindowListener
    (new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          // change this for an Applet
          System.out.println("Bye.");
          System.exit(0);
        }
     }
   );
  }

 public void update( Graphics g) {
   paint(g);
 }

 public void paint(Graphics g) {
   if(image != null) {
      int x = 0, y = 0;
      while(y < getSize().height) {
         x = 0;
         while(x< getSize().width) {
            g.drawImage(image, x, y, this);
            x= x + image.getWidth(null);
         }
         y = y + image.getHeight(null);
      }
   }
   else {
      g.clearRect(0, 0, getSize().width, getSize().height);
   }
 }

 static public void main(String[] args) {
   ImageFrame iframe = new ImageFrame();
   iframe.setVisible(true);
 }
}