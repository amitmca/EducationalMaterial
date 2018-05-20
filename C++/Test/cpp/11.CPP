//PROGRAM FOR THE POINTER TO THE OBJECT OF THE CLASS
#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class item
{
		protected:
				char name[20];
				float price;
		public:
				void getdata();
				void putdata();
};
void item::getdata()
{
		cout<<"\n\nEnter the name of the Item:=>";
		cin>>name;
		cout<<"\n\nEnter the Item Price:=>";
		cin>>price;
}
void item::putdata()
{
		cout<<"\n\t"<<  name<<"\t\t"<<  price<<"\n";
}
int main()
{
		char ch='y';
		int i=0;
		item *I=new item[10];
		item *Ii=I;
		clrscr();
		while(ch=='y')
		{
				I->getdata();
				cout<<"\n\nDo you insert more data(y/n):";
				ch=getche();
				I++;
				i++;
		}
		cout<<"\n\nThe Item information is:\t\t";
		cout<<"\n\n\tItem Name"<<"\tPrice\n";
		cout<<"\n================================================\n";
		for(int j=0;j<i;j++)
		{
			Ii->putdata();
			Ii++;
		}
				cout<<"\n================================================\n";
		getch();
		return 0;
}