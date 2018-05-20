//Program for Stack using Static way
//Date :- 4-3-2008	Day:- Tuesday		Time:-9 to 10.30

#include<stdio.h>
#include "conio.h"
#define MAX 100
struct stack
	{
	int items[MAX];
	int top;
	};

void init(struct stack *s)
	{
	s->top=-1;
	}
void push(struct stack *s,int n)
	{
	if(!isfull(s))
		{
		s->top++;
		s->items[s->top]=n;
		}
	else
		printf("\nStack is full:\n");
	}
int pop(struct stack *s)
	{
	return(s->items[s->top--]);
	}
int isempty(struct stack *s)
	{
	return(s->top==-1);
	}
int isfull(struct stack *s)
	{
	return(s->top==MAX-1);
	}
int main()
	{
	int n,choice;
	struct stack s1;
	init(&s1);
	clrscr();
	do
		{
		
		printf("\n1.PUSH\n2.POP\n3.EXIT\n");
		printf("\nEnter your choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nEnter the element to push:");
				scanf("%d",&n);
				push(&s1,n);
				clrscr();
				break;

			case 2:
				if(isempty(&s1)==1)
					printf("\nThe stack is empty\n");
				else
					printf("\nThe popped element is:%d",pop(&s1));
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
