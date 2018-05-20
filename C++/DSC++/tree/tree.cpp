//Program for Tree Using C++ and 3 tree traversal methods

#include<iostream.h>
#include<conio.h>

class node
	{
	public:
		int data;
		node *left,*right;
	};

class tree
	{
	private:
		node *root;
	public:
		tree();
		node * Create(node *root);
		void Display(node *tree,int l);
		void Inorder(node *root);
		void Preorder(node *root);
		void Postorder(node *root);
	};

tree::tree()
	{
	root=NULL;
	}

node * tree::Create(node *root)
	{
	node *newnode,*temp;
	char ch='y';
	root=NULL;
	while(ch=='y')
		{
		newnode=new node;
		cout<<"\n\n Root data:";
		cin>>newnode->data;
		newnode->left=newnode->right=NULL;
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
			else if(newnode->data > temp->data)
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
		cout<<"\n Do you want to add another data(y/n):";
		ch=getche();
		}
	return(root);
	}
void tree::Inorder(node *root)
	{
	if(root!=NULL)
		{
		Inorder(root->left);
		cout<<root->data<<"\t";
		Inorder(root->right);
		}
	}
void tree::Preorder(node *root)
	{
	if(root!=NULL)
		{
		cout<<root->data<<"\t";
		Inorder(root->left);
		Inorder(root->right);
		}
	}
void tree::Postorder(node *root)
	{
	if(root!=NULL)
		{
		Inorder(root->left);
		Inorder(root->right);
		cout<<root->data<<"\t";
		}
	}
void tree::Display(node *root,int l)
	{
	 int i;
	 cout<<"\n";
	 if(root)
	   {
	   Display(root->right,l+1);
	   for(i=0;i<l;i++)
		   cout<<"  ";
	   cout<<root->data;
		 cout<<"\n";
	   Display(root->left,l+1);
	   }
	}

int main()
	{
	tree t;
	node *root;
	root=NULL;
	clrscr();
	root=t.Create(root);
	t.Display(root,1);
	cout<<"\n Inorder Tree Traversal is:\n\n";
	t.Inorder(root);
	cout<<"\n Preorder Tree Traversal is:\n\n";
	t.Preorder(root);
	cout<<"\n Postorder Tree Traversal is:\n\n";
	t.Postorder(root);
	getch();
	return 0;
	}
