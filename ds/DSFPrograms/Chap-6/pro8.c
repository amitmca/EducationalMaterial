/*Program 6.8 : A program to handle binary file*/
#include <stdio.h>
#include <conio.h>
typedef struct item
	{
		char name [30];
		int code;
		int price;
	}item;
void main()
{
	item nyitem;
	int n, i;
	char filename [30]; FILE *fp;
	printf("\n Enter file name :");
	gets(filename);
	fp=fopen(filename, "wb");
		printf("\n Enter number of items :");
		scanf("%d", &n);
	for(i=0; i < n; i++)
	{
		printf("\n Enter next item(name, code, price):");
		scanf("%s%d%d", ? nyitem.name, &nyitem.code, &nyitem.price);
		fwrite(&nyitem, sizeof(nyitem), 1, fp);
	}
	fclose(fp);
/* displaying contents of file */
fp=fopen(file name,"rb");
while(! feof(fp))
{
	fread(&nyitem, sizeof(nyitem), 1, fp);
	printf("\n%s\t%d\t", nyitem.name, nyitem.code, nyitem.price);
}
getch();
}
