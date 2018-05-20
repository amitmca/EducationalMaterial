//Program for Reversing a stack

#include<stdio.h>
#include"conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))



struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *SQ;

int c=0;

SQ Push(SQ top)
	{
	SQ newnode;
	char ch[10];
	top=NULL;
	while(strcmp(ch,"y")==0)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nTop Data:");
		scanf("%d",&newnode->data);
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
		printf("\nAnother Data(y/n):");
		ch=getche();
		c++;
		}
	return(top);
	}
void Display(SQ top)
	{
	int b=25;
	printf("\n\n");
	printf("top");
	printf("--->");
	while(top!=NULL)
		{
		printf("\t%d\n",top->data);
		printf("\t %c\n",b);
		top=top->next;
		}
	printf("\tNULL\n\n");
	}
SQ InsertQ(SQ top)
	{
	SQ first,newnode,last;
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
SQ Push1(SQ first)
	{
	SQ newnode,top;
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
int main()
	{
	SQ top;
	clrscr();
	top=Push(top);
	printf("\nThe Original stack elements are:\n\n");
	Display(top);
	top=InsertQ(top);
	top=Push1(top);
	printf("\nThe Reversed stack elements are:\n\n");
	Display(top);
	getch();
	}





