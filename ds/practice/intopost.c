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
			case 'g': post[j]=in[i];	j++;	break;
			case '+':
			case '-':
			case '*':
			case '/':
			case '%':
			case '(':  push(&s,in[i]);	break;
			case ')':
				while((ch=pop(&s)) !='(')
				{
				post[j]=ch;
				j++;
				}
			}
		}
	while(!isempty(&s))
		{
		post[j]=pop(&s);
		j++;
		}
	post[j]='\0';
	}
void main()
	{
	char post[20],in[20];
	clrscr();
	printf("\nEnter the Infix String:");
	scanf("%s",in);
	fflush(stdin);
	postfix(in,post);
	printf("\nThe Postfix string is:");
	printf("%s",post);
	getch();
	}
