#include<stdio.h>
#include<conio.h>
main()
	{
	int n,i,j,temp,A=65,space=-1;
	clrscr();
	printf("\nHow many lines:");
	scanf("%d",&n);
	temp=n;
	for(i=1;i<=n;i++)
		{
		if(i==1)
			{
			for(j=temp;j>0;j--)
				{
				printf("%c",A++);
				}
			A=A-2;
			for(j=temp-1;j>0;j--)
			printf("%c",A--);
			printf("\n");
			}
		else
			{
			A=65;
			for(j=temp-1;j>0;j--)
				{
				printf("%c",A++);
				}
			A--;
			space=space+2;
			for(j=1;j<=space;j++)
				printf(" ");
			for(j=temp-1;j>0;j--)
				{
				printf("%c",A--);
				}
			printf("\n");
			temp--;
			}
		}
	getch();
	return 0;
	}
