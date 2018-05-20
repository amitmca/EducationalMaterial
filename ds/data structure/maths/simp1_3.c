/*program for simpson's one third rule*/
#include<stdio.h>
#include<conio.h>
#include<math.h>
float f(float x);
void main()
{
float x0,x1,sol,h;
int n,i;
clrscr();
printf("\n enter the lower limit");
scanf("%f",&x0);
printf("\n enter the upper limit");
scanf("%f",&x1);
printf("\n enter the number of steps");
scanf("%d",&n);
h=(x1-x0)/n;
sol=0;
for(i=1;i<n;i++)
{
if(i%2==0)
sol=sol+2*f(x0+i*h);
else
sol=sol+4*f(x0+i*h);
}
sol=f(x0)+f(x1)+sol;
sol=(h/3)*sol;
printf("\value of itegration %f",sol);
getch();
}
float f(float x)
{
return(x*x-2);
}































                                                                                
                                                                                
                                                                                
                                                                                

