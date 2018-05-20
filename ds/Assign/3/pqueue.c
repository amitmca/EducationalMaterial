#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))



struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	int size,i;
	first=last=NULL;
	printf("\nSize:");
	scanf("%d",&size);
	for(i=1;i<=size;i++)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nLast Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
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
QUEUE NewJob(QUEUE last,int ele)
	{
	QUEUE first,newnode;
	first=last=NULL;

	newnode=ALLOC;
	newnode->next=NULL;
	newnode->data=ele;
	if(first==NULL)
		first=last=newnode;
	else
		{
		last->next=newnode;
		last=newnode;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	printf("\n");
	printf("first-->");
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
	first=NewJob(last,ele);
	//first=DeleteQ(first);
	first=Sort(first);
	Display(first);
	getch();
	return 0;
	}
