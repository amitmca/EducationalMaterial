#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<iomanip.h>

class Inventory
	{
	char name[30];	
	int code;
	int cost;
	public:
		void readdata(void);
		void writedata(void);
	};

void Inventory::readdata(void)
	{
	cout<<"Enter Name:";cin>>name;
	cout<<"Enter Code:";cin>>code;
	cout<<"Enter Cost:";cin>>cost;
	}

void Inventory::writedata(void)
	{
	cout<<setw(10)<<name<<setw(10)<<code<<setprecision(2)<<setw(10)<<cost<<endl;
	}

int main()
	{
	Inventory item;
	fstream file;
	clrscr();
	file.open("STOCK.DAT",ios::ate | ios::in | ios::out | ios::binary);
	file.seekg(0,ios::beg);
	
	cout<<"\n Current Stock:\n";
	while(file.read((char *) & item,sizeof(item)))
		{
		item.writedata();
		}
	file.clear();
	
	cout<<"\n ADD An ITEM\n";
	item.readdata();
	char ch;
	cin.get(ch);
	file.write((char *) & item,sizeof(item));
	file.seekg(0);
	
	cout<<"\n Appended Stock:\n";
	while(file.read((char *) & item,sizeof(item)))
		{
		item.writedata();
		}
	file.close();
	getch();
	return 0;
	}
