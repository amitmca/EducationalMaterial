// PROGRAM FOR THE CONSTRUCTOR AND DESTRUCTOR

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class integer
{
	int m,n;
	public:
			integer(int,int);
			void display(void)
			{
				cout<<"M="<<m<<"\n\n";
				cout<<"N="<<n<<"\n\n";
			}
			~integer();
};
integer::integer(int x,int y)
{
	m=x;
	n=y;
}
integer::~integer()
{
	cout<<"\n\nThe destructor is invoked\n\n";
}
int main()
{
	clrscr();
	integer int1(0,100);
	integer int2=integer(25,75);
	cout<<"\n\nOBJECT 1\n\n";
	 int1.display();
	 cout<<"\n\nOBJECT 2\n\n";
	 int2.display();
	 getch();
	 return 0;

}