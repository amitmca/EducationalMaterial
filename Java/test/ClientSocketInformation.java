import java.net.*;
import java.io.*;
import java.net.InetAddress;

public class ClientSocketInformation{
  public static final short TIME_PORT = 135;
  public static void main(String[] args) throws IOException{
    String hostName= null;
    try{
      Socket socket= new Socket(hostName,TIME_PORT);
      System.out.println();
      System.out.println("Socket is =" + socket);
      System.out.println("is socket bound? ="+ socket.isBound());
      System.out.println("is socket Connected? ="+ socket.isConnected());
      System.out.println("show time out = "+ socket.getSoTimeout());
      System.out.println("so linger =" + socket.getSoLinger());
      System.out.println("TCP no Delay =" + socket.getTcpNoDelay());
      System.out.println("Traffic class =" + socket.getTrafficClass());
      System.out.println("channel is =" + socket.getChannel());
      System.out.println("Reuse address is =" + socket.getReuseAddress());
      System.out.println("close =" + socket.isClosed());
      InetAddress in= socket.getInetAddress();
      System.out.println(in);
      System.out.println("\n");
      System.out.print("RAW IP Address - (byte[]) : ");
      byte[] b1 = in.getAddress();
      for (int i=0; i< b1.length; i++) {
        if (i > 0) {
          System.out.print(".");}
          System.out.print(b1[i]);
      }
      System.out.println();
      System.out.println("Is Loopback Address?      : " + in.isLoopbackAddress());
      System.out.println("Is Multicast Address?     : " + in.isMulticastAddress());
      System.out.println("\n");
      InetAddress address = socket.getLocalAddress();
      System.out.println("Local address =" + address);
     }
    catch (UnknownHostException  e)  {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
} 