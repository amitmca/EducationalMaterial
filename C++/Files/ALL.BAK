#include<fstream.h>
#include<iostream.h>
#include "conio.h"
#include<stdlib.h>
#include<string.h>
#include<iomanip.h>

class employee
	{
	private:
		struct person
		{
		int empno;
		char empname[40];
		float empsalary;
		}p;
	fstream file;
	public:	
		employee();
		void add();
		void display();
		void modify();
		void search();
		void exit();
	};
 employee::employee()
	{
	file.open("EMP.DAT",ios::binary|ios::in|ios::out);
		if(!file)
		{
		cout<<"Unable to open file\n";
		}	
	}
void employee::add()
	{
	char ch;
	file.seekp(0,ios::end);
	do
		{
		cout<<"\nEnter Employee Number:";
		cin>>p.empno;
		cout<<"\nEnter Employee Name:";
		cin>>p.empname;
		cout<<"\nEnter Employee Salary:";
		cin>>p.empsalary;
		file.write((char *)&p,sizeof(p));
		cout<<"\n Add Another record(y/n):";
		cin>>ch;
		}while(ch=='y' || ch=='Y');
	}
void employee::display()
	{
	file.seekg(0,ios::beg);
	cout<<"\nNumber\tName\tSalary\n";
	while(file.read((char *)&p,sizeof(p)))
		{
		cout<<p.empno<<"\t"<<p.empname<<"\t"<<p.empsalary<<endl;
		}
	file.clear();
	}
void employee::modify()
	{
	int no;
	long int pos;
	int count=0;
	cout<<"\n Enter Employee Number:";
	cin>>no;
	file.seekg(0,ios::beg);
	while(file.read((char *)&p,sizeof(p)))
		{
		if(p.empno!=no)
			{
			cout<<"\n No such a employee number exists\n";
			file.clear();
			}
		 else
			{
			cout<<"\n Enter New Record:";
			cin>>p.empno>>p.empname>>p.empsalary;
			pos=count*sizeof(p);
			file.seekp(pos,ios::beg);
			file.write((char *)&p,sizeof(p));
			return;
			}
		count++;
		}
	}
int main()
	{
	int choice;
	employee e;
	clrscr();
	do
		{
		cout<<"1.Add\n";
		cout<<"2.Display\n";
		cout<<"3.Modify\n";
		cout<<"4.Search\n";
		cout<<"Your Choice:";
		cin>>choice;
		switch(choice)
			{
			case 1:
				e.add();
				break;
			case 2:
				e.display();
				break;

			case 3:
				e.modify();
				break;
			case 4:
				exit(0);
			}
		}while(choice!=4);
	getch();
	return 0;
	}
