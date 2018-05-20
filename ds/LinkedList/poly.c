//Program for Addition Of 2 Polynomials

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	int coef,pow;
	struct node *next;
	}*POLY;

POLY Create(POLY r)
	{
	POLY newnode,p;
	char ch='y';
	p=r=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		printf("\n\n Coefficient :");
		scanf("%d",&newnode->coef);
		printf("\n Power :");
		scanf("%d",&newnode->pow);
		if(r==NULL)
			p=r=newnode;
		else
			{
			p->next=newnode;
			p=newnode;
			}
		printf("\n Is it further ? :");
		ch=getche();
		}
	return(r);
	}
void Display(POLY r)
	{
	POLY p=r;
	printf("\n\n");
	while(p)
		{
		printf("%d x ^ %d + ",p->coef,p->pow);
		p=p->next;
		}
	printf("\n\n");
	}
POLY add(POLY r1,POLY r2)
	{
	POLY t1=r1,t2=r2,t3,p3,newnode;
	t3=p3=NULL;
	while(t1 && t2)
		{
		newnode=ALLOC;
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
			t3=p3=newnode;
		else
			{
			t3->next=newnode;
			t3=newnode;
			}
		}
	while(t1)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->pow=t1->pow;
		newnode->coef=t1->coef;
		t3->next=newnode;
		t3=newnode;
		t1=t1->next;
		}
	while(t2)
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->pow=t2->pow;
		newnode->coef=t2->coef;
		t3->next=newnode;
		t3=newnode;
		t2=t2->next;
		}
	return(p3);
	}
void main()
	{
	POLY r1,r2,r3;
	clrscr();
	printf("\nPlease Enter the first polynomial:\n\n");
	r1=Create(r1);
	clrscr();
	printf("\n\nPlease Enter the second polynomial:\n\n");
	r2=Create(r2);
	clrscr();
	printf("\nPlease wait while performing the addition......\n\n");
	delay(1000);
	printf("\n First Polynomial:\t");
	delay(800);
	Display(r1);
	printf("\n Second Polynomial:\t");
	delay(800);
	Display(r2);
	printf("\nAddition is:\n\t");
	r3=add(r1,r2);
	delay(800);
	Display(r3);
	getch();
	}