import java.util.*;
import java.io.*; 
public class sampledb1 
{   
	public static void main(String[] args) 
	{    
	try
	  {  
	  System.out.println("database connect");
	  Runtime rt = Runtime.getRuntime(); 
	  rt.exec("C:/Program Files/MySQL/MySQL Server 5.0/bin/mysqldump -uroot -pamit12 MysqlPlus -r/D:/backup.sql");
	  }   
	catch(IOException ioe)  
	 { 
	 ioe.printStackTrace();  
	 }  
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 }
	} 
 }