/*Program for finding middle element from a Singly Linked List*/

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
	int i;
	NODE p,newnode;
	char ch='y';
	r=p=NULL;
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
		printf("\n\nDo you want to have another record(y/n):");
		ch=getche();
		c++;
		}
	return r;
	}
void DisplayList(NODE r)
	{
	NODE p;
	int i=0,a[20];
	printf("\n\nThe Linked List is:\n\n");
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		a[i++]=p->data;
		printf(" %d -- %c ",p->data,16);
		delay(1000);
		}
	printf("%c\n\n",219);
	printf("\n Total Nodes:%d\n",c);
	}
void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	getch();
	}