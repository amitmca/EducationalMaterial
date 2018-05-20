//Program for finding the height/depth of BST
#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;
TREE Create(TREE root)
	{
	TREE temp,newnode;
	char ch='y';
	root=NULL;
	while(ch=='y')
		{
		newnode=ALLOC;
		newnode->left=newnode->right=NULL;
		printf("\n\nData:");
		scanf("%d",&newnode->data);
		if(root==NULL)
			root=newnode;
		else
			{
			temp=root;
			while(temp!=NULL)
			{
			if(newnode->data < temp->data)
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
			{
			if(newnode->data > temp->data)
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
			}
		printf("\nAnother(y/n):");
		ch=getche();
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
			printf("  ");
		printf("%d",root->data);
		printf("\n");
		Display(root->left,l+1);
		}
	}
int Depth(TREE root,int l)
	{
	TREE temp=root;
	static int def=0;
	if(temp!=NULL)
		{
		Depth(temp->right,l+1);
		def++;
		if(def<l)
			def=l;
		Depth(temp->left,l+1);
		}
	return(def);
	}
void main()
	{
	TREE root,root1;
	int ans;
	clrscr();
	root=Create(root);
	Display(root,1);
	ans=Depth(root,1);
	printf("\nDepth is:%d",ans);
	getch();
	}