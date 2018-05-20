import java.lang.*;
import java.util.*;
import java.io.*;
import java.io.File;
import java.lang.String;

class phone
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		FileReader fw = new FileReader("ph.txt");
		BufferedReader fr = new BufferedReader(fw);

		FileWriter fp = new FileWriter("ph.txt",true);
		BufferedWriter fq = new BufferedWriter(fp);
		
		
		String s;
		int i;
  		String c;
		String name;
		int no;
		String add;

		
		while(true)
		{	
			System.out.println("\nEnter the \n1.search\n2.add\n3.exit");
			i=Integer.parseInt(br.readLine());	
			switch(i)
			{
				case 1:
				{
					System.out.println("Enter the name");
					s=br.readLine();
					while((c=fr.readLine())!=null)
					{
						if(c.contains(s))
						{
						String str = c;
						System.out.println(str);
						String[] a=str.split("\t");
						System.out.println(a[0]);
						}

					}
				
					break;		

				}
				case 2:
				{
					System.out.println("Enter your name");
					name=br.readLine();
					System.out.println("Enter your no.");
					no=Integer.parseInt(br.readLine());
					fq.write(name);	
					fq.write("\t");
					fq.write(no);		
					break;

				}
				case 3:
				{
					System.exit(0);
				}
			
		
			}

	
		}



	}

}
