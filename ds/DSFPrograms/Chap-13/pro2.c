/*Program 13.2 : Program showing various operations on a binary search tree.*/
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
typedef struct BSTnode
{
	 int data;
	 struct BSTnode *left,*right;
}BSTnode;

BSTnode *initialise();
BSTnode *find(BSTnode *,int);
BSTnode *insert(BSTnode *,int);
BSTnode *delet(BSTnode *,int);
BSTnode *find_min(BSTnode *);
BSTnode *find_max(BSTnode *);
BSTnode *create();
void inorder(BSTnode *T);
void main()
{
	BSTnode *root,*p;
	int x;
	clrscr();
	initialise();
	root=create();
	printf("\n**** BST created ****");
	printf("\ninorder traversal on the tree ");
	inorder(root);
	p=find_min(root);
	printf("\n smallest key in the tree = %d",p->data);
	p=find_max(root);
	printf("\nlargest key in the tree = %d",p->data);
	printf("\n **** delete operation ****");
	printf("\nEnter the key to be deleted :");
	scanf("%d",&x);
	root=delet(root,x);
	printf("inorder traversal after deletion :");
	inorder(root);
}
void inorder(BSTnode *T)
{
	if(T!=NULL)
	{
		inorder(T->left);
		printf("%5d",T->data);
		inorder(T->right);
	}
}
BSTnode *initialise()
{
	return(NULL);
}
BSTnode *find(BSTnode *root,int x)
{
	while(root!=NULL)
	{
		if(x==root->data)
			return(root);
		if(x>root->data)
			root=root->right;
		else
		root=root->left;
	}
	return(NULL);
}
BSTnode *insert(BSTnode *T,int x)
{
	BSTnode *p,*q,*r;
	// acquire memory for the new node
	r=(BSTnode*)malloc(sizeof(BSTnode));
	r->data=x;
	r->left=NULL;
	r->right=NULL;
	if(T==NULL)
		return(r);
	// find the leaf node for insertion
	p=T;
	while(p!=NULL)
	{
		q=p;
		if(x>p->data)
			p=p->right;
		else
			p=p->left;
	}
	if(x>q->data)
		q->right=r;  // x as right child of q
	else
		q->left=r;   //x as left child of q
	return(T);
}
BSTnode *delet(BSTnode *T,int x)
{
	BSTnode *temp;
	if(T==NULL)
	{
		printf("\nElement not found :");
		return(T);
	}
	if(x < T->data)                // delete in left subtree
	{
		T->left=delet(T->left,x);
		return(T);
	}
	if(x > T->data)                // delete in right subtree
	{
		T->right=delet(T->right,x);
		return(T);
	}
	// element is found
	if(T->left==NULL && T->right==NULL)   // a leaf node
	{
		temp=T;
		free(temp);
		return(NULL);
	}
	if(T->left==NULL)
	{
		temp=T;
		T=T->right;
		free(temp);
		return(T);
	}
	if(T->right==NULL)
	{
		temp=T;
		T=T->left;
		free(temp);
		return(T);
	}
	// node with two children
	temp=find_min(T->right);
	T->data=temp->data;
	T->right=delet(T->right,x);
	return(T);
}
BSTnode *create()
{
	int n,x,i;
	BSTnode *root;
	root=NULL;
	printf("\nEnter no. of nodes :");
	scanf("%d",&n);
	printf("\nEnter tree values :");
	for(i=0;i<n;i++)
	{
		scanf("%d",&x);
		root=insert(root,x);
	}
	return(root);
}
BSTnode *find_min(BSTnode *T)
{
	while(T->left!=NULL)
		T=T->left;
	return(T);
}
BSTnode *find_max(BSTnode *T)
{
	while(T->right!=NULL)
		T=T->right;
	return(T);
}

/*
          *** OUTPUT ***
Enter no. of nodes :5

Enter tree values :34 11 2 99 6

**** BST created ****
inorder traversal on the tree     2    6   11   34   99
 smallest key in the tree = 2
largest key in the tree = 99
 **** delete operation ****
Enter the key to be deleted :11
inorder traversal after deletion :    2    6   34   99

*/
.

