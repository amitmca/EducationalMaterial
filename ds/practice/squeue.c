#include<stdio.h>
//#include<conio.h>
#define MAX 100
struct queue
	{
	int front,rear;
	int items[MAX];
	};
void init(struct queue *q)
	{
	q->front=q->rear=-1;
	}
void addq(struct queue *q,int n)
	{
	if(!isfull(q))
		{
		q->rear++;
		q->items[q->rear]=n;
		}
	else
		printf("\nQueue is Full\n\n");
	}
int delq(struct queue *q)
	{
	int s;
	q->front++;
	s=q->items[q->front];
	return(s);
	}
int isempty(struct queue *q)
	{
	return(q->front==q->rear);
	}
int isfull(struct queue *q)
	{
	return(q->rear==MAX-1);
	}

void main()
	{
	int n,c;
	struct queue q;
	init(&q);
	//clrscr();
	do
		{
		printf("\n\n  1)  ADD \n\n  2)  DELETE  \n\n  3)  EXIT\n\n");
		printf("\nUsers Choice:");
		scanf("%d",&c);
		switch(c)
			{
			case 1:
			     printf("\nElement :");
			     scanf("%d",&n);
			     addq(&q,n);
			     break;
			case 2:
			      if(isempty(&q)==1)
				printf("\nQueue is empty\n\n");
			      else
				printf("\nThe element deleted is:%d",delq(&q));
			     break;
			case 3:
			     exit(0);
			     break;
			}
		}while(c!=3);
	getch();
	}
