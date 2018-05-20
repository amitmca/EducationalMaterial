#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	FILE *fp1,*fp2;
	int n,num,num1,i;
	clrscr();
	fp1=fopen("e.txt","w");
	fp2=fopen("o.txt","w");
	for(i=1;i<=argc;i++)
		{
		n=atoi(argv[i]);
		printf("%d\n",n);
		if(n%2==0)
			{
			fprintf(fp1,"%d\t",n);
			}
		else
			{
			fprintf(fp2,"%d\t",n);
			}
		}
	fclose(fp1);
	fclose(fp2);
	fp1=fopen("e.txt","r");
	fp2=fopen("o.txt","r");
	printf("\nThe Contents of e.txt are...\n");
	while(!feof(fp1))
		{
		fscanf(fp1,"%d\t",&num);
		printf("%d\n",num);
		}
	printf("\nThe Contents of o.txt are...\n");
	while(!feof(fp2))
		{
		fscanf(fp2,"%d\t",&num1);
		printf("%d\n",num1);
		}
	fclose(fp1);
	fclose(fp2);
	getch();
	return 0;
	}
