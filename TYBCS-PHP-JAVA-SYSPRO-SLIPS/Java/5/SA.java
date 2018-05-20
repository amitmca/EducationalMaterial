import java.lang.*;
import java.io.*;
import java.util.*;
class Invalid extends Exception
{
	Invalid()
	{
		System.out.println("Less Amount");
	}
}
class SA
{
	int ano;
	String name;
	int bal;
	SA()
	{

	}
	SA(int ano,String name,int bal)
	{
		this.ano=ano;
		this.name=name;
		
		try
		{
			if(bal<=500)
			{
				throw new Invalid();
			}
		}
		catch(Invalid e)
		{
			System.out.println(e);
			System.exit(0);
		}
		finally
		{
			this.bal=bal;
		}



	}
	void view()
	{
		System.out.println("Total Balance = "+bal+"\n");
	}

	void draw(int amt)
	{
		try
		{
			if(bal<=500)
			{
				throw new Invalid();
			}
		}
		catch(Invalid e)
		{
			System.out.println(e);
			System.exit(0);
		}
		finally
		{
			bal=bal-amt;
			System.out.println("WithDraw Amt = "+amt);
			System.out.println("Available Bal = "+bal);
		}
	}
	
	void dep(int amt)
	{
		try
		{
			if(bal<=500)
			{
				throw new Invalid();
			}
		}
		catch(Invalid e)
		{
			System.out.println(e);
			System.exit(0);
		}
		finally
		{	
			bal=bal+amt;
			System.out.println("Deposit Amt = "+amt);
			System.out.println("Available Bal = "+bal);
		}
	}

	public static void main(String args[])throws Exception
	{
		int ano;
		String name;
		int bal;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SA s = new SA(1,"A",600);
		s.view();
		s.dep(100);
		s.draw(200);
	}


}
