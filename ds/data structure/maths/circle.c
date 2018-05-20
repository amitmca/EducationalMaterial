/*the program for the generation of n pts on circle*/

#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
{
int i,r,n;
float xl,xu,p,q,c,d,x[20],y[20],p1,p2,p3;
clrscr();
printf("\nenter the number of points...");
scanf("%d",&n);
printf("\nenter the value of a=");
scanf("%d",&r);
d=(2*3.14)/n;
p=cos(d);
q=sin(d);
x[0]=r;
y[0]=0;
for(i=0;i<=n-1;i++)
{
x[i+1]=x[i]*p-y[i]*q;
y[i+1]=x[i]*q+y[i]*q;
printf("%2.3f\t%2.3f\n",x[i],y[i]);
}
getch();
return 0;
}








                                                                                
                                                                                
                                                                                



