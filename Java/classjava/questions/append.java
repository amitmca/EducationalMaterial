import java.io.*;

class append 
	{
	public static void main(String args[])
		{
		FileOutputStream fout;
		System.out.println("Enter the String to be Appended:");
		DataInputStream dis=new DataInputStream(System.in);
		String str="";
		byte[] b;
		try
			{
			fout=new FileOutputStream("amit.txt",true);
			str=dis.readLine();
			b=str.getBytes();
			for(int i=0;i<b.length;i++)
				fout.write(b[i]);
			fout.
			System.out.println("String Appended");
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