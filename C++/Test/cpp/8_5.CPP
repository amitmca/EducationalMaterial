#include<stdio.h>
#include<conio.h>
#include<iostream.h>
#include<process.h>
class person
{
	   //	protected:
	   public:
				char name[20];
				int code;
				int acno;
				float amt;


				void getdata(void);
};
class acount:public person
{
				public:
			void getamount();
};
class admin:public person
{
		public:
				void change(int a);
};
class master:public person
{
		public:
				void watch();
};
void person::getdata()
{
		cout<<"\n\nEnter the name of the employee:";
		cin>>name;
		cout<<"\n\nEnter the code of the emp:";
		cin>>code;
		cout<<"\n\nEnter the acount number:";
		cin>>acno;
}
void acount::getamount()
{
		cout<<"\n\nEnter the amount:";
		cin>>amt;

}
void admin::change(int a)
{
		if(a==acno)
		{
				cout<<"\n\nEnter the new amount:";
				cin>>amt;
		}
		else
			cout<<"\n\n\tThe Given Account number is not valid:";

}
void master::watch()
{
	cout<<"\n\n\t"<<name<<"\t"<<code<<"\t"<<acno<<"\t"<<amt<<"\n\n";
}

int main()
{
			acount a;
			admin ad;
			master m;
			clrscr();
			while(1)
			{
					cout<<"\n\n\t\tMENU\n\n";
					cout<<"\n1:CREATE\n"
						<<"\n2:UPDATE\n"
						<<"\n3:DISPLAY\n"
						<<"\n4:EXIT\n";
					cout<<"\n\n\nEnter your choice:";
					int choice;
					cin>>choice;
					switch(choice)
					{
							case 1:

									char ch='y';
									while(ch=='y')
									{
										a.getdata();
										a.getamount();
										cout<<"\n\nYou want to cretae the new account(y/n):";
										ch=getche();

									}
									break;
							case 2:
									cout<<"\n\nEnter the acount number to update:";
									int a;
									cin>>a;
									ad.change(a);
									break;
							case 3:
									cout<<"\n\nThe Acoount Information is:";
									cout<<"\n\n\tNAME\tCODE\tA/C NO.\tAMOUNT\n";
									m.watch();
									break;
							case 4:
									exit(0);

					}
			}
}