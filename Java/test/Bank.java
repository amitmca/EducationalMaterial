import java.io.*;
 interface transaction
	{
	public void deposit(float bal1);
	public void withdrawl(float bal1);
	public void Balance_Enquiry();
	}

 interface ac_mgmt
	{
	public void open_ac(int accountno,String name,float bal,String actype);
	public void get_ac_details(int ano);
	}

 class Account implements transaction,ac_mgmt
	{
	public int acno=0;
	public String cname="";
	public float balance=0.0f;
	public void open_ac(int accountno,String name,float bal,String actype)
		{
		acno=accountno;
		cname=name;
		balance=bal;
		System.out.println("Account Open Successful\n");
		System.out.println("Account No:"+acno+"\nAccount Type"+actype+"\nCustomer Name:"+cname+"\nBalance:"+balance+"\n");

		}
	public void get_ac_details(int ano)
		{
		if(ano==acno)
			System.out.println("Account No:"+acno+"\nCustomer Name:"+cname+"\n Balance:"+balance);
		else
			System.out.println("Please enter correct Account number\n");	
		}
	public void deposit(float bal1)
		{	
			balance=balance+bal1;
		}
	public void withdrawl(float bal1)
		{
			balance=balance-bal1;
		}
	public void Balance_Enquiry()
		{
		System.out.println("Your Balance is :\t"+balance);	
		}
	}

class Savings extends Account
	{
	public double balance_int=0.0;
	public Savings()
		{	
		balance_int=balance+balance*0.07;
		}
	}
class Current extends Account
	{
	public double  balance_int1=0.0;
	public Current()
		{
		balance_int1=balance+balance*0.03;	
		}
	}	

 class Bank
	{
	public static void main(String args[])
		{
		Account ac_obj=new Account();
		Savings sobj=new Savings();
		DataInputStream dis=new DataInputStream(System.in);
		int choice=0;
		do
			{ 
			System.out.println(" ********** MENU ******* \n");
			System.out.println(" 1) Open A/c \n 2) Enquiry \n 3) Deposit Amount \n 4) Withdaw Money \n 5) Balance Enquiry\n");
			System.out.println(" Please enter your choice:");
			try
				{
				choice=Integer.parseInt(dis.readLine());
				
				switch(choice)
					{
					case 1:
						ac_obj.open_ac(100,"Amit",500,"Savings");
						break;

					case 2:
						ac_obj.get_ac_details(100);
						break;
					
					case 3:
						ac_obj.deposit(1000);
						break;

					case 4:
						if(ac_obj.balance<500)
						{
						System.out.println("Low Balance");
						}
						else
						{
						ac_obj.withdrawl(300);
						}
						break;

					case 5:
						System.out.println("Balance:"+ac_obj.balance);
						break;
					}	
				}	
			catch(Exception e)
				{
				System.out.println(e.getMessage());
				}
			}while(choice!=6);
		
		
		}
	}