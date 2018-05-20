//Program to convert Octal number to decimal,binary,hexadecimal number
#include<stdio.h>
#include<conio.h>
#include<math.h>
main()
	{
	int oct1,dec1,ch,i,r[20],j;
	int octtodec(int);
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
			printf("\nEnter the Octal Number:");
			scanf("%d",&oct1);
			dec1=octtodec(oct1);
			printf("\nThe Equivalent Decimal Number is: %d\n\n",dec1);
			break;

			case 2:
			printf("\nEnter the Octal Number:");
			scanf("%d",&oct1);
			dec1=octtodec(oct1);
			i=0;
			while(dec1>0)
				{
				r[i]=dec1%2;
				i++;
				dec1=dec1/2;
				}
			printf("\nThe Equivalent Binary Number is:  ");
			for(j=i-1;j>=0;j--)
				{
				printf(" %d\t",r[j]);
				}
			printf("\n\n");
			break;

			case 3:
			printf("\nEnter the Octal Number:");
			scanf("%d",&oct1);
			dec1=octtodec(oct1);
			i=0;
			while(dec1>0)
				{
				r[i]=dec1%16;
				i++;
				dec1=dec1/16;
				}
			printf("\nThe Equivalent Hexadecimal Number is:  ");
			for(j=i-1;j>=0;j--)
				{
				if(r[j]<9)
					{
					printf(" %d\t",r[j]);
					}
				else
					{
					printf(" %c\t",r[j]+55);
					}
				}
			printf("\n\n");
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
int octtodec(int oct)
	{
	int rem,k,dec=0;
	k=0;
	while(oct>0)
		{
		rem=oct%10;
		dec=dec+(rem*pow(8,k));
		k++;
		oct=oct/10;
		}
	return dec;
	}