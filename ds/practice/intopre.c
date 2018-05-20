//Program for Converting Infix expression to Prefix expression

//Example : Infix ==== > (a+b)*c             Prefix ==== > *+abc	

#include<stdio.h>
#include<conio.h>
#define MAX 15
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
	s->items[++s->top]=n;
	}
int pop(struct stack *s)
	{
	return(s->items[s->top--]);
	}
int isempty(struct stack *s)
	{
	return(s->top==-1);
	}

void prefix(char in[],char pre[])
	{
	int i,j=0;
	char ch,op1,op2,expr[20];
	struct stack opnd,oprt;
	init(&opnd);
	init(&oprt);
	for(i=0;in[i]!='\0';i++)
		{
		switch(in[i])
			{
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g': push(&opnd,in[i]);	break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '(':  push(&oprt,in[i]);	break;
			case ')':
				while((ch=pop(&oprt)) !='(')
				{
				op1=pop(&opnd);
				op2=pop(&opnd);
				*expr=strcpy(expr,ch);
				printf("%c",*expr);
				}
			}
		}
	}
int main()
	{
	char pre[20],in[20];
	//clrscr();
	printf("\nEnter the Infix String:");
	scanf("%s",in);
	fflush(stdin);
	prefix(in,pre);
	printf("\nThe Prefix string is:");
	printf("%s",pre);
	getch();
	}
