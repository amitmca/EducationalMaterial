import java.io.*;

class decrypt
	{	
	public static void main(String args[])
		{
		FileOutputStream fout;
		PrintWriter pw;
		try
			{
			DataInputStream dis=new DataInputStream(System.in);

			System.out.println("Enter A String To Encrypt:");

			String str=dis.readLine();

			char[] array=str.toCharArray();

			for(int i=0;i<array.length;i++)

				array[i]--;
			String e=new String(array);

			System.out.println("Encrypted String is:"+e);

			fout=new FileOutputStream("test.txt",true);

			pw=new PrintWriter(fout,true);

			byte[] b =e.getBytes();

			for(int j=0;j<b.length;j++)
				{
				fout.write(b[j]);
				}
			pw.println();
			System.out.println("String is appended");
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}