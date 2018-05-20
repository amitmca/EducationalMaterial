/*Program 13.3 :Program for creating an expression tree from a postfix expression and printing its preorder and inorder traversal sequence*/
#include<conio.h>
#include<stdio.h>
typedef struct node
{
	char data;
	struct node *left,*right;
}node;
typedef struct stack
{
	node *data[30];
	int top;
}stack;
void push(stack *s,node *x)
{
	s->top=s->top+1;
	s->data[s->top]=x;
}
node* pop(stack *s)
{
	node* x;
	x=s->data[s->top];
	s->top=s->top-1;
	return(x);
}
void preorder(node *T)
{
	if(T!=NULL)
	{
		printf("%c", T -> data);
		preorder(T -> left);
		preorder(T -> right);
	}
}
void inorder(node *T)
{
	if(T!=NULL)
	{
		inorder(T -> left);
		printf("%c", T -> data);
		inorder(T -> right);
	}
}
void main()
{
	char c;
	stack s;
	node *top,*t1,*t2;
	top=NULL;
	s.top=-1;
	printf("\nEnter a postfix expression:");
	while((c=getchar())!='\n')
	{
		if(isalpha(c))
		{
			top=(node*)malloc(sizeof(node));
			top->left=NULL;
			top->right=NULL;
			top->data=c;
			push(&s,top);
		}
		else
		{
			t2=pop(&s);
			t1=pop(&s);
			top=(node*)malloc(sizeof(node));
			top->data=c;
			top->left=t1;
			top->right=t2;
			push(&s,top);
		}
	}
printf("\n preorder/prefix ->");
preorder(top);
printf("\n inorder/infix ->");
inorder(top);
}
/*
          *** OUTPUT
Enter a postfix expression:AB*C+

 preorder/prefix ->+*ABC
 inorder/infix ->A*B+C
*/
