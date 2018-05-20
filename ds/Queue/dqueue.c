//Program for Creating a Queue Using Doubly linked list

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))



struct node
	{
	int data;
	struct node *next,*prev;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	int i,size;
	first=last=NULL;
	printf("\nSize:");
	scanf("%d",&size);
	for(i=1;i<=size;i++)	
		{
		newnode=ALLOC;
		newnode->next=newnode->prev=NULL;
		printf("\n\nFirst Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			newnode->prev=last;
			last=newnode;
			}
		c++;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	printf("\n");
	printf("first-->");
	while(first!=NULL)
		{
		printf(" %d--> ",first->data);
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
int main()
	{
	QUEUE first,last;
	int choice;
	clrscr();
	do
		{
		printf("\n************ QUEUE  ***********\n\n");
		printf("\n 1) INSERT\n");
		printf("\n 2) DELETE\n");
		printf("\n 3) DISPLAY \t\t No Of Elements:%d\n",c);
		printf("\n 4) EXIT\n\n");
		printf("\nSelect Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				first=InsertQ(last);
				break;
			case 2:
				first=DeleteQ(first);
				if(first==last)
					printf("\nThere is no element to Delete........\n\n");
				else
					printf("\nThe element is Deleted....\n\n");
		
				break;
			case 3:
				Display(first);
		
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}





