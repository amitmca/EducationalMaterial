//Program for Creating Input restricted a DQueue

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
#include<graphics.h>
#include<dos.h>


struct node
	{
	int data;
	struct node *next,*prev;
	};

typedef struct node *QUEUE;

int c=0;

QUEUE InsertQ(QUEUE last)
	{
	QUEUE first,newnode;
	char ch='y';
	first=last=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=newnode->prev=NULL;
		printf("\n\nFirst Data:");
		scanf("%d",&newnode->data);
		if(first==NULL)
			first=last=newnode;
		else
			{
			last->next=newnode;
			newnode->prev=last;
			last=newnode;
			}
		printf("\nAnother Data(y/n):");
		ch=getche();
		c++;
		}
	return(first);
	}
void Display(QUEUE first)
	{
	printf("\n");
	printf("first-->");
	delay(700);
	while(first!=NULL)
		{
		printf("%d-->",first->data);
		delay(300);
		first=first->next;
		}
	printf("last\n\n");
	}
QUEUE Del_from_last(QUEUE first)
	{
	QUEUE p=first,tmp;
	int i;
	for(i=1;i<c-1;i++)
		p=p->next;
	tmp=p->next;
	p->next=NULL;
	free(tmp);
	c--;
	return(first);
	}
QUEUE Del_from_first(QUEUE first)
	{
	QUEUE tmp=first;
	first=first->next;
	free(tmp);
	c--;
	return(first);
	}
void main()
	{
	QUEUE first,last;
	int choice,choice1;
	clrscr();
	do
		{
		printf("\n************ QUEUE  ***********\n\n");
		printf("\n 1) INSERT\n");
		delay(300);
		printf("\n 2) DELETE\n");
		delay(300);
		printf("\n 3) DISPLAY \t\t No Of Elements:%d\n",c);
		delay(300);
		printf("\n 4) EXIT\n\n");
		delay(300);
		printf("\nSelect Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				first=InsertQ(last);
				clrscr();
				break;
			case 2:
				do
				{
				printf("\n\n 1) Delete from front:\n");
				printf("\n 2) Delete from rear:\n");
				printf("\n 3) Exit:\n");
				printf("\n Choice:");
				scanf("%d",&choice1);
				switch(choice1)
					{
					case 2:
						last=Del_from_last(first);
						printf("\nThe element is deleted......\n\n");
						break;

					case 1:
						first=Del_from_first(first);
						printf("\nThe element is deleted......\n\n");
						break;
					}
				}while(choice1!=3);
				break;
			case 3:
				Display(first);
				delay(2000);
				clrscr();
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}





