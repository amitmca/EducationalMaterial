// Menu Driven Program for tree

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;

TREE stack[50];

int c=0,top=-1,dep;

void Push(TREE ele)
	{
	top++;
	stack[top]=ele;
	}
TREE Pop()
	{
	TREE ele;
	ele=stack[top];
	top--;
	return(ele);
	}
TREE Createbst(TREE root)
	{
	TREE newnode,temp;
	int n;
	char ch='y';
	clrscr();
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
void RecInorder(TREE root)
	{
	TREE temp=root;
	if(temp!=NULL)
		{
		RecInorder(temp->left);
		printf("\t%d",temp->data);
		RecInorder(temp->right);
		}
	}
void RecPreorder(TREE root)
	{
	TREE temp=root;
	if(temp!=NULL)
		{
		printf("\t%d",temp->data);
		RecPreorder(temp->left);
		RecPreorder(temp->right);
		}
	}
void RecPostorder(TREE root)
	{
	TREE temp=root;
	if(temp!=NULL)
		{
		RecPostorder(temp->left);
		RecPostorder(temp->right);
		printf("\t%d",temp->data);
		}
	}
void NonRecInorder(TREE root)
	{
	TREE temp=root;
	while(1)
		{
		while(temp!=NULL)
			{
			Push(temp);
			temp=temp->left;
			}
		if(top==-1)
			break;
		else
			{
			temp=Pop();
			printf("\t%d",temp->data);
			temp=temp->right;
			}
		}
	}
void NonRecPreorder(TREE root)
	{
	TREE temp=root;
	while(1)
		{
		while(temp!=NULL)
			{
			Push(temp);
			printf("\t%d",temp->data);
			temp=temp->left;
			}
		if(top==-1)
			break;
		else
			{
			temp=Pop();
			temp=temp->right;
			}
		}
	}
void NonRecPostorder(TREE root)
	{
	TREE temp=root;
	while(1)
		{
		while(temp!=NULL)
			{
			Push(temp);
			temp=temp->left;
			}
		if(stack[top]->right==NULL)
			{
			temp=Pop();
			printf("\t%d",temp->data);
			}
		while(stack[top]->right==temp)
			{
			if(top!=-1)
				{
 				temp=Pop();
				printf("\t%d",temp->data);
				}
			}
		if(top==-1)
			break;
		else
			temp=stack[top]->right;
		 }
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
int SumLeaf(TREE root)
	{
	static int sum=0;
	TREE temp=root;
	if(temp==NULL)
		{
		return(sum);
		}
	if(temp->left==NULL && temp->right==NULL)
		{
		sum=sum+temp->data;
		return(sum);
		}
	SumLeaf(temp->left);
	SumLeaf(temp->right);
	}

int CountLeaf(TREE root)
	{
	static int leaf=0;
	TREE temp=root;
	if(temp==NULL)
		{
		return(leaf);
		}
	if(temp->left==NULL && temp->right==NULL)
	++leaf;
	CountLeaf(temp->left);
	CountLeaf(temp->right);
	}
void Mirror(TREE root)
	{
	TREE temp=root,temp1;
	if(temp->left)
		Mirror(temp->left);
	if(temp->right)
		Mirror(temp->right);
	temp1=temp->left;
	temp->left=temp->right;
	temp->right=temp1;
	}
TREE Copy(TREE root)
	{
	TREE newnode;
	if(root!=NULL)
		{
		newnode=ALLOC;
		newnode->left=Copy(root->left);
		newnode->right=Copy(root->right);
		newnode->data=root->data;
		return(newnode);
		}
	else
		return(NULL);
	}
int CountTotal(TREE root)
	{
	TREE temp=root;
	static int count=0;
	if(temp!=NULL)
		{
		count++;
		CountTotal(temp->left);
		CountTotal(temp->right);
		}
	return(count);
	}
void Depth(TREE root,int l)
	{
	if(root!=NULL)
		{
		Depth(root->right,l+1);
		  if(dep<l)
		    dep=l;
		Depth(root->left,l+1);
		}
	}
int SumAllNodes(TREE root)
	{
	TREE temp=root;
	static int sum=0;
	if(temp!=NULL)
		{
		sum=sum+temp->data;
		SumAllNodes(temp->left);
		SumAllNodes(temp->right);
		}
	return(sum);
	}
void main()
	{
	TREE root,root1;
	int c,c1,c2,c3,sum,l,count,sum1;
	clrscr();
	do
		{
		printf("\n WELCOME  TO  TREE  OPREATIONS\n\n");
		printf("\n1] CREATE TREE\n\n");
		printf("\n2] DISPLAY TREE\n\n");
		printf("\n3] TREE TRAVERSALS\n\n");
		printf("\n4] SUM OF LEAF NODES\n\n");
		printf("\n5] COUNT NUMBER OF LEAF NODES\n\n");
		printf("\n6] MIRROR IMAGE OF THE TREE\n\n");
		printf("\n7] COPY TREE\n\n");
		printf("\n8] COUNT TOTAL NUMBER OF NODES\n\n");
		printf("\n9] DEPTH OF TREE\n\n");
		printf("\n10] SUM OF ALL NODES\n\n");
		printf("\n11] EXIT\n\n");
		printf("\n Your Choice:");
		scanf("%d",&c);
		switch(c)
			{
			case  1:
				root=Createbst(root);
				clrscr();
				break;

			case 2:
				Display(root,1);
				delay(1800);
				clrscr();
				break;

			case 3:
				do
				{
				clrscr();
				printf("\n\n TREE TRAVERSALS\n\n");
				printf("\n\n1) RECURSIVE \n\n");
				printf("\n\n2) NON RECURSIVE \n\n");
				printf("\nYour Choice:");
				scanf("%d",&c1);
				switch(c1)
					{
					case 1:
						do
						{
						printf("\n\n1)INORDER\n\n");
						printf("\n\n2)PREORDER\n\n");
						printf("\n\n3)POSTORDER\n\n");
						printf("\n\n Your Chioce:");
						scanf("%d",&c2);
						switch(c2)
							{
							case 1:
								RecInorder(root);
								break;
							case 2:
								RecPreorder(root);
								break;
							case 3:
								RecPostorder(root);
								break;
							}
						}while(c2!=4);
						break;
					case 2:
						do
						{
						printf("\n\n1)INORDER\n\n");
						printf("\n\n2)PREORDER\n\n");
						printf("\n\n3)POSTORDER\n\n");
						printf("\n\n Your Chioce:");
						scanf("%d",&c3);
						switch(c3)
							{
							case 1:
								NonRecInorder(root);
								break;
							case 2:
								NonRecPreorder(root);
								break;
							case 3:
								NonRecPostorder(root);
								break;
							}
						}while(c3!=4);
						break;
					}
				}while(c1!=3);
				break;

			case 4:
				sum=SumLeaf(root);
				printf("\n\nSUM :%d\n",sum);
				break;

			case 5:
			       l=CountLeaf(root);
			       printf("\n Total Leaf Nodes:%d\n",l);
			       break;

			case 6:
				Display(root,1);
				Mirror(root);
				Display(root,1);
				break;

			case 7:
				root1=Copy(root);
				Display(root1,1);
				break;

			case 8:
				count=CountTotal(root);
				printf("\n Total Nodes:%d\n",count);
				break;

			case 9:
				Depth(root,1);
				printf("\nDepth Is:%d\n",dep);
				break;

			case 10:
				sum1=SumAllNodes(root);
				printf("\nSUM :%d\n\n",sum1);
				break;

			case 11:
				exit(0);
			}
		}while(c!=11);
	}