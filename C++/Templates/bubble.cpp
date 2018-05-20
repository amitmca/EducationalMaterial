
// Program for Bubble Sort using Function Templates

#include<iostream.h>
#include "conio.h"

template<class T>
void sort(T a[],int n)
	{	
	for(int pass=1;pass<n;pass++)
		{
		for(int j=0;j<n-pass;j++)
			{
			if(a[j]>a[j+1])
				{
				swap(a[j],a[j+1]);
				}
			}
		}
	}	
template<class X>
void swap(X &a,X &b)
	{
	X temp=a;
	  a=b;
  	  b=temp;
	}

int main()
	{
	int a[5]={10,50,30,40,20};
	float b[5]={3.3,2.2,5.5,1.1,4.4};
	
	sort(a,5);
	sort(b,5);
	cout<<"\n Sorted a-array:";
	for(int i=0;i<5;i++)
		cout<<a[i]<<"\t";
	cout<<endl;
	cout<<"\n Sorted b-array:";
	for(int j=0;j<5;j++)
		cout<<b[j]<<"\t";
	cout<<endl;
	getch();
	return 0;
	}