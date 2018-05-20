// Creating Files with constructor function

#include<iostream.h>
#include<fstream.h>
#include<conio.h>
class account
	{
	protected:
		int ano;
		char name[20];
		float bal;
	public:
		void Create()
			{
			ofstream outf("bankac",ios::app);
			cout<<"\n Enter Account Number:";
			cin>>ano;
			outf<<ano;
			outf<<"\t";
			cout<<"\n Enter Name:";
			cin>>name;
			outf<<name;
			outf<<"\t";
			cout<<"\n Enter Balance:";
			cin>>bal;
			outf<<bal;
			outf<<"\n";
			outf.close();
			}
		void read_print()
			{
			ifstream intf("bankac");
			intf>>ano;
			cout<<"Account Number:"<<ano<<"\n";;
			intf>>name;
			cout<<"Name:"<<name<<"\n";
			intf>>bal;
			cout<<"Balance:"<<bal<<"\n";
			intf.close();
			}
		void withdraw();
		void deposit();
	};
void account::withdraw()
			{
			ifstream intf("bankac");
			ofstream outf("bankac",ios::app);
			int a;
			float b;
			cout<<"\n Enter your account number:";
			cin>>a;
			intf>>ano;
			if(a==ano)
				{
				cout<<"\n Enter the amount to be withdrawn:";
				cin>>b;
				intf>>bal;
				if(b>bal)
					{
					cout<<"\n Not enoungh balance";
					}
				else
					{
					bal=bal-b;
					outf<<bal;
					}
				}
			else
				{
				cout<<"\n Invalid Account Number:";
				}
			}
int main()
	{
	account obj;
	clrscr();
	//obj.Create();
	obj.read_print();
	obj.withdraw();
	obj.read_print();
	getch();
	return 0;
	}
