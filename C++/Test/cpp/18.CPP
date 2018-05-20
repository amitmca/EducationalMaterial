//PROGRAM FOR THE RESADING AND WRITING IN FILE BY USING CLASS OBJECT

#include<iostream.h>
#include<conio.h>
#include<fstream.h>
#include<iomanip.h>
class item
{
		char name[20];
		int code,qty;
		float price;
		public:
				void getdata(void);
				void putdata(void);
};
void item::getdata(void)
{
		cout<<"\n\nEnter the item Name:";
		cin>>name;
		cout<<"\n\nEnter the item Code:";
		cin>>code;
		cout<<"\n\nEnter the item Quntity:";
		cin>>qty;
		cout<<"\n\nEnter the item Price:";
		cin>>price;
}
void item::putdata(void)
{

		cout<<"\n\t"<<name<<"\t\t"<<code<<"\t\t"<<qty<<"\t\t"<<setprecision(3)<<  price<<endl;
}
int main()
{
		item i[10];
		clrscr();
		ofstream file;
		file.open("item.dat",ios::in|ios::out);
			cout<<"\n\nEnter the details:";
			char ch='y';
			int j=0;
		while(ch=='y')
		{
				i[j].getdata();
				file.write((char *) & i[j],sizeof(i[j]));
				cout<<"\n\t\nDo you insert more data(y/n):";
				ch=getche();
				j++;
		}
	   file.close();
		ifstream f;
		f.open("item.dat",ios::in | ios::out);
		f.seekg(0);
		cout<<"\n\nOutput\n\n";
			cout<<"\n\n\tItem Name\tCode\t      Quntity\t\tPrice\n";
				for(int k=0;k<j;k++)
		{

				f.read((char *) & i[k],sizeof(i[k]));
				i[k].putdata();
		}
		file.close();
		getch();
		return 0;

}