/*PROGRAM FOR DOUBLY LINKED LIST*/
#include<stdio.h>
#include<conio.h>
#define NODEALLOC (struct node *)malloc(sizeof (struct node))
void create();
void display();
void insatstart();
void insert();
void insatend();
void insinbet();
//void delete();
//void delatstart();
void delfirst();
struct node
{
	int data;
	struct node *next,*prev;
} *newnode,*start,*temp;

void create()
{
	int i,n,df;
	clrscr();
	printf("enter the number of nodes");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		newnode=NODEALLOC;
		newnode->next=NULL;
		newnode->prev=NULL;
		printf("the newnode data is ");
		scanf("%d",&newnode->data);
		 if(start==NULL)
		start=temp=newnode;
		else
		{
			temp->next=newnode;
			newnode->prev=temp;
			temp=newnode;
		}
	}
}

		void  display()
	     {
	    for(temp=start;temp!=NULL;temp=temp->next)
	    printf("the data is%d\n",temp->data);
	    getch();
	       }
	       char menu()
	       {
	       char ch;
	   printf("\n C:\tFOR CREATING A NODE "
		  "\n D:\tTO DISPLAY THE DATA"
		  "\n I:\tTO INSERT A NODE"
		 "\n DF:\tTO DELETE A FIRST NODE"
		  "\n E:\tTO EXIT FROM THE PROGRAM");
		  printf("\n\t\tenter your choice\n\t");
		     flushall();
		   scanf("%c",&ch);
		  return(toupper(ch));


		  }
		  void main()
		  {
		  clrscr();
		  while (1)
		  {
		  switch(toupper(menu()))
		  {
		  case 'C' :create();
			   break;
		  case 'D': display();
			   break;
		  case 'I':insert();
			   break;
		  case 'GF':delfirst();
			   break;
		  case 'E':exit(0);

		  }
		  }
		  }
		       submenu()
	       {
	       char ch;
	   printf("\n S:\tFOR INSERTING AT START "
		  "\n N:\tTO  INSERT AT END"
		  "\n B :\tTO INSERT IN BETWEEN"
		  "\n D :\t TO DISPLAY THE NEW DATA"
		  "\n E:\tTO EXIT FROM THE PROGRAM"
		  "\n GF:\tTO DELETE FIRST " );
		  printf("\n\t\tenter your choice\n\t");
		  flushall();
		  scanf("%c",&ch);
		  return(toupper(ch));

		   }
		   void insert()
		   {
		    clrscr();
		    while (1)
		    {
		    switch(submenu())
		    {
		    case 'S':insatstart();
		    break;
		    case 'D':display();
		    break;
		   case 'N':insatend();
		   break;
		   case 'B':insinbet();
		   break;
		   case 'DF':delfirst();
		   break;
		    case 'E':exit(menu());
		      }
		      }
		      }
	void   insatstart()
	   {
	   clrscr();
	   newnode=NODEALLOC;
	   newnode->next=NULL;
	   newnode->prev=NULL;
	   printf("enter the newnode data");
	   scanf("%d",&newnode->data);
	   newnode->next=start;
	   start->prev=newnode;
	   start=newnode;
	   }
	 void insatend()
	 {
	 newnode=NODEALLOC;
	 newnode->next=NULL;
	 newnode->prev=NULL;
	 printf("enter the newnode data");
	 scanf("%d",&newnode->data);
	 for(temp=start;temp->next!=NULL;temp=temp->next);
	  temp->next=newnode;
	  newnode->prev=temp;
	  temp=newnode;
	  }
	void insinbet()
	{
	int p,i=0;
	newnode=NODEALLOC;
	newnode->next=NULL;
	newnode->prev=NULL;
	printf("enter the newnode data");
	scanf("%d",&newnode->data);
	printf("enter the position to insert the node");
	scanf("%d",&p);
	temp=start;
	for(i=1;i<p-1&&temp!=NULL;i++)
	temp=temp->next;
	newnode->next=temp->next;
	temp->next=newnode;
	temp->next->prev=newnode->prev;
	newnode->prev=temp;
	}
	void delfirst()
	{
	int g;
	newnode=NODEALLOC;
	newnode->next=NULL;
	newnode->prev=NULL;
	printf("enter the newnode data");
	scanf("%d",&newnode->data);
	printf("enter the position to delete the node");
	scanf("%d",&g);
	temp->next=start;
	temp->next->prev=NULL;
	free(temp);
	}