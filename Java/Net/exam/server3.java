import java.net.*;
import java.io.*;

class server3
	{
	public static void main(String args[])throws IOException 
		{
		ServerSocket serversocket=null;
		PrintWriter out=null;
		BufferedReader in=null;
		try
			{
			serversocket=new ServerSocket(8000);
			}	
		catch(IOException e)
			{
			System.out.println(e);
			System.exit(1);
			}
		Socket cs=null;
		try
			{
			cs=serversocket.accept();
			
			}
		catch(IOException e1)
			{
			System.out.println(e1);
			System.exit(1);
			}
		while(true)
			{
			try
				{
				out=new PrintWriter(cs.getOutputStream(),true);
				in=new BufferedReader(new InputStreamReader(cs.getInputStream()));

				String line=in.readLine();
				RandomAccessFile raf;
				long ptr,sz;
				int c=0;

				File f=new File(line);
				raf=new RandomAccessFile(f,"r");
				ptr=raf.getFilePointer();			
				sz=f.length();
				System.out.println("Size Of The File is:"+sz);
				while(sz!=-1)
					{
					raf.seek(sz);
					c=raf.read();
					System.out.print((char)c);
					sz--;
					}
				}
			catch(IOException e2)
				{
				System.out.println(e2);	
				System.exit(-1);
				}
			}
		}
	}