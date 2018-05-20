//Program to reverse a doubly linked list
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
	NODE newnode,p;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->prev=NULL;
		printf("\n\nNode Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			newnode->prev=p;
			p=newnode;
			}
		printf("\n Another Node(yes/no):");
		ch=getche();
		c++;
		}
	return(r);
	}

void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("\nroot-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf("[ %d ]-->",p->data);
		}
	printf("NULL\n");
	printf("\nTotal Nodes:%d\n\n",c);
	}
NODE ReverseList(NODE r)
	{
	int i,j;
	NODE f,c,b;
	f=r;
	c=NULL;
	while(f)
		{
		b=c;
		c=f;
		f=f->next;
		c->next=b;
		}
	r=c;
	return(r);
	}
main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	r=ReverseList(r);
	DisplayList(r);
	getch();
	}	
