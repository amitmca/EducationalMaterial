//Program for Use of Friend Functions

#include<iostream.h>
#include "conio.h"

class student
	{
	private:
		int rno;
		char name[20];
		int m1,m2;
	public:
		void getdata(void);
		void putdata(void);
		friend void calculate(student s);
	};

void student::getdata(void)
	{
	cout<<"\n Enter Student Details:";
	cout<<"\n Roll Number:";
	cin>>rno;
	cout<<"\n Name:";
	cin>>name;
	}
void calculate(student s)
	{
	cout<<"\n Marks1:";
	cin>>s.m1;
	cout<<"\n Marks2:";
	cin>>s.m2;
	float total=s.m1+s.m2;
	float avg=total/2;
	cout<<"\n Total :"<<total<<"\t"<<"Average:"<<avg;
	}
void student::putdata(void)
	{
	cout<<"\n Student Details are...\n";
	cout<<"\n Roll No \t Name\n";
	cout<<  rno<<"\t "<<name<<"\n";
	}

int main()
	{
	student s;
	clrscr();
	s.getdata();
	calculate(s);
	s.putdata();
	getch();
	return 0;
	}
