#include<stdio.h>
void main(int argc,char *argv[])
	{
	FILE *fp;
	int l=0,j,k;
	char ch,ch1;
	clrscr();
	fp=fopen(argv[1],"r");
	while(!feof(fp))
		{
		fscanf(fp,"%c",&ch);
		if(ch=='.')
			l++;
		}
	k=l-2;
	fclose(fp);
	fp=fopen(argv[1],"r");
	printf("l=%d\tk=%d\n",l,k);
	j=0;
	while(!feof(fp))
		{
		fscanf(fp,"%c",&ch);
		if(ch=='.')
			j++;
		if(j>=k)
			printf("%c",ch);
		}
	printf("\n");
	fclose(fp);
	getch();
	}
