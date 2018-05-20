// Program for Public Derivation
 
#include<iostream.h>
//#include "conio.h"
class base
	{
	int i,j;
	public:
		void set(int a,int b)
		{
		i=a;
		j=b;
		}
		void show()
		{
		cout<<"i="<<i<<"\n"<<"j="<<j<<"\n";
		}
	};

class derived:public base
	{
	int k;
	public:
		derived(int x)
		{
		k=x;
		}
		void showk()
		{
		cout<<"k="<<k<<"\n";
		}
	};
	
int main()
	{
	derived obj(3);
//	clrscr();
	obj.set(1,2);
	obj.show();
	obj.showk();
	//getch();
	return 0;
	}
