#include<iostream.h>
#include<conio.h>
class overloadpp
	{
	int a,b;
	public:
		void getab(int x,int y)
			{
			a=x;
			b=y;
			}
		void putab(void)
			{
			cout<<"\n Value Of a:"<<a;
			cout<<"\n Value Of b:"<<b;
			}
		void operator ++();
	};
void overloadpp::operator ++()
	{
	int c=a*b;
	cout<<"\n Multiplication is:"<<c;
	}
int main()
	{
	overloadpp o;
	clrscr();
	o.getab(2,2);
	o.putab();
	++o;
	getch();
	return 0;
	}

