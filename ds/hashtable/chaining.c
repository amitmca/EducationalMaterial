// Program for Chaining using linked list.

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
struct node
	{
	int ident;
	struct node *next;
	}*ht[10];
typedef struct node *HASH;
int Hashfun(int n)
	{
	return(n%10);
	}
void init()
	{
	int i;
	for(i=0;i<10;i++)
		ht[i]=NULL;
	}
void Add(int id)
	{
	HASH newnode,temp;
	int bucket;
	bucket=Hashfun(id);
	newnode=ALLOC;
	newnode->next=NULL;
	newnode->ident=id;
	if(ht[bucket]==NULL)
		ht[bucket]=newnode;
	else
		{
		for(temp=ht[bucket];temp->next!=NULL;temp=temp->next);
			temp->next=newnode;
		}
	return;
	}
void Delete(int id)
	{
	int bucket;
	HASH temp,temp1;
	bucket=Hashfun(id);
	temp=temp1=ht[bucket];
	if(temp->ident==id)
		{
		ht[bucket]=temp->next;
		free(temp);
		return;
		}
	while(temp!=NULL)
		{
		if(temp->ident==id)
			{
			temp1->next=temp->next;
			free(temp);
			return;
			}
		temp1=temp;
		temp=temp->next;
		}
	printf("\nIdentifier Not Found\n\n");
	}
void Display()
	{
	HASH temp;
	int i;
	for(i=0;i<10;i++)
		{
		printf("\n Bucket %d\t",i);
		for(temp=ht[i];temp!=NULL;temp=temp->next)
			printf("->%d",temp->ident);
		}
	printf("\n");
	}
void main()
	{
	int n,choice;
	clrscr();
	do
		{
		printf("\n 1 : ADD\n");
		printf("\n 2 : DELETE\n");
		printf("\n 3 : DISPLAY\n");
		printf("\n 4 : EXIT\n");
		printf("\n Select Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\n Enter the Identifier:");
				scanf("%d",&n);
				Add(n);
				Display();
				break;
			case 2:
				printf("\n Enter the Identifier:");
				scanf("%d",&n);
				Delete(n);
				Display(n);
				break;
			case 3:
				Display();
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}
