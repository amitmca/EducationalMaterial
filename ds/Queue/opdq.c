//Program for Creating output restricted a DQueue

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<graphics.h>
#include<dos.h>


struct node
	{
	int data;
	struct node *next,*prev;
	};

typedef struct node *QUEUE;

int c=0;

void Display(QUEUE first)
	{
	printf("\n");
	printf("first-->");
	delay(700);
	while(first!=NULL)
		{
		printf("%d-->",first->data);
		delay(300);
		first=first->next;
		}
	printf("last\n\n");
	}
QUEUE Insert_at_last(QUEUE first,int ele)
	{
	QUEUE last=first,newnode;
	int i;
//	first=last=NULL;
	newnode=ALLOC;
	newnode->next=newnode->prev=NULL;
	newnode->data=ele;
	if(first==NULL)
		{
		first=last=newnode;
		}
	else
		{
		for(i=1;i<c;i++)
			last=last->next;
		last->next=newnode;
		newnode->prev=last;
		last=newnode;
		}
	c++;
	return(first);
	}
QUEUE Insert_at_first(QUEUE first,int ele)
	{
	QUEUE newnode,last;
	int i;
	first=last=NULL;
	newnode->next=newnode->prev=NULL;
	newnode->data=ele;
	if(c==0)
		{
		first=last=newnode;
		c++;
		}
	else
		{
		for(i=0;i<=c;i++)
			first=first->next;
		newnode->next=first;
		//first->prev=newnode;
		newnode->prev=NULL;
		first=newnode;
		c++;
		}

	return(first);
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
	int choice,choice1,ele;
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
				do
				{
				printf("\n\n 1) Insert at front:\n");
				printf("\n 2) Insert from rear:\n");
				printf("\n 3) Exit:\n");
				printf("\n Choice:");
				scanf("%d",&choice1);
				switch(choice1)
					{
					case 1:
						printf("\nNewnode to insert:");
						scanf("%d",&ele);
						first=Insert_at_first(first,ele);
						printf("\nThe element is inserted......\n\n");
						break;

					case 2:
						printf("\nNewnode to insert:");
						scanf("%d",&ele);
						first=Insert_at_last(first,ele);
						printf("\nThe element is inserted......\n\n");
						break;
					}
				}while(choice1!=3);
				clrscr();
				break;
			case 2:
				first=DeleteQ(first);
				printf("\nThe element is deleted....\n");
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





