#include<stdio.h>
#include<conio.h>
main()
	{
	int i,j,n,s=0;
	clrscr();
	printf("\nHow many ? ");
	scanf("%d",&n);
	for(i=2;i<=n;i++)
		{
		for(j=1;j<=10;j++)
			{
			s=s+i;
			printf("\n%d",s);
			}
		printf("\t");
		}
	getch();
	return 0;
	}