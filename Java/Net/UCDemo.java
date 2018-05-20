import java.net.*;
import java.io.*;
import java.util.Date;

public class UCDemo
	 {
	 public static void main(String[] args)throws Exception 
    	{
    	int c;
    	URL hp=new URL("http://localhost/Tennis/aboutus.htm");
    	URLConnection hpcon=hp.openConnection();
 		System.out.println("Date:"+new Date(hpcon.getDate()));   
		System.out.println("Content Type:"+hpcon.getContentType());
		System.out.println("Expires:"+hpcon.getExpiration());
		System.out.println("Last-Modified"+new Date(hpcon.getLastModified()));
		int len=hpcon.getContentLength();
		System.out.println("Content-Length:"+len);
		if(len>0)
			{
			System.out.println("===== Content =====");
			InputStream input=hpcon.getInputStream();
			int i=len;
			while(((c=input.read())!=-1) &&(-i>0))
				{
					System.out.println((char)c);
				}
			
			}	
		else
			{
				System.out.println("No Content Available");
			}				
        }
}
