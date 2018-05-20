//Program to overload <,>,== operators using strings

#include<iostream.h>
#include "conio.h"
#include<string.h>

class string
	 {
	 char *p;
	 int len;
	 public:
		string()
			{
			len=0;
			p=0;
			}
		string(const char *s);
		string(const string &s);
		~string()	{  delete p; }
		friend int operator <(const string &s,const string &t);
		friend int operator >(const string &s,const string &t);
		friend int operator == (const string &s,const string &t);
  	        friend void show(const string &s);
			
	 };
void show(const string &s)
	{
	cout<<s.p;
	}
string::string(const char *s)
	{
	len=strlen(s);
	p=new char[len+1];
	strcpy(p,s);
	}

string::string(const string &s)
	{
	len=s.len;
	p=new char[len+1];
	strcpy(p,s.p);
	}
int operator <(const string &s,const string &t)
	{
	int m=strlen(s.p);
	int n=strlen(t.p);

	if(m<n)
		return 1;
	else
		return 0;
	}
int operator ==(const string &s,const string &t)
	{
	int m=strlen(s.p);
	int n=strlen(t.p);

	if(m==n)
		{
		if(strcmp(s.p,t.p))
			return 1;
		}
	else
		return 0;
	}
int operator >(const string &s,const string &t)
	{
	int m=strlen(s.p);
	int n=strlen(t.p);

	if(m>n)
		return 1;
	else
		return 0;
	}
int main()
	{
	string s1="Amit";
	string s2="Amit";
	string s3="Om";
	string t1,t2,t3;
	clrscr();
	t1=s1;
	t2=s2;
	t3=s3;

	if(t1 < t2)
		{
		show(t1);
		cout<<" smaller than ";
		show(t2);
		}
	else
		{
		if(t1 > t3)
			{
			show(t1);
			cout<<" greater than ";
			show(t3);
			}
		}
	cout<<"\n\n";
	if(t1==t3)
		{
		show(t1);
		cout<<" and ";
		show(t3);
		cout<<" are same ";
		}
	else
		{
		show(t1);
		cout<<" and ";
		show(t3);
		cout<<" are not same ";
		}
	getch();
	return 0;
	}
