#include<iostream.h>
#include<conio.h>
class A
	{
	public:
	int a,b;
		void getab(int x,int y)
			{
			a=x;
			b=y;
			}
	};

class B:public A
	{
	int c:
	public:
	   void getc(int z)
		{
		c=z;
		}
	  void putc(void)
		{
		cout<<"\nc:"<<c;
		cout<<"\n a:"<<a;
		cout<<"\n b:"<<b;
		}
	};
int main()
	{
	clrscr();
	getch();
	return 0;
	}
