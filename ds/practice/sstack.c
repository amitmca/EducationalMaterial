#include<stdio.h>
#include<conio.h>
#define MAX 100
struct stack
	{
	int top;
	int items[MAX];
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
		printf("\nStack is full\n");
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
void main()
	{
	int n,choice;
	struct stack s1;
	init(&s1);
	clrscr();
	do
		{
		printf("\n 1) Push \n\n 2) Pop \n\n 3) Exit\n\n");
		printf("\nUsers Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nElement to add:");
				scanf("%d",&n);
				push(&s1,n);
				break;
			case 2:
				if(isempty(&s1)==1)
					printf("\nStack is empty\n");
				else
					printf("\nThe popped element is:%d",pop(&s1));
				break;
			case 3:
				exit(0);
				break;
			}
		}while(choice!=3);
	getch();
	}
