//Program for Doubly Circular Linked List
//Date:- 3-3-2008		Day:-Monday			Time:- 9 to 10.30
#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next,*prev;
	};
typedef struct node *NODE;

int c=0;

NODE CreateList(NODE r)
	{
	int i;
	NODE p,newnode;
	char ch='y';
	r=newnode=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=newnode->prev=NULL;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			{
			r=p=newnode;
			r->prev=newnode;
			newnode->next=r;
			}
		else
			{
			p->next=newnode;
			newnode->next=r;
			r->prev=newnode;
			p=newnode;
			}
		printf("\n\nDo you want to have another record(y/n):");
		ch=getche();
		c++;
		}

	return r;
	}
void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("\nSTART-->[ %d ]-->",p->data);
	for(p=r->next;p!=r;p=p->next)
		{
		printf("[ %d ] --> ",p->data);
		}
	printf("NULL\n\n");
	printf("\n Total Nodes:%d\n",c);
	}

void main()
	{
	NODE r,p;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	getch();
	}
