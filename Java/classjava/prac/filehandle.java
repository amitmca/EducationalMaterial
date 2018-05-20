import java.io.*;

class filehandle
	{
	public static void main(String args[])throws IOException
		{
		String fname="";
		FileInputStream fin;
		DataInputStream dis=new DataInputStream(System.in);
		int i;
		try
			{
			System.out.println("Enter File name:");
			fname=dis.readLine();
			fin=new FileInputStream(fname);
			do
				{
				i=fin.read();
					if(i!=-1)
					System.out.print((char)i);
				}while(i!=-1);			
			}
		catch(FileNotFoundException e)
			{
			}
		catch(ArrayIndexOutOfBoundsException e1)
			{
			return;
			}
		}
	}