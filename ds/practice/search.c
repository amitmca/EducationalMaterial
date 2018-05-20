#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;
int dep;
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
int Search(TREE root,int ele)
	{
	static int level=0;
	TREE temp=root;
	if(temp!=NULL)
		{
		if(temp->data==ele)
			{
			level++;
			}
		Search(temp->left,ele);
		Search(temp->right,ele);
		}
	return(level);
	}
void main()
	{
	TREE root,root1;
	int ele,ans;
	clrscr();
	root=Create(root);
	Display(root,1);
	printf("\nElement to Search:");
	scanf("%d",&ele);
	ans=Search(root,ele);
	printf("\n Level is:%d",ans);
/*	if(ans==0)
		printf("\nNot Found\n");
	else
		printf("\nFound\n");*/
	getch();
	}