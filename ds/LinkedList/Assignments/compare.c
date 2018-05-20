//Program to insert an element in an sorted array

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int c=0;

NODE CreateList(NODE r)
	{
	int i,size;
	NODE p,newnode;
	char ch='y';
	r=newnode=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\nAnother data(y/n):");
		ch=getche();
		c++;
		}
	return(r);
	}

void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d-->",p->data);
		}
	printf("NULL\n");
	printf("\n Total Nodes:%d\n",c);
	}

void Compare(NODE fr,NODE sr)
	{
	NODE sp=sr,fp=fr;
	int a[20],i,b[20],j,k,l,m;
	i=0;
	j=0;
	l=0,m=0;
	while(fp!=NULL)
		{
		while(sp!=NULL)
			{
			if(fp->data==sp->data)
				{
				a[i++]=fp->data;
				l++;
				}
			else
				{
				b[j++]=sp->data;
				m++;
				}
			sp=sp->next;
			}
		fp=fp->next;
		}
	printf("\nSame elememnts are:\n");
	for(k=0;k<l;k++)
		printf("%d\n",a[k]);
	printf("\nDifferent elememnts are:\n");
	for(k=0;k<m;k++)
		printf("%d\n",a[k]);


	}
void main()
	{
	NODE r,r1;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	r1=CreateList(r1);
	DisplayList(r1);
	Compare(r,r1);
	getch();
	}

