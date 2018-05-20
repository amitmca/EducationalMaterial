// Program for Creating a Binary Search Tree and Counting Total and Leaf Nodes
#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;

int c=0;

TREE Createbst(TREE root)
	{
	TREE newnode,temp;
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

void Display(TREE root,int l)
	{
	 int i;
	 printf("\n");
	 if(root)
	   {
	   Display(root->right,l+1);
	   for(i=0;i<l;i++)
	     printf("   ");
	   printf("%d",root->data);
	     printf("\n");
	   Display(root->left,l+1);
	   }
	}
int Countnode(TREE root)
	{
	static int count=0;
	TREE temp=root;
	if(temp!=NULL)
		{
		count++;
		Countnode(temp->left);
		Countnode(temp->right);
		}
	return(count);
	}
int Sumleaf(TREE root)
	{
	static int sum=0;
	TREE temp=root;
	if(temp==NULL)
		return(sum);
	if(temp->left == NULL && temp->right == NULL)
		{
		sum=sum+temp->data;
		return(sum);
		}
		Sumleaf(temp->left);
		Sumleaf(temp->right);
	}
int Countleaf(TREE root)
	{
	static int leaf=0;
	TREE temp=root;
	if(temp==NULL)
		return(leaf);
	if(temp->left == NULL && temp->right == NULL)
		return ++leaf;
		Countleaf(temp->left);
		Countleaf(temp->right);
	}
void main()
	{
	TREE root,root1;
	int c,l,sum;
	clrscr();
	root=Createbst(root);
	Display(root,1);
	c=Countnode(root);
	l=Countleaf(root);
	sum=Sumleaf(root);
	printf("\n Total Nodes:%d\n\nTotal Leaf Nodes:%d\n\nSum Of Leaf Nodes:%d",c,l,sum);
	getch();
	}

