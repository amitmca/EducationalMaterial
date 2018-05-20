//Program for Singly Linked List

#include<iostream.h>
#include<conio.h>

class node
	{
	public:
	int data;
	node *next;
	};

class singly
	{
	private:
		node *start;
	public:
		singly()
		{
		start=NULL;
		}
		node * Create();
		void Display(node *);
	};
node * singly::Create()
	{
	node *newnode,*temp,*start=NULL;
	char ch;
		do
		{
		newnode=new node;
		newnode->next=NULL;
		cout<<"\nNode Data:";
		cin>>newnode->data;
		if(start==NULL)
			start=temp=newnode;
		else
			{
			temp->next=newnode;
			temp=newnode;
			}
		cout<<"\n Another Node(y/n):";
		cin>>ch;
		}while(ch=='y' || ch=='Y');
	return(start);
	}
void singly::Display(node *start)
	{
	node *temp=start;
	while(temp!=NULL)
		{
		cout<<temp->data<<"\n";
		temp=temp->next;
		}
	}
int main()
	{
	singly s;
	node *start=NULL;
	clrscr();
	start=s.Create();
	s.Display(start);
	getch();
	return 0;
	}