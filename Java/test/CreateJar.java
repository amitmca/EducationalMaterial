import java.io.*;

public class CreateJar{
  public static void main(String[] args) throws IOException{
    if(args.length <= 0){
      System.out.println("Please enter the command.");
      System.exit(0);
    }
    else{
      Runtime.getRuntime().exec(args[0] + " " + args[1] + " " + args[2] + " " + args[3]);
    }
  }
} 