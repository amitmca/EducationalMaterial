import java.net.*;
import java.io.*;
import java.util.*;

class server
{
	public static void main(String args[])throws Exception
	{
	ServerSocket ss=new ServerSocket(6000);
	Socket sc=ss.accept();
	DataInputStream dis=new DataInputStream(sc.getInputStream());
	DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
	String fname[]= new String[5];
	//File f=new File(fname);
	for(int i=0;i<5;i++)
	{
		fname[i]=dis.readUTF();
		File f=new File(fname[i]);
		if (f.exists())
		{
			System.out.println(fname[i]+" - Present");
		}
		else
		{
			System.out.println(fname[i]+" - Not Present");
		}		
	}

    }	
	
}
	
class client
{
		public static void main(String args[])throws Exception
		{
			Socket sc=new Socket("localhost",6000);
			System.out.println("welcome to client");

			DataInputStream dis=new DataInputStream(sc.getInputStream());
			DataOutputStream dos=new DataOutputStream(sc.getOutputStream());
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Enter 5 file name: ");
			String fname[]=new String[5];
			for(int i=0;i<5;i++)
			{
				fname[i]=br.readLine();
				dos.writeUTF(fname[i]);
			}
	
			String status="";
			
			while((status=dis.readLine())!=null)
			{
				System.out.println(status);
			}
	
		}
	
		
}
