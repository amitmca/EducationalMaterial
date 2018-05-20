#include<stdio.h>
#include<ctype.h>
main()
	{
	FILE *fp1;
	char ch;
	int c;
	system("clear");
	fp1=fopen("cc.txt","r");
	c=0;
	if(!fp1)
		{
		printf("\nError in opening file\n");
		exit(1);
		}
	else
		{
		while(!feof(fp1))
			{
			ch=fgetc(fp1);
			if(isdigit(ch))
				{
				c++;
				}	
			}
		}
	printf("\nThere are total %d digits",c);
	}
