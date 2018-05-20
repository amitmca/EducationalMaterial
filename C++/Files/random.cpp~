// Program for Random Access Files

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<iomanip.h>

class INVENTORY
	{
	char name[30];
	int code;
	float cost;
	public:
		void getdata(void)
		{
		cout<<"\n Enter Name:"; cin>>name;
		cout<<"\n Enter Code:"; cin>>code;
		cout<<"\n Enter Cost:"; cin>>cost;
		}
		void putdata(void)
		{
		cout<<setw(10)<<name
		    <<setw(10)<<code
		    <<setprecision(2)<<setw(10)<<cost<<endl;
		}
	};

int main()
	{
	INVENTORY item;
	fstream inoutfile;
	clrscr();
	inoutfile.open("STOCK.DAT",ios::ate|ios::in|ios::out|ios::binary);
	inoutfile.seekg(0,ios::beg);
	cout<<"CURRENT DETAILS OF STOCK:"<<"\n";
	while(inoutfile.read((char *) & item,sizeof item))
		{
		item.putdata();
		}
	inoutfile.clear();
	cout<<"\n ADD an item:";
	item.getdata();
	char ch;
	cin.get(ch);
	inoutfile.write((char *) & item,sizeof item);
	inoutfile.seekg(0);
	cout<<"CONTENTS OF APPENDED FILE:"<<"\n";
	while(inoutfile.read((char *) & item,sizeof item))
		{
		item.putdata();
		}
	getch();
	return 0;
	}
