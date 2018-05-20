#include<iostream.h>
#include<process.h>
#include<iomanip.h>
#include<fstream.h>
#include<conio.h>

class stud
{
protected:
		char name[20];
		int marks;
		public:
				int rno;
				void getdata(void);
				void putdata(void);
};
void stud::getdata()
{
		cout<<"\n\n\t\tEnter the Student Information:";
		cout<<"\n\nEnter the stdudent name:";
		cin>>name;
		cout<<"\n\nEnter the Roll number:";
		cin>>rno;
		cout<<"\n\nEnter the Total marks:";
		cin>>marks;

}
void stud::putdata()
{
		cout<<"\n\t"<<name<<"\t"<<rno<<"\t"<<marks<<"\n\n";
}
int main()
{
		stud s;
		clrscr();
		textcolor(10);
		fstream file;
		file.open("stud.dat",ios::in|ios::out);
		int choice;
		//file.close();
		while(1)
		{

				cout<<"\n\n\t***MENU***\n\n";
				cout<<"\n1:Add"
					<<"\n2:Modify"
					<<"\n3:Display All"
					<<"\n4:Display Single"
					<<"\n5:Exit";
				cout<<"\n\n\tEnter your choice:";
				cin>>choice;

				switch(choice)
				{
						case 1:
								if(file.fail())
										cout<<"\n\nSorry,The File can not be found.........";
							  cout<<"\n\nInsert the student information:";
							  s.getdata();
							  file.open("stud.dat",ios::out|ios::app);
							  file.write((char *) & s,sizeof(s));
							  file.clear();
							  break;
						case 2:
								char n;
								cout<<"\n\nEnter the roll number to modify:";
								cin>>n;
								if(n==s.rno)
									cout<<"\n\nNo is present:";
								break;
						case 3:
								/*if(file.fail())
									cout<<"\n\nThe File is not opend:";*/
								 file.open("stud.dat",ios::in);
								file.seekg(0);

								while(file.read((char *) & s,sizeof s))
								{
										s.putdata();
								}
								break;
						case 5:
								  //	file.close();
								exit(0);

				}

		}

}