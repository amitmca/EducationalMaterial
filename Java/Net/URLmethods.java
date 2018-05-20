import java.net.*;

public class URLmethods
	 {
	 public static void main(String[] args) 
    	{
    		try
    		{
    			URL myurl=new URL("http://localhost:80/Tennis/index.htm");
    			System.out.println("Protocol :"+myurl.getProtocol());
    			System.out.println("HostName :"+myurl.getHost());
    			System.out.println("Port :"+myurl.getPort());
    			System.out.println("Filename :"+myurl.getFile());
    			System.out.println("Reference :"+myurl.getRef());
    		}
    		catch(MalformedURLException e)
    		{
    		
    		}
        }
}
