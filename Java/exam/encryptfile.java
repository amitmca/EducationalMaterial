import java.io.*;

class encryptfile
	{	
	public static void main(String args[])
		{
			
		FileInputStream fin;
		FileOutputStream fout;
		int j;
		String str;
		PrintWriter pw;
		try
			{
			DataInputStream dis=new DataInputStream(System.in);
			System.out.println("Enter A file Name to be encrypted:");
			String fname=dis.readLine();
			fin=new FileInputStream(fname);
			fout=new FileOutputStream("temp.txt");
			do
				{
				j=fin.read();
				if(j!=-1)
					{
					str=Integer.toString(j);

					char[] array=str.toCharArray();

					for(int i=0;i<array.length;i++)

						array[i]++;
					String e=new String(array);
					
					pw=new PrintWriter(fout,true);

					byte[] b =e.getBytes();

					for(int k=0;k<b.length;k++)
						{
						fout.write(b[k]);
						}
					
					}
				}while(j!=-1);
			}
		catch(Exception e)
			{
			System.out.println(e);
			}
		}
	}