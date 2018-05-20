//PROGRAM FOR THE VIRTUAL BASE CLASS IMPLEMENTATION

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class student
{
		protected:
				int rno;
		public:
				void getrno(int r)
				{
						rno=r;
				}

};
class test:virtual public student
{
		protected:
				int m1,m2;
		public:
				void getmarks(int a,int b)
				{
						m1=a;
						m2=b;
				}

};
class sport:virtual public student
{
		protected:
				int sport_mark;
		public:
				void getsport_mark(int s)
				{
						sport_mark=s;
				}
};
class result:public test,public sport
{
		protected:
					int r;
		public:
				void display()
				{
					r=m1+m2+sport_mark;
					cout<<"\n\t  "<<rno<<"\t   "<<m1<<"\t   "<<m2<<"\t   "<<sport_mark<<"\t         "<<r<<"\n\n";

				}

};
int main()
{
		result R[10];
		int i=0;
		int rno,sport_mark,m1,m2;
		char ch='y';
		clrscr();
		while(ch=='y')
		{
			cout<<"\n\nEnter the Roll Number of the student:";
			cin>>rno;
			R[i].getrno(rno);
			cout<<"\n\nEnter the mark of the first subject:";
			cin>>m1;
			cout<<"\n\nEnter the mark of the second subject:";
			cin>>m2;
			R[i].getmarks(m1,m2);
			cout<<"\n\nEnter the sport mark of the student:";
			cin>>sport_mark;
			R[i].getsport_mark(sport_mark);
			cout<<"\n\nDo you insert more record's(y/n):";
			ch=getche();
			i++;
		}
		cout<<"\n\n\nThe Student Information is:";
		cout<<"\n\n\tR_no\tMark1\tMark2\tSport_Mark\tTotal\n";
		cout<<"\n\n----------------------------------------------------------------\n";

		for(int j=0;j<i;j++)
		R[j].display();
			cout<<"\n\n----------------------------------------------------------------\n";
		getch();
		return 0;
}
