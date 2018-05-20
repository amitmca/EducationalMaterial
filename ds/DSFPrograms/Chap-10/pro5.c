/*Program 10.5 : A sample program for insertion of 5 elements in a doubly circular linked list and subsequently printing of elements stored in the list.*/
#include<conio.h>
#include<stdlib.h>
#include<stdio.h>
typedef struct dnode
{
	int data;
	struct dnode *next,*prev;
}dnode;

dnode * insert(dnode *head,int x);
void print(dnode *);
void main()
{
	dnode *head;
	int i,x;
	head=NULL;    // initially the list is empty
	printf("\nEnter 5 elements :");
	for(i=1;i<=5;i++)
	{
		scanf("%d",&x);
		head=insert(head,x);
	}
	print(head);
	getch();
}
dnode *insert(dnode *head,int x)
{
	dnode *P;
	P=(dnode*)malloc(sizeof(dnode));
	P->data=x;
	P->prev=P->next=NULL;
	if(head==NULL)           //inserting in an empty link list
	{		P->prev=P->next=P;
		return(P);
	}
	P->prev=head->prev;
	P->next=head;
	head->prev->next=P;
	head->prev=P;
	return(head);
}
void print(dnode *head)
{
	dnode *P;
	P=head;
	do
	{
		printf("<- %d ->",P->data);
		P=P->next;
	}while(P!=head);
} 
/*
              *** OUTPUT ***
Enter 5 elements :5 4 3 2 1
<- 5 -><- 4 -><- 3 -><- 2 -><- 1 ->


*/
