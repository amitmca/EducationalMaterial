#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

class node
	{
	public:
		int data;
		node *next;
	};
class queue
	{
	private:
		node *front,*rear;
	public:
		queue()	{  front=rear=NULL;	}
		node * Insert(node *rear);
		node * Delete(node *front);
		void Display(node *front);
	};
node * queue::Insert(node *rear)
	{
	node *newnode;
	char ch='y';
	while(ch=='y')
		{
		newnode=new node;
		newnode->next=NULL;
		cout<<"\n\n Rear Data:";
		cin>>newnode->data;
		if(front==NULL)
			front=rear=newnode;
		else
			{
			rear->next=newnode;
			rear=newnode;
			}
		cout<<"\n Any New node:(y/n)";
		ch=getche();
		}
	return(front);
	}
node * queue::Delete(node *front)
	{
	node *tmp=front;
	front=front->next;
	delete tmp;
	return(front);
	}
void queue::Display(node *front)
	{
	node *temp=front;
	cout<<"\n";
	while(temp!=NULL)
		{
		cout<<" "<<temp->data<<"\n";
		temp=temp->next;
		}
	}
int main()
	{
	queue q;
	node *front,*rear;
	clrscr();
	front=rear=NULL;
	front=q.Insert(rear);
	q.Display(front);
	front=q.Delete(front);
	q.Display(front);
	getch();
	return 0;
	}