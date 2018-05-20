/*  program for insertion sort  */
#include<stdio.h>
#include<conio.h>
void inser(int a[],int);
void main()
{
int i,a[5],n;
clrscr();
printf("enter the last element");
scanf("%d\n",&n);
printf("ENTER THE ARRAY");
for(i=0;i<n;i++)
{
scanf("\n%d",&a[i]);
}
inser(a,n);
printf("  the sorted array is \n ");
for(i=0;i<n;i++)
{
printf("\n%d",a[i]);
}
getch();
}

   void inser(int a[],int n)
   {
	int j,temp,k,m=0;
	for(j=1;j<n;j++)
	{

		if(a[m]>a[j])
	{
	temp=a[j];
	for(k=j-1;k>=0;k--)
	{
		a[k+1]=a[k];
	}
		a[m]=temp;
	}
	}
}
