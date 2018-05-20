import java.io.*;

public class ListSystemRoots {
  static File giveRoot[];

  public ListSystemRoots(){
  }
  public static void main(String args[]){
    giveRoot = File.listRoots();      // list the names of the drives
    for (int i = 0; i < giveRoot.length; i++)
      System.out.println(giveRoot[i]);    // Print the list
  }
} 