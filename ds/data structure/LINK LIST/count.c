/*  program for count sorting  */
#include<stdio.h>
#include<conio.h>
void main()
{
int i,k,c[5],a[5],b[5],n;
clrscr();
printf("enter the array");
for(i=0;i<=10;i++)
{
scanf("%d",&a[i]);
}
scanf("%d%d",&k,&n);
for(i=0;i<=k-1;i++)
{
c[i]=0;
for(i=0;i<=n-1;i++)
{
c[a[i]]=c[a[i]]+1;
}
}
for(i=1;i<=k-1;i++)
{
c[i]=c[i]+c[i-1];
}
for(i=n-1;i>=0;i--)
{
b[c[a[i]]-1]=a[i];
c[a[i]]=c[a[i]]-1;
}
getch();
}
