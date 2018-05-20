//Program to convert Hexadecimal number to decimal,binary,octal number
#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
	{
	int
	int
	clrscr();
	do
		{
		printf("\n****** MENU ********\n\n");
		printf("\n\n1)Hexadecimal to Decimal Conversion:");
		printf("\n\n2)Hexadecimal to Binary Conversion:");
		printf("\n\n3)Hexadecimal to Octal Conversion:");
		printf("\n\n4)Exit:");
		printf("\n\nSelect Your Choice....\t");
		scanf("%d",&ch);
		switch(ch)
			{
			case 1:
			printf("\nEnter the Hexadeimal Number:");
			scanf("%d",&hex1);
			break;

			case 2:
			break;

			case 3:
			break;

			case 4:
			exit(0);
			break;

			default:
				printf("\nYou have selected wrong option\n\n");
			}
		}while(ch!=4);
	getch();
	return 0;
	}

int hextodec(int hex)
	{
	int i,rem;
	i=0;
	while(hex>0)
		{
		rem=hex%10;
		dec=dec+
		}
	}