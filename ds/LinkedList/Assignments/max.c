//Program to find maximum from a singly linked list
//Date:- 3-3-2008		Day:-Monday			Time:- 9 to 10.30

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *NODE;

NODE CreateList(NODE r)
	{
	NODE newnode,p;
	char ch='y';
	p=r=NULL;
	do
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nNode Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother(y/n):");
		ch=getc(stdin);
		}while(ch=='y');
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
	
	}
void Maximum(NODE r)
	{
	NODE max,p;
	p=r;
	max->data=p->data;
	for(p=r;p!=NULL;p=p->next)
		{
		if(p->next->data > max->data)
			max->data=p->next->data;
		}
	printf("\nMax:%d",max->data);
	}
int main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	Maximum(r);
	getch();
	}	
