//Program to concatenate 2 strings

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
		len=0;
		p=new char[len+1];
		}
		string(char *s);
		void join(string &s,string &t);
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
void string ::join(string &s,string &t)
	{
	len=s.len+t.len;
	delete p;
	p=new char[len+1];
	strcpy(p,s.p);
	strcat(p,t.p);
	}
int main()
	{
	string s1="Amit",s2="Ramjit",s3;
	clrscr();
	cout<<"s1=";s1.show();
	cout<<"s2=";s2.show();
	s3.join(s1,s2);
	s3.show();
	getch();
	return 0;
	}
