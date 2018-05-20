/*Program 10.4 :A sample program for creation of a doubly linked list  and printing its elements in forward and reverse direction*/
#include<conio.h>
#include<stdlib.h>
#include<stdio.h>
typedef struct dnode
{
	int data;
	struct dnode *next,*prev;
}dnode;

dnode* create();
void print_forward(dnode *);
void print_reverse(dnode *);
void main()
{
	dnode *head;
	head=NULL;    // initially the list is empty

	head=create();
	printf("\nElements in forward direction :");
	print_forward(head);
	printf("\nElements in reverse direction :");
	print_reverse(head);
}
dnode *create()
{
	dnode *h,*p,*q;
	int i,n,x;
	h=NULL;
	printf("\nEnter no of elements :");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("\nEnter next data: ");
		scanf("%d",&x);
		q=(dnode*)malloc(sizeof(dnode));
		q->data=x;
		q->prev=q->next=NULL;
		if(h==NULL)
			p=h=q;
		else
			p->next=q;
			q->prev=p;
 
			p=q;
	}
	return(h);
}
void print_forward(dnode *h)
{
	while(h!=NULL)
	{
		printf("<- %d ->",h->data);
		h=h->next;
	}
}
void print_reverse(dnode *h)
{
	  while(h!=NULL)
	  {
	  h=h->next;
	  }
    while(h!=NULL)
	{
		printf("<- %d ->",h->data);
		h=h->prev;
	}
}
/*
       *** OUTPUT ***
Enter no of elements :4
Enter next data:1
Enter next data:2
Enter next data:3
Enter next data:4
Elements in forward direction :<-1-> <-2-><-3-><-4->
Elements in reverse direction :<-4-> <-3-><-2-><-1->
*/
