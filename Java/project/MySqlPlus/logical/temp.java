import java.io.*;

class temp	
	{
	public static void main(String args[])
		{	
		try
			{	
			Runtime.getRuntime().exec("mysqldump -u root -p123456 MysqlPlus > C:/a.sql");
			ProcessBuilder p=new ProcessBuilder("C:\\WINDOWS\\System32\\cmd.exe");
			p.start();
			}
		catch(Exception e)
			{
			System.out.println(e.getMessage());
			}
		}
	}