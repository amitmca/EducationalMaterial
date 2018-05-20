import java.util.*;
import java.io.*;
import java.net.*;


class server
{
	public static void main(String args[])throws Exception
	{
		ServerSocket ss =new ServerSocket(4000);
		Socket sc = ss.accept();
		
		System.out.println("Welcome to the server.... Waiting for client....");
		Date d= new Date();
		
		DataOutputStream dos = new  DataOutputStream(sc.getOutputStream());
		
		dos.writeUTF(d+"");
	}

}

class client
{
	public static void main(String args[])throws Exception
	{
		Socket sc = new Socket("localhost",4000);
		System.out.println("Welcome to client..");
		DataInputStream dis = new  DataInputStream(sc.getInputStream());
		System.out.println(dis.readUTF());
	}


}
