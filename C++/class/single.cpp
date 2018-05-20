// Program For Single Inheritance
// Public Derivation
// Syntax : class derivedclassname::visibility_mode baseclassname

#include<iostream.h>
#include<conio.h>

class B				// Base Class
	{
	private:
		int a;  		// Can not be inherited
	public:
		int b;
		void get_ab();
		int get_a();
		void show_a();
	};

class D:public B		// Derived Class derived publicly
	{
	/*all the public members and member functions of the Base becomes
	public in the derived class*/
	int c; 				// Can not be inherited
	public:
		//int b;
		void mul(void);
		void display(void);
		/*
		void get_ab();			These are inherited from the Base Class
		int get_a();
		void show_a();
		*/
	};

void B::get_ab(void)
	{
	a=5;
	b=10;
	}

int B::get_a(void)
	{
	return(a);
	}

void B::show_a(void)
	{
	cout<<"a="<<a;
	}

void D::mul(void)
	{
	c=b*get_a();
	}

void D::display(void)
	{
	cout<<"\na="<<get_a()<<"\n";
	cout<<"\nb="<<b<<"\n";
	cout<<"\nc="<<c<<"\n";
	}

int main()
	{
	D d;
	clrscr();
	d.get_ab();
	d.mul();
	d.show_a();
	d.display();
	d.b=20;
	d.mul();
	d.display();
	getch();
	return 0;
	}