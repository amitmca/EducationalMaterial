/*Program 10.6 : A program to create and print a polynomial.*/
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
typedef struct pnode
{
	int pow;
	float coeff;
	struct pnode *next;
}pnode;
pnode* create(int);    	//create polynomials of n terms
void print(pnode *);  	/* print the polynomial referenced by address of first node*/
void main()
{
	pnode *HEAD;
	int n;
	printf("\n Enter no. of terms :");
	scanf("%d",&n);
	HEAD=create(n);
	print(HEAD);
}
pnode *create(int n)
{
	pnode *head,*p;
	int i;
	// create the first node
	head=(pnode *)malloc(sizeof(pnode));
	//acquire memory for the first node
	p=head;
head->next=NULL;
	printf("\nEnter power and coefficient : ");
	scanf("%d %f",&(p->pow),&(p->coeff));
	for(i=1;i<n;i++)
	{
	   //create subsequent nodes
	   p->next=(pnode*)malloc(sizeof(pnode));
	   p=p->next;
	   p->next=NULL;
	   printf("\n Enter power and coefficient :");
	   scanf("%d%f",&(p->pow),&(p->coeff));
	}
	return(head);
}
void print(pnode *p)
{
	printf("\n");
	while(p!=NULL)
	{
		printf("%5.2fx^%d\t",p->coeff,p->pow);
		p=p->next;   //go to the next node
	}
}

