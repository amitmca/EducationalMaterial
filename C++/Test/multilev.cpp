// Program for Multilevel inheritance

#include<iostream.h>
#include<conio.h>

class student
	{
	protected:
		int rno;
		char name[20];
	public:
		void getdata()
			{
			cout<<"\n Roll Number:";
			cin>>rno;
			cout<<"\n Name:";
			cin>>name;
			}
		void putdata()
			{
			cout<<"\nRoll No \t Name\n\n";
			cout<<rno<<"\t"<<name<<"\n";
			}
	};
class test:public student
	{
	protected:
		int m1,m2;
	public:
		void getdata()
			{
			student::getdata();
			cout<<"\n Marks of 1 st Subject:";
			cin>>m1;
			cout<<"\n Marks of 2 nd Subject:";
			cin>>m2;
			}
		void putdata()
			{
			student::putdata();
			cout<<"\n Marks1 \t Marks2\n\n";
			cout<<m1<<"\t"<<m2;
			}
	};
class result:public test
	{
	private:
		int total;
	public:
		void getdata()
			{
			test::getdata();
			}
		void putdata()
			{
			test::putdata();
			total=m1+m2;
			cout<<"\n Total marks:"<<total;
			}
	};
int main()
	{
	result r;
	clrscr();
	r.getdata();
	r.putdata();
	getch();
	return 0;
	}