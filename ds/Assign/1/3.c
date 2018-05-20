
//Program for displaying 1) Only odd locations node 2) First node and Last node
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

int c=0,e=0,o=0,f,l;

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
	int i=0;
	printf("\n\nOdd locations nodes are:\t");
	for(p=r;p!=NULL;p=p->next)
		{
		i++;
		if(i%2!=0)
			{
			printf("%d\t",p->data);
			}
		}
	i=0;
	for(p=r;p!=NULL;p=p->next)
		{
		i++;
		if(i==1)
			{
			printf("\n\nFirst Node:%d\n\n",p->data);
			}
		if(i==c)
			{
			printf("\nLast Node:%d\n\n",p->data);
			}
		}
	printf("\nTotal Nodes:%d\n",c);
	}

void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	getch();
	}
