/*the program for newtons forward difference */

#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
int a[10],b[10],c[10][10],n,i,j,k,x,h,x0,z,f;
float u,y,x1;
clrscr();
printf("\nhow many points u wants");
scanf("%d",&n);
printf("\nEnter the point   ");
for(i=1;i<=n;i++)
scanf("%d%d",&a[i],&b[i]);
for(i=1;i<=n;i++)
c[1][i]=b[i];
h=a[2]-a[1];
x0=a[1];
printf("\n\n\tForword Diff. Table is....");
printf("\n\tX\tY\n");
j=1;
for(i=1;i<=n;i++)
{
printf("\t%d\t%d",a[i],b[i]);
printf("\n");
}
for(i=2;i<=n;i++)
{
printf("\nDifference %d",(i-1));
for(j=1;j<=(n-(i-1));j++)
{c[i][j]=c[(i-1)][(j+1)]-c[(i-1)][j];
printf("\n%d",c[i][j]);}
}
getch();
printf("Now....");
printf("\n\tBy Applying Newtons Forword diff. Formula for Equal Intervals...\n");
printf("\n\tY0+UD1Y0+U(U-1)D2Y0+.....");
printf("\n\tWhere U=x-x0/h ");
printf("\n\tEnter Value of X1 :=> ");
scanf("%f",&x1);
x0=x1-a[1];
u=x0/h;
z=u;
y=c[1][1];
for(i=2;i<=n;i++)
{
f=1;
for(j=1;j<i;j++)
f=f*j;
y=y+((z*c[i][1])/f);
z=z*(u-(i-1));
}
printf("%.2f",y);
getch();
}



		***OUTPUT***

Enter the point   1
1
2
4
3
9


	Forword Diff. Table is....
	X       Y
        1       1                                                               
        2       4                                                               
        3       9                                                               
                                                                                
Difference 1                                                                    
3                                                                               
5                                                                               
Difference 2
2
Now....
	By Applying Newtons Forword diff. Formula for Equal Intervals...

	Y0+UD1Y0+U(U-1)D2Y0+.....
	Where U=x-x0/h
	Enter Value of X1 :=> 4
16.00
