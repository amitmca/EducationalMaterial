/*Program for Singly Circular Linked List*/

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
	int i;
	NODE p,newnode;
	char ch[3];
	r=newnode=NULL;
	while(strcmp(ch,"no")!=0)
		{
		newnode=ALLOC;
		printf("\n\n Node Data:");
		scanf("%d",&newnode->data);
		if(r==NULL)
			{
			r=p=newnode;
			p->next=r;
			}
		else
			{
			p->next=newnode;
			p->next=r;
			p=newnode;
			}
		printf("\n\nDo you want to have another record(y/n):");
		scanf("%s",ch);
		c++;
		}

	return r;
	}

void DisplayList(NODE r)
	{
	NODE p=r;
	printf("\n\nThe Linked List is:\n\n");
	printf("\nSTART-->[ %d ]-->",p->data);
	for(p=r->next;p->next!=r;p=p->next)
		{
		printf("[ %d ] --> ",p->data);
		}
	printf("NULL\n\n");
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
		newnode->next=r;
		c++;
		return r;
		}
	else               // Insert in between
		{
	for(i=1;i < pos-1 && p->next!=NULL;i++,p=p->next);
		newnode->next=p->next;
		p->next=newnode;
		c++;
		return r;
		}
	}
/*NODE Delete(NODE r)
	{

	}*/

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

 main()
	{
	int num,i,choice,s,ele;
	NODE r,p;
	clrscr();
	do
		{
		printf("\n *************** MENU ****************\r\n");
		
		printf("\n 1) Create Linked List:       Present status of linked list:%d\r\n",c);
		
		printf("\n 2) Display Linked List:\r\n");
		
		printf("\n 3) Insert a node:\r\n");
		
		printf("\n 4) Delete a node:\r\n");
		
		printf("\n 5) Search a node:\r\n");
		
		printf("\n 6) Sort a node:\r\n");
		
		printf("\n 7) Exit:\r");
		
		printf("\n\n Select Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				r=CreateList(r);
				clrscr();
				break;

			case 2:
		
				printf("\n\nPlease wait while creating the node..............\n\n");

				DisplayList(r);

				
				break;

			case 3:

				  printf("\n Position and New node to insert:");
				  scanf("%d%d",&i,&num);
				  r=Insert(r,i,num);

				  printf("\nNode Inserted Successfully.......");
				  DisplayList(r);

				
				  break;

			case 4:
				  break;

			case 5:
				  DisplayList(r);

				  printf("\nElement to search:");
				  scanf("%d",&ele);
				  s=SearchList(r,ele);
				  if(s==0)
					printf("\n Element is not present\n\n");
				  else
					printf("\n Element is present\n\n");
				  
				
				  break;

			case 6:
				  r=SortList(r);
				  printf("\nThe Sorted Linked List is:\n\n");
				  DisplayList(r);
				  
				
				  break;

			case 7:
				  clrscr();
				  exit(0);
				  break;
			}
		}while(choice!=7);
	getch();
	}
