//Program for Creating  a stack using Linked list

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

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
	printf("\n");
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

void main()
	{
	STACK top;
	clrscr();
	top=Push(top);
	Display(top);
	top=Pop(top);
	Display(top);
	getch();
	}





