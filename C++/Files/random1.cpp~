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
	INVENTORY item[3];
	fstream inoutfile;
	clrscr();
	inoutfile.open("STOCK.DAT",ios::in|ios::out);
	for(int i=0;i<3;i++)
		{
		item[i].getdata();
		inoutfile.write((char *) & item[i],sizeof(item[i]));
		}
	inoutfile.seekg(0);
	cout<<"\n OUTPUT\n";
	for(int i=0;i<3;i++)
		{
		inoutfile.read((char *) & item[i],sizeof(item[i]));
		item[i].putdata();
		}
	inoutfile.close();
	getch();
	return 0;
	}
