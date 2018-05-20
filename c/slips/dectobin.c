//Program to convert Decimal number to binary ,octal,hexadecimal numeber
#include<stdio.h>
#include<conio.h>
main()
	{
	int dec,r[100],i,choice;
	clrscr();
	do
	{
	printf("\n1) Decimal to Binary number:\n\n");
	printf("\n2) Decimal to Octal number:\n\n");
	printf("\n3) Decimal to Hexadecimal number:\n\n");
	printf("\n4) Exit\n\n");
	printf("\n\nEnter Your Choice:");
	scanf("%d",&choice);
	switch(choice)
		{
		case 1:
		for(i=0;i<16;i++)
			r[i]=0;
		printf("\n\n\nEnter the Decimal Number:");
		scanf("%d",&dec);
		i=0;
		while(dec > 0)
			{
			r[i]=dec%2;
			i++;
			dec=dec/2;
			}
		printf("\n\nThe Binary Equivalent is:");
		for(--i;i>=0;i--)
			{
			printf("\t%d",r[i]);
			}
		printf("\n\n");
		break;

		case 2:
		printf("\n\n\nEnter the Decimal Number:");
		scanf("%d",&dec);
		i=0;
		while(dec > 0)
			{
			r[i]=dec%8;
			i++;
			dec=dec/8;
			}
		printf("\n\nThe Octal Equivalent is:");
		for(--i;i>=0;i--)
			{
			printf("\t%d",r[i]);
			}
		printf("\n\n");
		break;

		case 3:
		printf("\n\n\nEnter the Decimal Number:");
		scanf("%d",&dec);
		i=0;
		while(dec > 0)
			{
			r[i]=dec%16;
			i++;
			dec=dec/16;
			}
		printf("\n\nThe Hexadecimal Equivalent is:");
		for(--i;i>=0;i--)
			{
			if(r[i] < 10)
				{
				printf("\t%d",r[i]);
				}
			else
				{
				printf("\t%c",r[i]+55);
				}
			}
		printf("\n\n");
		break;

		case 4:
		       exit(0);
		       break;
		}
	}while(choice!=4);
	getch();
	return 0;
	}
