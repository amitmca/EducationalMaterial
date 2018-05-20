#include<iostream.h>
#include<fstream.h>
#include "conio.h"
#include<iomanip.h>

const char *filename="BINARY";

int main()
	{
	float height[4]={175.5,153.0,167.25,160.70};
	clrscr();
	ofstream outfile;
	outfile.open(filename);
	outfile.write((char *) & height,sizeof(height));
	outfile.close();
	for(int i=0;i<4;i++)
		height[0]=0;
	ifstream infile;
	infile.open(filename);
	infile.read((char *) & height,sizeof(height));
	for(int i=0;i<4;i++)
		{
		cout.setf(ios::showpoint);
		cout<<setw(10)<<setprecision(2)<<height[i];
		}
	infile.close();
	getch();
	return 0;
	}
