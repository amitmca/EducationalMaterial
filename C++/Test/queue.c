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
	QUEUE newnode,first;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n Rear Data:");
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
	return(first);
	}
void Display(QUEUE first)
	{
	while(first!=NULL)
		{
		printf("\t%d",first->data);
		first=first->next;
		}
	}
int main()
	{
	QUEUE first,last;
	clrscr();
	first=last=NULL;
	first=Add(last);
	Display(first);
	getch();
	return 0;
	}