#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,l,no=1,b,p,q,x;
//	clrscr();
	printf("\nHow many lines ? :");
	scanf("%d",&l);
	b=1;
	q=0;
	while(q<l)
		{
		for(p=30-3*q;p>0;p--)
		printf(" ");
		for(x=0;x<=q;x++)
			{
			if(x==0 || q==0)
				b=1;
			else
				b=(b*(q-x+1)/x);
			printf("%6d",b);
			}
		printf("\n");
		q++;
		}
	getch();
	return 0;
	}
