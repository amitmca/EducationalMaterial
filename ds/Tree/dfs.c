// Program for Depth First Search

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
#define MAX 100

typedef struct node
	{
	int data;
	struct node *left,*right;
	}tree;

int c=0;

tree *stack[50];
int top=-1;


struct node * Createbst(struct node *root)
	{
	struct node *newnode,*temp;
	int n;
	char ch='y';
	root=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		printf("\n\n Data:");
		scanf("%d",&n);
		newnode->left=newnode->right=NULL;
		newnode->data=n;
		if(root==NULL)
			root=newnode;
		else
			{
			temp=root;
			while(temp!=NULL)
				{
				if(n < temp->data)
					{
					if(temp->left==NULL)
						{
						temp->left=newnode;
						break;
						}
					else
						temp=temp->left;
					}
				else
					if(n > temp->data)
					{
					if(temp->right==NULL)
						{
						temp->right=newnode;
						break;
						}
					else
						temp=temp->right;
					}
				}
			}
		printf("\nAnother(y/n):");
		ch=getche();
		c++;
		}
	return(root);
	}
void push(struct node *ele)
	{
	top++;
	stack[top]=ele;
	}
struct node *pop()
	{
	struct node *ele;
	ele=stack[top];
	top--;
	return ele;
	}
void DFS(struct node *root)
	{
	struct node *temp;
	temp=root;
	while(1)
		{
		while(temp!=NULL)
			{
			push(temp);
			temp=pop();
			printf("\t%d",temp->data);
			if(temp->right)
				push(temp);
			if(temp->left)
				push(temp);
			}
		}
	}
void Display(struct node *root,int l)
	{
	 int i;
	 printf("\n");
	 if(root)
	   {
	   Display(root->right,l+1);
	   delay(200);
	   for(i=0;i<l;i++)
	     printf("   ");
	   printf("%d",root->data);
	   delay(200);
	     printf("\n");
	   delay(200);
	   Display(root->left,l+1);
	   }
	}

void main()
	{
	struct node *root;
	clrscr();
	root=Createbst(root);
	Display(root,1);
	DFS(root);
	getch();
	}

