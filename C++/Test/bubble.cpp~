// Program for Bubble Sort using Function Templates

#include<iostream.h>
#include<conio.h>

template<class T>
void bubble(T a[],int n)
	{
	for(int pass=1;pass<n;pass++)
		{
		for(int j=0;j<n-pass;j++)
			{
			if(a[j] > a[j+1])
				{
				swap(a[j],a[j+1]);
			   	}
			}
		}
	}

template<class x>
void swap(x &a,x &b)
	{
	x temp=a;
	  a=b;
	  b=temp;
	}

int main()
	{
	int x[5]={10,50,30,40,20};
	float y[5]={1.1,5.5,3.3,4.4,2.2};
	clrscr();
	bubble(x,5);
	bubble(y,5);
	cout<<"\n Sorted x-array:";
	for(int i=0;i<5;i++)
		cout<<x[i]<<" ";
	cout<<endl;

	cout<<"\n Sorted y-array:";
	for(int j=0;j<5;j++)
		cout<<y[j]<<" ";
	cout<<endl;

	getch();
	return 0;
	}
