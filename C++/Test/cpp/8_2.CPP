//PROGRAM FOR THE MULTIPLE INHERITANCE

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class M
{
		protected:
				int m;
		public:
			void get_m(int);
};
class N
{
		protected:
				int n;
		public:
			void get_n(int);
};
class P:public M,public N
{
		public:
				void display(void);

};
void M::get_m(int x)
{
		m=x;
}
void N::get_n(int y)
{
	n=y;
}
void P::display(void)
{
		cout<<"M="<<m<<"\n\n";
		cout<<"N="<<n<<"\n\n";
		cout<<"M*N="<<m*n<<"\n\n";
}
int main()
{
		P p;
		clrscr();
		p.get_m(10);
		p.get_n(20);
		p.display();
		getch();
		return 0;
}