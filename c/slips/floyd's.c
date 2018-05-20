/* Program to print the Floyd's triangle
       1
       2 3
       4 5 6
       -----
       -----
 */
#include<stdio.h>
#include<conio.h>
main()
	{
	int l,c,n,number;
	clrscr();
	printf("\nHow many lines do you want:");
	scanf("%d",&n);
	number=1;
	printf("\nThe Floyd's triangle is.....\n\n");
	for(l=1;l<=n;l++)
		{
		for(c=1;c<=l;c++)
			{
			printf("%d\t",number++);
			}
		printf("\n\n");
		}
	getch();
	return 0;
	}