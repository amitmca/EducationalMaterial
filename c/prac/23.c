#include<stdio.h>
#include<math.h>

void main()
	{
	int dec=0,bin,r,i,j;
	clrscr();
//	system("clear");
	printf("\nBinary Number:");
	scanf("%d",&bin);
	i=0;
	while(bin>0)
		{
		r=bin%10;
		dec=dec+r*pow(2,i);
		i++;
		bin=bin/10;
		}
	printf("\nDecimal Number is:%d",dec);
	printf("\n\n");
	}
/*int mypow(int x,int y)
	{
	int k,p;
	for(k=1;k<y;k++)
		{
		p=p*x;
		}
	return p;
	}*/
