//Program for typeid applied on template 

#include<iostream.h>
#include "conio.h"

template <class T>

class myclass
	{
	T a;
	public:
		myclass(T i)
		{
		a=i;
		}
	};

int main()
	{
	myclass<int> obj1(10),obj2(8),obj3(6);
	myclass<double> obj4(8.3);
	clrscr();
	cout<<"Type Of Obj1 is:"<<typeid(obj1).name()<<endl;
	cout<<"Type Of Obj2 is:"<<typeid(obj2).name()<<endl;
	cout<<"Type Of Obj3 is:"<<typeid(obj3).name()<<endl;
	if(typeid(obj1)==typeid(obj2))
		cout<<"\n Obj1 and Obj2 are of the same type\n";
	if(typeid(obj1)==typeid(obj3))
		cout<<"\n Error\n";
	else
		cout<<"\n Obj1 and Obj3 are of the different type\n";
	getch();
	return 0;
	}
