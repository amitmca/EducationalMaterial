//Program for making even and odd into seprate stack

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
	int i,size;
	top=NULL;
	printf("\nSize:");
	scanf("%d",&size);
	for(i=0;i<size;i++)
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
		}
	return(top);
	}

SQ even(SQ top)
	{
	SQ newnode;
	newnode=ALLOC;
	newnode->next=NULL;
	if(newnode->data%2==0)
		{
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
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

void main()
	{
	SQ top,top1;
	clrscr();
	top=Push(top);
	printf("\nThe Original stack elements are:\n\n");
	Display(top);
	top1=even(top);
	Display(top1);
	getch();
	}





