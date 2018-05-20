/*  program for addition using function((int))  */
#include<iostream.h>
#include<conio.h>
long int sum(int x,int y)
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
return(0);
}