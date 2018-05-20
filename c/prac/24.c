// Binary to Octal Conversion

#include<stdio.h>
#include<math.h>
main()
	{
	int bin,dec1,i,r[20],j;
	clrscr();
	printf("\nBinary Number:");
	scanf("%d",&bin);
	dec1=bintodec(bin);
	i=0;
	while(dec1>0)
		{
		r[i]=dec1%8;
		i++;
		dec1=dec1/8;
		}
	printf("\nBinary Number:");
	for(j=i-1;j>=0;j--)
		{
		printf("%d",r[j]);
		}
	getch();
	return 0;
	}
int bintodec(int bin)
	{
	int rem,i,dec=0;
	i=0;
	while(bin>0)
		{
		rem=bin%10;
		dec=dec+(rem*pow(2,i));
		i++;
		bin=bin/10;
		}
	return dec;
	}
