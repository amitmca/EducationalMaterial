import java.util.*;
interface Creditcard
{
	public void viewCreditAmount();
	public void useCard();
	public void payCredit();
	public void increaseLimit();
}
class Silvercard implements Creditcard
{
	String name;
	int cid;
	int camt;
	int climit;
	public Silvercard()
	{
	}
	public Silvercard(String name,int cid)
	{
		this.name=name;
		this.cid=cid;
		camt=0;
		climit=50000;
	}
	public void viewCreditAmount()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount :");
		int amt=sc.nextInt();
		int temp=camt+amt;
		if(temp>climit)
		{
			System.out.println("Failed....Due to transaction");
		}
		else
		{
			camt=temp;
			System.out.println("Transaction done.....");
		}
	}
	public void payCredit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount :");
		int amt=sc.nextInt();
		camt=camt-amt;
		System.out.println("Credit paid");
	}
	public void increaseLimit()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount :");
		int amt=sc.nextInt();
		climit=climit+amt;
		System.out.println("Limit increased"+climit);
	}
	public void useCard()
	{
		System.out.println("Enter Amt:");
		Scanner sc=new Scanner(System.in);
		int amt=sc.nextInt();
		if(camt<amt)
		{
			System.out.println("Insufficient Amt.");
		}
		else
		{
			camt=camt-amt;
		}
	}

}
class Goldcard extends Silvercard
{
	public Goldcard()
	{
	}
	public Goldcard(String name,int cid)
	{
		super(name,cid);
		climit=100000;
	}
}

class Asssetb2
{
	public static void main(String args[])
	{
	System.out.println("Enter 1 - Silvercard 2- Goldcard");
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	if(choice==1)
	{
	Silvercard s1=new Silvercard();
	while(true)
	{
	System.out.println("\n 1.ViewCreditAmount 2.UseCard 3.PayCredit 4.IncreaseLimit 5.exit\n Choice:");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			s1.viewCreditAmount();
			break;
		case 2:
			s1.useCard();
			break;
		case 3:
			s1.payCredit();
			break;
		case 4:
			s1.increaseLimit();
			break;
		case 5:
			System.exit(0);
		}
	}//End of While
	}
	if(choice==2)
	{
	Goldcard s2=new Goldcard();
	while(true)
	{
	System.out.println("\n 1.ViewCreditAmount 2.UseCard 3.PayCredit 4.IncreaseLimit 5.exit");
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			s2.viewCreditAmount();
			break;
		case 2:
			s2.useCard();
			break;
		case 3:
			s2.payCredit();
			break;
		case 4:
			s2.increaseLimit();
			break;
		case 5:
			System.exit(0);
		}
	}//End of While
	}

	}//main
}
