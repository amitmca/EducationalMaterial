//Program for merging 2 linked lists

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
//#include<dos.h>

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int c=0;

NODE Create(NODE r)
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
void Display(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d -- %c ",p->data,16);
		//delay(1000);
		}
	printf("%c\n\n",219);
	printf("\n Total Nodes:%d\n",c);
	}
NODE Merge(NODE r1,NODE r2)
	{
	NODE t1=r1,t2=r2,t3,r3,newnode;
	t3=r3=NULL;
	while(t1 && t2)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		if(t1->data < t2->data)
			{
			newnode->data=t1->data;
			t1=t1->next;
			}
		else
			{
			newnode->data=t2->data;
			t2=t2->next;
			}
		if(t3==NULL)
			t3=r3=newnode;
		else
			{
			t3->next=newnode;
			t3=newnode;
			}
		}
	if(t1)
		t3->next=t1;
	if(t2)
		t3->next=t2;
	return(r3);
	}
void main()
	{
	NODE r1,r2,r3;
	clrscr();
	r1=Create(r1);
	Display(r1);
	r2=Create(r2);
	Display(r2);
	clrscr();
	r3=Merge(r1,r2);
	Display(r3);
	getch();
	}