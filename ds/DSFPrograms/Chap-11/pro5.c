/*Program 11.5 : Program for conversion of infix to its postfix form operators supported '+,-,*,/,%,^,(,) operands supported -- all single character operands.*/
#include<stdio.h>
#include<conio.h>
#include<ctype.h>
#define MAX 50
typedef struct stack
{
	int data[MAX];
	int top;
}stack;
int precedence(char);
void init(stack *);
int empty(stack *);
int full(stack *);
char pop(stack *);
void push(stack *,char);
char top(stack *); //value of the top element
void main()
{ 	stack s;
	char x;
	char token;
	init(&s);
	clrscr();
	printf("\nEnter infix expression:");
	while((token=getchar())!='\n')
	{
		if(isalnum(token))
			printf("%c",token);
		else
			if(token == '(')
				push(&s,'(');
			else
				if(token == ')')
				   while((x=pop(&s))!='(')
					printf("%c",x);
				else
				{
					while(precedence(token)<=precedence(top(&s)) && !empty(&s))
					{
						x=pop(&s);
						printf("%c",x);
					 }
						push(&s,token);
				}
	}
	while(!empty(&s))
	{
		x=pop(&s);
		printf("%c",x);
	}
}
int precedence(char x)
{
	if(x == '(')
		return(0);
	if(x == '+' || x == '-')
		return(1);
	if(x == '*' || x == '/' || x == '%')
		return(2);
	return(3);
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
void push(stack *s,char x)
{
	s->top=s->top+1;
	s->data[s->top]=x;
}
char pop(stack *s)
{
	int x;
	x=s->data[s->top];
	s->top=s->top-1;
	return(x);
}
char top(stack * p)
{
	return(p->data[p->top]);
}

/*
        *** OUTPUT ***
Enter infix expression:a*(b+c)/d+g
abc+*d/g+
*/
