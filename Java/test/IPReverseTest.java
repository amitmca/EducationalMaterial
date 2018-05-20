import java.net.*;

public class IPReverseTest {
  public static void main (String[] args) {
    try {
      InetAddress ia = InetAddress.getByName("127.0.0.1");
      System.out.println(ia.getHostName());
    }
    catch (Exception ex) {
      System.err.println("does not fine hostname");
    }
  }
}