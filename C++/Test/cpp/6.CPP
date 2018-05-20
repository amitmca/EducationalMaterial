//PROGRAM FOR THE INITILIZING  THE OBJECT DYNAMIC

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class fixed_deposite
{
	long int p_amount;
	int years;
	float rate;
	float r_value;
	public:
			fixed_deposite(){}
			fixed_deposite(long int p,int y,float r=0.12);
			fixed_deposite(long int p,int y,int r);
			void display(void);
};
fixed_deposite::fixed_deposite(long int p,int y,float r)
{
	p_amount=p;
	years=y;
	rate=r;
	r_value=p_amount;
	for(int i=1;i<=y;i++)
		r_value=r_value*(1.0+r);
}
fixed_deposite::fixed_deposite(long int p,int y,int r)
{
		p_amount=p;
		years=y;
		rate=r;
		r_value=p_amount;

			for(int i=1;i<=y;i++)
				r_value=r_value*(1.0+float(r)/100);

}
void fixed_deposite::display(void)
{
		cout<<"\n\n"
			<<"\n\n\t\tPrinciple Amount="<<p_amount<<"\n\n"
			<<"\n\n\t\tReturn Value="<<r_value<<"\n\n";
}
int main()
{
	fixed_deposite fd1,fd2,fd3;
	long int p;
	int y;
	float r;
	int R;
	clrscr();
	cout<<"\n\nEnter the amount,period,intreset rate(in percentage)"<<"\n\n";
	cin>>p>>y>>R;
	fd1=fixed_deposite(p,y,R);
	cout<<"\n\nEnter the amount,period,intreset rate(in deciml)"<<"\n\n";
	cin>>p>>y>>r;
	fd2=fixed_deposite(p,y,r);

	cout<<"\n\nEnter the amount and period"<<"\n\n";
	cin>>p>>y;
	fd3=fixed_deposite(p,y);
	cout<<"\n\nDeposite 1:";
	fd1.display();
	cout<<"\n\nDeposite 2:";
	fd2.display();
	cout<<"\n\nDeposite 3:";
	fd3.display();
	getch();
	return 0;

}