/*Program 6.6 : Program to read, the 'newfile' and to add its entries*/ 
# include <stdio.h>
void main()
	{
		FILE *fp;
		int val, sum, i ;
		fp = fopen("newfile", "r");
		sum = 0;
		for(i=0; i < 5; i++)
		{
			scanf(fp, "%d", &val);
			sum = sum + val;
		}
		printf( "\n sum = %d", sum);
		fcolse(fp);
	}	
