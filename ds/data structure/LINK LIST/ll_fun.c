/*  program for create ,display ,insert begi  */
#include<stdio.h>
#include<conio.h>
#include<alloc.h>
#define AMOL (struct node *)malloc(sizeof (struct node))
struct node
 {
 int data;
 struct node *next;
 };
 typedef struct node * NODEPTR;
 NODEPTR creat(NODEPTR start,int);
 NODEPTR insertbeg (NODEPTR start);
 void display(NODEPTR start);
 void main()
 {
 int n;
 NODEPTR start=NULL;
 clrscr();
 printf("How many node's\n");
  scanf("%d",&n);
start= creat(start,n);
display(start);
start=insertbeg(start);
 display(start);
 getch();
 }
 NODEPTR creat(NODEPTR start,int n)
 {
 int i;
  NODEPTR temp,newnode;

  for(i=0;i<n;i++)
  {
  newnode=AMOL;
  newnode->next=NULL;
  printf("enter the data for newnode\n");
  scanf("\n%d",&newnode->data);
  if(start==NULL)
  {
  start=temp=newnode;
  }
  else
  {
  temp->next=newnode;
  temp=newnode;
  }
  }
 return (start);
 }

   void display(NODEPTR start)
  {
  NODEPTR temp;
  printf("DISPLAY THE LIST\n");
   for(temp=start;temp!=NULL;temp=temp->next)
  {
  printf("\n%d",temp->data);
  }
  }

     NODEPTR insertbeg(NODEPTR start)
   {
   int n;
   NODEPTR newnode,temp;
   printf("\nenter the data to insert in newnode\n");
   scanf("\n%d",&n);
   newnode=AMOL;
   newnode->next=NULL;
   newnode->data=n;
   newnode->next=start;
   start=newnode;
   return(start);
   }



