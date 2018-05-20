/* program for conversion of infix to its postfix form and its evaluation
   operators supported '+,-,*,/,%,^,(,)
   operands supported -- all single digit operands */

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
void infix_to_postfix(char postfix[]);
 void evaluate(char postfix[]);

void main()
{  char postfix[30];
   infix_to_postfix(postfix);
   printf("\npostfix= %s",postfix);
   evaluate(postfix);
   getch();
}

void infix_to_postfix(char postfix[])
 {  	stack s;
	char x;
	int token,i=0;
	init(&s);
	printf("\nEnter infix expression:");
	while((token=getchar())!='\n')
	{
		if(isalnum(token))
			postfix[i++]=token;
		else
			if(token == '(')
				push(&s,'(');
			else
				if(token == ')')
				   while((x=pop(&s))!='(')
					postfix[i++]=x;
				else
				{
					while(precedence(token)<=precedence(top(&s)) && !empty(&s))
				{
						x=pop(&s);
						postfix[i++]=x;
					 }
						push(&s,token);
				}
	}
	while(!empty(&s))
	{
		x=pop(&s);
		postfix[i++]=x;
	}
	postfix[i]='\0';
  }
 void evaluate(char postfix[])
  { stack s;
    int op1,op2,oprtor,val=0,i;
    init(&s);
    for(i=0;postfix[i]!='\0';i++)
     { if(isdigit(postfix[i]))
	{ op1=postfix[i]-48;/*character digit to integer form */
	  push(&s,op1);
	}
      else
       { op2=pop(&s);
	 op1=pop(&s);
	 switch(postfix[i])
	  { case '+':push(&s,op1+op2);break;
	    case '-':push(&s,op1-op2);break;
	    case '*':push(&s,op1*op2);break;
	    case '/':push(&s,op1/op2);break;
	    case '%':push(&s,op1%op2);break;
	 }
      }
    }
  val=pop(&s);
  printf("\nValue of the expression= %d",val);
  getch();
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
Enter infix expression:2*(7-5)

postfix= 275-*
Value of the expression= 4
*/
