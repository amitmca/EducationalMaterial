//program to implement queue using array
#include<stdio.h>
#include<conio.h>
#define queuesize 10
int front=-1,rear=-1;
int queue[queuesize];
	void insert(void)
		{
		int item;
		if(rear==queuesize-1)
			printf("\n Queue is full:");
		else
			{
			if(front==-1)
				front++;
			printf("\n Enter value to insert: ");
			scanf("%d",&item);
			rear++;
			queue[rear]=item;
			}

		}

	void delet(void)
		{
		if(front==-1||front>rear)
			printf("\n The queue is empty");
		else
			{
			printf("\n The deleted item is: %d",queue[front]);
			front++;
			}
		}

	void display(void)
		{
		int i;
		if(front==-1||front>rear)
			printf("\n The queue is empty");
		else
			{
			printf("\n The queue is:\n\n");
			for(i=front;i<=rear;i++)
				{
				printf(" [%d] ",queue[i]);
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