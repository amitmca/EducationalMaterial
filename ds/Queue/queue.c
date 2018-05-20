//Program for Creating a Queue

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
	int a=16,sum=0;
	printf("\n");
	printf("first");
	printf("--%c",a);
	delay(700);
	while(first!=NULL)
		{
		printf(" %d--%c ",first->data,a);
		sum=sum+first->data;
		delay(300);
		first=first->next;
		}
	printf(" last\n\n");
	printf("\nSum Is:%d",sum);
	}
QUEUE DeleteQ(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	c--;
	return(first);
	}
void main()
	{
	QUEUE first,last;
	int choice;
	clrscr();
	do
		{
		printf("\n************ QUEUE  ***********\n\n");
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
				clrscr();
				break;
			case 2:
				first=DeleteQ(first);
				if(c==0)
					printf("\nThere is no element to Delete........\n\n");
				else
					printf("\nThe element is Deleted....\n\n");
				delay(1000);
				clrscr();
				break;
			case 3:
				Display(first);
				delay(2000);
				clrscr();
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}





