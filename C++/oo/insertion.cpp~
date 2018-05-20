// Program for overloading insertion (<<) and extraction(>>) operator

#include<iostream.h>
#include "conio.h"

class dist
	{
	int feet;
	public:
		dist()	
		{
		feet=0;
		}
		friend istream & operator >>(istream &s,dist &d);
		friend ostream & operator <<(ostream &s,dist &d);
	};
istream & operator >>(istream &s,dist &d)
	{
	cout<<"Enter Feet:";
	s>>d.feet;
	return(s);
	}
ostream & operator <<(ostream &s,dist &d)
	{
	s<<d.feet;
	return(s);
	}
int main()
	{
	dist obj;
	clrscr();
	cin>>obj;
	cout<<obj;
	getch();
	return 0;
	}
