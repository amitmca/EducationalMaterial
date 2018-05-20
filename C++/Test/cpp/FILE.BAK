#include<conio.h>
#include<iostream.h>
#include<fstream.h>
#include<string.h>
class sert
{
		protected:
				int rno;
				char name[20];
		public:
				void getdata(void);
				void putdata(ofstream &os);

};
void sert::getdata(void)
{
		cout<<"\n\nEnter the roll number:";
		cin>>rno;
		cout<<"\n\nEnter the name:";
		cin>>name;
}
void sert::putdata(ofstream &os)
{
		os.write((char *) &rno,sizeof(rno));
		os<<ends;
		os.write(name,strlen(name));

}
int main()
{
		ofstream file("new.dat",ios::trunc|ios::binary);
		if(file.fail())
			cout<<"\t\n\nNot opend:";
		sert in;

		cout<<"\n\nEnter the details:";
		cin>>in;
		file.write((char *) &in,sizeof(in));
					getch();
			return 0;

}