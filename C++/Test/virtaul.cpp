#include<iostream.h>
#include "conio.h"

class shape
	{
	public:
	virtual void display();	
	};

class triangle:public shape
	{
	int h,b;
	float a;
	public:
		void getdata()
		{
		cout<<"\n Enter base and height:";
		cin>>b>>h;
		a=0.5*b*h;	
		}
		void display()
		{
		cout<<"\n Area Of Triangle Is:"<<a;
		}
	};

class rectangle:public shape
	{
	int w,h;
	float a;
	public:
		void getdata()
		{
		cout<<"\n Enter width and height:";
		cin>>w>>h;
		a=2*w*h;	
		}
		void display()
		{
		cout<<"\n Area Of Rectangle Is:"<<a;
		}
	};

int main()
	{
	triangle t;
	shape *s;
	clrscr();
	s=&t;
	t.getdata();
	s->display();
	getch();
	return 0;
	}
