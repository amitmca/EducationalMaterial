#include<stdio.h>
#include "conio.h"
main()
	{
	FILE *e,*o;
	int i,a[20];
	clrscr();
	e=fopen("e.txt","w");
	o=fopen("o.txt","w");
	for(i=1;i<=10;i++)
		{
		scanf("%d",&a[i]);
		if(a[i]%2==0)
			{
			fprintf(e,"%d\n",a[i]);
			}	
		else
			{
			fprintf(o,"%d\n",a[i]);
			}
		}
	fclose(e);
	fclose(o);
	getch();
	}
