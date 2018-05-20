//program to implement circular queue
#include<stdio.h>
#include<conio.h>
#define qsize 10
	int  front=-1;
       int rear=-1;
	int queue[qsize];

	 void insert(void)
		{
		if((front==0&&rear==qsize-1)||front==rear+1)
			printf("\n queue is full");
		else if(front==-1)
			{
			front=0;
			rear=0;
			}
		else if(rear==qsize-1)
			{
			rear=0;
			}
		else
			rear=rear+1;
		printf("\n Enetr the element to insert in queue: ");
		scanf("%d",&queue[rear]);
		}

	 void delet(void)
		{
		if(front==-1)
			{
			printf("\n queue is empty");
			return ;
			}
		printf("\n item deleted:%d",queue[front]);
		if(front==rear)
			{
			rear=-1;
			front=-1;
			}
		else if(front==qsize-1)
			front=0;
		     else
			front++;
		}

	   void display(void)
		{
		int front_pos=front;
		int rear_pos=rear;
		if(front==-1)
			{
			printf("\n queue is empty:");
			return ;
			}
		printf("\n queue is:\n\n");
		if(front<rear)
			{
			while(front_pos<=rear_pos)
				{
				printf(" [%d] ",queue[front_pos]);
				front_pos++;
				}
			 }
		else
			{
			while(front_pos<=qsize-1)
				{
				printf(" [%d] ",queue[front_pos]);
				front_pos++;
				}
			front_pos=0;
			while(front_pos<=rear)
				{
				printf(" [%d] ",queue[front_pos]);
				front_pos++;
				}
			}
		}

	 int menu(void)
		{
		int c;
		printf("\n\n1.Insert"
		"\n\n2.Delete"
		"\n\n3.Display"
		"\n\n4.Exit");
		printf("\n\nEnter your choice: ");
		scanf("%d",&c);
		return(c);
		}

	void main(void)
		{
		clrscr();
		while(1)
			{
			switch(menu())
				{
				case 1:
				clrscr();
				insert();
				break;
				case 2:
				clrscr();
				delet();
				break;
				case 3:
				clrscr();
				display();
				break;
				case 4:
				exit(0);
				default:
				printf("\n\nInvalid Choice:");
				}
			getch();
			}
		}
