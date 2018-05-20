import java.io.*;

class filecount
	{
	public static void main(String args[])
		{	
		FileInputStream fin;
		int wc,cc,lc,i=0;
		wc=cc=lc=0;
		try
			{
			fin=new FileInputStream("test.txt");
			while(i!=-1)
				{
				i=fin.read();
				if(i=='\n')
					lc++;
				else if(i==' ')
					wc++;
				}
			System.out.println("Total Number Of Lines:"+lc+"   " +wc);
			}
		catch(FileNotFoundException e)
			{
			}
		catch(ArrayIndexOutOfBoundsException e1)
			{
			return;
			}
		catch(IOException e2)
			{
			}
		}
	}