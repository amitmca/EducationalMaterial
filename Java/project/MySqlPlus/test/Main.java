
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main implements Runnable{
    private final JFrame frame;
    public Main(JFrame frm){
        this.frame=frm;
    }//constructor closed
    public void run(){
        frame.setVisible(true);
    }//run method closed
    public static void main(String args[]){
        new frmSplash(6500);
        EventQueue.invokeLater(new Main(new Login()));
    }//main method closed

}//class closed
