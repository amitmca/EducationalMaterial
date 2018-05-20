//A function Friendly to 2 Classes

#include<iostream.h>
#include<conio.h>

class ABC;		//forward declaration
class XYZ
	{
		int x;
	public:
		void setValue(int i)
			{
			x=i;
			}
		friend void max(XYZ,ABC);
	};

class ABC
	{
		int a;
	public:
		void setValue(int i)
			{
			a=i;
			}
		friend void max(XYZ,ABC);
	};

void max(XYZ m,ABC n)
	{
	if(m.x>=n.a)
		cout<<m.x;
	else
		cout<<n.a;
	}

int main()
	{
	ABC abc;
	clrscr();
	abc.setValue(10);
	XYZ xyz;
	xyz.setValue(20);
	max(xyz,abc);
	getch();
	return 0;
	}
