/*Program to move a node in a Singly Linked List*/

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<dos.h>

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
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d -- %c ",p->data,16);
		delay(1000);
		}
	printf("%c\n\n",219);
	printf("\n Total Nodes:%d\n",c);
	}
NODE Move(NODE r)
	{
	NODE p,tmp1,tmp;
	int i,k=0,j;
	printf("\nEnter the position of node to move:");
	scanf("%d",&i);
	printf("\nEnter the position at which to node to move:");
	scanf("%d",&j);
	for(p=r;p!=NULL;p=p->next)
		{
		k++;
		if(k==i)
			{
			tmp1->data=p->data;
			p->data=p->next->data;
			p->next->data=tmp1->data;
			}
		}
	return(r);
	}
void main()
	{
	NODE r;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	r=Swap(r);
	DisplayList(r);
	getch();
	}
