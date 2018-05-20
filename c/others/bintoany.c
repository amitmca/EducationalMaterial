//Program to convert Binary number to decimal,octal,hexadecimal numeber
#include<stdio.h>
#include<conio.h>
main()
	{
	int bin,dec=0,p=1,digit;
	clrscr();
	printf("\nEnter the Binary Number:");
	scanf("%d",&bin);
	while(bin > 0)
		{
		digit=bin%10;
		if((digit!=0) || (digit!=1))
			{
			printf("\nPlease Enter the correct input\n");
			exit(0);
			}
		dec=dec+digit*p;
		p=p*2;
		bin=bin/10;
		}
	printf("\nThe Decimal Equivalent is:%d",dec);
/*	printf("\nThe Octal Equivalent is:");
		for(--j;j>=0;j--)
		{
		printf("%d",r1[j]);
		}
	printf("\nThe Hexadecimal Equivalent is:");
	for(--k;k>=0;k--)
		{
		if(r2[k] < 10)
			printf("%d",r2[k]);
		else
			printf("%c",r2[k]+55);
		}            */
	getch();
	return 0;
	}
