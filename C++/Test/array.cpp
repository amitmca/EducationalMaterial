// Program for merging the array eleements by overloading + operator

#include<iostream.h>
#include<conio.h>

class array
	{
	int a[10],b[10],m,n;
	public:
		void getdata(void);
		void putdata(void);
		void operator +(int a[]);
	};
void opeartor +(int a[])
	{
	
	for(
	}

void array::getdata(void)
	{
	cout<<"How many elements in first array:";
	cin>>m;
	cout<<"\n Elements of first array:";
	for(int i=0;i<m;i++)
		{
		cin>>a[i];
		}
	}
void array::putdata(void)
	{
	cout<<"Array elements are:";
	for(int i=0;i<m;i++)
		{
		cout<<a[i]<<"\n";
		}
	}
int main()
	{
	array obj;
	clrscr();
	obj.getdata();
	obj.putdata();
	getch();
	return 0;
	}
