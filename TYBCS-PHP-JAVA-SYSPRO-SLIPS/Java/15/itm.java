import java.io.*;
import java.lang.*;

class ItemInfo
{
	int id,quantity;
	String name;
	long price;

	ItemInfo()
	{
	}

	ItemInfo(int id,String name,long price,int quantity)
	{
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}

	long store(RandomAccessFile f) throws Exception
	{
		String sid="",sprice="",squantity="";

		sid+=id;
		sprice+=price;
		squantity+=quantity;

		long pos=f.getFilePointer();

		
		f.writeUTF(sid);
		f.writeUTF(name);
		f.writeUTF(sprice);
		f.writeUTF(squantity);

		return pos;
	}

	void access(RandomAccessFile f) throws Exception
	{
		id=Integer.parseInt(f.readUTF());
		name=f.readUTF();
		price=Long.parseLong(f.readUTF());
		quantity=Integer.parseInt(f.readUTF());

		System.out.println(toString());
	}

	public String toString()
	{
		return "Id = "+id+"\tName= "+name+"\tPrice= "+price+"\tQuantity = "+quantity;
	}
}

class Setb1
{
	public static void main(String args[])throws Exception
	{
		RandomAccessFile f=new RandomAccessFile("Item.dat","rw");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		ItemInfo I;

		long max=0,total=0;

		System.out.println("How many records :");
		int n=Integer.parseInt(br.readLine());

		String nameTable[]=new String[n];
		long posTable[]=new long[n];
		
		long costTable[]=new long[n];

		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Details");

			System.out.println("Enter Item Id : ");
			int id=Integer.parseInt(br.readLine());

			System.out.println("Enter Item Name : ");
			String name=br.readLine();

			System.out.println("Enter Item Price : ");
			long price=Long.parseLong(br.readLine());

			System.out.println("Enter Item Quantity : ");
			int quantity=Integer.parseInt(br.readLine());

			I=new ItemInfo(id,name,price,quantity);

			nameTable[i]=name;

			costTable[i]=(price*quantity);
			posTable[i]=I.store(f);
		}
		f.close();

		boolean done=false;

		RandomAccessFile f1=new RandomAccessFile("Item.dat","r");

		ItemInfo I1=new ItemInfo();

		while(!done)
		{
			System.out.println("1.Search by name");
			System.out.println("2.Find costliest item");
			System.out.println("3.Display all item and total cost");
			System.out.println("Enter choice");
			int choice=Integer.parseInt(br.readLine());

			switch(choice)
			{
				case 1 :
					System.out.println("Enter Name to search :");
					String name=br.readLine();
					boolean found=false;
					for(int i=0;i<n;i++)
					{
						if(nameTable[i].equals(name))
						{
							found=true;
							f1.seek(posTable[i]);
							I1.access(f1);
						}
					}
					if(!found)
						System.out.println("Sorry , record not found . . . ");
					break;
				case 2 : 
					for(int i=0;i<n;i++)
					{
						if(costTable[i] > max)
							max=costTable[i];
					}
					for(int i=0;i<n;i++)
					{
						if(costTable[i]==max)
						{
							f1.seek(posTable[i]);
							I1.access(f1);
						}
					}
					break;
				case 3 :

					for(int i=0;i<n;i++)
					{
						f1.seek(posTable[i]);
						I1.access(f1);
						total+=costTable[i];
					}
					System.out.println("\t\t\t\tTotal Amount : "+total);
					break;
			}
			System.out.println("Do you want to continue (Y/N) :");
			String ans=br.readLine();
			if(ans.equals("N"))
				done=true;
		}
	}
}

