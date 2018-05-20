/*Program 6.3 : Sample program for creating a text file using putc() */
# include <stdio.h>
void main()
	{
		FILE *fp; char file1[20];
		char x;
		printf("\n Enter file name :");
		gets(file1);
		fp = fopen(file1, "w"); /* create file */
		if(fp)
		{ /* if file is created successfully */
		printf("\n Enter the text(end with ^z):");
		while((x=getchar())!=EOF)

			putc(x, fp); /* character written to file */
		}
		else
			printf("\ n Error creating file:");
			fclose(fp);
	}
