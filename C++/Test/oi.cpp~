#include<iostream.h>
#include "conio.h"
class test
	{
	int a,b;
	public:
		
	friend ostream & operator <<(ostream &s,test &t);
	friend istream & operator >>(istream &s,test &t);
	};
istream & operator >>(istream &s,test &t)
	{
	cout<<"\nEnter the values of a and b:";
	s>>t.a>>t.b;
	} 
ostream & operator <<(ostream &s,test &t)
	{
	s<<"\n Values Of a and b are:\n";
	s<<"a="<<t.a<<"\tb="<<t.b<<"\n";
	}
int main()
	{
	test t;
	clrscr();
	cin>>t;
	cout<<t;
	getch();
	return 0;
	}	
