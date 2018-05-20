#include<stdio.h>
#include<conio.h>
main()
	{
	int n,i=0,j,rem[20],k;
	int a=1,b=2,c=0,t;
	clrscr();
	printf("\nEnter the 3 Digit Number:");
	scanf("%d",&n);
	if(n>=1000)
		{
		printf("\nEnter 3 digit number only\n");
		exit(1);
		}
	else
		{
		while(n>0)
			{
			rem[i]=n%10;
			n=n/10;
			i++;
			}
		printf("\nCombinations are:\n");
		for(j=1;j<=i;j++)
			{
			for(k=1;k<=i-1;k++)
				{
				printf("\n%d%d%d",rem[c],rem[a],rem[b]);
				t=a;	a=b;	b=t;
				}
			c++;
			a=a+1;
			b=b-a;
			if(c==i-1)
				{
				a=1;
				b=0;
				}
			}
		}
	printf("\n");
	getch();
	return 0;
	}
