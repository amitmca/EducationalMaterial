//Program for Queue Implementation

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *QUEUE;

QUEUE Add(QUEUE last)
	{
	QUEUE first,newnode;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Rear Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
		printf("\n Do you want to add another node(y/n):");
		ch=getche();
		}
	printf("\n");
	return(first);
	}
QUEUE Delete(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	return(first);
	}
void Display(QUEUE first)
	{
	printf("\nFront->");
	while(first!=NULL)
		{
		printf(" %d->",first->data);
		first=first->next;
		}
	printf(" Rear \n");
	}
int main()
	{
	QUEUE first,last;
	clrscr();
	first=Add(last);
	Display(first);
	Delete(first);
	Display(first);
	getch();
	return 0;
	}