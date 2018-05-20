
#include<iostream.h>
#include<conio.h>

class A
	{
	public:
		void print(char ch,int r);
	};
void A::print(char ch,int r=5)
			{
			for(int i=0;i<r;i++)
				{
				cout<<ch<<"\n";
				}
			}
int main()
	{
	A obj;
	char ch='A';
	clrscr();
	obj.print(ch,7);
	cout<<"\n After this\n\n";
	obj.print(ch);
	getch();
	return 0;
	}