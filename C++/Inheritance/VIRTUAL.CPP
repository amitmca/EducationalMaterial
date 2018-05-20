
#include<iostream.h>
//#include<conio.h>

class Base
	{
	public:
		virtual void display()
		{
		cout<<"\n Display Base";
		}
		virtual void show()
		{
		cout<<"\n show base";
		}
	};

class Derived:public Base
	{
	public:
		void display()
		{
		cout<<"\n Display Derived";
		}
		void show()
		{
		cout<<"\n show derived";
		}
	};
int main()
	{
	Base B;
	Derived D;
	Base *bptr;
//	clrscr();
	bptr=&B;
	cout<<"\n bptr points to Base\n";
	bptr->display();
	bptr->show();

	bptr=&D;
	cout<<"\n bptr points to Derived\n";
	bptr->display();
	bptr->show();

	//getch();
	return 0;
	}
