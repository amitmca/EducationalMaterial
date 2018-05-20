#include<stdio.h>
#include<conio.h>

struct node
{
	int data;
	struct node *next,*prev;
}*newnode,*temp;

struct node *create(struct node *start)
{
	char ch='y';
	while(ch=='y')
	{
		newnode=(struct node *)malloc(sizeof(struct node));
		newnode->next=newnode->prev=NULL;
		printf("\n\nEnter the data:");
		scanf("%d",&newnode->data);
		if(start==NULL) // for the first pos
			start=newnode;
		else
		{
			temp->next=newnode;
			newnode->prev=temp;
		}
		temp=newnode;
		newnode->next=start;
		start->prev=newnode;
		printf("\n\n\n Do you insert data(y/n):");
		fflush(stdin);
		scanf("%c",&ch);
	}
	return(start);
}

void display(struct node *start)
{
	printf("\n\nSTART-->");
	printf("%d-->",start->data);
       for(temp=start->next;temp!=start;temp=temp->next)
		printf("%d-->",temp->data);
	printf("NULL");
}

struct node *insert(struct node *start)
{
	int pos,ele,c=1;
	printf("\n\nEnter the pos to insert the data:");
	scanf("%d",&pos);
	printf("\n\nEnter the element to insert:");
	scanf("%d",&ele);
	newnode=(struct node *)malloc(sizeof(struct node));
	newnode->data=ele;
	newnode->next=newnode->prev=NULL;
	temp=start->prev;
	if(pos==1) //First postion
	{
			temp->next=newnode;
			newnode->next=start;
			newnode->prev=temp;
			start->prev=newnode;
			start=newnode;
	}
	else
	{
		for(temp=start;temp!=start->prev;temp=temp->next)
		{

			if(c==pos-1)
			{
			newnode->next=temp->next;
			temp->next=newnode;
			newnode->prev=temp;
			temp->next->prev=newnode;
			temp=newnode;
			}
			c++;
		}
		temp=start->prev;
		if(++c==pos)
		{
			temp->next=newnode;
			newnode->prev=temp;
			newnode->next=start;
			start->prev=newnode;
			temp=newnode;
		}
	}
	if(pos>c)
	{
		printf("\n\nEnter the proper postion :");
		printf("\n\n\tPress,any key to exit......");
	}

	return(start);
}

struct node *delete_list(struct node *start)
{
	int pos,c=0;
	struct node *temp1;
	printf("\n\nEnter the postion to delete  the list:");
	scanf("%d",&pos);
	if(start->next==start && pos==1) //for only one element
	{
		temp1=start;
		free(temp1);
		start->next=start->prev=NULL;
	}

	if(pos==1)
	{
		temp=start->prev;
		temp1=start;
		start=temp1->next;
		start->prev=temp;
		temp->next=start;
		free(temp1);
	}
	else
	{
		for(temp=start;temp!=start->prev;temp=temp->next)
		{
			c++;
			if(c==pos-1)
			{
				temp1=temp->next;
				temp->next=temp1->next;
				temp1->next->prev=temp;
				free(temp1);
			}
		}
	}
	if(pos>c)
	{
		printf("\n\nEnter the proper postion :");
		printf("\n\n\tPress,any key to exit......");
	}

	return(start);
}
void  menu()
{
	struct  node *start;
	int choice;
	start=NULL;
	while(1)
	{
		printf("\n\n\t\t*********MENU******\n");
		printf("\n\t\t1:CREATE\n"
			"\n\t\t2:DISPLAY\n"
			"\n\t\t3:INSERT\n"
			"\n\t\t4:DELETE\n"
			"\n\t\t5:EXIT\n");
		printf("\n\nEnter your choice:");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				start=create(start);
				break;
			case 2:
				display(start);
				break;
			case 3:
				start=insert(start);
				break;
			case 4:
				start=delete_list(start);
				break;
			case 5:
				exit(0);
		}
	}
}
void main()
{
	clrscr();
	menu();
	getch();
}