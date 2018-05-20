//Program for Reversing a String using Queue
#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))


struct node
	{
	char data;
	struct node *next,*prev;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	char *str;
	first=last=NULL;
	printf("\nEnter the String:");
	gets(str);
	while(*str!='\0')
		{
		newnode=ALLOC;
		newnode->next=newnode->prev=NULL;
		newnode->data=*str;
		str++;
		if(first==NULL)
				first=last=newnode;
		else
			{
			last->next=newnode;
			newnode->prev=last;
			last=newnode;
			}
		c++;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	int a=16;
	printf("\n");
	printf("first");
	printf("--%c",a);
	delay(700);
	while(first!=NULL)
		{
		printf(" %c--%c ",first->data,a);
		delay(300);
		first=first->next;
		}
	printf(" last\n\n");
	}
QUEUE Reverse(QUEUE first)
	{
	QUEUE tmp=first,tmp1;
	int i;
	for(i=1;i<c;i++)
		{
		printf("\n%c",tmp->data);
		tmp=tmp->next;
		}
	tmp1->data=tmp->next->data;
	printf("\n%c",tmp1->data);
	return(first);
	}
void main()
	{
	QUEUE first,last;
	clrscr();
	first=InsertQ(last);
	Display(first);
	first=Reverse(first);
	getch();
	}





