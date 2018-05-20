/* stack in an array */

#include<stdio.h>
#include<conio.h>
#define MAX 6
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
void print(stack *);
void main()
{
	stack s;
	int x,op;
	init(&s);
	clrscr();
	do {
	     printf("\n\n1)Push\n2)Pop\n3)Print\n4)Quit");
	     printf("\nEnter Your choice: ");
	     scanf("%d",&op);
	     switch(op)
	      { case 1:printf("\n enter a number :");
		       scanf("%d",&x);
		       if(!full(&s))
			  push(&s,x);
		       else
			  printf("\nStack is full......");
		       break;
	       case 2:if(!empty(&s))
			 { x=pop(&s);
			   printf("\npopped value= %d",x);
			 }
		       else
			printf("\nStack is empty.....");
		       break;

	       case 3:print(&s);break;
	     }
      }while(op!=4);
}
void init(stack *s)
{ s->top=-1;
}

int empty(stack *s)
{ 	if(s->top==-1)
		return(1);
	return(0);
}

int full(stack *s)
{ 	if(s->top==MAX-1)
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
void print(stack *s)
  { int i;
    printf("\n");
    for(i=s->top;i>=0;i--)
     printf("%d  ",s->data[i]);
  }

/*
                      *** OUTPUT ***
1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 1

 enter a number :5


1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 1

 enter a number :4

1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 1

 enter a number :3


1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 3

3  4  5

1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 2

popped value= 3

1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 3

4  5

1)Push
2)Pop
3)Print
4)Quit
Enter Your choice:4
*/
