import java.io.*;



class file	
	{
	public static void main(String args[])throws IOException 
		{
		FileInputStream fin;
		FileOutputStream fout;
		DataInputStream dis=new DataInputStream(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int c,choice;
		
		do
		{
		System.out.println("\t1) Read \n\t 2)tWrite \n\t 3) Exit");
		System.out.println("\tWhat is your choice ?  ");
		choice=Integer.parseInt(dis.readLine());
		switch(choice)
			{
			case 1:
			System.out.println("Enter File name to read:");		
			String fname=dis.readLine();
			try
				{
				fin=new FileInputStream(fname);
				do
					{
					c=fin.read();
					if(c!=-1)
						System.out.print((char)c);
					}while(c!=-1);
				}
			catch(FileNotFoundException e)
				{
				System.out.println("Please check the file existance");	
				return;
				}
			catch(ArrayIndexOutOfBoundsException e2)
				{
				return;
				}
			break;

			case 2:
			System.out.println("Enter File name to write:");		
			fname=dis.readLine();
			try
				{
				fout=new FileOutputStream(fname);
				System.out.println("Press 'q ' to exit");
				do
					{
					c=br.read();
					fout.write(c);
					}while(c!='q');
				}
			catch(FileNotFoundException e)
				{
				System.out.println("Please check the file existance");	
				return;
				}
			catch(ArrayIndexOutOfBoundsException e2)
				{
				return;
				}
			break;

			case 3:
				System.exit(0);
			}
		     }while(choice!=3);
		}
	}