// Program for Single Inheritance

#include<iostream.h>
#include "conio.h"

class basic_info
	{	
	private:
		char name[20];
		int rno;
		char sex;
	public:
		void getdata()
		{
		cout<<"\n Name:"; cin>>name;
		cout<<"\n Roll number:"; cin>>rno;
		cout<<"\n Sex:"; cin>>sex;
		}
		void putdata()
		{
		cout<<name<<"\t"<<rno<<"\t"<<sex; 
		}
	};

class physical_fit:public basic_info
	{
	private:
		int width,height;
	public:
		void getdata()
		{
		basic_info::getdata();
		cout<<"\n Width:"; cin>>width;
		cout<<"\n Height:"; cin>>height;
		}		
		void putdata()
		{
		basic_info::putdata();
		cout<<"\t"<<width<<"\t"<<height<<"\n";
		}
	};

int main()
	{	
	physical_fit p;
	clrscr();
	p.getdata();
	cout<<"--------------------------------------------\n";
	cout<<"\n Name\tRoll No\tSex\tWidth\tHeight\n\n";
	cout<<"--------------------------------------------\n";
	p.putdata();
	
	getch();
	return 0;
	}
