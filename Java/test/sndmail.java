/*
 *
 * A free Java sample program 
 * to send email from a Java program
 *
 * @author William Alexander
 * free for use as long as this comment is included 
 * in the program as it is
 * 
 * More Free Java programs available for download 
 * at http://www.java-samples.com
 *
 */
import java.io.*;
import java.net.*;
 
public class sndmail {
  public static void main(String[] args) {
    try {

      if (args.length >= 1) System.getProperties().put("mail.host", args[0]);
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      System.out.print("From: ");
      String from = in.readLine();
      System.out.print("To: ");
      String to = in.readLine();
      System.out.print("Subject: ");
      String subject = in.readLine();

      URL u = new URL("mailto:" + to);      
      URLConnection c = u.openConnection(); 
      c.setDoInput(false);                  
      c.setDoOutput(true);                  
      System.out.println("Connecting...");  
      System.out.flush();                   
      c.connect();                          
      PrintWriter out =                     
        new PrintWriter(new OutputStreamWriter(c.getOutputStream()));
      out.println("From: \"" + from + "\" <" +
                  System.getProperty("user.name") + "@" + 
                  InetAddress.getLocalHost().getHostName() + ">");
      out.println("To: " + to);
      out.println("Subject: " + subject);
      out.println();  

      System.out.println("Enter the message. " + 
                         "End with a '.' on a line by itself.");
      String line; 
      for(;;) {
        line = in.readLine();
        if ((line == null) || line.equals(".")) break;
        out.println(line);
      }

      out.close();
      System.out.println("Message sent.");
      System.out.flush();
    }
    catch (Exception e) {  
      System.err.println(e);
      System.err.println("Usage: java sndmail [your.mailserver.com]");
    }
  }
}
 
