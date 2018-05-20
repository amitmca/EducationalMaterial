//Program to find only numbers divisible by given number n
//Date:- 3-3-08		Day:-Monday			Time:-9 to 10.30
#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next,*prev;
	};

typedef struct node *NODE;
int c=0,i,n;

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
	printf("\nEnter your number:");
	scanf("%d",&n);
	printf("\nroot-->");
	for(p=r;p!=NULL;p=p->next)
		{
		if((p->data)%n==0)
		printf("[ %d ]-->",p->data);
		}
	printf("NULL\n\n");
	}

void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	getch();
	}	
