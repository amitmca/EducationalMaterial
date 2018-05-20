import java.io.*;


class dtb
	{
	public static void main(String args[])throws IOException
		{
		System.out.println("Enter Decimal Number==>");	// Converting Decimal To Binary

		DataInputStream dis=new DataInputStream(System.in);

		int dec=Integer.parseInt(dis.readLine());

		int dec1=dec;

		int r[]=new int[20];

		int i=0;

		while(dec>0)
			{
			r[i]=dec%2;
			i++;
			dec=dec/2;
			}	
		
		System.out.println("Binary Number is==>");
		for(int j=i-1;j>=0;j--)
			System.out.println(r[j]);

		 i=0;					// Converting Decimal To Octal
		while(dec1>0)
			{
			r[i]=dec1%8;
			i++;
			dec1=dec1/8;
			}
		System.out.println("Octal Number is==>");
		for(int j=i-1;j>=0;j--)
			System.out.println(r[j]);	


		System.out.println("Enter Binary Number==>");		// Converting Binary To Decimal 	
		
		int bin=Integer.parseInt(dis.readLine());

		int rem;
		double d=0;

		i=0;

		while(bin>0)
			{
			rem=bin%10;
			d=d+rem*Math.pow(2,i);
			i++;
			bin=bin/10;					
			}

		System.out.println("Decimal Number is==>"+d);	

		i=0;							// Converting Binary To Octal

		int d1=(int)d;		

		while(d1>0)
			{
			r[i]=d1%8;
			i++;
			d1=d1/8;
			}	
		
		System.out.println("Octal Number is==>");
		for(int j=i-1;j>=0;j--)
			System.out.println(r[j]);
				
		}
	}