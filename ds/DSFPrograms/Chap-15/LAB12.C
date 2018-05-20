/* stack  using a linked list */

#include<stdio.h>
#include<conio.h>
typedef struct stack
{
	int data;
	struct stack *next;
} stack;
void init(stack **);
int empty(stack *);
int pop(stack **);
void push(stack **,int);
void print(stack *p);
void main()
{
	stack *TOP;
	int x,op;
	init(&TOP);
		clrscr();
	do {
	     printf("\n\n1)Push\n2)Pop\n3)Print\n4)Quit");
	     printf("\nEnter Your choice: ");
	     scanf("%d",&op);
	     switch(op)
	      { case 1:printf("\n enter a number :");
		       scanf("%d",&x);
		       push(&TOP,x);
		       break;
	       case 2:if(!empty(TOP))
			 { x=pop(&TOP);
			   printf("\npopped value= %d",x);
			 }
		       else
			printf("\nStack is empty.....");
		       break;

	       case 3:print(TOP);break;
	     }
      }while(op!=4);

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
void push(stack **T,int x)
{
	stack *P;
	P=(stack *)malloc(sizeof(stack));
	P->data=x;
	P->next=*T;
	*T=P;
}
int pop(stack **T)
{
	int x;
	stack * P;
	P=*T;
	*T=P->next;
	x=P->data;
	free(P);
	return(x);
}
void print(stack *p)
 { printf("\n");
  while(p!=NULL)
   {printf("%d  ",p->data);
    p=p->next;
   }
}

/*
                   *** OUTPUT ***
1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 1

 enter a number :1


1)Push
2)Pop
3)Print
4)Quit
Enter Your choice: 1

 enter a number :2

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

3  2  1

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

2  1

1)Push
2)Pop
3)Print
4)Quit
Enter Your choice:4
*/
