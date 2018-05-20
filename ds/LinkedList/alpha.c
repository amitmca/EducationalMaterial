/*Program for Singly Linked List*/

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<dos.h>

struct node
	{
	char data;
	struct node *next;
	};
typedef struct node *NODE;

int n;

NODE CreateList(NODE r)
	{
	int i;
	NODE p,newnode;
	char ch='y';
	r=newnode=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Node Data:");
		scanf("%s",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\n\nDo you want to have another record(y/n):");
		ch=getche();
		}
	return r;
	}
void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("\t");
	for(p=r;p!=NULL;p=p->next)
		{
		printf("[ %c ] --> ",p->data);
		delay(1000);
		}
	printf("NULL\n\n");
	}
int Vowel(NODE r)
	{
	NODE p;
	int l=0;
	for(p=r;p!=NULL;p=p->next)
		{
		if(p->data=='a' || p->data=='e' || p->data=='i' || p->data=='o' || p->data=='u')
			l++;
		}
	return(l);
	}
void main()
	{
	int num,i,v;
	NODE r,p;
	clrscr();
	r=CreateList(p);
	delay(1000);
	printf("\n\nPlease wait while creating the node..............\n\n");
	delay(1500);
	DisplayList(r);
	v=Vowel(r);
	printf("\n\nTotal Vowels:%d",v);
	getch();
	}
