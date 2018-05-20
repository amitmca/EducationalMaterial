//PROGRAM FOR SWAPPING THE DATA USING THE REFERENCES VARIBLE OF 3.1

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
void swap(int,int);
void main()
{
		int a,b;
		clrscr();
		cout<<"\n\n\nEnter the two number:";
		cin>>a>>b;
		swap(a,b);
		getch();

}
void swap(int a,int b)
{
		int temp;
		temp=a;
		a=b;
		b=temp;
		cout<<"\n\nThe swaped data is:";
		cout<<a<<"\t"<<b;
}