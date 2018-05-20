//program to implement queue using link list
#include<stdio.h>
#include<conio.h>
	struct node
		{
		int data;
		struct node *next;
		};
	struct node *front=NULL,*rear=NULL;

	void insert(void)
		{
		struct node *n;
		n=(struct node *)malloc(sizeof(struct node));
		printf("\n\n Enter node data: ");
		scanf("%d",&n->data);
		n->next=NULL;
		if(front==NULL)
		   front=rear=n;

		else
			{
			rear->next=n;
			rear=n;
			}
		}

	 void delet(void)
		{
		struct node *temp;
		if(front==NULL)
			printf("\n The queue is empty");
		else
			{
			temp=front;
			printf("\n\nThe node deleted=%d",front->data);
			front=front->next;
			free(temp);
			}
		}

	void display(void)
		{
		struct node *temp;
		temp=front;
		if(front==NULL)
			printf("\n The queue is empty");
		else
			{
			printf("\n The queue is:\n\n");
			while(temp!=NULL)
				{
				printf(" [%d] ",temp->data);
				temp=temp->next;
				}
			}
		}

	int menu(void)
		{
		int c;
		printf("\n\n1.Insert"
		"\n\n2.Delet"
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