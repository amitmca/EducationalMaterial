#include<iostream.h>
#include "conio.h"


int main()
	{
	char s[]="man";
	int i;
	clrscr();
	for(i=0;s[i];i++)
	cout<<"\n"<<s[i]<<*(s+i)<<*(i+s)<<i[s];
	getch();
	return 0;
	}
