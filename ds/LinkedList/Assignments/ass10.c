#include<stdio.h>
#include<conio.h>
struct node
{
	int data;
	struct node *next;
};
struct node1
{
	char chr;
	struct node1 *next;
};
struct node *create(struct node *start)
{
	struct node *newnode,*temp;
	int data;
	char ch;
	ch='y';
	while(ch=='y')
	{
		newnode=(struct node *)malloc(sizeof(struct node));
		newnode->next=NULL;
		printf("\n\nEnter the data:");
		scanf("%d",&data);
		newnode->data=data;
		if(start==NULL)
			temp=start=newnode;
		else
		{
			temp->next=newnode;
			temp=newnode;
		}
		printf("\n\nDo you insert more data(y/n):");
		fflush(stdin);
		scanf("%c",&ch);
	}
	return(start);
}
struct node1 *create1(struct node1 *start)
{
	struct node1 *newnode,*temp;
	char ch,str;
	ch='y';
	while(ch=='y')
	{
		newnode=(struct node1 *)malloc(sizeof(struct node1));
		newnode->next=NULL;
		printf("\n\nEnter the data:");
		scanf("%s",str);
		newnode->chr=str;
		if(start==NULL)
			temp=start=newnode;
		else
		{
			temp->next=newnode;
			temp=newnode;
		}
		printf("\n\nDo you insert more data(y/n):");
		fflush(stdin);
		scanf("%c",&ch);
	}
	return(start);
}

void display(struct node *start)
{
		struct node *temp;
		printf("\n\nSTART-->");
		for(temp=start;temp!=NULL;temp=temp->next)
			printf("%d-->",temp->data);
		printf("NULL");
}
void display1(struct node1 *start)
{
		struct node1 *temp;
		printf("\n\nSTART-->");
		for(temp=start;temp!=NULL;temp=temp->next)
			printf("%s-->",temp->chr);
		printf("NULL");
}

void menu()
{
	struct node *list1;
	struct node1 *list2;
	int choice;
	list1=NULL;
	list2=NULL;
	while(1)
	{
		printf("\n\n\t*********MENU*******\n");
		printf("\n\t1:CREATE INTEGER TYPE LIST\n"
			"\n\t2:CREATE CHARCTER TYPE LIST\n"
			"\n\t3:DISPALY\n"
			"\n\t4:DISPLAY DOUBLEY WITH INTEGER AND CHARCTER\n"
			"\n\t5:EXIT\n");
		printf("\n\nEnter your choice.........::");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
				   printf("\n\nEnter the first LL with integer type:");
				   list1=create(list1);
				   break;
			case 2:
				   printf("\n\nEnter the second LL with charcter type:");
				   list2=create1(list2);
				   break;
			case 3:
				printf("\n\nThe first linked list is:");
				display(list1);
				printf("\n\nThe second linked list is:");
				display1(list2);
				break;
			case 4:
			      //	dis_double(list1,list2);
				break;
			case 5:
				exit(0);
			default:
				printf("\n\nEnter the proper choice.......");

		}
	}

}
void main()
{
	clrscr();
	menu();
	getch();
}
