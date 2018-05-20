
/*	When the Base Class is inherited in a public mode then

		1) Public members of the base class becomes public in derived class.
		2) Protected members of the base class becomes protected in derived class.
		3) Private menbers cannot be inherited.

class base    					class derived:public base
	{								{
	private:                        private:
		int a;  cannot be inherited      int d: cannot be inherited
	public:							public:
		int b;                           int e;		// int b;
	protected:						protected:
		int c;							 int f;		// int c;
	}

*/

#include<iostream.h>
#include<conio.h>

class base
	{
	private:
		int a;
	public:
		int b;
		void get_abc();
		void show_abc();
	protected:
		int c;
	};

void base::get_abc()
	{
	a=10;
	b=20;
	c=30;
	}

void base::show_abc()
	{
	cout<<"a="<<a<<"\n";
	cout<<"b="<<b<<"\n";
	cout<<"c="<<c<<"\n";
	}

class derived:public base
	{
	private:
		int d;
	public:
		int e;		// int b;
		void get_def();
		void show_def();
	protected:
		int f;		// int c;
	};

void derived::get_def()
	{
	d=40;
	e=50;
	f=60;
	b=70;
	c=80;
	}

void derived::show_def()
	{
	cout<<"d="<<d<<"\n";
	cout<<"e="<<e<<"\n";
	cout<<"f="<<f<<"\n";
	cout<<"b="<<b<<"\n";
	cout<<"c="<<c<<"\n";
	}

int main()
	{
	derived D;
	clrscr();
	D.get_abc();
	D.show_abc();
	D.get_def();
	D.show_def();
	getch();
	return 0;
	}