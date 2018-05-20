/*  Program for menudriven of dynamic representation of stack  */
#include<stdio.h>
#include<conio.h>
#define GANESH (struct node *) malloc (sizeof (struct node))
struct node
{
int data;
struct node *next;
}*top;               /* Self refrential structure */
typedef struct node * NODEPTR;
void initstack()
{
top=NULL;
}  /* Initialising a stack */
int isempty()
{
return(top==NULL);
}  /* check the stack is empty!  */
int push(int n)
{
NODEPTR newnode;
newnode=GANESH;
newnode->next=NULL;
newnode->data=n;
if(top==NULL)
top=newnode;
else
{
newnode->next=top;
top=newnode;
}
return(0);
}  /* push opration */
int pop()
{
int n;
NODEPTR temp=top;
n=top->data;
free(temp);
return(n);
} /* pop opration */
main()
{
int choice();
int n;
initstack();  /*  cerate a stack  */
do

{
clrscr();
printf("\n1:Push\n2:Pop\n3:exit\n");
printf("Enter your choice");
scanf("%d",&choice);

}
switch(choice)
{
{
case 1:/*  Push */
printf("Enter the element to be Pushed");
scanf("%d",&n);
push(n);
break;
}
case 2:/* Pop */
if(isempty())
printf("Stack is empty");
else
{
printf("Poped element=%d",pop());
getch();
break;
}

}
return(0);
}
