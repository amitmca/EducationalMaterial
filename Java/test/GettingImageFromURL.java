import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GettingImageFromURL extends JFrame implements ActionListener {

    private JButton  exitButton = null;
    private URL url    = null;        

    public GettingImageFromURL() {        
        super("Getting an Image from a specified URL");
        this.setSize(170, 130);
		
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        try {
            url = new URL("http://localhost/php/Database/new/thanks.gif");
        }
		catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        Image img = Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(url);
        
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        
        ImagePanel imagePanel = new ImagePanel(img);
        contentPane.add(imagePanel, BorderLayout.CENTER);
        contentPane.add(exitButton, BorderLayout.SOUTH);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void actionPerformed(ActionEvent actionevent) {

        String action = actionevent.getActionCommand();
                
        if (action.equals("Exit")) {
            dispose();
            System.out.println("Exiting.");
            System.exit(0);
        } else {
            System.out.println(action);
        }
    }
	
    public static void main(String[] args) {
        GettingImageFromURL mainFrame = new GettingImageFromURL();
        mainFrame.setVisible(true);        
    }
}

class ImagePanel extends JPanel {

    Image img;
    public ImagePanel(Image img) {
        this.img = img;
    }

    public void paintComponent(Graphics g) {
		
        super.paintComponent(g);        
        g.drawImage(img, 0, 0, this); 
    }
}