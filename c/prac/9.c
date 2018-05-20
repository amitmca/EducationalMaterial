#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	int n[10],i,sum=0;
	clrscr();
	for(i=1;i<argc;i++)
		{
		n[i]=atoi(argv[i]);
		sum=sum+n[i];
		}
	printf("\nThe Sum is:%d\n",sum);
	getch();
	return 0;
	}
