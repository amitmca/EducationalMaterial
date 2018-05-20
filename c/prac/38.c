#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	int r=0,n,d;
	clrscr();
	n=atoi(argv[1]);
	while(n>0)
		{
		r=r*10+n%10;
		n=n/10;
		}
	while(r>0)
		{
		d=r%10;
		r=r/10;
		switch(d)
			{
			case 0:
				printf("\nZERO");
				break;
			case 1:
				printf("\nONE");
				break;
			case 2:
				printf("\nTWO");
				break;
			case 3:
				printf("\nTHREE");
				break;
			case 4:
				printf("\nFOUR");
				break;
			case 5:
				printf("\nFIVE");
				break;
			case 6:
				printf("\nSIX");
				break;
			case 7:
				printf("\nSEVEN");
				break;
			case 8:
				printf("\nEIGHT");
				break;
			case 9:
				printf("\nNINE");
				break;
			}
		}
	getch();
	return 0;
	}