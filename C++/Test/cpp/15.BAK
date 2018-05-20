//	PROGRAM FOR CREATING RESUME BY OWN MANIPULATOR USING
#include<iostream.h>
#include<iomanip.h>
#include<string.h>
#include<conio.h>
ostream & resume(ostream & output)
{
		char name,quli;
		float result;
		output<<"\n\nEnter name:";
		cin.get(name);
		output<<"\n\n\t\t\t\tName:";
		while(name!='\n')
		{
			output<<name;
			cin.get(name);
		}

		output<<"\n\nEnter the Qualification:";
		cin.get(quli);
		output<<"\n\n\t\t\t\tQualification:";
		while(quli!='\n')
		{
			output<<quli;
			cin.get(quli);
		}

		output<<"\n\nEnter the Result in Percentage:";
		cin>>result;
		output<<"\n\n\t\t\t\tResult:"<<result;
		return output;
}
istream & addr(istream & input)
{
		char addr[20];
		cout<<"\n\nEnter the Address:";
		cin.getline(addr,20);
		cout<<"\n\n\t\t\t\tAddress:";
		int m=strlen(addr);
		int i=0;
		while(i<m)
		{
				cout<<addr;
				i++;
		}
		return input;
}
int main()
{
	clrscr();
	cout<<resume;
	cin>>addr;
	getch();
	return 0;
}