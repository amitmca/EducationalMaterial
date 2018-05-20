
// An applet that says "Hello World" in a big bold font.  When the user
// clicks on a button labeled "Blink at Me!", the message cycles a few times
// from red to green and back.  This applet depends on the class
// ColoredHellowWorldCanvas, which is defined in a separate file.

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
/*
<applet code="BlinkingHelloWorld1" height="250" width="250">
</applet>
*/

public class BlinkingHelloWorld1 extends Applet implements ActionListener, Runnable {

   ColoredHelloWorldCanvas canvas;  // A canvas which actually displays the message
   
   Button blinkBttn;  // The control button.
   
   Thread blinker;  // a thread that is responsible for cycling the message colors.

   public void init() {

          // This routine is called by the system to initilize the applet.
          // It creates the canvas and lays out the applet to consist of a
          // bar of control buttons below the canvas.
          
       setBackground(Color.lightGray);

       canvas = new ColoredHelloWorldCanvas();

       Panel buttonBar = new Panel();  // a panel to hold the control buttons
       
       blinkBttn = new Button("Blink at Me!");  // Create button and add it to the
       blinkBttn.addActionListener(this);       //    button bar.
       buttonBar.add(blinkBttn);
       
       setLayout(new BorderLayout(3,3));  // Lay out the applet
       add("Center",canvas);
       add("South", buttonBar);

   }  // end init()
   
   
   public Insets getInsets() {
   
        // This routine is called by the system to determine how much
        // space to leave between the edges of the applet and the
        // components that the applet contains.  It leaves a 3-pixel
        // border, which will be displayed in the background color.
        
      return new Insets(3,3,3,3);
      
   }
   
   
   public void actionPerformed(ActionEvent evt) {
   
         // This routine is called by the system when an "action" is performed
         // by the user, provided that the applet has been set as a "listener"
         // for such events.  Starts a thread to run the applets run() method.
         
       if (blinker == null || ! blinker.isAlive()) {
          blinker = new Thread(this);
          blinker.start();
       }
         
   }  // end actionPerformed()
   
   
   public void run() {
        // The routine that is executed by the runner thread.
        // It cycles the color of the message from red to green and back
        // three times.  The control is disabled while this is
        // happening.
      blinkBttn.setEnabled(false);
      canvas.setTextColor(Color.green);
      delay(300);
      canvas.setTextColor(Color.red);
      delay(300);
      canvas.setTextColor(Color.green);
      delay(300);
      canvas.setTextColor(Color.red);
      delay(300);
      canvas.setTextColor(Color.green);
      delay(300);
      canvas.setTextColor(Color.red);
      blinkBttn.setEnabled(true);
   }
   
   void delay(int milliseconds) {
        // Pause for the specified nmber of milliseconds.
      try {
         Thread.sleep(milliseconds);
      }
      catch (InterruptedException e) {
      }
   }
   
   
} // end class ColoredHelloWorldApplet2


