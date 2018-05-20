//Program to insert an element in an sorted linked list

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
NODE SortList(NODE  r)
	{
	int temp;
	NODE p=r,p1,q;
	while(p1!=NULL)
		{
		p=r;
		while(p->next!=NULL)
			{
			q=p->next;
			if(p->data > q->data)
				{
				temp=p->data;
				p->data=q->data;
				q->data=temp;
				}
			p=p->next;
			}
		p1=p1->next;
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
NODE InsertSorted(NODE r,int num)
	{
	NODE newnode,p,tmp;
	newnode=ALLOC;
	newnode->next=NULL;
	newnode->data=num;
	p=r;
	while(p!=NULL)
		{
		if(newnode->data >= p->data && newnode->data <= p->next->data)
			{
			tmp=p->next;
			p->next=newnode;
			newnode->next=tmp;
			c++;
			}
		p=p->next;
		}
	return(r);
	}
void main()
	{
	NODE r;
	int num;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	r=SortList(r);
	printf("\nThe Sorted Linked List is:\n\n");
	DisplayList(r);
	printf("\nEnter the data to insert:");
	scanf("%d",&num);
	r=InsertSorted(r,num);
	printf("\nAfter inserting an element:\n\n");
	DisplayList(r);
	getch();
	}

