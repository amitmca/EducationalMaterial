import java.util.*;

public class GenerateRandomNumber{
  public static void main(String[] args){
    Random rand = new Random();
    int num = rand.nextInt(1);
    System.out.println("Generated Random Number between 0 to 10 is : " + num);
    int numNoRange = rand.nextInt();
    System.out.println("Generated Random Number without specifying any range is : " + numNoRange);
  }
} 