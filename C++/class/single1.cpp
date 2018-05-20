// Program For Single Inheritance
// Private Derivation
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

class D:private B		// Derived Class derived privately
	{
	/*all the public members and member functions of the Base becomes
	private in the derived class*/

	int c; 				// Can not be inherited
	//int b;
	/*
		void get_ab();			These are inherited from the Base Class
		int get_a();
		void show_a();
		*/
	public:
		void mul(void);
		void display(void);
	};

void B::get_ab(void)
	{
	cout<<"\n Enter values of a and b:";
	cin>>a>>b;
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
	get_ab();
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
	d.mul();
	d.display();
	d.mul();
	d.display();
	getch();
	return 0;
	}