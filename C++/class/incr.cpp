//Program for Overloading ++ and  -- Operator

#include<iostream.h>
#include<conio.h>

class index
	{
	int a;
	public:
		index()
			{
			a=0;
			}
		int getindex()
			{
			return(a);
			}
		void operator ++()
			{
			a=a+1;
			}
		void operator --()
			{
			a=a-1;
			}
	};

int main()
	{
	index i1,i2;
	clrscr();
	cout<<"\n Index1:"<<i1.getindex();
	cout<<"\n Index2:"<<i2.getindex();
	++i1;
	i2++;
	cout<<"\n Index1:"<<i1.getindex();
	cout<<"\n Index2:"<<i2.getindex();
	--i1;
	i2--;
	cout<<"\n Index1:"<<i1.getindex();
	cout<<"\n Index2:"<<i2.getindex();
	getch();
	return 0;
	}

