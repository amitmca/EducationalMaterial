/*Program 11.3 :  Program to reverse a string represented using a stack.*/
#include<stdio.h>
#include<conio.h>
typedef struct stack
{
	char data;
	struct stack *next;
} stack;
void init(stack **);
int empty(stack *);
char pop(stack **);
void push(stack **,char);
void main()
{
	stack *TOP;
	char x;
	init(&TOP);
	printf("\nEnter the string :");
	while((x=getchar())!='\n')
		push(&TOP,x);
	printf("\n");
	while(!empty(TOP))
	{
		x=pop(&TOP);
		printf("%c",x);
	}
}
void init(stack **T)
{
	*T=NULL;
}
int empty(stack *TOP)
{
	if(TOP==NULL)
		return(1);
	return(0);
}
void push(stack **T,char x)
{
	stack *P;
	P=(stack *)malloc(sizeof(stack));
	P->data=x;
	P->next=*T;
	*T=P;
}
char pop(stack **T)
{
	char x;
	stack * P;
	P=*T;
	*T=P->next;
	x=P->data;
	free(P);
	return(x);
}

/*
        *** OUTPUT ***
Enter the string :structure

erutcurts
*/
