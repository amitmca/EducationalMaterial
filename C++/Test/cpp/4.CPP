
//PROGRAM FOR DISPLAYING THE MARKS OF THE STUDENT IN FREIND FUNCTION USED
#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class student
{
	private:
			int m1,m2;
	public:
			void setdata(int a,int b)
			{
				m1=a;
				m2=b;
			}
			friend int add(student s);
};
int add(student s)
{
	return s.m1+s.m2;
}
void main()
{
		int a,b,i=0,j;
		char ch='y';
		clrscr();
		student s1[20];
		while(ch=='y')
		{
			cout<<"\n\nEnter the marks of the two subjects:";
			cin>>a>>b;
			s1[i].setdata(a,b);
			cout<<"\n\nDo you insert more data:";
			ch=getche();
			i++;
		}
		for(j=0;j<i;j++)
		cout<<"\n\n\n\tThe Total of the marks of  "<< j+1 <<"   student:"<<add(s1[j]);
		getch();
}