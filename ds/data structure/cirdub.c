/*PROGRAM FOR CIRCULAR DOUBLY LINKED LIST*/
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
struct node
{
	int data;
	struct node *next,*prev;
} *newnode,*start,*temp,*temp1;

void create()
{
	int i,n;
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
	temp->next=start;
	start->prev=temp;

}

		void  display()
	     {
	    for(temp1=start;temp1!=temp;temp1=temp1->next)
	    printf("the data is%d\n",temp1->data);
	    printf("the data is%d\n",temp1->data);
	    getch();
	     }


	       char menu()
	       {
	       char ch;
	   printf("\n C:\tFOR CREATING A NODE "
		  "\n D:\tTO DISPLAY THE DATA"
		  "\n I:\tTO INSERT A NODE"
		  //"\n T:\tTO DELETE A NODE"
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
		 // case 'T':delete();
		 //	   break;
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
		  "\n E:\tTO EXIT FROM THE PROGRAM");
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
	   newnode->prev=start->prev;
	   start->prev=newnode;
	   newnode->next->prev=newnode;
	   start=newnode;
	   }

	 void insatend()
	 {
	 newnode=NODEALLOC;
	 newnode->next=NULL;
	 newnode->prev=NULL;
	 printf("enter the newnode data");
	 scanf("%d",&newnode->data);
	 newnode->next=start;
	 newnode->prev=start->prev;
	 start->prev->next=newnode;
	 start->prev=newnode;
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
	temp1=start;
	for(i=1;i<p-1;i++)
	temp1=temp1->next;
	newnode->next=temp1->next;
	temp1->next=newnode;
	newnode->next->prev=newnode;
	newnode->prev=temp1;
	}




