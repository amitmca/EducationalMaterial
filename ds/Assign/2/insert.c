//Program for Insert and Delete a node In a SLL
#include<stdio.h>
#include<conio.h>
typedef struct node
	{
	int data;
	struct node *next;
	}*NODE;

int c=0;

NODE CreateList(NODE r)
	{
	NODE p,newnode;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=(struct node *)malloc(sizeof(struct node));
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
		printf("\nAnother(y/n):");
		ch=getche();
		c++;
		}
	return(r);
	}
void  DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nROOT---->");
	delay(1000);
	p=r;
	while(p!=NULL)
		{
		printf("%d-->",p->data);
		delay(1000);
		p=p->next;
		}
	printf("NULL\n");
	printf("\nTotal Nodes:%d\n",c);
	}
NODE Insert(NODE r,int pos,int num)
	{
	NODE p,newnode;
	int i;
	newnode=(struct node *)malloc(sizeof(struct node));
	newnode->next=NULL;
	newnode->data=num;
	if(pos==1)
		{
		p=r;
		newnode->next=r;
		r=newnode;
		c++;
		return(r);
		}
	if(pos==c)
		{
		p=r;
		for(i=0;i<c-1;i++)
			p=p->next;
		newnode->next=NULL;
		p->next=newnode;
		p=newnode;
		c++;
		return(r);
		}
	else
		{
		p=r;
		for(i=1;i<pos-1;i++)
			p=p->next;
		newnode->next=p->next;
		p->next=newnode;
		c++;
		return(r);
		}
	}


void main()
	{
	NODE r;
	int i,ele;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	printf("\nPosition of the node:");
	scanf("%d",&i);
	printf("\nNewnode data:");
	scanf("%d",&ele);
	r=Insert(r,i,ele);
	DisplayList(r);
	getch();
	}

