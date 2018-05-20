/*  program addition of two polynomials  */
#include<stdio.h>
#include<conio.h>
#define POLY (struct node *)malloc (sizeof(struct node))
struct node
{
int coef,pow;
struct node *next;
};
typedef struct node * POLY;
main()
{
POLY p1=NULL,p2=NULL,p3=NULL;
POLY cerate(POLY,int);
void display(POLY);
POLY add(POLY p1,POLY p2,POLY p3);
int n;
clrscr();
printf("\nHow many terms in the first polynomial?");
scanf("%d",&n);
p1=create(p1 , n);
display(p1);
printf("\nHow many terms in the second polynomial?");
scanf("%d",&n);
p2=create(p2 , n);
display(p2);
p3=add(p1,p2,p3);
printf("\nThe addition is:=>" );
display(p3);
getch();
return(0);
}
POLY create(POLY p1,int n)
{
POLY temp=p1,newnode;
int i;
pirntf("Enter the terms in desending order of power:\n");
for(i=0;i<n;i++)
{
newnode=POLY;
newnode->next=NULL;
printf("\nCoefficent= :");
scanf("%d",&newnode->coef);
printf("\nPower= :");
scanf("%d",&newnode->pow);
if(p1==NULL)
temp=p1=newnode;
else
{
temp->next=newnode;
temp=newnode;
}
}
return(p1);
}
void display(POLY p1)
{
POLY temp=p1;
while(temp)
{
printf("%d X^ %d +",temp->coef,temp->pow);
temp=temp->next;
}
}
POLY add(POLY p1,POLY p2,POLY p3)
{
POLY t1=p1,t2=p2,t3=p3,newnode;
int i;
while(t1 && t2)
{
newnode=POLY;
newnode->next=NULL;
if(t1->pow > t2->pow)
{
newnode->pow=t1->pow;
newnode->coef=t1->coef;
t1=t1->next;
}
else
if(t1->pow < t2->pow)
{
newnode->pow=t2->pow;
newnode->coef=t2->coef;
t2=t2->next;
}
else
{
newnode->pow=t1->pow;
newnode->coef=t1->coef+t2->coef;
t1=t1->next;
t2=t2->next;
}
if(t3==NULL)
p3=t3=newnode;
else
{
t3->next=newnode;
t3=newnode;
}
}
while(t1)
{
newnode=POLY;
newnode->next=NULL;
newnode->pow=t1->pow;
newnode->coef=t1->coef;
t3->next=newnode;
t3=newnode;
t1=t1->next;
}
while(t2)
{
newnode=POLY;
newnode->next=NULL;
newnode->pow=t2->pow;
newnode->coef=t2->coef;
t3->next=newnode;
t3=newnode;
t2=t2->next;
}
return(p3);
}

