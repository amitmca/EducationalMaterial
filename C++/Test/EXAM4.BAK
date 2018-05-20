#include<iostream.h>
#include<conio.h>
#include<fstream.h>
#include<stdlib.h>

int main()
	{
	ifstream infile;
	char fname[20];
	char ch;
	int t=0,n=0,s=0,v=0,w;
	clrscr();
	cout<<"\nEnter the file name to be opened:";
	cin>>fname;
	infile.open(fname);
	if(infile.fail())
		{
		cout<<"\n Unable To Open File\n";
		exit(1);
		}
	while(!infile.eof())
		{
		ch=infile.get();
		cout<<ch;
		if(ch=='\t')
			t++;
		if(ch=='\n')
			n++;
		if(ch==' ')
			s++;
		if((ch=='a') || (ch=='A') || (ch=='e') || (ch=='E') || (ch=='i') || (ch=='I') || (ch=='o') || (ch=='O') || (ch=='u') || (ch=='U'))
			v++;
		}
	w=(t+n+s)-1;
	cout<<"\n";
	cout<<"\n Tabs:"<<t<<"\n";
	cout<<"\n Lines:"<<n<<"\n";
	cout<<"\n Spaces:"<<s<<"\n";
	cout<<"\n Vowels:"<<v<<"\n";
	cout<<"\n Words:"<<w<<"\n";
	infile.close();
	getch();
	return 0;
	}
