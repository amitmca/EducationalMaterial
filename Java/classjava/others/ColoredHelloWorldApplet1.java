
// An applet that says "Hello World" in a big bold font, with a button to change
// the color of the message.

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/*
<applet code="ColoredHelloWorldApplet1" height="250" width="250">
</applet>
*/

public class ColoredHelloWorldApplet1 extends Applet implements ActionListener {

   Color textColor;  // Color in which "Hello World" is displayed;
                     //     this changes when the user clicks on a button.     
   int colorNum;     // Keeps track of which color is displayed;
                     //     1 for red, 2 for blue, 3 for green.
   Font textFont;    // The font in which the message is displayed.
   
   
   public void init() {

          // This routine is called by the system to initilize the applet.
          // It sets up the font and initial color for the message and 
          // it adds a button to the apple for changing the message color.
          
       setBackground(Color.lightGray);

       textColor = Color.red;
       colorNum = 1;
       textFont = new Font("Serif",Font.BOLD,24);

       Button bttn = new Button("Change Color");  // Create a new button.
       bttn.addActionListener(this);  // Set up the bttn to send an "action event"
                                      // to this applet when the user clicks the button.
       add(bttn);  // Add button to applet, so that it will appear on the screen.

   }  // end init()
   
   
   public void paint(Graphics g) {
         
         // This routine is called by the system whenever the content of the
         // applet needs to be drawn or redrawn.  It displays the message
         // "Hello World" in the proper color and font.

      g.setColor(textColor);
      g.setFont(textFont);
      g.drawString("Hello World!", 20,70);

   }  // end paint()
   

   public void actionPerformed(ActionEvent evt) {
   
         // This routine is called by the system when an "action" is performed
         // by the user, provided that the applet has been set as a "listener"
         // for such events.  This applet listens only for events from the
         // "Change Color" button, so I assume that the user has clicked
         // on that button.  The routine changes the drawing color and
         // tells the system that the applet has to be repainted.
         
      if (colorNum == 1) {
         colorNum = 2;
         textColor = Color.blue;
      }
      else if (colorNum == 2) {
         colorNum = 3;
         textColor = Color.green;
      }
      else { // colorNum must be 3
         colorNum = 1;
         textColor = Color.red;
      }
      
      repaint();  // Tells system that this applet needs to be redrawn
      
   }  // end init()
   
} // end class ColoredHelloWorldApplet
   