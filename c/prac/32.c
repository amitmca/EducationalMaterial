#include<stdio.h>
#include<conio.h>
void main()
{
	FILE *fp;
	int i=0,j=0,k=0;
	char ch[20];
	clrscr();
	fp=fopen("art.txt","r");
	while(!feof(fp))
	{
		  fscanf(fp,"%s",ch);
		  if((strcmp(ch,"a")==0))
		  i++;
		  if((strcmp(ch,"an")==0))
		  j++;
		  if((strcmp(ch,"the")==0))
		  k++;

	}
	fclose(fp);
	printf("a=%d\tthe=%d\tan=%d",i,k,j);
	getch();
}