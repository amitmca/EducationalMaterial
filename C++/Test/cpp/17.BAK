//PROGRAMS FOR COUNTING THE WORDS,VOWELS,SPACE,TAB,LINE IN USER GIVEN FILE

#include<iostream.h>
#include<conio.h>
#include<fstream.h>
int main()
{
		char name[20];
		clrscr();
		cout<<"\n\nEnter the file name:";
		cin>>name;
		ifstream in;
		in.open(name);
		int line=0,space=0,vowels=0,tb=0;
		char ch;
		if(in.fail())
		{
				cout<<"\n\n\tThe File Name Is Invalid:";
				cout<<"\n\n\tPlease,enter the proper file name............";
		}
		else
		{

				in.seekg(0);
				while(!in.eof())
				{

						ch=in.get();
						if(ch=='\n')
							line++;
						if(ch==' ')
							space++;
						if(ch=='\t')
								tb++;
					   if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')
								vowels++;
				  }
					cout<<"\n\n\tThe file contains the "<<line<<" Line";
					cout<<"\n\n\tThe file contains the "<<space<<" Space";
					cout<<"\n\n\tThe file contains the "<<tb<<" Tabs";
					cout<<"\n\n\tThe file contains the "<<vowels<<" Vowels";
					cout<<"\n\n\tThe file contains the "<<space+tb<<" Words";

		}
		getch();
		return 0;
}