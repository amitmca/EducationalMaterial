//Singly Linked List

#include<iostream.h>
#include<conio.h>
#include<stdio.h>

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
	node *start=NULL,*newnode,*temp;
	char ch;
	do
		{
		newnode=new node;
		newnode->next=NULL;
		cout<<"\n\n Node Data:";
		cin>>newnode->data;
		if(start==NULL)
			start=temp=newnode;
		else
			{
			temp->next=newnode;
			temp=newnode;
			}
		cout<<"\n\nAnother Node(Y/N):";
		ch=getche();
		}while(ch=='y' || ch=='Y');
	return(start);
	}
void singly::Display(node *start)
	{
	node *temp;
	for(temp=start;temp!=NULL;temp=temp->next)
		{
		cout<<"\n"<<temp->data;
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