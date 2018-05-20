/*Program 6.4 : A sample program to copy contents of a file to another file*/ 
# include <stdio.h>
void main()
	{
		FILE *fp1, *fp2
		char x, file1[20], file2[20];
		/* file[] is for source file and file 2[] is for
			destination file */
		printf("\n Enter source file :");
		gets(file1);
		fp1 = fopen(file1, "r");
		printf("\n Enter destination file :");
		gets(file2);
		fp2 = fopen(file2, "w");
		if(fp1 && fp2) /* if both files opened successfully */
		{	while((x = getc(fp1)) ! = EOF)
			putc(x, fp2);
			fclose(fp1); fclose(fp2);
		}
		else
		printf("\n Error opening file :");
	}
