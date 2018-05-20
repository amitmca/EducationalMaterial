//Program for reference variable

#include<iostream.h>
#include "conio.h"

int main()
	{
	float total=100;
	clrscr();
	float & sum=total;
	cout<<"\n Value of total:"<<total;
	cout<<"\n Value of sum:"<<sum;
	total=total+10;
	cout<<"\n Value of sum:"<<sum;
	sum=sum-50;
	cout<<"\n Value of total:"<<total;
	getch();
	return 0;
	}
