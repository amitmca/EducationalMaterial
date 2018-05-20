import java.io.*;

class string
{
	public static void main(String args[])throws Exception  
	{
		FileReader fr=new FileReader("abc.txt"); 
		BufferedReader br=new BufferedReader(fr);
		String line;
		int cnt=0;
		if(args.length==1)
		{
			while((line=br.readLine())!=null)
			{
				System.out.println(line);
				br.readLine();
			}
		}
		if(args.length==2 && args[0].equals("-c"))
		{
			while((line=br.readLine())!=null)
			{
				if((line.indexOf(args[0]))==-1)
				cnt++;
			}
		}
		System.out.println("No. of line contain string :"+cnt);

		if(args.length==2 && args[0].equals("-v"))
		{
			while((line=br.readLine())!=null)
			{
				if((line.indexOf(args[1]))==-1)
				System.out.println(line);
				br.readLine();
			}
		}
	}
}
