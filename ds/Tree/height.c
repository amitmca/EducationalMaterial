// Program for Creating a Binary Search Tree and Tree traversal

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
int Height(TREE root,int h)
	{
	if(root)
		{
		Height(root->left,h+1);
		Height(root->right,h+1);
		}
	return h;
	}
void main()
	{
	TREE root;
	int ans;
	clrscr();
	root=Createbst(root);
	Display(root,1);
	ans=Height(root,1);
	printf("\nHeight is:%d",ans);
	getch();
	}

