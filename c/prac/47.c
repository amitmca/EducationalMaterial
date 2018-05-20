#include<stdio.h>
#include<conio.h>
FILE *fp;
int n;
void w_d(int );
struct account
	{
	int ano,bal;
	char name[20];
	}a[10];

main()
	{
	int i,ano1;
	clrscr();
	printf("\nHow many records:");
	scanf("%d",&n);
	fp=fopen("bank.txt","w");
	for(i=0;i<n;i++)
		{
		printf("\nEnter Name,Account Number and balance for custromer %d:",i+1);
		scanf("%s%d%d",a[i].name,&a[i].ano,&a[i].bal);
		}
	for(i=0;i<n;i++)
		{
		fprintf(fp,"%d\t%s\t%d\n\n",a[i].ano,a[i].name,a[i].bal);
		}
	fclose(fp);
	fp=fopen("bank.txt","r");
	printf("\nANo\tName\tBalance\n");
	printf("\n======================\n\n");
	while(!feof(fp))
		{
		fscanf(fp,"%d\t%s\t%d",&a[i].ano,a[i].name,&a[i].bal);
		printf("%d\t%s\t%d\n\n",a[i].ano,a[i].name,a[i].bal);
		}
	printf("\n=======================\n\n");
	printf("\nEnter the Account number to which yo want to deposit or withdraw:");
	scanf("%d",&ano1);
	w_d(ano1);
	getch();
	return 0;
	}
void w_d(int ano1)
	{
	char ch;
	int b,i,d;
	printf("\nPress 'w' for Withdraw\n");
	printf("\nPress 'd' for Deposit\n");
	printf("\n\nWhat Do You Want to do ? ...");
	ch=getche();
	if(ch=='w')
		{
		printf("\nEnter the Amount which you want to withdraw:");
		scanf("%d",&b);
		for(i=0;i<n;i++)
		{
		if(b<=a[i].bal)
			{
			a[i].bal=a[i].bal-b;
			printf("\nBALANCE IS:%d",a[i].bal);
			}
		else
			{
			printf("\nBalance is very low\n");
			}
		  }
		}
	else
		{
		if(ch=='d')
			{
			printf("\nEnter the Amount which you want to Deposit:");
			scanf("%d",&d);
				for(i=0;i<n;i++)
				{
				if(a[i].ano==ano1)
					{
					a[i].bal=a[i].bal+d;
					printf("\nBALANCE IS:%d",a[i].bal);
					}

				}

			}
		}

	}