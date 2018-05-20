#include<stdio.h>
#include<conio.h>
main()
	{
	int k,i,t,r=0,sum=0,n,l,u;
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
			r=k%10;
			sum=sum+r*r*r;
			k=k/10;
			}
		if(sum==t)
			printf("\n%d\n",t);
		sum=0;
		}

	getch();
	return 0;
	}