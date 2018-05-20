#include<stdio.h>
struct stud
	{
	int rno;
	char name[20];
	float per;
	}s[20];
main()
	{
	int i,n;
	system("clear");
	printf("\nHow many Records ? :");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		{
		printf("\nRoll Number:");
		scanf("%d",&s[i].rno);
		printf("\nName:");
		scanf("%s",s[i].name);
		printf("\nPercentage:");
		scanf("%f",&s[i].per);
		}	
	printf("\n============================\n");
	printf("\nRollNo \t Name\tPercenatge\n");
	printf("\n============================\n");
		for(i=0;i<n;i++)
		{
		printf("\n%d\t%s\t%f\n",s[i].rno,s[i].name,s[i].per);
		}	
	printf("\n============================\n");
	}
