import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
abstract class EmailVerifier extends InputVerifier
  {  
   public static void main(String args[])	  
     {
      String regx = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";

      String text = "once_amit1rediffmail.com";
 
      if(text.matches(regx))
      {       
        System.out.println("Ok");
      }
      else
      {
        System.out.println("Ok");
      }
    }
  }