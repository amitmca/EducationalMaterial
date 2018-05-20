
/*
    Applet scrolls a message, while a red oval grows from size zero
    to the full size of the applet.  Two blue bars across the applet
    lie above and below the path of the message.  This is an example
    of animation using an off-screen canvas.
    
    David Eck, September 2, 1996
    Revised August 7, 1998 to conform to Java 1.1.
*/


import java.awt.*;
import java.applet.*;

/*
<applet code="ScrollingMessage" height="250" width="250">
</applet>
*/
public class ScrollingMessage extends Applet
                              implements Runnable {
   
   String message = "AMIT!";   // can be modified by an applet param with name "message"
   
   int message_x, message_y;   // position where message is drawn
   int min_x, max_x;           // largest and smallest values for message_x
   int bar1_y, bar2_y;         // y coordinates for red lines across the applet
   
   int pulse_frames = 60;   // number of frames it takes for red oval to grow to full size
   int scroll_frames = 150; // number of framed it takes for message to scroll across the screen
   
   int current_frame = 0;   // current frame number
         
   Image OSC = null;       // the off-screen image
   Graphics OSC_graphics;  // graphics context for OSC 
   int width = -1;         // width of OSC  (value of -1 indicates OSC doesn't exist)
   int height = -1;        // height of OSC
   
   Thread runner = null;   // Thread for running the animation
   int sleepTime = 50;     // Pause between frames, in milliseconds
   
   private volatile int status;        // used to control the thread
   private final static int GO = 0,    // values for status variable
                    SUSPEND = 1,
                    TERMINATE = 2;
   

   public void init() {
         // just check for the parameter
      String param = getParameter("message");
      if (param != null)
         message = param;
   }
       
   synchronized public void paint(Graphics g) {
      if (width != getSize().width || height != getSize().height) {
         doResize();
         drawFrameToOSC();
      }
      g.drawImage(OSC,0,0,this);
   }
       
   public void update(Graphics g) {
         // redefine update() so that it doesn't erase the applet;
         // this will avoid flickering when the applet is redrawn
      paint(g);
   }
         
   synchronized public void start() {
         // create thread, or tell it to resume if it already exists
      status = GO;
      if (runner == null || ! runner.isAlive()) {  // create and start the thread
         runner = new Thread(this);
         runner.start();
      }
      else 
         notify();
   }
         
   synchronized public void stop() {
        // tell thread to pause
      status = SUSPEND;
      notify();
   }
         
   synchronized public void destroy() {
       // tell thread to die
      status = TERMINATE;
      notify();
   }
   
   synchronized void doResize() {
   
         // Create an off-screen canvas of the same size as the
         // applet, and set up various parameters related to
         // the size.  This routine is called if it is discovered
         // that the size of the applet 
         
       OSC = null;  // free up memory being used by the OSC, if any
       width = getSize().width;
       height = getSize().height;
       OSC = createImage(width,height);  // create off-screen canvas
       OSC_graphics = OSC.getGraphics();
       
       Font font = getFont();  // font for drawing message, about 1/8 height of applet
       font = new Font("TimesRoman", Font.PLAIN, height/8);
       OSC_graphics.setFont(font);
       FontMetrics fm = getFontMetrics(font);
           // compute drawing parameters that depend on applet and font size
       message_y = (height - fm.getHeight()) / 2 + fm.getAscent() + fm.getLeading() / 2;
       bar1_y = message_y - fm.getAscent() - fm.getLeading() - 2;
       bar2_y = message_y + fm.getLeading() + fm.getDescent() + 2;
       min_x = -fm.stringWidth(message);
       max_x = width;
       
   }  // end doResize()
         
   
   synchronized void drawFrameToOSC() {
           
           // Create one frame in the animation.  The variable scroll_frame 
           // gives relative position of scrolling message, while pulse_frame
           // gives relative size of growing oval.  Note that the OSC must be
           // created before this is called.
           
       int scroll_frame = current_frame % scroll_frames;
       int pulse_frame = current_frame % pulse_frames;
                  
       message_x = max_x - ((scroll_frame * (max_x-min_x)) / scroll_frames);
       int a = (width/2) - (pulse_frame*width)/(2*pulse_frames);   // left edge for oval
       int b = (height/2) - (pulse_frame*height)/(2*pulse_frames); // top edge for oval
       
       OSC_graphics.setColor(Color.white);                 // fill the background
       OSC_graphics.fillRect(0,0,width,height);
       OSC_graphics.setColor(Color.red);                   // draw the oval
       OSC_graphics.fillOval(a,b,width-2*a,height-2*b);
       OSC_graphics.setColor(Color.blue);
       OSC_graphics.drawLine(0,bar1_y,width,bar1_y);       // draw the bars (2 pixels high)
       OSC_graphics.drawLine(0,bar1_y+1,width,bar1_y+1);
       OSC_graphics.drawLine(0,bar2_y,width,bar2_y);
       OSC_graphics.drawLine(0,bar2_y-1,width,bar2_y-1);
       OSC_graphics.setColor(Color.black);                 // draw the message
       OSC_graphics.drawString(message,message_x,message_y);
   
   }  // end drawFrameToOSC()
   
   synchronized void createNextFrame() {
          // Compute data for the next frame of the animation, and draw that frame to the
          // off-screen canvas.  In this case, the only data that needs to be changed
          // is the value of current_frame.
       current_frame++;
       if (getSize().height != height || getSize().width != width)  // Make sure that OSC exists
            doResize();                                             //   and is of the correct size.
       drawFrameToOSC();
   }
       
   public void run() {
         // subroutine to be executed by the thread
      while (status != TERMINATE) {
         synchronized(this) {
            while (status == SUSPEND)
               try { wait(); }
               catch (InterruptedException e) { }
         }
         if (status == GO) {
            createNextFrame();
            repaint();
         }
         if (status == GO) {
            synchronized(this) {
               try { wait(sleepTime); }
               catch (InterruptedException e) { }
            }
         }
      }
   }  // end run()
         
}  // end of class ScrollingMessage
