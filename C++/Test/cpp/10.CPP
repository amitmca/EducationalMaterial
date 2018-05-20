//PROGRAM FOR THE CALLING CONSTRUCTOR IN THE DERIVED CLASS

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class A
{
		int a;
		public:
				A(int i)
				{
					a=i;
					cout<<"\n\nA Constructor is declared";
				}
				void show_a(void)
				{
						cout<<"\n\n\tA="<<a<<"\n";
				}
};
class  B
{
			float b;
			public:
				B(float j)
				{
						b=j;
						cout<<"\n\nB Constructor is declraed";
				}
				void show_b(void)
				{
						cout<<"\n\n\tB="<<b<<"\n";
				}
};

class C: public B,public  A
{
			int m,n;
			public:
					C(int i,float j,int k,int l):B(j),A(i)
					{
							m=k;
							n=l;
							cout<<"\n\nC Constructor is declraed";
					}
					void show_c(void)
					{
						cout<<"\n\n\tM="<<m<<"\t\tN="<<n<<"\n\n";
					}
};
int main()
{
		clrscr();
		C c(10,20.20,30,40);
		cout<<"\n\n";
		c.show_a();
		c.show_b();
		c.show_c();
		getch();
		return 0;
}