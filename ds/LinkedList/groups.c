/*Program for Singly Linked List*/

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

NODE Create(NODE e)
	{
	NODE p,newnode;
	newnode=ALLOC;
	newnode->next=NULL;
	if(e==NULL)
		e=p=newnode;
	else
		{
		p->next=newnode;
		p=newnode;
		}
	return(e);
	}

NODE CreateList(NODE r)
	{
	int i;
	NODE newnode;
	char ch='y';
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(newnode->data%2==0)
			{
			Create(r);
			printf("\n\nDo you want to have another record(y/n):");
			ch=getche();
			return(r);
			}
		else
			{
			Create(r);
			printf("\n\nDo you want to have another record(y/n):");
			ch=getche();
			return(r);
			}
		}
	return r;
	}
void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("\t");

	for(p=r;p!=NULL;p=p->next)
		{
		printf("[ %d ] --> ",p->data);
		delay(1000);
		}
	printf("NULL\n\n");
	}
/*NODE insert(NODE r,int pos,int num)
	{
	int i;
	NODEPTR newnode,temp;
	newnode=ALLOC;
	newnode->data=num;
	newnode->next=NULL;
	if(pos==0)
		{
		newnode->next=start;
		start=newnode;
		return start;
		}
	else if(pos==n)
		{
		for(temp=start;temp->next!=NULL;temp=temp->next);
			temp->next=newnode;
		return start;
		}
	else
		{
	for(i=1;i < pos-1 && temp->next!=NULL;i++,temp=temp->next);
		newnode->next=temp->next;
		temp->next=newnode;
		return start;
		}

	}*/
void main()
	{
	int num,i;
	NODE r,p;
	clrscr();
	CreateList(p);
	delay(1000);
	printf("\n\nPlease wait while creating the node..............\n\n");
	delay(1500);
	DisplayList(r);
	/*printf("\n Position and New node to insert:");
	scanf("%d%d",&i,&num);
	start=insert(start,i,num);
	printf("\n\n New Linked List is:\n\n");
	display(start);*/
	getch();
	}
