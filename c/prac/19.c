#include<stdio.h>
#include<conio.h>
main()
	{
	FILE *fp;
	int i,j,l,no=1,b,p,q,x;
	clrscr();
	fp=fopen("pas.txt","w");
	printf("\nHow many lines ? :");
	scanf("%d",&l);
	fprintf(fp,"Floyd's Triangle is:\n\n");
	fprintf(fp,"\n");
	for(i=1;i<=l;i++)
		{
		for(j=1;j<=i;j++)
			{
			fprintf(fp,"%d\t",no++);
			}
		fprintf(fp,"\n");
		}
	fprintf(fp,"========================================\n");
	fprintf(fp,"Pascal's Triangle is:\n");
	b=1;
	q=0;
	while(q<l)
		{
		for(p=30-3*q;p>0;p--)
		fprintf(fp," ");
		for(x=0;x<=q;x++)
			{
			if(x==0 || q==0)
				b=1;
			else
				b=(b*(q-x+1)/x);
			fprintf(fp,"%6d",b);
			}
		fprintf(fp,"\n");
		q++;
		}
	fprintf(fp,"========================================\n");
	getch();
	return 0;
	}