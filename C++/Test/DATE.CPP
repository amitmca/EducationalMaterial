//Program for Date Swapping

#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

class date
	{
	int d1,d2;
	public:
		date()
		{
		d1=0;
		d2=0;
		}
		void get()
		{
		cout<<"Enter Date1:";
		cin>>d1;
		cout<<"\nEnter Date2:";
		cin>>d2;
		if( d1==0 || d2==0  ||  d1>31 || d2>31)
			{
			cout<<"\nPlease enter a valid date";
			exit(0);
			}
		}
		void put()
		{
		cout<<"Date1:"<<d1<<"\n";
		cout<<"Date2:"<<d2<<"\n";
		}
		void swap()
		{
		int t=d1;
		d1=d2;
		d2=t;
		}
	};
int main()
	{
	date obj;
	clrscr();
	obj.get();
	obj.put();
	obj.swap();
	obj.put();
	getch();
	return 0;
	}