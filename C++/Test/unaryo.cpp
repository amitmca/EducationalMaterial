#include<iostream.h>
#include "conio.h"

class sample
	{
	private:
		int x,y,z;
	public:
		void getdata(int a,int b,int c)
		{
		x=a,y=b,z=c;
		}
		void display()
		{
		cout<<"x="<<x<<endl;
		cout<<"y="<<y<<endl;
		cout<<"z="<<z<<endl;
		}
		void operator -();
	};
void sample::operator -()
	{
	x=-x;
	y=-y;
	z=-z;
	}
int main()
	{
	sample obj;
	clrscr();
	cout<<"\n Before Opeator Overloading....\n";
	obj.getdata(10,20,30);
	obj.display();
	cout<<"\n After Opeator Overloading....\n";
	-obj;
	obj.display();
	getch();
	return 0;
	}
