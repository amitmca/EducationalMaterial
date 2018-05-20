
//PROGRAM FOR THE ASSCENDING AND DESSENCDING THE DOUBLY CIRCULAR LINKED LIST

#include<stdio.h>
#include<conio.h>
struct node
{
		int data;
		struct node *next,*prev;
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
				newnode->next=newnode->prev=NULL;
				printf("\n\nEnter the data:");
				scanf("%d",&newnode->data);
				if(start->next==start)//no node
				{
						start->next=newnode;
						newnode->prev=start;
				}
				else
				{
						temp->next=newnode;
						newnode->prev=temp;
				}
				temp=newnode;
				newnode->next=start;
				start->prev=newnode;
				printf("\n\nDo you insert more dat(y/n):");
				fflush(stdin);
				scanf("%c",&ch);
		}
		return(start);
}

void display(struct node *start)
{
		struct node *temp;
		printf("\n\nSTART-->");
		for(temp=start->next;temp!=start;temp=temp->next)
				printf("%d-->",temp->data);
		printf("NULL");
}

void assc(struct node *start)
{
		struct node *temp,*temp1,*temp2;
		for(temp=start->next;temp!=start;temp=temp->next)
		{
				for(temp1=temp->next;temp1!=start;temp1=temp1->next)
				{
						if(temp->data<temp1->data)
						{
								temp2=temp->data;
								temp->data=temp1->data;
								temp1->data=temp2;

						}
				}
		}
				printf("\n\nSTART-->");
		for(temp2=start->next;temp2!=start;temp2=temp2->next)
				printf("%d-->",temp2->data);
		printf("NULL");
}
void dessc(struct node *start)
{
				struct node *temp,*temp1,*temp2;
		for(temp=start->next;temp!=start;temp=temp->next)
		{
				for(temp1=temp->next;temp1!=start;temp1=temp1->next)
				{
						if(temp->data>temp1->data)
						{
								temp2=temp->data;
								temp->data=temp1->data;
								temp1->data=temp2;

						}
				}
		}
				printf("\n\nSTART-->");
		for(temp2=start->next;temp2!=start;temp2=temp2->next)
				printf("%d-->",temp2->data);
		printf("NULL");

}
void menu()
{
		struct node *start;
		int choice;
		start=(struct node *)malloc(sizeof(struct node));
		start->next=start;
		while(1)
		{
					printf("\n\n\t*******MENU*********\n\n");
					printf("\n\t1:CREATE\n"
							"\n\t2:DISPLAY\n"
							"\n\t3:SORT ASSECNDING\n"
							"\n\t4:SORT DESECNDING\n"
							"\n\t5:EXIT\n");
					printf("\n\nEnter your choice........::");
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
									assc(start);
									break;
							case 4:
									dessc(start);
									break;
							case 5:
									exit(0);
							default:
									printf("\n\nPlease,Enter the proper choice.......");
					}
		}
}

void main()
{
		clrscr();
		menu();
		getch();
}