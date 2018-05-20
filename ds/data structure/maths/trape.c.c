/*program for TRAPEZOIDAL rule*/
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
sol=sol+f(x0+i*h);
}
sol=2*sol;
sol=f(x0)+f(x1)+sol;
sol=(h/2)*sol;
printf("\value of itegration %f",sol);
getch();
}
float f(float x)
{
return(x*x-1);
}


	   ***	OUTPUT      ***


 enter the lower limit1

 enter the upper limit10

 enter the number of steps5
 Value of iteration 328.859955







                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
