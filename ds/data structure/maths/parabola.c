/*the program for the generation of n pts on parabola*/
#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
{
int i,a,n;
float xl,xu,c,d,x[20],y[20],p1,p2,p3;
clrscr();
printf("\nenter the number of points...");
scanf("%d",&n);
printf("\nenter the value of a=");
scanf("%d",&a);
printf("\nenter the minimum value of x=");
scanf("%f",&xu);
printf("\nenter the maximum value of y=");
scanf("%f",&xl);
p1=sqrt(xl/a);
p2=sqrt(xu/a);
p3=(p2-p1)/(n-1);
c=p3;
d=2*a*p3;
x[0]=a*p1*p1;
y[0]=2*a*p1;
for(i=0;i<=n-1;i++)
{
x[i+1]=x[i]+y[i]*c+a*c*c;
y[i+1]=y[i]+d;
printf("%2.3f\t%2.3f\n",x[i],y[i]);
}
getch();
return 0;
}

      *** OUTPUT ***


enter the number of points...5

enter the value of a=3

enter the minimum value of x=3

enter the maximum value of y=12
12.000  12.000
9.188   10.500
6.750   9.000
4.688   7.500
3.000   6.000






                                                                                
                                                                                
                                                                                
                                                                                
                                                                                




