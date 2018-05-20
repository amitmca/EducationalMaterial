//Program for Copying a stack

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<graphics.h>
#include<dos.h>


struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *STACK;

int c=0;

STACK Push(STACK top)
	{
	STACK newnode;
	char ch='y';
	top=NULL;
	while(ch=='y')
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
void Display(STACK top)
	{
	int b=25;
	printf("\n\n");
	while(top!=NULL)
		{
		printf("top");
		printf("--->");
		delay(700);
		printf("\t%d\n",top->data);
		delay(300);
		printf("\t %c\n",b);
		top=top->next;
		}
	printf("\tNULL\n\n");
	}
STACK Pop(STACK top)
	{
	STACK tmp=top;
	top=top->next;
	free(tmp);
	c--;
	return(top);
	}
STACK Copy(STACK top)
	{
	STACK top1,newnode;
	top1=NULL;
	top1=Pop(top);
	newnode=ALLOC;
	newnode->next=NULL;
	if(top1==NULL)
		top1=newnode;
	else
		{
		newnode->next=top1;
		top1=newnode;
		}
	return(top1);
	}
void main()
	{
	STACK top,top1;
	clrscr();
	top=Push(top);
	Display(top);
	top1=Copy(top);
	printf("\nThe Copied Stack is:\n\n");
	Display(top1);
	getch();
	}





