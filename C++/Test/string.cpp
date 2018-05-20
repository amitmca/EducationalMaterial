//Program to overload == operator

#include<iostream.h>
#include<string.h>
#include "conio.h"

class string
	{
	char *p;
	int len;
	public:
		string()
		{
		p=0;
		len=0;
		}
		string(char *s);
		string(const string &s)
		{
		len=s.len;
		p=new char[len+1];
		strcpy(p,s.p);
		}
		friend int operator ==(const string &s,const string &t);
		void show()
			{
			cout<<p<<"\n";
			}
	};
string :: string(char *s)
	{
	len=strlen(s);
	p=new char[len+1];
	strcpy(p,s);
	}
int operator ==(const string &s,const string &t)
	{
	if(strcmp(s.p,t.p))
		{
		return 1;
		}
	else
		{
		return 0;
		}
	}
int main()
	{
	string s1="Amit",s2="Ramjit";
	clrscr();
	cout<<"s1=";s1.show();
	cout<<"s2=";s2.show();
	if(s1==s2)
		{
		cout<<"\n Both are same";
		}
	else
		{
		cout<<"\n Both are different";
		}
	getch();
	return 0;
	}
