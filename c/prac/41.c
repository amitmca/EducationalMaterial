#include<stdio.h>
#include<conio.h>
void rec(int dec)
	{	
	int r[20],i,j;
	i=0;
	if(dec!=0)
		{
		r[i]=dec%2;
		i++;
		rec(dec/2);
		}
	for(j=i-1;j>=0;j--)
		{
		printf("%d",r[j]);
		}
	}
main()
	{
	int dec,ans;
	clrscr();
	printf("\nEnter the decimal:");
	scanf("%d",&dec);
	rec(dec);
	printf("\n");
	getch();
	return 0;
	}

// (1*2^5)+(0*2^4)+(1*2^3)+(1*2^2)+(0*2^1)+(1*2^0)
// 32+0+8+4+0+1
// 45					
