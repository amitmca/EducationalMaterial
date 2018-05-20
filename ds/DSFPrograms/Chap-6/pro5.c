/*Program 6.5 : Program to read 5 integer numbers from the keyboard and to store then in the file "newfile"*/
# include <stdio.h>
void main()
	{	
		FILE *fp;
		int x, i ;
		printf("\n Enter 5 numbers :");
		fp = fopen("newfile","w");
		for(i = 0; i < 5 ; i++)
		{
			scanf("%d", &x);
			fprintf(fp, "%d\t", x);
		}
		fclose(fp);
	}  
