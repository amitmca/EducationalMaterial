/*Program for Operations On Singly Linked List*/

#include<stdio.h>
#include<graphics.h>
#include "conio.h"
#define NODEALLOC (struct node *)malloc(sizeof(struct node))
#include<dos.h>

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int n;

NODE createlist(NODE r)
	{
	int i;
	char ch='y';
	NODE p,newnode;
	r=newnode=NULL;
	while(ch=='y')
		{
		newnode=NODEALLOC;
		newnode->next=NULL;
		setcolor(RED);
		outtextxy(20,105,"Node Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		outtextxy(20,145,"Do you want have another node(y/n):");
		ch=getche();
		}
	return r;
	}
void display(NODE r)
	{
	NODE p;
	outtextxy(20,165,"The Linked List is:");

	for(p=r;p!=NULL;p=p->next)
		{
		printf("[ %d ] --> ",p->data);
		delay(1000);
		}
	outtextxy(20,175,"NULL");
	}
/*NODE insert(NODE r,int pos,int num)
	{
	int i;
	NODE newnode,p;
	newnode=NODEALLOC;
	newnode->data=num;
	newnode->next=NULL;
	if(pos==0)
		{
		newnode->next=r;
		r=newnode;
		return r;
		}
	else if(pos==n)
		{
		for(p=r;p->next!=NULL;p=p->next);
			p->next=newnode;
		return r;
		}
	else
		{
	for(i=1;i < pos-1 && p->next!=NULL;i++,p=p->next);
		newnode->next=p->next;
		p->next=newnode;
		return r;
		}

	}*/
NODE SortList(NODE r)
	{
	NODE p,t,q;
	for(p=r;p!=NULL;p=p->next)
		{
		for(q=p->next;q!=NULL;q=q->next)
			{
			if(p->data < q->data)
				{
				t->data=p->data;
				p->data=q->data;
				q->data=t->data;
				}
			}
		}
	return(r);
	}
void main()
	{
	int num,i,choice,gd=DETECT,gm;
	NODE r,p;
	initgraph(&gd,&gm,"");
	setbkcolor(BLACK);
	setcolor(RED);
	outtextxy(20,25,"Welcome");
	clrscr();
	do
		{
		setcolor(BLUE);
		outtextxy(20,35,"1)Create Linked List:");
		delay(500);
		setcolor(BLUE);
		outtextxy(20,55,"2)Display Linked List:");
		delay(500);
		setcolor(BLUE);
		outtextxy(20,75,"3) Exit:");
		delay(500);
		setcolor(GREEN);
		outtextxy(20,95,"Select Your Choice");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				r=createlist(r);
				clrscr();
				break;
			case 2:
				setcolor(RED);
				outtextxy(20,125,"Please wait while creating the Linked List..............");
				delay(500);
				display(r);
				break;
			case 3:
				exit(0);
				break;
			}

		}while(choice!=3);

	/*printf("\n Position and New node to insert:");
	scanf("%d%d",&i,&num);
	r=insert(r,i,num);*/
	r=SortList(r);
	printf("\n\n After Sorting Linked List is:\n\n");
	display(r);
	getch();
	//closegraph();
	}
