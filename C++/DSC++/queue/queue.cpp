//Program for Queue Using C++

#include<iostream.h>
#include "conio.h"
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
		queue();
		node * Insert(node *rear);
		node * Delete(node *front);
		void Display(node *front);
	};

queue::queue()
	{
	front=rear=NULL;
	}

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
		cout<<"\n Do you want to add more data(y/n):";
		ch=getche();
		}
	return(front);
	}

void queue::Display(node *front)
	{
	node *temp=front;
	cout<<"\n\n Front->";
	while(temp!=NULL)
		{
		cout<<temp->data<<"->";
		temp=temp->next;
		}
	cout<<"->Rear\n\n";
	}

node * queue::Delete(node *front)
	{
	node *tmp=front;
	front=front->next;
	delete tmp;
	return(front);
	}
int main()
	{
	queue q;
	node *front,*rear;
	int choice;
	clrscr();
	front=rear=NULL;
	do
		{
		cout<<"\n ***** MENU ***** \n\n";
		cout<<"\n 1) ADD \n";
		cout<<"\n 2) DELETE \n";
		cout<<"\n 3) DISPLAY \n";
		cout<<"\n 4) EXIT \n";
		cout<<"\n Select Your Choice:";
		cin>>choice;
		switch(choice)
			{
			case 1:
				front=q.Insert(rear);
				break;

			case 2:
				if(front==NULL)
					{
					cout<<"\n Queue is empty\n";
					}
				else
					{
					front=q.Delete(front);
					cout<<"\n 1 element is deleted\n\n";
					}
				break;

			case 3:
			if(front==NULL)
					{
					cout<<"\n Queue is empty no element to display\n";
					}
				else
					{
					q.Display(front);
					}
				break;

			case 4:
				exit(0);
			}
		}while(choice!=4);
	getch();
	return 0;
	}
