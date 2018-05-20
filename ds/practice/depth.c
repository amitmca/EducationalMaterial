//write a program t calculate the depth of the tree...

#include<stdio.h>
#include<conio.h>

int dep;
struct tree
{
	int data;
	struct tree *left,*right;
};

//To create the tree & to insert element in the tree
struct tree *create(struct tree *r,int ele)
{
	if(r==NULL)
	{
		r=(struct tree *)malloc(sizeof(struct tree));
		r->left=r->right=NULL;
		r->data=ele;
		return r;
	}

	if(ele<r->data)
		r->left=create(r->left,ele);
	else
		r->right=create(r->right,ele);
	return r;
}

//To display the tree
void display(struct tree *r,int l)
{
	if(r!=NULL)
	{
		int i;
		display(r->right,l+1);
		for(i=0;i<l;i++)
			printf("   ");
		printf("%d\n",r->data);
		display(r->left,l+1);
	}
}

//To display postorder
void postorder(struct tree *r)
{
	if(r!=NULL)
	{
		int i;
		postorder(r->left);
		postorder(r->right);
		printf("%d ",r->data);

	}
}


//To display preorder
void preorder(struct tree *r)
{
	if(r!=NULL)
	{
		int i;
		printf("%d ",r->data);
		preorder(r->left);
		preorder(r->right);


	}
}
//To display inorder
void inorder(struct tree *r)
{
	if(r!=NULL)
	{
		int i;
		inorder(r->left);
		printf("%d ",r->data);
		inorder(r->right);

	}
}

//To calculate the depth of tree
void depth(struct tree *r,int l)
{
	if(r!=NULL)
	{
		int i;
		depth(r->right,l+1);
		if(dep<l)
		    dep=l;
		depth(r->left,l+1);
	}
}

// To search the element in the tree
int search(struct tree *r,int n)
{
	if(r!=NULL)
	{
		int i;
		if(n==r->data)
		     return 1;
		i=search(r->right,n);
		if(i!=1)
		    i=search(r->left,n);
		return i;
	}

	return 0;
}


void main()
{
	struct tree *t=NULL;
	clrscr();
	while(1)
	{
		int ch,ele,n,i;
		printf("\n\n\tMenu\n\n1)Crete Tree\n2)Display Tree\n3)To find the Depth of the Tree\n4)To search Any element");
		printf("\n5)Preorder\n6)Inorder\n7)Postorder");
		printf("\n0)Exit\n\n\tSELECT:");
		scanf("%d",&ch);
		switch(ch)
		{
		   case 1:
			printf("\n\nEnter the element:");
			scanf("%d",&ele);
			t=create(t,ele);
			printf("\n\tElement is inseted in the TREE");
			break;

		   case 2:
			printf("Tree is:\n\n");
			display(t,1);
			break;

		   case 3:
			dep=0;
			depth(t,1);
			printf("\nDepth of the tree is: %d",dep);
			break;

		   case 4:
			printf("\nEnter The element to search:");
			scanf("%d",&n);
			i=search(t,n);
			if(i)
			    printf("\nNumber is present");
			else
			    printf("\nNumber Not present");
			break;

		   case 5:
			printf("Preorder: ");
			preorder(t);
			break;

		   case 6:
			printf("Inorder: ");
			inorder(t);
			break;

		   case 7:
			printf("Postorder: ");
			postorder(t);
			break;

		   case 0:exit(0);
		}
		printf("\n\n\tPress Any Key...");
		getch();
		clrscr();
	}

}