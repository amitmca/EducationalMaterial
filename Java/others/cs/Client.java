import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class Client extends JFrame implements ActionListener
   {
    JTextArea ta1;
    JScrollPane sp_textarea_1;
    JLabel label_1;
    JTextArea ta2;
    JScrollPane sp_textarea_2;
    JLabel label_2;
    JButton btnsend;
    ImageIcon i;

    public Client() {
        ClientLayout customLayout = new ClientLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        ta1 = new JTextArea("");
        sp_textarea_1 = new JScrollPane(ta1);
        getContentPane().add(sp_textarea_1);

        i=new ImageIcon("bar3.gif");	
        label_1 = new JLabel(i);
        getContentPane().add(label_1);

        ta2 = new JTextArea("");
        sp_textarea_2 = new JScrollPane(ta2);
        getContentPane().add(sp_textarea_2);

        label_2 = new JLabel("Client Interface");
        getContentPane().add(label_2);

        btnsend = new JButton("SEND");
        getContentPane().add(btnsend);
        btnsend.addActionListener(this);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent ae)
	{
	if(ae.getSource()==btnsend)
		{
 		try
			{
			Socket socket=new Socket("127.0.0.1",6000);
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
			String client=ta1.getText();
			 stdin=new BufferedReader(new InputStreamReader(client));
			String fromuser;
			String fromserver;
			while((fromserver=stdin.readLine())!=null)			
				{
				out.println("Server:"+fromserver);
				if(fromserver.equals("EXIT"))
					break;
				fromuser=stdin.readLine();
				if(fromuser!=null)
					ta2.setText(fromuser);
//				out.println(fromuser);
				}
			}
		catch(Exception e)
			{
			System.out.println(e);
			System.exit(1);
			}	
		}
	}
    public static void main(String args[]) {
        Client window = new Client();

        window.setTitle("Client");
        window.pack();
        window.show();
    }
}

class ClientLayout implements LayoutManager {

    public ClientLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 486 + insets.left + insets.right;
        dim.height = 339 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+24,insets.top+96,184,160);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+232,insets.top+8,16,320);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+272,insets.top+96,192,160);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+40,insets.top+32,144,24);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+72,insets.top+280,72,24);}
    }
}
