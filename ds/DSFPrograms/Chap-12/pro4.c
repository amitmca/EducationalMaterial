/*Program 12.4 :Program for showing various operations on a queue  represented using circular linked list.*/
#include<stdio.h>
#include<conio.h>
typedef struct node
{
 int data;
 struct node *next;
}node;
void init(node **R);
void enqueue(node **R,int x);
int dequeue(node **R);
int empty(node *rear);
void print(node *rear);
void main()
{
 int x,option;
 int n = 0,i;
 node *rear;
 init(&rear);
 clrscr();
 do
 {
  printf("\n 1. Insert\n 2. Delete\n 3. Print\n 4. Quit");
  printf("\n your option:     ");
  scanf("%d",&option);
  switch(option)
  {
    case 1 :
	     printf("\n Element to be inserted");
	     scanf("%d",&n);
	     for(i=0;i<n;i++)
	     {
	       scanf("\n %d",&x);
	       enqueue(&rear,x);
	     }
	     break;
    case 2 : if(! empty(rear))
	       {
		x = dequeue(&rear);
		printf("\n Element deleted = %d",x);
	       }
	       else
		printf("\n Uderflow..... Cannot deleted");
	       break;
    case 3 : print(rear);
	     break;
  }
 }while(option != 4);
 getch();
 }
 void init(node **R)
 {
  *R = NULL;
 }
 void enqueue(node **R,int x)
 {
  node *p;
  p = (node *)malloc(sizeof(node));
  p->data = x;
  if(empty(*R))
  {
     p->next = p;
     *R = p;
  }
  else
  {
     p->next = (*R)->next;
     (*R)->next = p;
     (*R) = p;
  }
 }
int dequeue(node **R)
{
  int x;
  node *p;
  p = (*R)->next;
  p->data = x;
  if(p->next == p)
  {
     *R = NULL;
     free(p);
     return(x);
  }
  (*R)->next = p->next;
  free(p);
  return(x);
}
void print(node *rear)
{
   node *p;
   if(!empty(rear))
   {
     p = rear->next;
   }
   p = p->next;
   do
   {
     printf("\n %d",p->data);
     p = p->next;
   }while(p != rear->next);
}
int empty(node *P)
{
	if(P->next== -1)
		return(1);
	return(0);
}
 
/*
          *** OUTPUT ***
 1. Insert
 2. Delete
 3. Print
 4. Quit
 your option:     1

 Element to be inserted 4
12 23 34 45

 1. Insert
 2. Delete
 3. Print
 4. Quit
 your option:     3

 12
 23
 34
 45
 1. Insert
 2. Delete
 3. Print
 4. Quit
 your option:     2
 Element deleted = 4
 1. Insert
 2. Delete
 3. Print
 4. Quit
 your option:     3

 23
 34
 45
 1. Insert
 2. Delete
 3. Print
 4. Quit
 your option:4
*/
