//Program to insert an element in an sorted array

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int c=0;

NODE CreateList(NODE r)
	{
	int i,size;
	NODE p,newnode;
	char ch='y';
	r=newnode=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother data(y/n):");
		ch=getche();
		c++;
		}
	return(r);
	}

void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d-->",p->data);
		}
	printf("NULL\n");
	printf("\n Total Nodes:%d\n",c);
	}
void main()
	{
	NODE r,r1;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	r1=r;
	DisplayList(r1);
	getch();
	}

