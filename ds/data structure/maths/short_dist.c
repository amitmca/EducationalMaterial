//the program for to find the dist betn two points and shortest dist

#include<stdio.h>
#include<conio.h>
#include<math.h>

void main()
{
int ax[10],ay[10],n,x1,y1,i,j,px1,px2,py1,py2,t1,t2,k;
float d,s,v;
clrscr();
printf("Enter How many points u wants :-> ");
scanf("%d",&n);
printf("Enter points....");
for(i=1;i<=n;i++)
scanf("%d%d",&ax[i],&ay[i]);
j=1;
k=1;
while(j<=n)
{
x1=ax[j];
y1=ay[j];
for(i=1;i<=n;i++)
{
if(i==j)
continue;
t1=(x1-ax[i]);
t2=(y1-ay[i]);
d=sqrt(pow(t1,2)+pow(t2,2));
v=d;
if(k==1)
{s=d;k++;}
if(s>=v)
{s=v;px1=x1;py1=y1;px2=ax[i];py2=ay[i];}
}
j++;k--;
printf("\n\n\tThe points which are nearest to each other are....");
printf("\n\n\tp1[%d,%d] and p2[%d,%d]",px1,py1,px2,py2);
printf("\n\n\tand Distance between points is....%.2f",s);
getch();
}
getch();
}


 out put

Enter How many points u wants :-> 3
Enter points....1 2
3 4
5 6


	The points which are nearest to each other are....

	p1[1,2] and p2[3,4]

	and Distance between points is....2.83

	The points which are nearest to each other are....

	p1[3,4] and p2[5,6]

	and Distance between points is....2.83

	The points which are nearest to each other are....

	p1[5,6] and p2[3,4]

	and Distance between points is....2.83


