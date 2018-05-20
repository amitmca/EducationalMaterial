/*  PROGRAM FOR SINGLY LINKED_LIST */
#include<stdio.h>
#include<conio.h>
struct node
{
int data;
struct node *next;
}*start,*temp,*newnode;
void main()
{
int i,n;
clrscr();
start=NULL;
printf("\n\t How many nodes");
scanf("%d",&n);
for(i=0;i<n;i++)
{
newnode=(struct node*)malloc(sizeof(struct node));
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

for(temp=start;temp!=NULL;temp=temp->next)
printf("\n\t%d\n\n",temp->data);
getch();
}
