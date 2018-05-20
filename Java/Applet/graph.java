import java.awt.*;
import java.applet.*;

/*
<applet code="graph" width="250" height="250">
</applet>
*/

public class graph extends Applet
        {
        int x[]={30,200,30,200,30};
        int y[]={30,30,200,200,30};
        public void paint(Graphics g)
                {
             /*   g.drawLine(0,0,100,100);
                g.drawRect(100,100,60,50);
                g.fillRect(150,150,60,50);
                g.drawRoundRect(250,250,50,50,20,10);
                g.fillRoundRect(350,350,50,50,20,10);
                g.drawOval(460,460,20,20);
                g.fillOval(490,490,20,20);
                g.drawArc(550,550,25,25,0,75);
                g.fillArc(600,600,25,25,0,75);*/
                g.fillPolygon(x,y,5);
                }
        }