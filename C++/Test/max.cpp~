//Program for finding maximum of 2 numbers using friend functions

#include<iostream.h>
#include "conio.h"

class max
	{
	private:
		int a,b;
	public:
		void getdata()
			{
			cout<<"\n Enter value of a:";
			cin>>a;
			cout<<"\n Enter value of b:";
			cin>>b;
			}
			void putdata()
			{
			cout<<"\n Value Of a:"<<a;
			cout<<"\n Value Of b:"<<b;
			}
			friend void maximum(max m);
	};
void maximum(max m)
	{
	if(m.a > m.b)
		{
		cout<<"\n\t"<<m.a<<" is maximum\n";
		}
	else
		{
		cout<<"\n\t"<<m.b<<" is maximum\n";
		}
	}
int main()
	{
	max obj;
	clrscr();
	obj.getdata();
	obj.putdata();
	maximum(obj);
	getch();
	return 0;
	}
