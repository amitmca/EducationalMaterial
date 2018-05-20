//Decimal to Octal Conversion
#include<stdio.h>
#include<math.h>
main()
	{
	int dec,r[20],i,j;
	clrscr();
	printf("\nDecimal Number:");
	scanf("%d",&dec);
	i=0;
	while(dec>0)
		{
		r[i]=dec%8;
		i++;
		dec=dec/8;
		}
	printf("\nOctal Number:");
	for(j=i-1;j>=0;j--)
		{
		printf(" %d ",r[j]);
		}
	getch();
	return 0;
	}