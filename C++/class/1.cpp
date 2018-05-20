//Program for Call By Value and Call by reference
#include<iostream.h>
#include<conio.h>
class cbvr
	{
   public:
   int a,b;
		void getvalue(void);
		void putvalue(void);
		void swapcbv(int x,int y);
		void swapcbr(int &x,int &y);
	};
void cbvr::getvalue(void)
	{
	cout<<"\n Enter the values :";
	cin>>a>>b;
	}
void cbvr::putvalue(void)
	{
	cout<<"a="<<a<<"\t"<<"b="<<b<<"\n";
	}
void cbvr::swapcbv(int a,int b)
	{
	int t=a;
		a=b;
		b=t;
	cout<<"\nCall By Value:"<<"\t"<<a<<"\t"<<b;
	}

void cbvr::swapcbr(int &x,int &y)
	{
	int t=x;
		x=y;
		y=t;
	cout<<"\nCall By Reference:"<<"\t"<<x<<"\t"<<y;
	}

int main()
	{
	//int a,b;
	cbvr obj;
	clrscr();
	obj.getvalue();
	obj.putvalue();
	obj.swapcbv(obj.a,obj.b);
	obj.swapcbr(obj.a,obj.b);
	getch();
	return 0;
	}