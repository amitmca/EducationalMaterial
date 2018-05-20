// Program for Stack implementation using C++

#include<iostream.h>
#include<conio.h>

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
		node *Push(node *top);
		void Display(node *top);
		node * Pop(node *top);
	};
node *Push(node *top)
	{
	node *newnode;
	char ch='y';
	top=NULL;
		while(ch=='y')
			{
			cout<<"\n Do You want to add another element(y/n):";
			ch=getche();
			}
	}
int main()
	{
	clrscr();
	getch();
	return 0;
	}