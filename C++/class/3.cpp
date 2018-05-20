#include<iostream.h>
#include<conio.h>
class account
	{
	private:
		char name[20];
		int ano;
		char type[20];
		float bal;
	public:
		void getvalues(void);
		void Deposit(void);
		void Withdrawl(float amt);
		void Display(void);
	};
void account::getvalues(void)
	{
	cout<<"\nEnter name :";
	cin>>name;
	cout<<"\nEnter account number:";
	cin>>ano;
	cout<<"\nAccount Type:";
	cin>>type;
	cout<<"\nBalance:";
	cin>>bal;
	}
void account::Display(void)
	{
	cout<<"Ano\t"<<"Name\t"<<"Type\t"<<"Balance\n";
	cout<<ano<<"\t"<<name<<"\t"<<type<<"\t"<<bal<<"\n";
	}
void account::Deposit(void)
	{
	float amt;
	cout<<"\nEnter the amount to deposit:";
	cin>>amt;
	bal=bal+amt;
	}
void account::Withdrawl(float amt)
	{
	bal=bal-amt;
	}
int main()
	{
	account A;
	clrscr();
	A.getvalues();
	A.Display();
	A.Deposit();
	cout<<"\n After Deposit:\n";
	A.Display();
	A.Withdrawl(1000);
	cout<<"\n After Withdrawl:\n";
	A.Display();
	getch();
	return 0;
	}
