//program to implement queue using circular link list
#include<stdio.h>
#include<conio.h>
	typedef	struct node
	{
	int data;
	struct node *next;
	}node;

	node *rear=NULL;

	void insert(void)
		{
		node *n;
		n=(node *)malloc(sizeof(node));
		printf("\n Enter node data: ");
		scanf("%d",&n->data);
		if(rear==NULL)
			{
			rear=n;
			rear->next=rear;
			}
		else
			{
			n->next=rear->next;
			rear->next=n;
			rear=n;
			}
		}

       void delet(void)
		{
		node *q,*ptr;
		q=rear->next;
		printf("*%d*%d*",q->data,rear->data);
		if(rear==NULL)
			{
			printf("\n The queue is empty");
			return;
			}
		else
		if(rear->next==rear)
			{
			q=rear;
			printf("\n Deleted node is:%d",q->data);
			rear=NULL;
			free(q);
			return;
			}
		else
		{
		q=rear->next;
		printf("\n The node deleted:%d",q->data);
		ptr=q;
		q=q->next;
		rear->next=q;
		free(ptr);
		}
		}
       void display(void)
		{
		node *temp;
		if(rear==NULL)
			printf("\n The queue is empty");
		else
			{
			temp=rear;
			printf("\n Queue is:\n\n");
			while(temp->next!=rear)
				{
				temp=temp->next;
				printf(" [%d]-->",temp->data);
				}
			printf(" [%d]-->",rear->data);
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