//PROGRAM FOR THE DISPLAYING THE AREA OF SEQURE AND CIRCLE BY FUNCTION OVERLOADING

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
float area(float a,float b)
{
	return(a*b);
}
float area(float r)
{
	return(3.14*r*r);
}
int main()
{
	float a,b;
	int r;
	clrscr();
	cout<<"\n\nEnter the height and width of  the sequre:";
	cin>>a>>b;
	cout<<"\n\nEnter the radius of the Circle:";
	cin>>r;
	cout<<"\n\n\tThe Area of the Sequre is:"<<area(a,b);
		cout<<"\n\n\tThe Area of the Circle is:"<<area(r);
		getch();
	return 0;
}