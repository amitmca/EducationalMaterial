//Program for Class Templates with 2 Generic Data Types

#include<iostream.h>
#include "conio.h"

template<class T,class U>
class Test
	{
	T a;
	U b;
	public:
		Test(T x,U y)
		{
		a=x;
		b=y;
		}
		void display()
		{
		cout<<a<<"\t"<<b<<endl;
		}
	};

int main()
	{
	Test<int,char> obj1(10,'x');
	Test<double,char *> obj2(2.5,"Amit");
	obj1.display();
	obj2.display();
	getch();
	return 0;
	}
