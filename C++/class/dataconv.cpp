//Program for Converting the Class type to Basic type and vice versa

#include<iostream.h>
#include<conio.h>
class invent2;		//Forward Declaration
class invent1
	{
	int code;
	int items;
	float price;
	public:
		invent1(int a,int b,float c)
			{
			code=a;
			items=b;
			price=c;
			}
		void putdata(void)
			{
			cout<<"Code:"<<code<<"\n";
			cout<<"Items:"<<items<<"\n";
			cout<<"Value:"<<price<<"\n";
			}
		int getcode()
			{
			return code;
			}
		int getitems()
			{
			return items;
			}
		float getprice()
			{
			return price;
			}
		operator float()	// Class to Basic
			{
			return(items*price);
			}
	};
class invent2
	{
	int code;
	float value;
	public:
		invent2()
			{
			code=0;
			value=0;
			}
		invent2(int x,float y)
			{
			code=x;
			value=y;
			}
		void putdata()
			{
			cout<<"Code:"<<code<<"\n";
			cout<<"Value:"<<value<<"\n";
			}
		invent2(invent1 p)		// Class To Class
			{
			code=p.getcode();
			value=p.getitems()*p.getprice();
			}
	};
int main()
	{
	invent1 s1(100,5,140.0);
	invent2 d1;
	float total_value;
	clrscr();
	total_value=s1;
	d1=s1;
	cout<<"\nProduct Details-invent1 type:"<<"\n";
	s1.putdata();
	cout<<"\n Stock Value:"<<"\n";
	cout<<"value:"<<total_value<<"\n\n";
	cout<<"\nProduct Details-invent2 type:"<<"\n";
	d1.putdata();
	getch();
	return 0;
	}
