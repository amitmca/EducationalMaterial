// Pointers To derived classes

/* Concept :- Base class pointers cannot directly point to derived class
	      members
	Example :-
		class B
			{
			public:
				int b;
			};
			class D:public B
			{
			public:
				int d;
			};
			main()
			{
			B *bptr;
			B bobj;
			bptr=&bobj;
			bptr->b=10;      // valid
			D dobj;
			bptr->b=20;	// valid
			-----------
			bptr->d=30;
			-----------
// invalid because base pointer cannot directly point to derived class members
			}
*/


#include<iostream.h>
#include<conio.h>

class BC
	{
	public:
		int b;
		void show()
		{
		cout<<"b="<<b<<"\n";
		}

	};

class DC:public BC
	{
	public:
		int d;
		void show()
		{
		cout<<"b="<<b<<"\n";
		cout<<"d="<<d<<"\n";
		}
	};

int main()
	{
	BC *bptr;
	BC base;
	clrscr();
	bptr=&base;
	bptr->b=100;
	cout<<"bptr points to base object\n";
	bptr->show();
	DC derived;
	bptr=&derived;
	bptr->b=200;
	cout<<"bptr points to derived object\n";
	bptr->show();
	DC *dptr;
	dptr=&derived;
	dptr->d=300;
	cout<<"dptr is derived type pointer\n";
	dptr->show();
	cout<<"using ((DC *)bptr)\n";
	((DC *)bptr)->d=400;
	((DC *)bptr)->show();

	getch();
	return 0;
	}