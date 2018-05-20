#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
struct node
	{
	int idata;
	char cdata;
	struct node *next;
	};
typedef struct node *NODE;

NODE Create(NODE r)
	{
	NODE p,newnode;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nNode Data:");
		scanf("%d",&newnode->idata);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother Node of Integer type(y/n):");
		ch=getche();
		}
	return(r);
	}
NODE Create1(NODE r)
	{
	NODE p,newnode;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nNode Data:");
		scanf("%s",newnode->cdata);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother Node of character type(y/n):");
		ch=getche();
		}
	return(r);
	}
void Display(NODE r)
	{
	NODE p=r;
	printf("\n\nSTART --->");
	while(p!=NULL)
		{
		printf(" [ %s ]-->",p->idata);
		p=p->next;
		}
	printf("NULL\n\n");
	}
void Display1(NODE r)
	{
	NODE p=r;
	printf("\n\nSTART --->");
	while(p!=NULL)
		{
		printf(" [ %c ]-->",p->cdata);
		p=p->next;
		}
	printf("NULL\n\n");
	}
void main()
	{
	NODE r,r1;
	clrscr();
	r=Create(r);
	r1=Create1(r1);
	Display(r);
	Display1(r1);
	getch();
	}
