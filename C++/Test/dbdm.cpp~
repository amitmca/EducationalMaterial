//Program for adding 2 object values

#include<iostream.h>
#include "conio.h"

class DB
	{
	protected:
		int m,cm,i,f;
	public:
	
		void getdata()
		{
		cout<<"\n Details For DB Class:\n";
		cout<<"\n Meters:"; cin>>m;
		cout<<"\n Centimeters:"; cin>>cm;
		cout<<"\n Inches:"; cin>>i;
		cout<<"\n Feets:"; cin>>f;
		}
	};

class DM
	{
	protected:
		int m,cm,i,f;
	public:
		void getdata()
		{
		cout<<"\n Details For DM Class:\n";
		cout<<"\n Meters:"; cin>>m;
		cout<<"\n Centimeters:"; cin>>cm;
		cout<<"\n Inches:"; cin>>i;
		cout<<"\n Feets:"; cin>>f;
		}
	};

class A:public DB,public DM
	{
	int m,cm,i,f;
	public:
		
		void adddata()
		{
		DB::getdata();
		DM::getdata();
		m=DB::m+DM::m;
		cm=DB::cm+DM::cm;
		i=DB::i+DM::i;
		f=DB::f+DM::f;
		}
		void putdata()
		{
		cout<<"Meters:"<<m<<endl;
		cout<<"Centimeters:"<<cm<<endl;
		cout<<"Inches:"<<i<<endl;
		cout<<"Feets:"<<f<<endl;
		}
	};
int main()
	{
	A obj;
	clrscr();
	obj.adddata();
	obj.putdata();
	getch();
	return 0;
	}
