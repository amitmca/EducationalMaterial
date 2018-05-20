// Program for Non recursive Binary Search Tree traversal

#include<stdio.h>
#include<conio.h>
#include<alloc.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
#define MAX 100

typedef struct node
	{
	int data;
	struct node *left,*right;
	}*TREE;

int c=0;

TREE stack[50];

int top=-1;


TREE  Createbst(TREE root)
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
void push(TREE ele)
	{
	top++;
	stack[top]=ele;
	}
TREE pop()
	{
	TREE ele;
	ele=stack[top];
	top--;
	return ele;
	}
void NonRecInorder(TREE root)
	{
	TREE temp;
	int i;
	temp=root;
	printf("\nIn Order ");
	for(i=0;i<3;i++)
		{
		printf("----");
//		delay(1200);
		}
	printf(">");
	while(1)
		{
		while(temp!=NULL)
			{
			push(temp);
			temp=temp->left;
			}
		if(top==-1)
			break;
		else
			{
			temp=pop();
			printf("\t%d",temp->data);
		//	delay(500);
			temp=temp->right;
			}
		}
	printf("\n");
	}
void NonRecPreorder(TREE root)
	{
	TREE temp;
	int i;
	temp=root;
	printf("\nPre Order ");
	for(i=0;i<3;i++)
		{
		printf("----");
		//delay(1200);
		}
	printf(">");

	while(1)
		{
		while(temp!=NULL)
			{
			printf("\t%d",temp->data);
			//delay(500);
			push(temp);
			temp=temp->left;
			}
		if(top==-1)
			break;
		else
			{
			temp=pop();
			temp=temp->right;
			}
		}
	printf("\n");
	}
void NonRecPostorder(TREE root)
	{
	TREE temp;
	int i;
	temp=root;
	printf("\nPost Order ");
	for(i=0;i<3;i++)
		{
		printf("---");
		//delay(1200);
		}
	printf(">");

	while(1)
		{
		while(temp!=NULL)
			{
			push(temp);
			temp=temp->left;
			}
		if(stack[top]==NULL)
			{
			temp=pop();
			printf("\t%d",temp->data);
			//delay(500);
			}
		while(stack[top]->right==temp)
			{
			if(top!=-1)
				{
				temp=pop();
				printf("\t%d",temp->data);
				//delay(500);
				}
			}
		if(top==-1)
			break;
		temp=stack[top]->right;
		}
	printf("\n");
	}
void Display(TREE root,int l)
	{
	 int i;
	 printf("\n");
	 if(root)
	   {
	   Display(root->right,l+1);
	   //delay(200);
	   for(i=0;i<l;i++)
	     printf("   ");
	   printf("%d",root->data);
	   //delay(200);
	     printf("\n");
	   //delay(200);
	   Display(root->left,l+1);
	   }
	}

void main()
	{
	TREE root;
	//clrscr();
	root=Createbst(root);
	Display(root,1);
	NonRecInorder(root);
	printf("\n");
	NonRecPreorder(root);
	printf("\n");
	NonRecPostorder(root);
	printf("\n");
	//getch();
	}

