import java.net.*;
import java.io.*;
import java.util.*;

class server
{
	public static void main(String args[])throws Exception
	{
	ServerSocket ss=new ServerSocket(4000);
	Socket sc=ss.accept();
	DataInputStream dis=new DataInputStream(sc.getInputStream());
	DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
	String fname=dis.readUTF();
	File f=new File(fname);
	if(f.exists())
	{
	FileReader fr=new FileReader(f);
	BufferedReader br=new BufferedReader(fr);
	String line="";
	while((line=br.readLine())!=null)
	{
		dos.writeUTF(line);
	} 
	
	}
	else
	{
	System.out.println("file not found");
	}
	}
}
	
class client
{
		public static void main(String args[])throws Exception
		{
			Socket sc=new Socket("localhost",4000);
			System.out.println("welcome to client");
			DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter the file name");
			String fname=br.readLine();
			dos.writeUTF(fname);
			DataInputStream dis=new DataInputStream(sc.getInputStream());
			String line="";					
			while((line=dis.readUTF())!=null)
			{
				System.out.println(line);
			} 
	
		}
	
		
}
