#include<iostream.h>

int main()
	{
	int a,b;
	cout<<"\n Enter values of a and b:";
	cin>>a>>b;
	int x=a-b;
	try
		{
		if(x!=0)
			{
			cout<<"Result(a/x)="<<x<<"\n";
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
	return 0;
	}