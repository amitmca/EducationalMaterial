import java.util.Random;

/** Generate 10 random integers in the range 0..99. */
public final class RandomInteger {
  
  public static final void main(String  args[]){
    log("Generating 10 random integers in range 0..99.");
    
    Random randomGenerator = new Random();
    for (int idx = 0; idx <= 10; ++idx){
      int randomInt = randomGenerator.nextInt(1);
      log("Generated : " + randomInt);
    }
    
    log("Done.");
  }
  
  private static void log(String aMessage){
    System.out.println(aMessage);
  }
}
