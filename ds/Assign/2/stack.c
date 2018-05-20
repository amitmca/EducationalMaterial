//Program for Operaions on  a stack

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

struct node
	{
	int data;
	struct node *next;
	};

typedef struct node *STACK;

int c=0;

STACK Push(STACK top)
	{
	STACK newnode;
	char ch='y';
	top=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\nTop Data:");
		scanf("%d",&newnode->data);
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
		printf("\nAnother Data(y/n):");
		ch=getche();
		c++;
		}
	return(top);
	}
void Display(STACK top)
	{
	int b=25;
	printf("\n");
	while(top!=NULL)
		{
		printf("top");
		printf("--->");
		delay(700);
		printf("\t%d\n",top->data);
		delay(300);
		printf("\t %c\n",b);
		top=top->next;
		}
	printf("\tNULL\n\n");
	}
STACK Pop(STACK top)
	{
	STACK tmp=top;
	top=top->next;
	free(tmp);
	c--;
	return(top);
	}
STACK Copy(STACK top)
	{
	STACK top1,newnode;
	top1=NULL;
	top1=Pop(top);
	newnode=ALLOC;
	newnode->next=NULL;
	if(top1==NULL)
		top1=newnode;
	else
		{
		newnode->next=top1;
		top1=newnode;
		}
	return(top1);
	}
STACK InsertQ(STACK top)
	{
	STACK first,newnode,last;
	first=last=NULL;
	while(top!=NULL)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=top->data;
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			last=newnode;
			}
		top=top->next;
		}
	return(first);
	}
STACK Push1(STACK first)
	{
	STACK newnode,top;
	top=NULL;
	while(first!=NULL)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=first->data;
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
		first=first->next;
		}
	return(top);
	}
void main()
	{
	STACK top,top1;
	int choice;
	clrscr();
	do
		{
		printf("\n************ STACK  ***********\n\n");
		printf("\n 1) PUSH\n");
		delay(300);
		printf("\n 2) POP\n");
		delay(300);
		printf("\n 3) DISPLAY \t\t No Of Elements:%d\n",c);
		delay(300);
		printf("\n 4) COPY\n");
		delay(300);
		printf("\n 5) REVERSE\n");
		delay(300);
		printf("\n 6) EXIT\n\n");
		delay(300);
		printf("\nSelect Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				top=Push(top);
				clrscr();
				break;
			case 2:
				top=Pop(top);
				if(top==NULL)
					printf("\nThere is no element to pop........\n\n");
				else
					printf("\nThe element is popped....\n\n");
				delay(1000);
				clrscr();
				break;
			case 3:
				Display(top);
				delay(2000);
				clrscr();
				break;
			case 4:
				top1=Copy(top);
				printf("\nThe Copied stack elements are:\n\n");
				Display(top1);
				clrscr();
				break;

			case 5:
				top=InsertQ(top);
				top=Push1(top);
				printf("\nThe Reversed stack elements are:\n\n");
				Display(top);
				clrscr();
				break;
			case 6:
				exit(0);
				break;
			}
		}while(choice!=6);
	getch();
	}





