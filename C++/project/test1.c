#include<stdio.h>
main()
	{
		int a,b;
		char ***p[3];
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
	}
