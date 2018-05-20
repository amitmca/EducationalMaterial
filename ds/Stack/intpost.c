// Program for Conversion Of Infix To Postfix expression


//Example : Infix ==== > (a+b)*c             Postfix ==== > ab+c*	

#include<stdio.h>
//#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
#define MAX  15

struct stack
	{
	int items[MAX];
	int top;
	};
void init(struct stack *s)
	{
	s->top=-1;
	}
int isempty(struct stack *s)
	{
	return(s->top==-1);
	}
int Pop(struct stack *s)
	{
	return(s->items[s->top--]);
	}
void Push(struct stack *s,int n)
	{
	s->items[++s->top]=n;
	}
void postfix(char in[],char post[])
	{
	int i,j=0;
	char ch;
	struct stack s;
	init(&s);
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
			case 'g':
			case 'h':
			case 'i':  post[j]=in[i];	j++;	break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '(': Push(&s,in[i]);	break;
			case ')':
				while((ch=Pop(&s))!='(')
				{
				post[j]=ch;
				j++;
				}
			}
		}
	while(!isempty(&s))
		{
		post[j]=Pop(&s);
		j++;
		}
	post[j]='\0';
	}

int main()
	{
	char in[20],post[20];
//	clrscr();
	printf("\nEnter the Fully Parenthsized Expression:");
	scanf("%s",in);
	fflush(stdin);
	postfix(in,post);
	printf("\nThe Postfix String is:");
	printf("%s",post);
//	getch();
	}
