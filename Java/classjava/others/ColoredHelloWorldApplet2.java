
// An applet that says "Hello World" in a big bold font, with three buttons for
// selecting the color of the message.  This applet depends on the class
// ColoredHelloWorldCanvas, which is defined in a separate file.

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class ColoredHelloWorldApplet2 extends Applet implements ActionListener {

   ColoredHelloWorldCanvas canvas;  // A canvas which actually displays the message
   

   public void init() {

          // This routine is called by the system to initilize the applet.
          // It creates the canvas and lays out the applet to consist of a
          // bar of control buttons below the canvas.
          
       setBackground(Color.lightGray);

       canvas = new ColoredHelloWorldCanvas();

       Panel buttonBar = new Panel();  // a panel to hold the control buttons
       
       Button redBttn = new Button("Red");  // Create buttons and add them to the
       redBttn.addActionListener(this);   //    button bar.
       buttonBar.add(redBttn);
       
       Button greenBttn = new Button("Green");
       greenBttn.addActionListener(this);
       buttonBar.add(greenBttn);
       
       Button blueBttn = new Button("Blue");
       blueBttn.addActionListener(this);
       buttonBar.add(blueBttn);
       
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
         // for such events.  Responds to the buttons by setting the text
         // display color of the canvas.
         
      String command = evt.getActionCommand();
      
      if (command.equals("Red"))
         canvas.setTextColor(Color.red);
      else if (command.equals("Green"))
         canvas.setTextColor(Color.green);
      else if (command.equals("Blue"))
         canvas.setTextColor(Color.blue);
      
   }  // end init()
   
   
} // end class ColoredHelloWorldApplet2

