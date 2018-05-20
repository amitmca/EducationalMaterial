//Program for Reversing a stack using another stack

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
	printf("top");
	printf("--->");
	delay(700);
	while(top!=NULL)
		{
		printf("\t%d\n",top->data);
		delay(300);
		printf("\t %c\n",b);
		top=top->next;
		}
	printf("\tNULL\n\n");
	}
STACK ReverseList(STACK top)
	{
	STACK f,c,b;
	f=top;
	c=NULL;
	while(f)
		{
		b=c;
		c=f;
		f=f->next;
		c->next=b;
		}
	top=c;
	top=top->next;
	return(top);
	}
void main()
	{
	STACK top;
	clrscr();
	top=Push(top);
	Display(top);
	ReverseList(top);
	Display(top);
	getch();
	}





