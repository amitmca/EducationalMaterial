/*  Overloading  */
/*  program for addition using function((float))  */

#include<iostream.h>
#include<conio.h>

long int sum(int a,int b)
	{
	return(a+b);
	}
float sum(float x,float y)
	{
	return(x+y);
	}
int main(void)
	{
	int m,n,s;
	clrscr();
	m=12;
	n=12;
	s=sum(m,n);
	cout<<"\nsum s="<<s;
	float k,l,q;
	k=12.22f;
	l=10.66f;
	q=sum(k,l);
	cout<<"\nsum q="<<q;
	return(0);
	}