// Insertion and Deletion for Doubly Linked List

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next,*prev;
	};
typedef struct node *NODEPTR;

int c=0;

NODEPTR Create()
	{
	NODEPTR start=NULL,newnode,temp;
	char ch;
	do
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->prev=NULL;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(start==NULL)
			start=temp=newnode;
		else
			{
			temp->next=newnode;
			newnode->prev=temp;
			temp=newnode;
			}
		printf("\n\n Another Node:(Y/N)");
		ch=getche();
		c++;
		}while(ch=='y' || ch=='Y');
	return(start);
	}

void Display(NODEPTR start)
	{
	NODEPTR temp;
	printf("\n\n\nSTART->");
	for(temp=start;temp!=NULL;temp=temp->next)
		{
		printf("\t%d->",temp->data);
		}
	printf("NULL");
	}

NODEPTR Insert(NODEPTR start,int pos,int num)
	{
	NODEPTR temp,temp1,newnode;
	int i;
	newnode=ALLOC;
	newnode->next=newnode->prev=NULL;
	newnode->data=num;
	if(pos==1)
		{
		newnode->next=start;
		start->prev=newnode;
		start=newnode;
		c++;
		return(start);
		}
	else if(pos==c)
		{
		for(temp=start;temp->next!=NULL;temp=temp->next);
		temp->next=newnode;
		newnode->prev=temp;
		temp=newnode;
		c++;
		return(start);
		}
	else
		{
		temp=start;
		for(i=0;i<pos-1;i++)
			temp=temp->next;
		temp1=temp->next;
		temp->next=newnode;
		newnode->prev=temp;
		newnode->next=temp1;
		temp->prev=newnode;
		temp=newnode;
		c++;
		return(start);
		}
	}

NODEPTR Delete(NODEPTR start,int pos)
	{
	NODEPTR temp,temp1;
	int i;
	if(pos==1)
		{
		temp=start;
		temp1=temp;
		temp=temp->next;
		free(temp1);
		start=temp;
		c--;
		return(start);
		}
	else if(pos==c)
		{
		temp=start;
		for(i=1;i<c-1;i++)
			temp=temp->next;
		temp1=temp->next;
		free(temp1);
		temp->next=NULL;
		c--;
		return(start);
		}
	}

int main()
	{
	NODEPTR start=NULL;
	int p,n;
	clrscr();
	start=Create();
	Display(start);
	printf("\n\n Position:");
	scanf("%d",&p);
	printf("\n Data:");
	scanf("%d",&n);
	start=Insert(start,p,n);
	Display(start);
	printf("\n\n Position:");
	scanf("%d",&p);
	start=Delete(start,p);
	Display(start);
	getch();
	return 0;
	}