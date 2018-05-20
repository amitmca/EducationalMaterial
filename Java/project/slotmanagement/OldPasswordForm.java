import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class PasswordForm
{
	
    public static void main(String[] argv) 
    {
        final JFrame f = new JFrame("Login");
		f.setLocation(250,240);
		JPasswordField passwordField = new JPasswordField(10);				
        JLabel label = new JLabel("Enter the password: ");        
        passwordField.setEchoChar('*');
        f.setResizable(false);
        
        passwordField.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                JPasswordField input = (JPasswordField)e.getSource();
                
                char[] password = input.getPassword();
                if (isPasswordCorrect(password))
                 {                   
                 	f.dispose();
                    SlotMgt S = new SlotMgt();                                                          
                 }
                 else 
                 {
                    JOptionPane.showMessageDialog(f,
                        "Invalid password. Try again.",
                        "Error Message",
                        JOptionPane.ERROR_MESSAGE);                        
                        input.setText("");
                 }                
            }
        });

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.add(label, BorderLayout.WEST);
        contentPane.add(passwordField, BorderLayout.CENTER);

        f.setContentPane(contentPane);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        f.pack();
        f.setVisible(true);
    }

    private static boolean isPasswordCorrect(char[] input) {
        char[] correctPassword = { 'a', 'd', 'm', 'i', 'n'};
        if (input.length != correctPassword.length)
            return false;
        for (int i = 0;  i < input.length; i ++)
            if (input[i] != correctPassword[i])
                return false;
        return true;
    }
}
