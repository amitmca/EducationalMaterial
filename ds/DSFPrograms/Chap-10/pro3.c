/*Program 10.3 : Program to create linked list interactively and print the list and total number of items in the list.*/
#include<conio.h>
#include<stdio.h>
typedef struct node
{
	int data;
	struct node *next;
}node;
node * create(int);
void print(node *);
int count(node *);
void main()
{
	node *HEAD;
	int n,number;
	printf("\n no. of items :");
	scanf("%d",&n);
	HEAD=create(n); //create function returns the address of first node
	print(HEAD);
	number=count(HEAD);
	printf("\n No of nodes = %d",number);
}
node * create(int n)
{
	node *head,*P;
	int i;
	head=(node*)malloc(sizeof(node));
	head->next=NULL;
	scanf("%d",&(head->data));
	P=head;
	//create subsequent nodes
	for(i=1;i<n;i++)
	{
		P->next=(node*)malloc(sizeof(node));
		//new node is inserted as the next node after P
		P=P->next;
		scanf("%d",&(P->data));
		P->next=NULL;
	}
	return(head);
}
void print(node *P)
{
	while(P!=NULL)
	{
		printf("<- %d ->",P->data);
		P=P->next;
	}
}
int count(node *P)
{
	int i=0;
	while(P!=NULL)
	{
{
		P=P->next;
		i++;
	}
	return(i);

}
}

/*
        *** OUTPUT ***
 no. of items :4
12
13
14
15
<- 12 -><- 13 -><- 14 -><- 15 ->
 No of nodes = 1
*/
