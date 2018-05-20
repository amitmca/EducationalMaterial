//Program for overloading + and - operators both unary and binary

#include<iostream.h>
#include<conio.h>

class myoverload
	{
	private:
		int a,b;
	public:
		void getdata(void)
			{
			cout<<"\n Enter Value Of a:";
			cin>>a;
			cout<<"\n Enter Value Of b:";
			cin>>b;
			}
		void putdata(void)
			{
			cout<<"\n a:"<<a<<"\n"<<"b:"<<b<<"\n";
			}
		void operator +()	// Unary operator overloaded
			{
			a=a+1;
			b=b+1;
			}
		myoverload operator +(myoverload); //
		friend myoverload operator +(myoverload &m1,myoverload &m2);
	};
myoverload myoverload::operator +(myoverload m)
	{
	myoverload m1;
	m1.a=a+m.a;
	m1.b=a+m.b;
	return(m1);
	}
myoverload operator +(myoverload &m1,myoverload &m2)
	{
	myoverload m3;
	m3.a=m1.a+m2.a;
	m3.b=m1.b+m2.b;
	return(m3);
	}
int main()
	{
	myoverload obj,obj1,obj2;
	clrscr();
	obj.getdata();
	obj.putdata();
	+obj;
	obj.putdata();
	+myoverload(obj);
	obj.putdata();
	obj=myoverload(obj,obj);
	obj.putdata();
	getch();
	return 0;
	}