#include<stdio.h>
#include<conio.h>
int non_mypow(int a,int b);
int rec_mypow(int a,int b);
main()
	{
	int a,b,c,d;
	clrscr();
	printf("\nEnter the value of a :");
	scanf("%d",&a);
	printf("\nEnter the value of a :");
	scanf("%d",&b);
	c=non_mypow(a,b);
	printf("\n%d raised to %d using non-recursive function is:=%d\n",a,b,c);
	d=rec_mypow(a,b);
	printf("\n%d raised to %d using recursive function is:=%d\n",a,b,d);
	getch();
	return 0;
	}
int non_mypow(int a,int b)
	{
	int p=1,i;
	for(i=1;i<=b;i++)
		{
		p=p*a;
		}
	return p;
	}
int rec_mypow(int a,int b)
	{
	int p=1;
	if(b==1)
		return 1;
	else
		{
		p=a*(rec_mypow(a,b-1));
		return p;
		}
	}