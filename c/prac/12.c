#include<stdio.h>
#include<conio.h>
FILE *fp1,*fp2;
int c=0,i,n[20],a,b;
main(int argc,char *argv[])
	{
	clrscr();
	fp1=fopen("even.txt","w");
	fp2=fopen("odd.txt","w");
	for(i=1;i<=argc;i++)
		{
		n[i]=atoi(argv[i]);
		c++;
		}
	for(i=1;i<=c;i++)
		{
		if(n[i]%2==0)
			{
			fprintf(fp1,"%d\n",n[i]);
			}
		else
			{
			fprintf(fp2,"%d\n",n[i]);
			}
		}
	fclose(fp1);
	fclose(fp2);
	read();
	getch();
	return 0;
	}
void read()
	{
	fp1=fopen("even.txt","r");
	fp2=fopen("odd.txt","r");
	printf("\nThe even numbers are:");
	while(!feof(fp1))
		{
		fscanf(fp1,"%d",&n[i]);
		printf("\n%d\n",n[i]);
		}
	printf("\nThe odd numbers are:");
	while(!feof(fp2))
		{
		fscanf(fp2,"%d",&n[i]);
		printf("\n%d\n",n[i]);
		}
	fclose(fp1);
	fclose(fp2);
	}

