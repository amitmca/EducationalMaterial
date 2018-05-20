import java.util.*;
import java.lang.*;

public class GetEnvironmentVariable
{
  public static void main(String args[]) {
    try{
      String environmentVariable = System.getenv("WINDIR");
      System.out.print("Environment Variable are =>"+environmentVariable);
    }catch (Exception e){
      System.out.println("Exception caught ="+e.getMessage());
    }
  }
}  
