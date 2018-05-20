//  program for newtons 1/3 rule

#include<iostream.h>
#include<conio.h>
#include<math.h>
float f(float x);
int main(void)
{
float sol,x0=1,x1=10,h;
int n=5,i;
clrscr();
cout<<"\n The value of x0=";
cin>>x0;
cout<<"\n The value of x1=";
cin>>x1;
cout<<"\n The no.of steps=";
cin>>n;
h=(x1-x0)/n;
sol=0;
for(i=1;i<n;i++)
{
if(i%2==0)
sol=(sol+2*f(x0+i*h));
else
sol=(sol+4*f(x0+i*h));
}
sol=f(x0)+f(x1)+sol;
sol=(h/3)*sol;
cout<<"\n The value of iteration ="<<sol;
return 0;
}
float f(float x)
{
return(x*x-2);
}