import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*
<applet code="kadapter" width="250" height="250">
</applet> 
*/ 

public class kadapter extends Applet
        {
        public void init()
                {
                addKeyListener(new MyKeyAdapter(this));
                }
        }
class MyKeyAdapter extends KeyAdapter
        {
       
        kadapter k;
                public MyKeyAdapter(kadapter k)
                {
                this.k=k;
                }        
        public void keyPressed(KeyEvent e)
                {
                k.showStatus("Key Pressed");
                }
       }       
        
