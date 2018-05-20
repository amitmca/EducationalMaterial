//Octal to Binary Conversion
#include<stdio.h>
#include<math.h>
main()
	{
	int oct,dec1,i,j,r[20];
	clrscr();
	printf("\nOctal Number:");
	scanf("%d",&oct);
	dec1=octtodec(oct);
	i=0;
	while(dec1>0)
		{
		r[i]=dec1%2;
		i++;
		dec1=dec1/2;
		}
	printf("\nBinary Number:");
	for(j=i-1;j>=0;j--)
		{
		printf("%d",r[j]);
		}

	getch();
	return 0;
	}
int octtodec(int oct)
	{
	int rem,i=0,dec=0;
	while(oct>0)
		{
		rem=oct%10;
		dec=dec+rem*pow(8,i);
		i++;
		oct=oct/10;
		}
	return dec;
	}