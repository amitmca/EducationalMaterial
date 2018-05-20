//Program for Unnamed NameSpace

#include<iostream.h>
#include "conio.h"

using namespace std;

namespace amit
	{
	const int i=4;
	}


int main()
	{
	clrscr();
	using namespace amit;
	cout<<amit::i<<endl;
	int i=2;	
	cout<<i<<endl;
	getch();
	return 0;
	}
