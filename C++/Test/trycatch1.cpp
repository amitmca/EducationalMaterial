
#include<iostream.h>

class exception
	{
	int a,b,x;
	public:
		void getdata()
		{
		cout<<"\n Enter values of a and b:";
		cin>>a>>b;
		}
		void throwe()
		{
		int x=a-b;
		try
		{
		if(x!=0)
			{
			cout<<"Result(a/x)="<<"\n";
			}
		else
			{
			throw(x);
			}
		}
		catch(int i)
			{
			cout<<"\n Exception Caught: x="<<x<<"\n";
			}
		}
	};

int main()
	{
	exception e;
	clrscr();
	e.getdata();
	e.throwe();
	getch();
	return 0;
	}