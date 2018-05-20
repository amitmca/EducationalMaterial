#include<stdio.h>
#include<stdlib.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	int n[50],i,c,a,b;
	system("clear");
	fp1=fopen("even.txt","w");
	fp2=fopen("odd.txt","w");
	c=0;
	for(i=1;i<argc;i++)
		{
		n[i]=atoi(argv[i]);
		c++;
		}
	for(i=1;i<=c;i++)
		{
		if(n[i]%2==0)
			{
			a=n[i];
			fprintf(fp1,"%d\n",a);
			}
		else
			{
			b=n[i];
			fprintf(fp2,"%d\n",b);
			}
		}
	}
