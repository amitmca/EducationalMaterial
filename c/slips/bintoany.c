#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
	{
	int
	int bintodec(int);
	clrscr();
	do
		{
		printf("\n****** MENU ********\n\n");
		printf("\n\n1)Octal to Decimal Conversion:");
		printf("\n\n2)Octal to Binary Conversion:");
		printf("\n\n3)Octal To Hexadecimal Conversion:");
		printf("\n\n4)Exit:");
		printf("\n\nSelect Your Choice....\t");
		scanf("%d",&ch);
		switch(ch)
			{
			case 1:
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
