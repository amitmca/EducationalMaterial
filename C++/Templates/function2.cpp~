//Program for explicitly overloading Function Templates 

#include<iostream.h>
#include "conio.h"

template<class T>
void swap(T &a,T &b)
	{
	T temp=a;
	  a=b;
	  b=temp;
	cout<<"\n Inside function template\n";
	}

void swap(int &a,int &b)
	{
	int temp=a;
	    a=b;
	    b=temp;	
	cout<<"\n Inside integer swap function";
	}

int main()
	{
	int i=30,j=40;
	double p=20.5,q=30.5;
	char a='x',b='z';
	clrscr();
	cout<<"Original i,j==>"<<i<<' '<<j<<endl;
	cout<<"Original p,q==>"<<p<<' '<<q<<endl;
	cout<<"Original a,b==>"<<a<<' '<<b<<endl;
	swap(i,j);
	swap(p,q);
	swap(a,b);
	cout<<endl;
	cout<<"swapped i,j==>"<<i<<' '<<j<<endl;
	cout<<"swapped p,q==>"<<p<<' '<<q<<endl;
	cout<<"swapped a,b==>"<<a<<' '<<b<<endl;
	getch();
	return 0;
	}
