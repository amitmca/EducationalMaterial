/*Program for Singly Linked List*/

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
//#include<dos.h>

struct node
	{
	int data;
	struct node *next;
	};
typedef struct node *NODE;

int c=0;

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
		scanf("%d",&newnode->data);
		if(r==NULL)
			r=p=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\n\nDo you want to have another record(y/n):");
		ch=getche();
		c++;
		}
	return r;
	}
void DisplayList(NODE r)
	{
	NODE p;
	printf("\n\nThe Linked List is:\n\n");
	printf("START-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf(" %d -- %c ",p->data,16);
		//delay(1000);
		}
	printf("%c\n\n",219);
	printf("\n Total Nodes:%d\n",c);
	}
NODE Insert(NODE r,int pos,int num)
	{
	int i;
	NODE newnode,p;
	newnode=ALLOC;
	newnode->data=num;
	newnode->next=NULL;
	if(pos==1)    	// Insert at Begining
		{
		newnode->next=r;
		r=newnode;
		c++;
		return r;
		}
	else if(pos==c)	   // Insert at end
		{
		for(p=r;p->next!=NULL;p=p->next);
			p->next=newnode;
		c++;
		return r;
		}
	else               // Insert in between
		{
	for(i=1;i < pos-1;i++,p=p->next);
		newnode->next=p->next;
		p->next=newnode;
		c++;
		return r;
		}
	}
NODE Delete(NODE r,int pos)
	{
	NODE p,tmp;
	int i;
	if(pos==1)
		{
		p=r;
		tmp=p;
		p=p->next;
		free(tmp);
		r=p;
		c--;
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
		c--;
		return(r);
		}
		else
		{
		for(i=1;i<pos-1;i++)
			p=p->next;
		tmp=p->next;
		p->next=tmp->next;
		free(tmp);
		c--;
		return(r);
		}
	}

NODE SortList(NODE  r)
	{
	int temp;
	NODE p=r,p1,q;
	while(p1!=NULL)
		{
		p=r;
		while(p->next!=NULL)
			{
			q=p->next;
			if(p->data > q->data)
				{
				temp=p->data;
				p->data=q->data;
				q->data=temp;
				}
			p=p->next;
			}
		p1=p1->next;
		}
	return(r);
	}

int SearchList(NODE r,int ele)
	{
	NODE p;
	int l=0;
	for(p=r;p!=NULL;p=p->next)
		{
		if(ele==p->data)
			l++;
		}
	return(l);
	}
NODE ReverseList(NODE r)
	{
	int i,j;
	NODE f,c,b;
	f=r;
	c=NULL;
	while(f)
		{
		b=c;
		c=f;
		f=f->next;
		c->next=b;
		}
	r=c;
	return(r);
	}
void main()
	{
	int num,i,choice,s,ele;
	NODE r,p;
	clrscr();
	do
		{
		textcolor(RED);
		cprintf("\n *************** MENU ****************\r\n");
		textcolor(GREEN);
		cprintf("\n 1) Create Linked List:       Present status of linked list:%d\r\n",c);
		delay(500);
		cprintf("\n 2) Display Linked List:\r\n");
		delay(300);
		cprintf("\n 3) Insert a node:\r\n");
		delay(300);
		cprintf("\n 4) Delete a node:\r\n");
		delay(300);
		cprintf("\n 5) Search a node:\r\n");
		delay(300);
		cprintf("\n 6) Sort the list:\r\n");
		delay(300);
		cprintf("\n 7) Reverse the list:\r\n");
		delay(300);
		cprintf("\n 8) Exit:\r");
		delay(300);
		cprintf("\n\n Select Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				r=CreateList(r);
				clrscr();
				break;

			case 2:
				textcolor(GREEN);
				cprintf("\n\nPlease wait while creating the node..............\n\n");
				delay(1500);
				DisplayList(r);
				delay(1200);
				clrscr();
				break;

			case 3:
				  textcolor(YELLOW);
				  printf("\nBefore Inserting....\n\n");
				  DisplayList(r);
				  delay(200);
				  printf("\n Position and New node to insert:");
				  scanf("%d%d",&i,&num);
				  r=Insert(r,i,num);
				  textcolor(MAGENTA);
				  printf("\nAfter Inserting.....\n\n");
				  DisplayList(r);
				  delay(1200);
				  clrscr();
				  break;

			case 4:
				 printf("\nBefore Deleting....\n\n");
				 DisplayList(r);
				 delay(200);
				 printf("\n Position of node to delete:");
				 scanf("%d",&i);
				 r=Delete(r,i);
				 textcolor(MAGENTA);
				 printf("\nAfter Deleting....\n\n");
				 DisplayList(r);
				 delay(1100);
				 clrscr();
				 break;

			case 5:
				  DisplayList(r);
				  textcolor(MAGENTA);
				  printf("\nElement to search:");
				  scanf("%d",&ele);
				  s=SearchList(r,ele);
				  textcolor(MAGENTA);
				  if(s==0)
					printf("\n Element is not present\n\n");
				  else
					printf("\n Element is present\n\n");
				  delay(1100);
				  clrscr();
				  break;

			case 6:
				  r=SortList(r);
				  printf("\nThe Sorted Linked List is:\n\n");
				  DisplayList(r);
				  delay(1100);
				  clrscr();
				  break;

			case 7:
				r=ReverseList(r);
				printf("\nThe Reverse Linked List is:\n\n");
				DisplayList(r);
				delay(1100);
				clrscr();
				break;
			case 8:
				  exit(0);
				  break;
			}
		}while(choice!=8);
	getch();
	}
