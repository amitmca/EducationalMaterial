/*Program 11.4 : Program for evaluation of a postfix expression.*/
/*Assumption-- primary operators  '-,+,*,/,%'  operand -- a single digit*/
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
int evaluate(char x,int op1,int op2);
void main()
{
	stack s;
	char x;
	int op1,op2,val;
	init(&s);
	printf("\nEnter the expression(i.e59+3*)\nsingle digit operand and operators only:");
	while((x=getchar())!='\n')
	{
		if(isdigit(x))
			push(&s,x-48);
		else
		{
			op2=pop(&s);
			op1=pop(&s);
			val=evaluate(x,op1,op2);
			push(&s,val);
	       }
	}
	val=pop(&s);
	printf("\nvalue of expression = %d",val);
}
int evaluate(char x,int op1,int op2)
{
	if(x=='+')
		return(op1+op2);
	if(x=='-')
		return(op1-op2);
	if(x=='*')
		return(op1*op2);
	if(x=='/')
		return(op1/op2);
	if(x=='%')
		return(op1%op2);
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
Enter the expression(i.e59+3*)
single digit operand and operators only:653+9*+

value of expression = 78
*/
