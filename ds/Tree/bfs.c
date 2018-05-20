// Program for Creating a Binary Search Tree and Breadth First Search

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))
typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;

TREE queue[50];

int c=0,front=-1,rear=-1;

void Insert(TREE ele)
	{
	rear++;
	queue[rear]=ele;
	}

TREE Delete()
	{
	TREE ele;
	ele=queue[front];
	front++;
	return(ele);
	}

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

void BFS(TREE root)
	{
	TREE temp=root;
	while(1)
		{
		while(temp!=NULL)
			{
			Insert(temp);
		     //	temp=Delete();
			printf("\t%d",temp->data);
			temp=temp->left;
			}
		}
	}
/*void Display(TREE root,int l)
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
  */
void main()
	{
	TREE root;
	//clrscr();
	root=Createbst(root);
    //	Display(root,1);
	BFS(root);
	//getch();
	}

