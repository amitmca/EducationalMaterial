#include<stdio.h>
#include "conio.h"

main()	
	{
	char a[10][10]={"one","two","three","four","five","six","seven","eight","nine","ten"};
	char b[10][10]={"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	char c[10][10]={"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninty","hundred"};
	int r,s,t;
	long n;
	clrscr();
	printf("\nEnter the number:");
	scanf("%ld",&n);
	if(n>9999)
		{
		r=n/1000;
		if(r>10 && r<20)
			{
			r=r%10;
			printf("%s thousands ",b[r-1]);
			}
		else
			{
			s=r/10;
			t=r%10;	
			printf("%s ",c[s-1]);
			printf("%s thousands ",a[t-1]);
			}
		n=n%1000;
		}
	if(n>1000)	
		{
		r=n/1000;
		printf("%s thousands ",a[r-1]);	
		n=n%1000;
		}
	if(n>100)	
		{
		r=n/100;
		printf("%s hundreds ",a[r-1]);	
		n=n%100;
		}
	if(n>10 && n<20)
		{
		r=n%10;
		printf("%s  ",b[r-1]);
		}
	if(n>19 && n<=100)
		{
		r=n/10;
		printf("%s  ",c[r-1]);
		n=n%10;
		}
	if(n>0 && n<=10)
		{
		printf("%s  ",a[r-1]);
		}
	printf("\n");
	getch();
	}
	
