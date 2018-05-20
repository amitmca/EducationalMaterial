//Dynamic Constructor

#include<iostream.h>
#include<conio.h>
#include<string.h>

class string
	{
	char *name;
	int length;
	public:
		string()
			{
			length=0;
			name=new char[length+1];
			}
		string(char *s)
			{
			length=strlen(s);
			name=new char[length+1];
			strcpy(name,s);
			}
		void display(void)
			{
			cout<<name<<"\n";
			}
		void join(string &a,string &b);
	};
void string::join(string &a,string &b)
	{
	length=a.length+b.length;
	delete name;
	name=new char[length+1];
	strcpy(name,a.name);
	strcat(name,b.name);
	}
int main()
	{
	char *first="Joseph";
	clrscr();
	string name1(first);
	string name2("Lowis");
	string name3("Lagrange");

	string s1,s2;
	s1.join(name1,name2);
	s2.join(s1,name3);
	name1.display();
	name2.display();
	name3.display();

	s1.display();
	s2.display();
	getch();
	return 0;
	}