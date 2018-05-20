// Program to reverse the queue using stack

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))


struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *QUEUE,*STACK;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nFirst Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
		printf("\nAnother Data(y/n):");
		ch=getche();
		c++;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	int a=16;
	printf("\n\n");
	printf("first");
	printf("--%c",a);
	delay(700);
	while(first!=NULL)
		{
		printf(" %d--%c ",first->data,a);
		delay(300);
		first=first->next;
		}
	printf(" last\n\n");
	}
QUEUE DeleteQ(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	return(first);
	}
STACK Push(QUEUE first)
	{
	STACK newnode,top;
	top=NULL;
	while(first!=NULL)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=first->data;
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
		first=first->next;
		}
	return(top);
	}
void show(STACK top)
	{
	while(top!=NULL)
		{
		printf("\n%d",top->data);
		top=top->next;
		}
	}
QUEUE InsertQ1(STACK top)
	{
	QUEUE first,last,newnode;
	first=last=NULL;
	while(top!=NULL)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=top->data;
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
		top=top->next;
		}
	return(first);
	}
void main()
	{
	STACK top;
	QUEUE first,last;
	clrscr();
	first=InsertQ(last);
	Display(first);
	top=Push(first);
	show(top);
	first=InsertQ1(top);
	Display(first);
	getch();
	}