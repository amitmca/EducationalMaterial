#include<iostream.h>
#include<conio.h>

template<class T>
void swap(T &x,T &y)
	{
	T temp=x;
	  x=y;
	  y=temp;
	}

int main()
	{
	int a=10,b=20;
	float c=15.5,d=25.5;
	clrscr();
	swap(a,b);
	cout<<a<<"\t"<<b<<endl;
	swap(c,d);
	cout<<c<<"\t"<<d;
	getch();
	return 0;
	}