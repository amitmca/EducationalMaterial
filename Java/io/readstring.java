import java.io.*;

class readstring
	{
	public static void main(String args[])throws IOException
		{
		String str;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 'stop' for quit");
		do
			{
			str=br.readLine();
			System.out.println(str);
			}while(!str.equals("stop"));
		}
	} 
