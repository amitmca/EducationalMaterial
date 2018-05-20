#include<iostream.h>
#include "conio.h"

namespace Matrix
	{
	void add(int a[][],int b[][])
		{
		int i,j,c[2][2];
		for(i=0;i<2;i++)
			{
			for(j=0;j<2;j++)
				{
				c[i][j]=0;
				c[i][j]=a[i][j]+b[i][j];
				}
			}
		cout<<"\n Addition is:";
		for(i=0;i<2;i++)
			{
			for(j=0;j<2;j++)
				{
				cout<<c[i][j]<<" ";
				}
			cout<<"\n";
			}
		}
	}

int main()
	{
	using namespace Matrix;
	int a[2][2],b[2][2],c[2][2],i,j;
	clrscr();
	cout<<"\n Enter elements for first matrix:";
	for(i=0;i<2;i++)
		{
		for(j=0;j<2;j++)
			{
			cin>>a[i][j];
			}
		}

	cout<<"\n Enter elements for second matrix:";
	for(i=0;i<2;i++)
		{
		for(j=0;j<2;j++)
			{
			cin>>b[i][j];
			}
		}
	add(a,b);
	getch();
	return 0;
	}
