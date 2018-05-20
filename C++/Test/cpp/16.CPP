//PROGRAM FOR THE READING THE FILE AND WRITE ANOTHER FILE
#include<conio.h>
#include<iostream.h>
#include<fstream.h>
#include<io.h>
int main()
{
	clrscr();
		ofstream outf("emp.txt",ios::app);
		cout<<"\n\nEnter the emp name:";
		char name[20];
		cin>>name;
		cout<<"\n\nEnter the emp id:";
		int id;
		cin>>id ;
		cout<<"\n\nEnter the salary of the emp:";
		float sal;
		cin>>sal;
		cout<<"\n\nEnter the post of the emp:";
		char post[20];
		cin>>post;
		cout<<"\n\nEnter the company name:";
		char c_name[20];
		cin>>c_name;
		outf<<"\n\t"<<name<<"\t"<<id<<"\t"<<sal<<"\t"<<post<<"\t"<<c_name;
		outf.close();
		ifstream inf("emp.txt");
		char line;
		inf.seekg(0);
		cout<<"\tName\tId\tPost\tCompany Name\n\n";
		cout<<"\n\t-------------------------------------------\n\n";

		ofstream out("emp1.txt");
		while(inf)
		{
			inf.get(line);
			out<<line;
			cout<<line;
		}
		out.close();
		cout<<"\n";

		inf.close();
		getch();
		return 0;
}