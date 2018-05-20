/*Program 12.2 : A sample program showing various operations on a queue represented using a linked list.*/
//(a)	Insert five values in the queue.
//(b)	Print elements of the queue.
//(c)	Delete 2 elements from the queue.
//(d)	Print elements of the queue.
//(e)	Delete the remaining elements of the queue.
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
	int x,i;
	initialise(&q);
	printf("\nEnter 5 elements :");
	for(i=1;i<=5;i++)
	{
		scanf("%d",&x);
		enqueue(&q,x);
	}
                  printf("\ndisplaying queue :");
	print(&q);
	x=dequeue(&q);
	x=dequeue(&q);
                  printf("\nafter deletion of two elements :");    
	print(&q);

	//delete remaining elements
	while(!empty(&q))
		x=dequeue(&q);
	getch();
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
Enter 5 elements :4 5 34 21 90

4
5
34
21
90

34
21
90

*/
