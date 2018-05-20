#include<iostream.h>
#include<conio.h>
class complex
	{
	float  x,y;
	public:
		void input(float real,float imag)
			{
			x=real;
			y=imag;
			}
	friend complex sum(complex,complex);
	void show(complex);
	};
complex sum(complex c1,complex c2)
	{
		complex c3;
		c3.x=c1.x+c2.x;
		c3.y=c1.y+c2.y;
		return(c3);
	}
void complex::show(complex c)
	{
	cout<<c.x<<" +i "<<c.y<<endl;
	}
int main()
	{
	complex A,B,C;
	clrscr();
	A.input(3.1,5.65);
	B.input(2.75,1.2);
	C=sum(A,B);
	cout<<"A=";	A.show(A);	cout<<"\n";
	cout<<"B=";	B.show(B);  cout<<"\n";
	cout<<"C=";	C.show(C);  cout<<"\n";
	getch();
	return 0;
	}