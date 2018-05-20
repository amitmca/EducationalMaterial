#include<stdio.h>
#include<conio.h>
#include<process.h>
int binsearch(int a[],int,int);

void bsort(int a[],int);
int i;
void main()
{
int a[10],n,p,r;
clrscr();
printf("enter the last element\n");
scanf("%d",&n);
printf("enter the array\n");
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}
printf("enter the key element");
scanf("%d",&p);
r=binsearch(a,n,p);
printf("the array element is = %d ",r);
getch();
}

   int binsearch(int a[],int n,int p)
   {
   int m,l,h;
   bsort(a,n);
   for(i=0;i<n;i++)
   printf("display matrix\n %d",a[i]);

   l=a[0];
   h=a[n-1];
   while(l<n)
	{
	m=(l+h)/2;
	if(p==a[m])
	     return m+1;
	   if(p<a[m])
	     h=m-1;
	   else
	     l=m+1;
	}
	   return 0;
   }
	 void bsort(int a[],int n)
	   {
	   int j,temp;
	   for(i=0;i<n-1;i++)
	    {
	    for(j=0;j<n-i-1;j++)
	     {
	     if(a[j]>a[j+1])
	      {
	       temp=a[j];
	       a[j]=a[j+1];
	       a[j+1]=temp;
	      }
    }
   }
 }


