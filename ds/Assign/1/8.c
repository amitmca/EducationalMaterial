
//Program for displaying the total of adjucent node data
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
	int sum=0;
	NODE p;
	printf("\n\n");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d ",p->data);
		}
	printf("\n\n");
	for(p=r;p!=NULL;p=p->next)
		{
		sum=sum+p->data+p->prev->data+p->next->data;
		printf("\nSum is:%d\n",sum);
		sum=0;
		}
	printf("\nTotal Nodes:%d\n\n",c);
	}

void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	getch();
	}	
