#include<conio.h>
#include<stdio.h>
void main()
{
int a[10],i;
clrscr();
printf("\n enter the array element ");
for(i=0;i<10;i++)
{
scanf("%d",&a[i]);
}
addition(a[i]);
getch();
}
 addition(int a[])
{
int sum=0,i;
//for(i=0;i<10;i++)
{
sum=sum+a[i];
}
printf("addition=%d",sum);
}

