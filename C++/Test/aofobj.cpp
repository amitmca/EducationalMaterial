//Program for Array of Objects

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
	};

void student::getdata(void)
	{
	
	cout<<"\n Roll Number:";
	cin>>rno;
	cout<<"\n Name:";
	cin>>name;
	cout<<"\n Marks1:";
	cin>>m1;
	cout<<"\n Marks2:";
	cin>>m2;
	}

void student::putdata(void)
	{
	
	float total=m1+m2;
	float avg=total/2;	
	
	cout<<  rno<<"\t "<<name<<"\t "<<m1<<"\t "<<m2<<"\t "<<total<<"\t "<<avg<<"\n";
	}

int main()
	{
	const int SIZE=2;
	student s[SIZE];
	clrscr();
	cout<<"\n Enter Student Details:";
	for(int i=0;i<SIZE;i++)
		{
		s[i].getdata();
		clrscr();
		}
	cout<<"\n Student Details are...\n";
	cout<<"\n Roll No \t Name \t Marks1 \t Marks2 \t Total \t Average\n\n";
	for(int i=0;i<SIZE;i++)
		{
		s[i].putdata();
		}
	getch();
	return 0;
	}
