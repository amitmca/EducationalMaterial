// Program for Stack implementation using C++

#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

class node
	{
	public:
		int data;
		node *next;
	};

class stack
	{
	private:
		node *top;
	public:
		stack();
		node * Push(node *top);
		void Display(node *top);
		node * Pop(node *top);
	};
stack::stack()
	{
	top=NULL;
	}
node * stack::Push(node *top)
	{
	node *newnode;
	char ch='y';
	top=NULL;
		while(ch=='y')
			{
			newnode=new node;
			cout<<"\n\n Top Data:";
			cin>>newnode->data;
			newnode->next=NULL;
			if(top==NULL)
				top=newnode;
			else
				{
				newnode->next=top;
				top=newnode;
				}
			cout<<"\n Do You want to add another element(y/n):";
			ch=getche();
			}
	return(top);
	}
void stack::Display(node *top)
	{
	cout<<"\n";
	while(top!=NULL)
		{
		cout<<top->data<<"\n";
		top=top->next;
		}
	}
node *stack::Pop(node *top)
	{
	node *tmp=top;
	top=top->next;
	delete tmp;
	return(top);
	}
int main()
	{
	stack s;
	node *top;
	int choice;
	clrscr();
	top=NULL;
	do
		{
		cout<<"\n ***** MENU *****\n";
		cout<<"\n 1) PUSH \n";
		cout<<"\n 2) POP \n";
		cout<<"\n 3) DISPLAY \n";
		cout<<"\n 4) EXIT\n";
		cout<<"\n Select Your Choice:";
		cin>>choice;
		switch(choice)
			{
			case 1:
				top=s.Push(top);
				clrscr();
				break;
			case 2:
				if(top==NULL)
					{
					cout<<"\n Stack is empty";
					}
				else
					{
					top=s.Pop(top);
					cout<<" 1 element is popped\n";
					}
				break;
			case 3:
					if(top==NULL)
					{
					cout<<"\n Stack is empty no element to display";
					}
				else
					{
					s.Display(top);
					}
				break;
			case 4:
				exit(0);
			}
		}while(choice!=4);
	getch();
	return 0;
	}