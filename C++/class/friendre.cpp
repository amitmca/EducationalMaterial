#include<iostream.h>
#include<conio.h>
class class2;
class class1
	{
	int value1;
	public:
		void indata(int a)
			{
			value1=a;
			}
		void display()
			{
			cout<<value1<<"\n";
			}
		friend void exchange(class1 &,class2 &);
	};
class class2
	{
	int value2;
	public:
		void indata(int a)
			{
			value2=a;
			}
		void display()
			{
			cout<<value2<<"\n";
			}
		friend void exchange(class1 &,class2 &);
	};
void exchange(class1 &x,class2 &y)
	{
	int temp=x.value1;
	x.value1=y.value2;
	y.value2=temp;
	}
int main()
	{
	class1 c1;
	class2 c2;
	clrscr();
	c1.indata(100);
	c2.indata(200);
	cout<<" Values Before Exchange"<<"\n";
	c1.display();
	c2.display();
	exchange(c1,c2);
	c1.display();
	c2.display();
	getch();
	return 0;
	}
