#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	int l,u,i;
	clrscr();
	l=atoi(argv[1]);
	u=atoi(argv[2]);
	printf("\nLower Limit:%d",l);
	printf("\nUpper Limit:%d\n",u);
	for(i=l;i<=u;i++)
		{
		if(i%2==0)
			{
			printf("%d\n",i);
			}
		else
			{
			continue;
			}
		}
	getch();
	return 0;
	}
