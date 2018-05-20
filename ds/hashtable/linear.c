//Program for Hashing using linear probing

#include<stdio.h>
#include<conio.h>

int Hashfun(int i)
	{
	return(i%10);
	}
void Add(int ht[],int id)
	{
	int pos,i;
	pos=Hashfun(id);
	if(ht[pos]==-1)
		{
		ht[pos]=id;
		return;
		}
	else
		{
		for(i=pos+1;i!=pos;i=(i+1)%10)
			{
			if(ht[i]==-1)
				{
				return ;
				}
			}
		if(i==pos)
			printf("\nHash Table is full\n");
		}
	}

void Delete(int ht[],int id)
	{
	int pos,i;
	pos=Hashfun(id);
	if(ht[pos]==id)
		{
		ht[pos]=-1;
		return;
		}
	else
		{
		for(i=pos+1;i!=pos;i=(i+1)%10)
			{
			if(ht[i]==id)
				{
				ht[i]=-1;
				return;
				}
			}
		if(i==pos)
			printf("\nIdentifier Not Found\n");
		}
	}
void Display(int ht[])
	{
	int i;
	printf("\nBucket \t Identifier\n");
	for(i=0;i<10;i++)
	if(ht[i]==-1)
		printf("%d\t\tempty\n",i);
	else
		printf("%d\t\t%d\n",i,ht[i]);
	}
void main()
	{
	int ht[10]={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},choice,n;
	clrscr();
	do
		{
		printf("\n1 : ADD\n\n 2 : DELETE \n\n 3 : DISPLAY\n\n 4 :  EXIT\n\n\n");
		printf("\n Enter Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nEnter the Identifier:");
				scanf("%d",&n);
				Add(ht,n);
				break;

			case 2:
				printf("\nEnter the Identifier:");
				scanf("%d",&n);
				Delete(ht,n);
				break;

			case 3:
				Display(ht);
				break;

			case 4:
				exit(0);
				break;
			}

		}while(choice!=4);
	getch();
	}

