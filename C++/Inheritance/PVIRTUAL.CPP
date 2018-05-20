//Program for Pure Virtual Function

#include<iostream.h>
#include<conio.h>

class Base
	{
	private:
		int x;
		float y;
	public:
		virtual void getdata();
		virtual void display();
	};

class Derived:public Base
	{
	private:
		long int code;
		char name[20];
	public:
		void getdata();
		void display();
	};
class Derived1:public Base
	{
	private:
		float w,h;
	public:
		void getdata();
		void display();
	};
void Base::getdata()	{	}
void Base::display()	{	}
void Derived::getdata()
	{
	cout<<"\n Enter code:";
	cin>>code;
	cout<<"\n Enter Employee Name:";
	cin>>name;
	}
void Derived::display()
	{
	cout<<"-----------------------------------";
	cout<<"\n Employee Code \tEmployee Name\n";
	cout<<"-----------------------------------\n";
	cout<<"\t"<<code<<"\t\t"<<name<<endl;
	}
void Derived1::getdata()
	{
	cout<<"\n Enter Width:";
	cin>>w;
	cout<<"\n Enter Height:";
	cin>>h;
	}
void Derived1::display()
	{
	cout<<"\n Employee width \tEmployee height\n";
	cout<<"\t"<<w<<"\t\t"<<h<<endl;
	}
int main()
	{
	Base *ptr[3];
	Derived d;
	Derived1 d1;
	clrscr();
	ptr[0]=&d;
	ptr[1]=&d1;
	ptr[0]->getdata();
	ptr[0]->display();
	ptr[1]->getdata();
	ptr[1]->display();
	getch();
	return 0;
	}