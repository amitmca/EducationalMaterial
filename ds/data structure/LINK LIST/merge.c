/*  PROGRAM FOR MERGING THE TWO LINKED LIST  */
#include<stdio.h>
#include<conio.h>                      /*|----------------------------------------------|*/
struct node                            /*| for e.g  list1   list2   list3(merge list)   | */
{                                      /*|           10      40      10                 |  */
 int data;                             /*|           20      50      20                 |  */
 struct node *next;                    /*|           30      60      30                 |  */
  }*start,*temp,*newnode;              /*|                           40                 |  */
typedef struct node * NODEPTR;         /*|                           50                 |  */
void main()                            /*|                           60                 |  */
{                                      /*|----------------------------------------------|  */
void display(NODEPTR);
NODEPTR createlist(NODEPTR);
NODEPTR merge(NODEPTR,NODEPTR,NODEPTR);
NODEPTR list1=NULL,list2=NULL,list3=NULL;
clrscr();
list1=createlist(list1);
list2=createlist(list2);
list3=merge(list1,list2,list3);
printf("\nThe first list is=>\n");
display(list1);
printf("\nThe second list is=>\n");
display(list2);
printf("\nThe merged list is=>\n");
display(list3);
getch();
}
NODEPTR createlist(NODEPTR start)
  {
    int i,n;
    clrscr();
    start=NULL;
    printf("\n\t How many nodes");
    scanf("%d",&n);
    for(i=0;i<n;i++)
       {
	 newnode=(NODEPTR)malloc(sizeof(struct node));
	 printf("\n\t enter the data for node ");
	 scanf("%d",&newnode->data);
	 newnode->next=NULL;
if(start==NULL)
	start=temp=newnode;
else
       {
	temp->next=newnode;
	temp=newnode;
       }
     }
return start;
  }

void display(NODEPTR start)
     {
       for(temp=start;temp!=NULL;temp=temp->next)
       printf("\n\t%d\n\n",temp->data);
       getch();
     }
NODEPTR merge(NODEPTR list1 ,NODEPTR list2 ,NODEPTR list3 )
    {
       NODEPTR t1=list1,t2=list2,t3=list3,newnode;
       while(t1 && t2)
      {
       newnode=(NODEPTR)malloc(sizeof(struct node));
       newnode->next=NULL;
       if(t1->data < t2->data)
	 {
	   newnode->data=t1->data;
	   t1=t1->next;
	 }
       else
{
newnode->data=t2->data;
t2=t2->next;
}
      if(list3==NULL)
      t3=list3=newnode;
      else
    {
      t3->next=newnode;
      t3=t3->next;
    }
}
if(t1)
t3->next=t1;
if(t2)
t3->next=t2;
return(list3);
}


