#include<iostream.h>
#include<conio.h>

class item
	{
	float price;
	char name[20];
	public:
		void accept()
		{
		cout<<"\n Enter Item Price:";
		cin>>price;
		cout<<"\n Enter Item Name:";
		cin>>name;
		}
		void display()
		{
		cout<<"\n Price \t Name\n";
		cout<<price<<"\t"<<name<<"\n";
		}
	};

int main()
	{
	item i;
	item *iptr;
	clrscr();
	iptr=&i;
	iptr->accept();
	iptr->display();
	getch();
	return 0;
	}