import java.lang.*;
import java.io.*;

public class StringLength{
  public static void main(String[] args) throws IOException{
    System.out.println("String lenght example!");
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter string:");
    String str = bf.readLine();
    int len = str.length();
    System.out.println("String lenght : " + len);
  }
}  
