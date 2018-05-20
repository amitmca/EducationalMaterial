#include<iostream.h>
#include<conio.h>

class base
	{
	public:
		base()
		{
		cout<<"\n This is from base class constructor";
		}
		~base()
		{
		cout<<"\n This is from base class destructor";
		}

	};
class derived:public base
	{
	public:
		derived()
		{
		cout<<"\n This is from derived class constructor";
		}
		~derived()
		{
		cout<<"\n This is from derived class destructor";
		}
	};

int main()
	{
	derived obj;
//	clrscr();
	getch();
	return 0;
	}