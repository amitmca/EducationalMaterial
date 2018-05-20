//Program to swap the two numbers
#include<stdio.h>
int main()
	{
	int a,b,t,ch;
	system("clear");		
	do	
		{
		printf("\n *** SWAP TWO NUMBERS ***\n");
		printf("\n 1) Using Temproray Variable:\n");
		printf("\n 2) Without Using Temproray Variable:\n");
		printf("\n 3) Using Bit-Wise Operator:\n");
		printf("\n 4) Exit:\n");
		printf("\n Enter Your Choice....\n");
		scanf("%d",&ch);
		switch(ch)
			{
			case 1:
				printf("\nEnter First Number:");
				scanf("%d",&a);
				printf("\nEnter Second Number:");
				scanf("%d",&b);
				printf("\nBefore Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				t=a;
				a=b;
				b=t;
				printf("\nAfter Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				break;
			case 2:
				printf("\nEnter First Number:");
				scanf("%d",&a);
				printf("\nEnter Second Number:");
				scanf("%d",&b);
				printf("\nBefore Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				a=a+b;		
				b=a-b;
				a=a-b;
				printf("\nAfter Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				break;
			case 3:
				printf("\nEnter First Number:");
				scanf("%d",&a);
				printf("\nEnter Second Number:");
				scanf("%d",&b);
				printf("\nBefore Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				a=a^b;
				b=a^b;
				a=a^b;
				printf("\nAfter Swapping:");
				printf("\na=%d\tb=%d\n",a,b);
				break;
			case 4:
				exit(0);
				break;
			}
		}while(ch!=4);
	return 0;
	}
