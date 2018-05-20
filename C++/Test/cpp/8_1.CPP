//PROGRAM FOR SIMPLE INHERITANCE

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
int i=0;
class fruit
{
		public:
		char name[20],type[20];
		int quntity;

				void getdata();
};
class derived:public fruit
{
		public:
				void show(void);
};
void fruit::getdata()
{
				cout<<"\n\n\nEnter the name of the Fruit:";
				cin>>name;
				cout<<"\n\nEnter the type of the fruit(good/bad):";
				cin>>type;
				cout<<"\n\nEnter the quntity of the fruit:";
				cin>>quntity;

}
void derived::show()
{
		cout<<"\t"<<name<<"\t\t"<<type<<"\t"<<quntity<<"\n\n";
}
int main()
{
		derived D[20];
			char ch='y';
			clrscr();
		while(ch=='y')
		{
				D[i].getdata();
				cout<<"\n\nDo you insert more data:";
				ch=getche();
				i++;
		}

		cout<<"\n\nThe Fruit Information is:";
		cout<<"\n\n\tFruit Name\tType\tQuntity\n";
		for(int j=0;j<i;j++)
		D[j].show();
		getch();
		return 0;
}