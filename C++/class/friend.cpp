#include<iostream.h>
#include<conio.h>

class test
	{
	int a,b;
	public:
		void getdata(int x,int y)
			{
			a=x;
			b=y;
			}
		void putdata(void)
			{
			cout<<"Value Of a:"<<a<<"\n\n";
			cout<<"Value Of b:"<<b<<"\n\n";
			}
	friend test add(test);	// friend return_type fun_name(arguments);
	};
test add(test t1)	// return_type fun_name(classname objectname)
	{
	t1.a=t1.a+10;
	t1.b=t1.b+10;
	return t1;
	}
int main()
	{
	test t;
	clrscr();
	t.getdata(10,20);
	t.putdata();
	t=add(t);
	t.putdata();
	getch();
	return 0;
	}