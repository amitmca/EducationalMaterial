/*Program 11.1 : Program for conversion of decimal number to binary form.*/
#include<stdio.h>
#include<conio.h>
#define MAX 20
typedef struct stack
{
	int data[MAX];
	int top;
}stack;
void init(stack *);
int empty(stack *);
int full(stack *);
int pop(stack *);
void push(stack *,int);
void main()
{
	stack s;
	int x;
	init(&s);
	printf("\nEnter decimal number:");
	scanf("%d",&x);
	while((x!=0))
	{
		if(!full(&s))
		{
			push(&s,x%2);
			x=x/2;
		}
		else
		{
			printf("\nstack overflow");
			exit(0);
		}
	}
	printf("\n");
	while(!empty(&s))
	{
		x=pop(&s);
		printf("%d",x);
	}
}
void init(stack *s)
{
	s->top=-1;
}
int empty(stack *s)
{
	if(s->top==-1)
		return(1);
	return(0);
}
int full(stack *s)
{
	if(s->top==MAX-1)
		return(1);
	return(0);
}
void push(stack *s,int x)
{
	s->top=s->top+1;
	s->data[s->top]=x;
}
int pop(stack *s)
{
	int x;
	x=s->data[s->top];
	s->top=s->top-1;
	return(x);
}

/*
        *** OUTPUT ***
Enter decimal number:12

1100
*/
