import java.io.*;
import java.lang.*;

class application
	{
	public static void main(String args[])throws IOException
		{
		ProcessBuilder p=new ProcessBuilder("explorer.exe");
		p.start();
		}
	}
