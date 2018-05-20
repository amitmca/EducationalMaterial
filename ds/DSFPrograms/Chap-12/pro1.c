/*Program 12.1 : A sample program for queue.*/
//Show the status of the queue after every operation.
//(a) Insert 5 elements  (b) Delete 2 elements  
#include<conio.h>
#include<stdio.h>
#define MAX 10
typedef struct Q
{
	int R,F;
	int data[MAX];
} Q;
void initialise(Q *P);
int empty(Q *P);
int full(Q *P);
void enqueue(Q *P,int x);
int dequeue(Q *P);
void print(Q *P);
void main()
{
	Q q;
	int x,i;
	initialise(&q);
	printf("\nEnter 5 elements :");
	for(i=1;i<=5;i++)
	{
		scanf("%d",&x);
		if(!full(&q))
			enqueue(&q,x);
		else
		{
			printf("\n Queue is full .......exitting");
			exit(0);
		}
	}
	print(&q);
	for(i=1;i<=2;i++)
	{
		if(!empty(&q))
			x=dequeue(&q);
		else
		{
			printf("\ncan not delete...Queue is empty");
			exit(0);
		}
	}
	print(&q);
}
void initialise(Q *P)
{
	P->R=-1;
	P->F=-1;
}
int empty(Q *P)
{
	if(P->R==-1)
		return(1);
	return(0);
}
int full(Q *P)
{
	if(P->R==MAX-1)
		return(1);
	return(0);
}
void enqueue(Q *P,int x)
{
	if(P->R==-1)
	{
		P->R=P->F=0;
		P->data[P->R]=x;
	}
	else
	{
		P->R=P->R+1;
		P->data[P->R]=x;
	}
}
int dequeue(Q *P)
{
	int x;
	x=P->data[P->F];
	if(P->R==P->F)
	{
		P->R=-1;
		P->F=-1;
	}
	else
		P->F=P->F+1;
	return(x);
}
void print(Q *P)
{
	int i;
	if(!empty(P))
	{
		printf("\n");
		for(i=P->F;i<=P->R;i++)
			printf("%d\n",P->data[i]);
	}
}


/*
           *** OUTPUT ***
Enter 5 elements :5 4 3 2 1

5       4       3       2       1
3       2       1
*/
