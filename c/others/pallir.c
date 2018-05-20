//Program to print the pallindrome numbers in the given range
#include<stdio.h>
#include<conio.h>
main()
	{
	int k,i,t,r=0,rev=0,n,l,u;
	clrscr();
	printf("\nEnter the lower limit:");
	scanf("%d",&l);
	printf("\nEnter the upper limit:");
	scanf("%d",&u);
	for(i=l;i<=u;i++)
		{
		t=i;
		k=i;
		while(k>0)
			{
			rev=r*10;
			r=rev+k%10;
			k=k/10;
			}
		if(r==t)
			printf("\t%d",t);
		r=0;
		rev=0;
		}

	getch();
	return 0;
	}