import java.util.*;
import java.io.*;

class CricketPlayer
{
	String name;
	int inn;
	int notout;
	int trun;
	static int batavg1;
	int batavg;
	
	public CricketPlayer(String name,int inn,int notout,int trun,int batavg)
	{
		this.name=name;
		this.inn = inn;
		this.notout = notout;
		this.trun = trun;
		this.batavg = batavg;
	}
	static int avg(int inn,int notout,int trun)
	{
		try
		{
			batavg1 = (trun/(inn-notout));
			return batavg1;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
			return 0;
		}
		
	}
	public  String toString()
	{
		return("name="+name+"\ninn="+inn+"\nnot out="+notout+"\ntrun="+trun+"\nbatavg="+batavg);
	}
	static void sort(CricketPlayer[] c)
	{
		int  temp ,i;  //= new CricketPlayer();
		for(i=0;i<c.length;i++)
		{
			for(int j=0;j<c.length-1;j++)
			{
				if(c[j].batavg > c[j+1].batavg)
				{
				temp = c[j].batavg;
				c[j].batavg = c[j+1].batavg;
				c[j+1].batavg = temp;
				}
			}
			
		}
		for(i=0;i<c.length;i++)
		{
			System.out.println(c[i]);
		}
	}
}
public class CricketPlay
{
	public static void main(String[] args)
	{
		int n,i;
                //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner s =new 	Scanner(System.in);
		System.out.println("Enter Size");
		n = s.nextInt();
		String name;
		int inn,notout,trun,batavg;
		
		CricketPlayer[] c1 = new CricketPlayer[n];
		for(i =0; i<n;i++)
		{
			System.out.println("name, no of inning notout totla run");
			name = s.next();
			inn = s.nextInt();
			notout = s.nextInt();
			trun = s.nextInt();
			
			batavg = CricketPlayer.avg(inn,notout,trun);
			
			c1[i] = new CricketPlayer(name, inn,notout,trun,batavg);
			System.out.println(c1[i]);
		}
		 CricketPlayer.sort(c1);
		/*System.out.println("Sorted data = \n");
		for(i=0;i<n;i++)
		{
			System.out.println(c1[i]);
		}*/
	}
}
