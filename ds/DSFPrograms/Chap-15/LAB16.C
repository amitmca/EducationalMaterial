// program showing various operations on binary search tree
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
typedef struct BSTnode
{
	 int data;
	 struct BSTnode *left,*right;
}BSTnode;
typedef struct stack
  { BSTnode *data[20];
    int top;
  }stack;
void init(stack *s)
 { s->top=-1;
 }
BSTnode * pop(stack *s)
 { BSTnode *p;
   p=s->data[s->top];
   s->top=s->top-1;
   return(p);
 }
void  push(stack *s, BSTnode *p)
  { s->top=s->top+1;
    s->data[s->top]=p;
  }
int empty(stack *s)
 { if(s->top==-1)
     return(1);
   return(0);
 }
int full(stack *s)
  {  if(s->top==19)
	return(1);
     return(0);
  }

BSTnode *find(BSTnode *,int);
BSTnode *insert(BSTnode *,int);
BSTnode *delet(BSTnode *,int);
BSTnode *create();
void inorder(BSTnode *T);
void preorder(BSTnode *T);
void postorder(BSTnode *T);
void non_rec_inorder(BSTnode *T);
void main()
{
	BSTnode *root=NULL,*p;
	int x,op;
	clrscr();
	do
	  { printf("\n\n1)Create\n2)Delete\n3)Search\n4)Preorder(recursive)");
	    printf("\n5)Inorder(recursive)\n6)Posorder(Recursive)");
	    printf("\n7)Inorder(Non-Recursive)\n8)Quit");
	    printf("\nEnter Your Choice :");
	    scanf("%d",&op);
	     switch(op)
	      {
		case 1:root=create();break;
		case 2:	printf("\nEnter the key to be deleted :");
			scanf("%d",&x);
			root=delet(root,x);
			break;
		case 3:	printf("\nEnter the key to be searched :");
			scanf("%d",&x);
			p=find(root,x);
			if(p==NULL)
			  printf("\n ***** Not Found****");
			else
			  printf("\n ***** Found*****");
			break;
		case 4: preorder(root);break;
		case 5: inorder(root);break;
		case 6: postorder(root);break;
		case 7: non_rec_inorder(root);break;

	     }
	 }while(op!=8);
}


void inorder(BSTnode *T)
{
	if(T!=NULL)
	{
		inorder(T->left);
		printf("%d\t",T->data);
		inorder(T->right);
	}
}

void preorder(BSTnode *T)
 {     	if(T!=NULL)
	  { printf("%d\t",T->data);
	    preorder(T->left);
	    preorder(T->right);
	  }
 }
void postorder(BSTnode *T)
 {    	if(T!=NULL)
	  {
	    postorder(T->left);
	    postorder(T->right);
	    printf("%d\t",T->data);
	  }
 }
void non_rec_inorder(BSTnode *T)
 {   stack s;
     init(&s);
     printf("\n");
     if(T==NULL)
      return;
      while(T!=NULL)
       { push(&s,T);
	 T=T->left;
       }
      while(!empty(&s))
       { T=pop(&s);
	 printf("%d   ",T->data);
	 T=T->right;
	 while(T!=NULL)
	  { push(&s,T);
	    T=T->left;
	  }
       }
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
	//go to the inorder successor of the node
	temp=T->right;
	while(temp->left !=NULL)
	  temp=temp->left;
	T->data=temp->data;
	T->right=delet(T->right,temp->data);
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

/*
                 *** OUTPUT ***
1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :1

Enter no. of nodes :5

Enter tree values :
8 9 7 5 4


1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :4
8       7       5       4       9

1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :5
4       5       7       8       9

1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :6
4       5       7       9       8


1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :7

4   5   7   8   9

1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :2

Enter the key to be deleted :7


1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :3

Enter the key to be searched :7

 ***** Not Found****

1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :3

Enter the key to be searched :4

 ***** Found*****

1)Create
2)Delete
3)Search
4)Preorder(recursive)
5)Inorder(recursive)
6)Posorder(Recursive)
7)Inorder(Non-Recursive)
8)Quit
Enter Your Choice :8
*/

