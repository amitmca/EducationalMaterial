#include<stdio.h>
#include<conio.h>

int main(int ac,char *v[])
	{
	int n,f=1,i;
	clrscr();
	n=atoi(v[1]);
	for(i=1;i<=n;i++)
		f=f*i;
	puts("Factorial Is:");
	printf("%d",f);
	getch();
	return 0;
	}
