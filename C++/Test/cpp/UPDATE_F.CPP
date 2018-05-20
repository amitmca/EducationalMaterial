#include<conio.h>
#include<iostream.h>
#include<fstream.h>
#include<string.h>
#define MAX 20
class file
{
		protected:
				int rno;
				char name[MAX];
		public:
				void getdata(void)
				{
						cout<<"\n\nEnter the name:";
						cin>>name;
						cout<<"\n\nEnter the Roll No:";
						cin>>rno;
				}
				void putdata(void)
				{
						cout<<"\n\n\t"<<name<<"\t"<<rno;
				}
};

int main()
{
		file F;
		fstream file;
		file.open("temp.dat",ios::in|ios::binary|ios::app|ios::out);
		if(file.fail())
			cout<<"\n\n\tThe File Not found";
		cout<<"\n\n\tEnter the data:";
	   F.getdata();
	   char ch;
	   file.write((char *) &  F,sizeof(F));
	   file.seekg(0);
	  while(file.read((char *) & F,sizeof(F)))
	  {
			F.putdata();
	  }
	  int n;
	  cout<<"\n\nEnter the object no to modify:";
	  cin>>n;
			n=(n-1) *sizeof(F);
			file.seekp(n);
			file.read((char *) & F,sizeof(F));
			while(!file.eof())
			{
				file.read((char *) & F,sizeof(F));
				F.putdata();
			}
				//F.putdata();

   /*	  cout<<"\n\nEnter the new data:";
	  F.getdata();
	  file.write((char *) & F,sizeof(F));

	  cout<<"\n\nThe updateed  data is:";
	  file.seekg(0,ios::beg);
	  while(file.read((char *) & F,sizeof(F)))
		{
				F.putdata();
		}*/
			file.close();
			getch();
			return 0;
}