// Program for Creating a Binary Search Tree and Compare two BST
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
int Compare(TREE root1,TREE root2)
	{
	static int e=0;
	if(root1==NULL && root2==NULL)
		return 1;
	else
		if(root1!=NULL && root2!=NULL)
			if(root1->data == root2->data)
				if(Compare(root1->left,root2->left))
				e=Compare(root1->right,root2->right);
		else
			e=0;
	return(e);
	}
void main()
	{
	TREE root,root1;
	int e;
	clrscr();
	root=Createbst(root);
	Display(root,1);
	root1=Createbst(root1);
	Display(root1,1);
	e=Compare(root,root1);
	if(e==0)
		printf("\n Tree's are not equal\n");
	else
		printf("\n Tree's are  equal\n");
	getch();
	}

