#include<iostream.h>
#include<conio.h>
class class2;		//forward declaration

class class1
	{
	int value1;
	public:
		void indata(int a)
			{
			value1=a;
			}
		void display(void)
			{
			cout<<"Value1:"<<value1<<"\n";
			}
		friend void exchange(class1 &c1,class2 &c2);
	};
class class2
	{
	int value2;
	public:
		void indata(int b)
			{
			value2=b;
			}
		void display(void)
			{
			cout<<"Value2:"<<value2<<"\n";
			}
		friend void exchange(class1 &,class2 &);
	};
void exchange(class1 &c1,class2 &c2)
	{
	int t=c1.value1;
		c1.value1=c2.value2;
		c2.value2=t;
	}
int main()
	{
	class1 c1;
	class2 c2;
	clrscr();
	c1.indata(10);
	c1.display();
	c2.indata(20);
	c2.display();
	exchange(c1,c2);
	c1.display();
	c2.display();
	getch();
	return 0;
	}