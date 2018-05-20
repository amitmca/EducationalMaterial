//Program for Singly Linked List

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODEPTR;

NODEPTR Create()
	{
	NODEPTR start=NULL,newnode,temp;
	int n,i;
	printf("\n How many Nodes:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n Node Data:");
		scanf("%d",&newnode->data);
		if(start==NULL)
			start=temp=newnode;
		else
			{
			temp->next=newnode;
			temp=newnode;
			}
		}
	return(start);
	}
void Display(NODEPTR start)
	{
	NODEPTR temp=start;
	while(temp!=NULL)
		{
		printf("\n%d",temp->data);
		temp=temp->next;
		}
	}
void main()
	{
	NODEPTR start=NULL;
	clrscr();
	start=Create();
	Display(start);
	getch();
	}