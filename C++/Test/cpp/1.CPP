//PROGRAM FOR DISPLAYING THE USE OF CLASS AND OBJECTS

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class student
{
int r,m1,m2;
	char name[20];

	public:
		   void	getdata();
		   void putdata();
};
void student::getdata()
{
	cout<<"\n\nEnter the Name of the Student:";
	cin>>name;
	cout<<"\n\nEnter the Roll Number of the Student:";
	cin>>r;
	cout<<"\n\nEnter the Marks of the two subjects:";
	cin>>m1>>m2;
}
void student::putdata()
{

		cout<<"\n\n\n\t"<<name<<"\t"<<r<<"\t"<<m1<<"\t"<<m2<<"\t"<<m1+m2<<"\t"<<(float)(m1+m2)/2;
}
int main()
{
	student stud[20];
	char ch='y';
	int k=0,j;
	clrscr();
	while(ch=='y')
	{
		stud[k].getdata();
		cout<<"\n\nDo you insert more data:";
		ch=getche();
		k++;
	}
	clrscr();
		cout<<"\n\n\tThe Information of the student is:";
		cout<<"\n\n\n\tName\tRoll No\tMark1\tMark2\tTotal\tAvarage";
		cout<<"\n\n\t-----------------------------------------------------";
		for(j=0;j<k;j++)
		{

			stud[j].putdata();
		}
		cout<<"\n\n\t-----------------------------------------------------";
	getch();

	return 0;
}