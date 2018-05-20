//Program to Store Book Information using Linked List

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
typedef struct node
	{
	int bno,price;
	char bname[20],aname[20];
	struct node  *next;
	}*NODE;

NODE Create(NODE r)
	{
	NODE p,newnode;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nBook Number:");
		scanf("%d",&newnode->bno);
		printf("\tBook Name:");
		scanf("%s",newnode->bname);
		printf("\tPrice:");
		scanf("%d",&newnode->price);
		printf("\tAuthor Name:");
		scanf("%s",newnode->aname);
		if(r==NULL)
			p=r=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother(y/n):");
		ch=getche();
		}
	return(r);
	}
void Display(NODE r)
	{
	NODE p;
	printf("\n\t******* Books Information *******\n\n");
	printf("\t==========================================");
	printf("\n\tBook No | Book Name | Price | Author Name\n");
	printf("\t==========================================\n");
	for(p=r;p!=NULL;p=p->next)
		{
		printf("\n\t %d\t ",p->bno);
		printf("  %s\t    ",p->bname);
		printf("  %d  	",p->price);
		printf("  %s\n",p->aname);
		}
	printf("\n\t==========================================\n");
	}
main()
	{
	NODE r;
	clrscr();
	r=Create(r);
	clrscr();
	Display(r);
	getch();
	}
