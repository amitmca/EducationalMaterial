// Program for typeinfo class

#include<iostream.h>
#include "conio.h"

class Mammal
	{
	public:
		virtual bool lays_eggs()
		{
		return false;
		}	
	};

class Rat:public Mammal
	{
	public:
	};

class Platypus:public Mammal
	{
	public:
		bool lays_eggs()
		{
		return true;
		}
	};

class Cat:public Mammal
	{
	public:
	};

Mammal *factory()
	{
	switch(rand()%3)
		{
		case 0: return new Cat;
		case 1: return new Rat;
		case 2: return new Platypus;
		}
	return 0;
	}

int main()
	{
	Mammal *ptr;
	int i;
	int c=0,r=0,p=0;
	clrscr();
	for(i=0;i<10;i++)
		{
		ptr=factory();
		cout<<"Object is"<<typeid(*ptr).name()<<endl;
		if(typeid(*ptr)==typeid(Cat))
		c++;	
		if(typeid(*ptr)==typeid(Rat))
		r++;	
		if(typeid(*ptr)==typeid(Platypus))
		p++;	
		}
	cout<<endl;
	cout<<"Animals Generated\n";
	cout<<"Cats:"<<c<<endl;
	cout<<"Rats:"<<r<<endl;
	cout<<"Platypus:"<<p<<endl;
	getch();
	return 0;
	}
