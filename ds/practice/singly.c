#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int c=0;

NODE Create(NODE r)
	{
	NODE newnode,p;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nNode Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			{
			p=r=newnode;
			newnode->next=r;
			}

		else
			{
			p->next=newnode;
			newnode->next=r;
			p=newnode;
			}
		printf("\nAnother(y/n):");
		ch=getche();
		c++;
		}
	return(r);
	}
void Display(NODE r)
	{
	NODE p=r;
	printf("\n\nStart-->",p->data);
	for(p=r->next;p!=r;p=p->next)
		{
		printf("%d-->",p->data);
		delay(300);
		}
	printf("NULL\n");
	}
/*NODE Delete(NODE r,int pos)
	{
	NODE p,tmp;
	int i;
	if(pos==1)
		{
		p=r;
		tmp=p;
		p=p->next;
		p->prev=NULL;
		free(tmp);
		r=p;
		return(r);
		}
	else
		if(pos==c)
			{
			p=r;
			for(i=1;i<c-1;i++)
				p=p->next;
			tmp=p->next;
			p->next=NULL;
			free(tmp);
			return(r);
			}
		else
			{
			p=r;
			for(i=1;i<pos-1;i++,p=p->next);
				tmp=p->next;
			tmp=p->next;
			p->next=tmp->next;
			tmp->next->prev=p;
			free(tmp);
			return(r);
			}
	}*/
void main()
	{
	NODE r;
	int n,i;
	clrscr();
	r=Create(r);
	Display(r);
/*	printf("\nPosition :");
	scanf("%d",&i);
	r=Delete(r,i);
	Display(r);*/
	getch();
	}