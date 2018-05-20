// Program for Private Derivation
 
#include<iostream.h>
#include "conio.h"
class base
	{
	int i,j;
	public:
		void setb()
		{
		cout<<"\n Enter 2 values:";
		cin>>i>>j;
		}
		void show()
		{
		cout<<"i="<<i<<"\n"<<"j="<<j<<"\n";
		}
	};

class derived:private base
	{
	int k;
	public:
		void set(int x)
		{
		setb();
		k=x;
		}
		void showk()
		{
		show();
		cout<<"k="<<k<<"\n";
		}
	};
	
int main()
	{
	derived obj;
	clrscr();
	obj.set(3);
	obj.showk();	
	getch();
	return 0;
	}
