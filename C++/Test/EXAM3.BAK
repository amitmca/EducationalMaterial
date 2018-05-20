#include<iostream.h>
#include<conio.h>
class shape
	{
	virtual void area()=0;
	};
class circle:public shape
	{
	int r;
	public:
		void getdata()
		{
		cout<<"\nEnter the Radius :";
		cin>>r;
		}
		void area()
		{
		float pi=3.14;
		float A=2*pi*r;
		cout<<"\n Area Of Circle Is:"<<A;
		}
	};
class rect:public shape
	{
	int w,h;
	public:
		void getdata()
		{
		cout<<"\nEnter Width:";
		cin>>w;
		cout<<"\nEnter Height:";
		cin>>h;
		}
		void area()
		{
		float A=2*w*h;
		cout<<"\n Area Of Rectangle Is:"<<A;
		}
	};
void main()
	{
	circle c;
	rect r;
	clrscr();
	c.getdata();
	c.area();
	r.getdata();
	r.area();
	getch();
	}