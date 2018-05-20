//Decimal to Hexadecimal Conversion
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
		r[i]=dec%16;
		i++;
		dec=dec/16;
		}
	printf("\nHexadecimal Number:");
	for(j=i-1;j>=0;j--)
		{
		if(r[j]<9)
			{
			printf(" %d ",r[j]);
			}
		else
			{
			printf(" %c ",r[j]+55);
			}

		}
	getch();
	return 0;
	}