//Program for Call By Value and Call by reference
#include<iostream.h>
#include<conio.h>
class infun
	{
	private:
		  int a,b;
	public:
		void getvalue(void);
		void putvalue(void);
		void multi(void);
		void div(void);
		void square(void);
		void cube(void);
	};
void infun::getvalue(void)
	{
	cout<<"\n Enter the values :";
	cin>>a>>b;
	}
void infun::putvalue(void)
	{
	cout<<"a="<<a<<"\t"<<"b="<<b<<"\n";
	}
inline void infun::multi(void)
	{
	int c=a*b;
	cout<<"\nMultiplication is:"<<c<<"\n";
	}
inline void infun::div(void)
	{
	int c=a/b;
	cout<<"\nDivision is:"<<c<<"\n";
	}
inline void infun::square(void)
	{
	int c=a*a;
	cout<<"\nSquare is:"<<c<<"\n";
	}
inline void infun::cube(void)
	{
	int c=a*a*a;
	cout<<"\nCube is:"<<c<<"\n";
	}
int main()
	{
	int m,n;
	infun obj;
	clrscr();
	obj.getvalue();
	obj.putvalue();
	obj.multi();
	obj.div();
	obj.square();
	obj.cube();
	getch();
	return 0;
	}