import java.net.*;
import java.io.*;

public class server
	{	
	public static void main(String args[])throws Exception
		{
		String csen;
		String casen;

		ServerSocket ws=new ServerSocket(8080);

		while(true)
			{
			Socket connsc=ws.accept();

			BufferedReader infrmcli=new BufferedReader(new InputStreamReader(connsc.getInputStream()));

			DataOutputStream outcli=new DataOutputStream(connsc.getOutputStream());

			csen=infrmcli.readLine();

			casen=csen.toUpperCase()+'\n';

			outcli.writeBytes(csen);
			}
		
		}
	}