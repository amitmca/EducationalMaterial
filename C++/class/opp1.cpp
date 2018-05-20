//Program for Overloading ++ and  -- Operator

#include<iostream.h>
#include<conio.h>

class index
	{
	int value;
	public:
		index()
			{
			value=0;
			}
		index(int val)
			{
			value=val;
			}
		int getindex()
			{
			return(value);
			}
		index operator ++()
			{
			return index(++value);
			}
		index operator ++(int)
			{
			return index(value++);
			}
	};

int main()
	{
	index i1,i2,i3,i4;
	clrscr();
	cout<<"\n Index1:"<<i1.getindex();
	cout<<"\n Index2:"<<i2.getindex();
	i3=i1++;
	i4=++i2;
	cout<<"\n Index1:"<<i1.getindex();
	cout<<"\n Index2:"<<i2.getindex();
	cout<<"\n Index3:"<<i3.getindex();
	cout<<"\n Index4:"<<i4.getindex();
	getch();
	return 0;
	}

