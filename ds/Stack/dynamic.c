//Program for Stack using Dynamic way(Linked List)
//Date :- 4-3-2008	Day:- Tuesday		Time:-9 to 10.30

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *STACK;

STACK top;

void Init()
	{
	top=NULL;
	}
void Push(int n)
	{
	STACK newnode;
	char ch[]="y";
	newnode=ALLOC;
	newnode->next=NULL;
	newnode->data=n;
	if(top==NULL)
		top=newnode;
	else
		{
		newnode->next=top;
		top=newnode;
		}
	}

int Pop()
	{
	int n;
	STACK temp=top;
	n=top->data;
	top=top->next;
	free(temp);
	return(n);
	}

int Isempty()
	{
	return(top==NULL);
	}
int main()
	{
	STACK s;
	int n,choice;
	Init();
	clrscr();
	do
		{
		printf("\n1.PUSH\n2.POP\n3.EXIT\n");
		printf("\nEnter your choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nElement to push:");
				scanf("%d",&n);
				Push(n);
				clrscr();
				break;

			case 2:
				if(Isempty())
					printf("\nThe stack is empty\n");
				else
					printf("\nThe popped element is:%d",Pop());
				break;

			case 3:	
				clrscr();
				exit(0);
				break;

			default:
				printf("\nPlease enter a valid option\n\n");
				break;
			}
		}while(choice!=3);
	getch();
	}
