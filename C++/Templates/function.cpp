//Program for Function Templates

#include<iostream.h>
#include "conio.h"

template<class T>

T getMax(T a,T b)		// Function Template
	{	
	T r;
	r=(a>b)?a:b;
	return r;
	}	

int main()
	{
	int i=5,j=6,k;
	long l=10,m=5,n;
	clrscr();
	k=getMax(i,j);
	n=getMax(l,m);
	cout<<"k="<<k<<endl;
	cout<<"n="<<n<<endl;
	getch();
	return 0;
	}
