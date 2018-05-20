/*write a program t implement circular queue of float items using array*/
#include<stdio.h>
#include<conio.h>
#include<process.h>
#include<ctype.h>
#define queuesize 10
float queue[queuesize];
int rear=-1,front=0,count=0;
char menu(void)
	{
	printf("\n\na:add item"
	       "\nd:display item"
	       "\nv:delete"
	       "\ne:exit");
	       printf("\nenter your choice...");
	       flushall();
	       return(getch());
	}

void additem(float item)
	{
	if(count==queuesize)
	{
	printf("\nthe queue is full");
	printf("press any key to exit");
	flushall();
	getch();
	exit(1);
	}
	count++;
	rear=(rear+1)%queuesize;
	queue[rear]=item;
	}
int deleteitem(void)
	{
	int item;
	if(count==0)
	{
	printf("\nqueue is empty");
	printf("\nnpress any key to exit");
	flushall();
	getch();
	exit(1);
	}
	count--;
	item=queue[front];
	front=(front+1)%queuesize;
	return item;
	}
void display(void)
	{
	int i,ch;
	if(count==0)
	{
	printf("\nthe queue is empty");
	}
	printf("\nthe queue is as follows");
	printf("\nfront=%d,\trear=%d",front,rear);
	printf("\nthe items are");
	for(i=front,ch=count;ch>0;ch--,i=(i+1)%queuesize)
	{
	printf("\n%f",queue[i]);
	}
	printf("\npress any key to continue...");
	getch();
	}

void main(void)
	{
	int item;
	clrscr();
	while(1)
	{
	switch(menu())
	{
	case 'a':
		printf("\nenter the item");
		scanf("%d",&item);
		additem(item);
		break;
	case 'v':
		item=deleteitem();
		printf("\nthe deleted item is=>%d",item);
		break;
	case 'd':
		display();
		break;
	case 'e':
		exit(0);
	}//end of switch...
	}//end of while...
	}//end of main...

