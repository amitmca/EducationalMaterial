#include<conio.h>
#include<ctype.h>
#include<fstream.h>
#include<iostream.h>
#include<string.h>
#define MAX 40
class person
{
		private:
				char name[MAX];
				int age;
		public:
				void write(ofstream &os)
				{
						os.write(name,strlen(name));
						os<<ends;
						os.write((char *)&age,sizeof(age));
				}
				int read(ifstream &is)
				{
						is.get(name,MAX,0);
						name[is.gcount()]=0;
						is.ignore(1);
						is.read((char*) &age,sizeof(age));
						return is.good();
				}
				friend ostream &operator<<(ostream &os,person &b);
				friend istream &operator>>(istream &is,person &b);
};
istream &operator>>(istream &is,person &b)
{
		cout<<"Name:";
		is>>ws;
		is.get(b.name,MAX);
		cout<<"Age:";
		is>>ws>>b.age;
		return is;
}
ostream &operator <<(ostream &os,person &b)
{
		os<<"Name:"<<b.name<<endl;
		os<<"Age:"<<b.age<<endl;
		return os;
}
void main()
{
		person p_obj;
		int count,obj_id;
		clrscr();
		cout<<"\n\nData Base Creataion:";
		ofstream ofile("person.dat",ios::trunc |ios::binary);
		count=0;
		char ch;
		do
		{
				cout<<"\n\n\tEnter Object"<<count<<"details"<<endl;
				cin>>p_obj;
				count=count+1;
				ofile.write((char *) &p_obj,sizeof(p_obj));
				cout<<"\n\n\tAnother?:";
				cin>>ch;
		}while(toupper(ch)=='Y');
		ofile.close();
		fstream iofile("person.dat",ios::binary|ios::in|ios::out);
		cout<<"\n\n\nDatabase Access:"<<endl;
		while(1)
		{
				cout<<"\n\nEnter the object name to access";
				cin>>obj_id;
				if(obj_id<0||obj_id>=count)
						break;
				int location=obj_id*sizeof(p_obj);
				iofile.seekg(location,ios::beg);
				iofile.read((char *) &p_obj,sizeof(p_obj));
				cout<<p_obj;
				cout<<"\n\nWants to modify ?:";
				cin>>ch;
				if(ch=='y' || ch=='Y')
				{
						cin>>p_obj;
						iofile.seekp(location,ios::beg);
						iofile.write((char *) &p_obj,sizeof(p_obj));
				}
		}
		iofile.close();
}