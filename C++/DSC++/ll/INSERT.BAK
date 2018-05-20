//Insertion and deletion for Singly Linked List

#include<iostream.h>
#include<conio.h>
#include<stdio.h>

int c=0;

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
		node * Insert(node *start,int pos,int num);
		node * Delete(node *start,int pos);
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
		c++;
		}while(ch=='y' || ch=='Y');
	return(start);
	}

void singly::Display(node *start)
	{
	node *temp;
	for(temp=start;temp!=NULL;temp=temp->next)
		{
		printf("\n%d\n",temp->data);
		}
	cout<<"\n\nc="<<c<<"\n";
	}

node * singly::Insert(node *start,int pos,int num)
	{
	int i;
	node *newnode,*temp,*temp1;
	newnode=new node;
	newnode->next=NULL;
	newnode->data=num;
	if(pos==1)
		{
		newnode->next=start;
		start=newnode;
		c++;
		cout<<"\n\nc="<<c<<"\n";
		return start;
		}
	else if(pos==c)
		{
		for(temp=start;temp->next!=NULL;temp=temp->next);
		temp->next=newnode;
		c++;
		cout<<"\n\nc="<<c<<"\n";
		return(start);
		}
	else
		{
		for(i=0,temp=start;i<pos-1;i++,temp=temp->next);
		temp1=temp->next;
		temp->next=newnode;
		newnode->next=temp1;
		c++;
		cout<<"\n\nc="<<c<<"\n";
		return(start);
		}
	}
node * singly::Delete(node *start,int pos)
	{
	node *temp,*temp1;
	int i;
	if(pos==1)
		{
		temp=start;
		temp1=temp;
		temp=temp->next;
		delete temp1;
		start=temp;
		c--;
		cout<<"\n\nc="<<c<<"\n";
		return(start);
		}
	else if(pos==c)
		{
		temp=start;
		for(i=1;i<c-1;i++)
			{
			temp=temp->next;
			}
		temp1=temp->next;
		temp->next=NULL;
		delete temp1;
		c--;
		return(start);
		}
	else
		{
		temp=start;
		for(i=0;i<pos-1;i++)
			temp=temp->next;
		temp1=temp->next;
		temp->next=temp1->next;
		delete temp1;
		c--;
		return(start);
		}
	}
int main()
	{
	int p,n;
	singly s;
	node *start=NULL;
	clrscr();
	start=s.Create();
	s.Display(start);
	cout<<"\nEnter Position:";
	cin>>p;
	cout<<"\n Enter Value:";
	cin>>n;
	start=s.Insert(start,p,n);
	s.Display(start);
	cout<<"\nEnter Position:";
	cin>>p;
	start=s.Delete(start,p);
	s.Display(start);
	getch();
	return 0;
	}