import java.io.*;

class dirlist
	{
	public static void main(String args[])
		{
		String dirname="/mnt/D:/Programs/Java/io";
		File f1=new File(dirname);	
		if(f1.isDirectory())
			{
			System.out.println("Directory of:"+dirname);
			String s[]=f1.list();
			for(int i=0;i<s.length;i++)
				{
				File f=new File(dirname + "/"+s[i]);
				if(f.isDirectory())
					System.out.println(s[i]+ " is a Directory");
				else		
					System.out.println(s[i]+ " is not a Directory");
				}
			}
		else
			{
			System.out.println(dirname+ " is not a Directory");
			}
		}
	}
