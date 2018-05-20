import java.net.*;
import java.io.*;

public class server
	{	
	public static void main(String args[])throws Exception
		{
		string csen;
		String casen;

		ServerSocket wc=new ServerSocket(8080);

		while(true)
			{
			Socket connsc=ws.accept();

			BufferedReader infrmcli=new BufferedReader(new InputStreamReader(connsc.getInputStream()));

			DataOuputStream outcli=new DataOutputStream(connsc.getOutputStream());

			csen=inusr.readLine();

			casen=csen.toUpperCase()+'\n';

			outcli.writeBytes(csen);
			}
		
		}
	}