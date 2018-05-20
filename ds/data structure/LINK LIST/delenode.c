/*  program for delete node at given position  */
#include<stdio.h>
#include<conio.h>
#define NODEALLOC (struct node *)malloc(sizeof(struct node))
struct node
{
int data;
struct node *next;
};
typedef struct node *NODEPTR ;
void main()
{
NODEPTR first=NULL,temp,newnode;
NODEPTR deletep(NODEPTR,int);
int n,pos,i;
clrscr();
printf("\nHow many nodes:=>");
scanf("%d",&n);
for(i=0;i<n;i++)
{
newnode=NODEALLOC;
newnode->next=NULL;
printf("Enter the data:=>");
scanf("%d",&newnode->data);
if(first==NULL)
first=temp=newnode;
else
{
temp->next=newnode;
temp=newnode;
}
}
printf("\nEnter the position for deletion:=>");
scanf("%d",&pos);
first=deletep(first,pos);
printf("\nThe list after deletion:=>");
for(temp=first;temp!=NULL;temp=temp->next)
printf("%d\t",temp->data);
getch();
}
NODEPTR deletep(NODEPTR first,int pos)
{
int i;
NODEPTR temp=first,temp1;
if(pos==1)
{
temp=first;
first=first->next;
free(temp);
return(first);
}
for(i=1;(i<pos-1) &&(temp!=NULL);i++)
temp=temp->next;
if(temp==NULL)
printf("POSITION OUT OF RANGE");
else
{
temp1=temp->next;
temp->next=temp1->next;
free(temp1);
}
return(first);
}

