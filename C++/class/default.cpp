#include<iostream.h>
#include<conio.h>

class integer
	{
	int m,n;
	public:
		integer(void);
		void Display(void)
			{
			cout<<"m:"<<m<<"\n";
			cout<<"n:"<<n<<"\n";
			}
	};
integer::integer(void)
	{
	m=10;
	n=20;
	}
int main()
	{
	integer int1;
	clrscr();
	int1.Display();
	getch();
	return 0;
	}