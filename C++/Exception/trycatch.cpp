//Program for Handling the Exceptions

#include<iostream.h>
#include<conio.h>


int main()
	{
	int a,b;

	cout<<"\nEnter values of a and b:";
	cin>>a;
	cin>>b;
	int x=a-b;
	try
		{
		if(x!=0)
			{
			cout<<"Result(a/x)="<<(a/x)<<"\n";
			}
		else
			{
			throw(x);
			}
		}
	catch(int i)
		{
		cout<<"\n Exception Caught: x="<<x<<"\n";
		}
	cout<<"\nEND\n";
    cin.get();
	return 0;
	}
