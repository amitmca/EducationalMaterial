//Program for Passing Object as an argument

#include<iostream.h>
#include<conio.h>

class time
	{
	int hour,minute;
	public:
		void gettime(int h,int m)
			{
			hour=h;
			minute=m;
			}
		void puttime(void)
			{
			cout<<hour<<" hrs "<<minute<<" mins\n " ;
			}
		void sum(time,time);		// objects as arguments
	};

void time::sum(time t1,time t2)
	{
	minute=t1.minute+t2.minute;
	hour=minute/60;
	minute=minute%60;
	hour=hour+t1.hour+t2.hour;
	}

int main()
	{
	time T1,T2,T3;
	clrscr();
	T1.gettime(2,40);
	T2.gettime(5,30);
	T3.sum(T1,T2);
	cout<<"\nT1:";	T1.puttime();
	cout<<"\nT2:";	T2.puttime();
	cout<<"\nT3:";	T3.puttime();
	getch();
	return 0;
	}
