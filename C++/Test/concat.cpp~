#include<string.h>
#include<iostream.h>
#include "conio.h"

class string
	{
	int len;
	char *p;
	public:
		string()		
		{
		len=0;
		p=0;
		}
		string(const char *s)
		{
		len=strlen(s);
		p=new char[len+1];
		strcpy(p,s);
		}
		string(const string &s)
		{
		len=s.len;
		p=new char[len+1];
		strcpy(p,s.p);
		}
	friend string operator +(const string &s,const string &t);
	void show()
		{
		cout<<p;
		}
	};
 string operator +(const string &s,const string &t)
	{
	string temp;
	temp.len=s.len+t.len;
	temp.p=new char[temp.len+1];
	strcpy(temp.p,s.p);
	strcpy(temp.p,t.p);
	return(temp);
	}
int main()
	{
	string s1="Amit",s2="Ajit",s3;
	clrscr();
	s3=s1+s2;
	s3.show();
	getch();
	return 0;
	}
