/*Program 6.7 : Program to print every 10th character of the file. It also display the size of the program */
# include <stdio.h>
void main()
{	FILE *fp;
	long size, offset;
	char filename [30];
	printf("\n Enter file name :");
	gets(filename);
	fp=fopen(filename, "r");
	if(fp) /* if file exists */
	{
		fseek(fp, 0, 2); /* go to end */
		size=ftell(fp);
		printf("\n size of the file=%ld", size);
		rewind(fp);
		offset=0;
		while(offset < size)
		{
			fseek(fp, offset, 0);
			printf("\n Position of %C is %ld", getc(fp), ftell(fp));
			offset=offset+10;
		}
	}
}
