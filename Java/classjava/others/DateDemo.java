

/*
   This very simple applet lets the user type dates into an
   input box.  The input strings are parsed by a constructor from the
   Date class.  If the input is acceptable as a date/time, then the
   date/time is displayed.  If not, an error message is displayed.
   At the start, the current date and time are displayed.
*/


import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.util.Date;

/*
<applet code="DateDemo" height="250" width="250">
</applet>
*/

public class DateDemo extends Applet implements ActionListener {

   Label message;    // For displaying message to the user.
   TextField input;  // Text-input box for user input.

   public void init() {
      setBackground(Color.white);
      setLayout(new GridLayout(3,1,3,3));
      add(new Label("Enter a date and press return:"));
      input = new TextField();
      input.addActionListener(this);
      add(input);
      message = new Label("Current date/time:  " + (new Date()) );
      message.setForeground(Color.red);
      add(message);
   }
   
   public void actionPerformed(ActionEvent evt) {
         // When user hits return, try to translate the
         // string from the input box into a date/time, and
         // display it in the message label.
      try {
         Date d = new Date(evt.getActionCommand());
         message.setText("Date entered was:  " + d);
      }
      catch (Exception e) {
         message.setText("Error in Input.");
      }
   }

}  // end class DateDemo