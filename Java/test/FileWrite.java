import java.io.*;
class FileWrite 
{
   public static void main(String args[])
  {
      try{
    // Create file 
    FileWriter fstream = new FileWriter("myfile.txt",true);
        BufferedWriter out = new BufferedWriter(fstream);
	PrintWriter pow=new PrintWriter(fstream,true); 
	pow.println(); 
    out.write("Hello Java");
    //Close the output stream
    out.close();
    }catch (Exception e){//Catch exception if any
      System.err.println("Error: " + e.getMessage());
    }
  }
}