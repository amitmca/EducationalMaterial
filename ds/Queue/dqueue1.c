//Program for Creating a DQueue

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<graphics.h>
#include<dos.h>


struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nFirst Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
		printf("\nAnother Data(y/n):");
		ch=getche();
		c++;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	int a=16;
	printf("\n");
	printf("first");
	printf("--%c",a);
	delay(700);
	while(first!=NULL)
		{
		printf(" %d--%c ",first->data,a);
		delay(300);
		first=first->next;
		}
	printf(" last\n\n");
	}
QUEUE DeleteQ(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	c--;
	return(first);
	}
void menu()
   {
   int choice;
   QUEUE first,last;
   do
	{
	printf("\n 1) INSERT\n");
	delay(300);
	printf("\n 2) DELETE\n");
	delay(300);
	printf("\n 3) DISPLAY \t\t No Of Elements:%d\n",c);
	delay(300);
	printf("\n 4) EXIT\n\n");
	delay(300);
	printf("\nSelect Your Choice:");
	scanf("%d",&choice);
	switch(choice)
			{
			case 1:
				first=InsertQ(last);
				break;

			case 2:
				first=DeleteQ(first);
				if(c==0)
					printf("\nThere is no element to Delete........\n\n");
				else
					printf("\nThe element is Deleted....\n\n");
							delay(1000);
				break;

			case 3:
				Display(first);
				delay(2000);
				break;

			case 4:
				exit(0);
				break;
			}
	}while(choice!=4);
   }
void menu1()
{
int choice2;
 do
 {
	 printf("\n\n 1) Input Restricted: Insert from only one side but delete from both\n");
	 printf("\n 2) Output Restricted: Insert from both sides but delete from only on side\n");
	 printf("\n 3) Exit:");
	 printf("\n\n Your Choice:");
	 scanf("%d",&choice2);
	 switch(choice2)
		{
		case 1:
			menu();
			break;

		case 2:
			break;

		case 3:
			exit(0);
			break;
		}
	}while(choice2!=3);
   }
void main()
	{
	QUEUE first,last;
	int choice1;
	clrscr();
		do
			{
			printf("\n1) QUEUE\n");
			printf("\n2) DQUEUE\n");
			printf("\n3) EXIT\n");
			printf("\nYour Choice:");
			scanf("%d",&choice1);
			switch(choice1)
				{
				case 1:
					menu();
					break;

				case 2:
					menu1();
					break;

				case 3:
					exit(0);
					break;
				}
			}while(choice1!=3);
	getch();
	}
