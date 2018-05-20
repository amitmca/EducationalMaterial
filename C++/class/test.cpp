#include<iostream.h>
#include<conio.h>

class arithm
	{
	int x,y;
	public:
		arithm()	{	}
		arithm(int a,int b)
			{
			x=a;
			y=b;
			}
		void show(void)
			{
			cout<<"x="<<x<<"\n";
			cout<<"y="<<y<<"\n";
			}
		friend void operator +(arithm &a);
	};

void operator +(arithm &a)
	{
	int c=a.x*a.y;
	cout<<"Multiplication Is:"<<c<<"\n";
	}

int main()
	{
	arithm A;
	clrscr();
	A=arithm(2,3);
	A.show();
	+A;
	getch();
	return 0;
	}