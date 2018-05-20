// Program for Destructor

#include<iostream.h>
#include<conio.h>

int count=0;
class alpha
	{
	public:
		alpha()		// Constructor
		{
		count++;
		cout<<"\n No Of Objects created="<<count;
		}
		~alpha()	// Destructor
		{
		count--;
		cout<<"\n No Of objects Destroyed="<<count;
		}
	};
int main()
	{
	clrscr();
	cout<<"\n\nEnter Main:";
	alpha A1,A2,A3,A4;
		{
		cout<<"\n\n Enter Block 1\n";
		alpha A5;
		}
		{
		cout<<"\n\n Enter Block 2\n";
		alpha A6;
		}
	alpha A7,A8,A9;

	getch();
	return 0;
	}