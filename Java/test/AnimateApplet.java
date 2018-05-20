import java.awt.*;
import java.applet.*;
/*
<applet code="AnimateApplet" width="250" height="250">
</applet>
*/
public class AnimateApplet extends Applet implements Runnable 
{
    static Image im[];
    static int numImages = 12;
    static int counter=0;
    Thread animator;
    public void init () {
        im = new Image[numImages];
        for (int i=0;i<numImages;i++)
            im[i] = getImage (getDocumentBase(), "clock"+i+".jpg");
    }
    public void start() {
        if (animator == null) {
            animator = new Thread (this);
            animator.start ();
        }
    }
    public void stop() {
        if ((animator != null) && (animator.isAlive())) {
            animator.stop();
            animator = null;
        }
    }
    public void run () {
        while (animator != null) {
            try {
                animator.sleep(200);
                repaint ();
                counter++;
                if (counter==numImages)
                    counter=0;
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
    }
    public void paint (Graphics g) {
        g.drawImage (im[counter], 0, 0, this);
    }
}
