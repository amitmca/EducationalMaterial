#include<iostream.h>
#include<conio.h>
class person
	{
	private:
		char name[20],addr[20];
		int phone;

	public:
		void getdata(void)
			{
			cout<<"\n Name:";
			cin>>name;
			cout<<"\n Address : ";
			cin>>addr;
			cout<<"\n Phone Number:";
			cin>>phone;
			}
		void putdata(void)
			{
			cout<<"\n Name \t Address \t Phone\n\n";
			cout<<name<<"\t"<<addr<<"\t"<<phone<<"\n";
			}
	};
class employee:public person
	{
	private:
		int eno;
		char ename[20];
	public:
		void getdata()
			{
			cout<<"\n Employee No:";
			cin>>eno;
			cout<<"\n Employee Name:";
			cin>>ename;
			}
		void putdata()
			{
			cout<<"\n Emp No \t Emp Name\n\n";
			cout<<eno<<"\t\t"<<ename;
			}
	};
class manager:public person
	{
	private:
		char desig[20];
		char dept[20];
		float bsal;
	public:
		void getdata()
			{
			person::getdata();
			cout<<"\n Designation:";
			cin>>desig;
			cout<<"\n Deapartment Name:";
			cin>>dept;
			cout<<"\n Basic Salary:";
			cin>>bsal;
			}
		void putdata()
			{
			person::putdata();
			cout<<"\n Designation \t Department \t Salary\n\n";
			cout<<desig<<"\t\t"<<dept<<"\t\t"<<bsal<<"\n";
			}
	};
int main()
	{
	employee e;
	manager m;
	clrscr();
	m.getdata();
	m.putdata();
	getch();
	return 0;
	}