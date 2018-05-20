import java.net.*;
import java.io.*;

public class MyServer1
	{
	public static void main(String args[])throws Exception
		{
		String sen;
		String msen;

		BufferedReader inusr=new BufferedReader(new InputStreamReader(System.in));

		Socket cs=new Socket(InetAddress.getLocalHost(),8080);

		DataOutputStream outtoser=new DataOutputStream(cs.getOutputStream());
	
		BufferedReader inser=new BufferedReader(new InputStreamReader(cs.getInputStream()));		

		sen=inusr.readLine();

		outtoser.writeBytes(sen + '\n');

		msen=inser.readLine();

		System.out.println("FROM SERVER:"+msen);

		cs.close();

		}
	}