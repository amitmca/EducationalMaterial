#include<iostream.h>
//#include<conio.h>
#include<vector>
#include<algorithm>

int main()
	{
	vector<int> v(4);
//clrscr();
	v[0]=2;
	v[1]=0;
	v[2]=3;
	v[3]=1;
	sort(v.begin(),v.end());
	for(vector<int>::iterator viter=v.begin();viter!=v.end();viter++)
		cout<<*viter<< " ";
		cout<<endl;
//	getch();
	return 0;
	}