#include<stdio.h>
#define ALLOCATE (struct cust *)malloc(sizeof(struct cust)) 
struct cust
	{
	char name[20];
	int ano;
	float units,bamt[20];
	}*c[20];
main()
	{
	int rate=5,n,i,*p;
	float max,amt[20];
	clrscr();
	printf("\nHow many customers:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		{
		c[i]=ALLOCATE;
		printf("\nEnter Name,Area Number,No Of Units for customer no %d:",i);
		scanf("%s%d%f",c[i]->name,&c[i]->ano,&c[i]->units);
		c[i]->bamt[i]=rate*(c[i]->units);
		amt[i]=c[i]->bamt[i];
		}
	printf("\n===========================================");
	printf("\nName\tArea No\tNo Of units\tBillAmount\n");
	printf("-------------------------------------------\n");
	for(i=0;i<n;i++)
		{
		printf("%s\t%d\t%f\t%f\n",c[i]->name,c[i]->ano,c[i]->units,c[i]->bamt[i]);
		}
	printf("==========================================\n\n");
	max=amt[0];
	for(i=1;i<=n;i++)
		{
		if(amt[i] > max)
			{
			max=amt[i];
			}
		if(max==amt[i])
			{
			printf("\nName Of Customer :%s\n\n",c[i]->name);
			}
		}
		printf("Maximum Bill Amount is:%f\n\n",max);
//	free(c[i]);
	getch();
	return 0;
	}
