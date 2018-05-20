// Program for Class Templates

#include<iostream.h>
#include "conio.h"

template<class T>
class max
	{
	T a,b;
	public:
		max(T x,T y)
		{
		a=x;
		b=y;
		}
		T getMax();
	};
template<class T>
T max<T>::getMax()
	{	
	T r;
	r=(a>b)?a:b;
	return r;
	}
int main()
	{
	max<int> obj(100,20);
	cout<<obj.getMax()<<endl;
	getch();
	return 0;
	}
