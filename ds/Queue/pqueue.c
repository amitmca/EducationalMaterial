// Program for Priority Queue

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))



struct node
	{
	int data;
	struct node *next,*prev;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=newnode->prev=NULL;
		printf("\n\nLast Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			newnode->prev=last;
			last=newnode;
			}
		printf("\nAnother(y/n):");
		ch=getche();
		c++;
		}
	return(first);
	}
QUEUE Sort(QUEUE first)
	{
	int tmp;
	QUEUE p,q,p1;
	while(p1!=NULL)
		{
		p=first;
		while(p->next!=NULL)
			{
			q=p->next;
			if(p->data > q->data)
				{
				tmp=p->data;
				p->data=q->data;
				q->data=tmp;
				}
			p=p->next;
			}
		p1=p1->next;
		}
	return(first);
	}
QUEUE NewJob(QUEUE first,int ele)
	{
	QUEUE newnode,p=first,last;
	int i;
	first=last=NULL;
	newnode=ALLOC;
	newnode->next=newnode->prev=NULL;
	newnode->data=ele;
	   for(p=first;p!=NULL;p=p->next)
		p->next=newnode;
		newnode->prev=p;
		newnode->next=NULL;
	c++;
	return first;
	}

void Display(QUEUE first)
	{
	printf("\n");
	printf("\n\nfirst-->");
	while(first!=NULL)
		{
		printf(" %d--> ",first->data);
		first=first->next;
		}
	printf(" last\n\n");
	}
QUEUE DeleteQ(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	c--;
	return(first);
	}
int main()
	{
	QUEUE first,last;
	int ele;
	clrscr();
	first=InsertQ(last);
	Display(first);
	printf("\nNew Job to enter:");
	scanf("%d",&ele);
	first=NewJob(first,ele);
//	first=DeleteQ(first);
//	first=Sort(first);
	Display(first);
	printf("\n%d",c);
	getch();
	return 0;
	}
