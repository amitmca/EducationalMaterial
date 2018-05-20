/*the program for the generation of n pts on ellipse*/

#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
{
int i,r,n;
float a,b,xl,e,xu,p,c,d,x[20],y[20];
clrscr();

printf("\nenter the value of n");
scanf("%d",&n);
printf("\nenter the semi major axis...");
scanf("%f",&a);
printf("\nenter the semi minor axis=");
scanf("%f",&b);
p=(2*3.14)/n;
c=cos(p);
d=b*sin(p)/a;
e=a*sin(p)/b;
x[0]=a;
y[0]=0;
for(i=0;i<=n-1;i++)
{
x[i+1]=x[i]*c+y[i]*e;
y[i+1]=x[i]*d+y[i]*c;
printf("%2.3f\t%2.3f\n",x[i],y[i]);
}
getch();
return 0;
}


/*  *** OUTPUT  ***

enter the value of n5

enter the semi major axis...3

enter the semi minor axis=12
3.000   0.000
0.929   11.410
3.000   7.066
2.609   13.598
4.040   14.132




  */




                                                                                
                                                                                
                                                                                
                                                                                
                                                                                


