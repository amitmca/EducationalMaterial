import java.awt.*;
import java.awt.event.*;

class SampleFrame extends Frame
        {
        SampleFrame(String title)
                {
                super(title);
                MyWindowAdapter adapter=new MyWindowAdapter(this);
                addWindowListener(adapter);
                }
        } 
class MyWindowAdapter extends WindowAdapter
        {
        SampleFrame sf;
        MyWindowAdapter(SampleFrame sf)
                {
                this.sf=sf;
                }          
        public void windowClosing(WindowEvent we)
                {
                sf.setVisible(false);
                }                              
        }        
class filedialog 
        {
        public static void main(String args[])
                {
                Frame f=new SampleFrame("File Dialog Demo");
                f.setVisible(true);
                f.setSize(100,100);
                FileDialog fd=new FileDialog(f,"File Dialog");
                fd.setVisible(true);
                }
        }        