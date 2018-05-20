/* Queue represented using a linked list.*/

#include<conio.h>
#include<stdio.h>
#define MAX 10
typedef struct node
{
	int data;
	struct node *next;
}node;

typedef struct Q
{
	node  *R,*F;
}Q;

void initialise(Q *);
int empty(Q *);
int full(Q *);
void enqueue(Q *,int);
int dequeue(Q *);
void print(Q *);
void main()
{
	Q q;
	int x,i,op;
	initialise(&q);
	clrscr();
     do{
	printf("\n\n1)Insert\n2)Delete\n3)Print\n4)Quit");
	printf("\nEnter Your Choice:");
	scanf("%d",&op);
	switch(op)
	 { case 1: printf("\n Enter a value:");
		   scanf("%d",&x);
		   enqueue(&q,x);
		   break;
	   case 2:if(!empty(&q))
		    {x=dequeue(&q);
		     printf("\Deleted Data=%d",x);
		    }
		   else
		    printf("\nQueue is empty !!!!");
		   break;
	   case 3: print(&q);break;
	}
      }while(op!=4);
}

void initialise(Q *qP)
{
	qP->R=NULL;
	qP->F=NULL;
}
void enqueue(Q *qP,int x)
{
	node *P;
	P=(node*)malloc(sizeof(node));
	P->data=x;
	P->next=NULL;
	if(empty(qP))
	{
		qP->R=P;
		qP->F=P;
	}
	else
	{
		(qP->R)->next=P;
		qP->R=P;
	}
}
int dequeue(Q *qP)
{
	int x;
	node *P;
	P=qP->F;
	x=P->data;
	if(qP->F==qP->R)  //deleting the last element
		initialise(qP);
	else
		qP->F=P->next;
	free(P);
	return(x);
}
void print(Q *qP)
{
	int i;
	node *P;
	P=qP->F;
	while(P!=NULL)
	{
		printf("\n%d",P->data);
		P=P->next;
	}
}
int empty(Q *qp)
{ if(qp->R==NULL)
     return 1;
   return 0;
}

/*
                  *** OUTPUT ***
1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:1

 Enter a value:20


1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:1

 Enter a value:30
1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:1

 Enter a value:40


1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:3

20
30
40


1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:2
Deleted Data=20

1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:3

30
40

1)Insert
2)Delete
3)Print
4)Quit
Enter Your Choice:4
*/
