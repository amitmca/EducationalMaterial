

#include<iostream.h>
#include "conio.h"

namespace A
	{
	int i;
	void display()
		{
		cout<<i;
		}
	}

namespace Inside
		{
		int Insidei;
		void dispInsidei()
			{
			cout<<Insidei;
			}
		}

int main()
	{
	
	clrscr();
	A::i=10;
	A::display();	
	Inside::Insidei=20;
	Inside::dispInsidei();
	getch();
	return 0;
	}
