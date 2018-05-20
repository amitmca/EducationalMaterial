
//Program for displaying the nodes data respective to the 2 given locations
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

void PrintLocNo(NODE r)
	{
	NODE p;
	int i,j,cnt=0;
	printf("\nEnter the first location:");
	scanf("%d",&i);
	printf("\nEnter the second location:");
	scanf("%d",&j);
	for(p=r;p!=NULL;p=p->next)
		{
		cnt++;
		if(cnt==i)
			{
			printf("\n%d",p->data);
			}
		if(cnt==j)
			{
			printf("\n%d",p->data);
			}
		}
	}


void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nROOT-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf("[ %d ] -->",p->data);
		}
	printf("NULL\n\n");
	printf("\nTotal Nodes:%d\n\n",c);
	}

void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	PrintLocNo(r);
	getch();
	}	
