// Program for read() and write()

#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<stdlib.h>
struct status
	{
	char name[80];
	double balance;
	unsigned long acno;
	};

int main()
	{
	struct status acc;
	clrscr();
	strcpy(acc.name,"abc");
	acc.balance=1123.23;
	acc.acno=3434;
	ofstream outbal("balance",ios::out|ios::binary);
	if(!outbal)
		{
		cout<<"\n Cannot open file\n";
		return 1;
		}
	outbal.write((char *)&acc,sizeof(struct status));
	outbal.close();
	ifstream inbal("balance",ios::in|ios::binary);
	inbal.read((char *)&acc,sizeof(struct status));
	cout<<acc.name<<endl;
	cout<<"Account Number:"<<acc.acno;
	cout.precision(2);
	cout.setf(ios::fixed);
	cout<<endl<<"Balance: $"<<acc.balance;
	inbal.close();
	getch();
	return 0;
	}
