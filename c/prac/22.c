#include<stdio.h>
void main()
	{
	int dec,bin,r[20],i,j;
	clrscr();
//	system("clear");
	printf("\nDeimal Number:");
	scanf("%d",&dec);
	i=0;
	while(dec>0)
		{
		r[i]=dec%2;
		i++;
		dec=dec/2;
		}
	printf("\nBinary Number is:");
	for(j=i-1;j>=0;j--)
		{
		printf(" %d ",r[j]);
		}
	printf("\n\n");
	getch();

	}
