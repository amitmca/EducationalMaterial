#include<stdio.h>
#include<conio.h>
void bsort(int a[],int);
int i;
void main()
{
int a[10],n;
clrscr();
printf("enter the last element\n");
scanf("%d",&n);
printf("enter the array\n");
for(i=0;i<n;i++)
{
scanf("%d",&a[i]);
}

bsort(a,n);
printf("the sorted array is = \n");
for(i=0;i<n;i++)
{
printf("%d\n",a[i]);
}
getch();
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
