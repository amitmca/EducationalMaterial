#include<iostream.h>
#include<conio.h>
class student
	{
	protected:
		int rno;
		char name[20];
		char class1[20];
	public:
		void getdata()
			{
			cout<<"\n Enter Roll Number:";
			cin>>rno;
			cout<<"\n Enter Name:";
			cin>>name;
			cout<<"\n Enter Class:";
			cin>>class1;
			}
		void putdata()
			{
			cout<<"\n Roll No\tName\tClass\n\n";
			cout<<rno<<"\t\t"<<name<<"\t  "<<class1<<"\n";
			}
	};
class marks
	{
	protected:
		int m1,m2,m3;
	public:
		void getmarks()
			{
			cout<<"\n Marks in First subject:";
			cin>>m1;
			cout<<"\n Marks in Second subject:";
			cin>>m2;
			cout<<"\n Marks in Third subject:";
			cin>>m3;
			}
		void putmarks()
			{
			cout<<"\n Marks1 \t Marks2 \t Marks3\n\n";
			cout<<m1<<"\t\t"<<m2<<"\t\t"<<m3<<"\n";
			}
	};
class result:public student,public marks
	{
	float per;
	char grade[1];
	public:
		void get()
			{
			student::getdata();
			marks::getmarks();
			per=(m1+m2+m3)/3;
			}
		void put()
			{
			student::putdata();
			marks::putmarks();
			cout<<"\n Percentage:"<<per;
			if(per>=70)
				cout<<"\n A \n";
			else if(per>=60 && per<=70)
				cout<<"\n B \n";
			else if(per >=45 && per<=60)
				cout<<"\n C \n";
			else if(per >=35)
				cout<<"\n D \n";
			else
				cout<<"\n Fail \n";
			}
	};
int main()
	{
	result r;
	clrscr();
	r.get();
	r.put();
	getch();
	return 0;
	}
