	//TEST THE ERROR OF CHAPTER 2 EXAMPLE 2.3


#include<stdio.h>
#include<conio.h>
#include<iostream.h>
int main()
{
	int i=10,j=5;
	int modResult=0;
	int divResult=0;
	modResult=i%j;
	cout<<modResult<<" ";
	divResult=i/modResult;
	cout<<divResult;
	getch();
	return 0;
}
