import java.util.Scanner;
import java.io.*;
 
 
public class Word_Count_Application {
 
	
	public static void main(String[] args) throws IOException
	{
		Scanner inFile = new Scanner(new FileReader("D:/Programs/Java/classjava/questions/append.java"));
		int lineCount;
		int wordCount;
		int characterCount;
		
		lineCount = 0;
		while (inFile.hasNextLine())
		{
			lineCount++;
			wordCount = 0;
			characterCount = 0;
			Scanner inLine = new Scanner(new FileReader("D:/Programs/Java/classjava/questions/append.java"));
			while (inLine.hasNext())
			{
				wordCount++;
				
			}
			
			System.out.println("The total number of lines in the file are " + 
					lineCount + " .");
			System.out.println("The total number of words in the file are " + 
					wordCount + " .");
			System.out.print("The total number of characters in the file are " + 
					characterCount + " .");
		}
		System.out.println();
	}
 
}
