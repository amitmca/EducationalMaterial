//Dynamic Initialization Of Objects

#include<iostream.h>
#include<conio.h>

class fixed_deposit
	{
	long int p_amount;
	int years;
	float rate;
	float R_value;
	public:
	fixed_deposit()
	{
	}
	fixed_deposit(long int p,int y,float r=0.15);
	fixed_deposit(long int p,int y,int r);
	void display(void);
	};
fixed_deposit::fixed_deposit(long int p,int y,float r)
	{
	p_amount=p;
	years=y;
	rate=r;
	R_value=p_amount;
	for(int i=1;i<=y;i++)
	R_value=R_value*(1.0+r);
	}
fixed_deposit::fixed_deposit(long int p,int y,int r)
	{
	p_amount=p;
	years=y;
	rate=r;
	R_value=p_amount;
	for(int i=1;i<=y;i++)
	R_value=R_value*(1.0+float(r)/100);

	}
void fixed_deposit::display(void)
	{
	cout<<"\n"<<"Principle Amount="<<p_amount
		<<"\n"<<"Return Value="<<R_value<<"\n";
	}
	int main()
	{
	fixed_deposit FD1,FD2,FD3;
	long int p;
	int y;
	float r;
	int R;
	clrscr();
	cout<<"Enter amount,Period,Interest,Rate(in percent)"<<"\n";
	cin>>p>>y>>R;
	FD1=fixed_deposit(p,y,R);
	cout<<"Enter amount,Period,Interest,Rate(in decimal)"<<"\n";
	cin>>p>>y>>r;
	FD2=fixed_deposit(p,y,r);
	cout<<"Enter amount,Period"<<"\n";
	cin>>p>>y;
	FD3=fixed_deposit(p,y);
	cout<<"\n Deposit 1=";
	FD1.display();
	cout<<"\n Deposit 2=";
	FD2.display();
	cout<<"\n Deposit 3=";
	FD3.display();
	getch();
	return(0);
	}





