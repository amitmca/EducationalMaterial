// Program for Hierarchical Inheritance

#include<iostream.h>
#include<conio.h>
#include<stdlib.h>

class person
	{
	protected:
		int pcode;
		char pname[20];
	public:
		void getdata()
			{
			cout<<"\n Person Code:";
			cin>>pcode;
			cout<<"\n Person Name:";
			cin>>pname;
			}
		void putdata()
			{
			cout<<"\n Code \t Name \n\n";
			cout<<pcode<<"\t"<<pname<<"\n";
			}
	};
class account:public person
	{
	protected:
		int ano;
		char atype[20];
	public:
		void getdata()
			{
			person::getdata();
			cout<<"\n Account Number:";
			cin>>ano;
			cout<<"\n Account Type:";
			cin>>atype;
			}
		void putdata()
			{
			person::putdata();
			cout<<"\n Ano \t Atype\n";
			cout<<ano<<"\t"<<atype<<"\n";
			}
	};
class admin:public person
	{
	protected:
		int salary;
		char post[20];
	public:
		void getdata()
			{
			person::getdata();
			cout<<"\n Enter Salary:";
			cin>>salary;
			cout<<"\n Enter post :";
			cin>>post;
			}
		void putdata()
			{
			person::putdata();
			cout<<"\n Salary \t Post\n";
			cout<<salary<<"\t"<<post<<"\n";
			}
	};

class master:public person
	{
	protected:
		int jdate;
	public:
		void getdata()
			{
			person::getdata();
			cout<<"\n Joining Date:";
			cin>>jdate;
			}
			void putdata()
			{
			person::putdata();
			cout<<"\n Joining Date:";
			cout<<jdate;
			}
	};

int main()
	{
	account a;
	admin ad;
	master m;
	int choice;
	clrscr();
	do
		{
		cout<<"\n MENU \n";
		cout<<"\n 1) Create \n";
		cout<<"\n 2) Update:\n";
		cout<<"\n 3) Display :\n";
		cout<<"\n 4) Exit :\n";
		cout<<"\n Select Your Choice:";
		cin>>choice;
		switch(choice)
			{
			case 1:

				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	return 0;
	}