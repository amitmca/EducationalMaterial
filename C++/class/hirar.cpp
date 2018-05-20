// Program for Hierarchical Inheritance

#include<iostream.h>
#include<conio.h>
const length=25;

class Vehicle
	{
	protected:
		char name[length];
		int wheelcount;
	public:
		void getdata()
			{
			cout<<"\n Name Of the Vehicle:";
			cin>>name;
			cout<<"\n Wheels ? :";
			cin>>wheelcount;
			}
		void Displaydata()
			{
			cout<<"\n Name Of Vehicle:"<<name<<endl;
			cout<<"\n Wheels:"<<wheelcount<<endl;
			}
	};
class lightmotor:public Vehicle
	{
	protected:
		int speedlimit;
	public:
		void getdata()
			{
			Vehicle::getdata();
			cout<<"\n Speed limit:";
			cin>>speedlimit;
			}
		void Displaydata()
			{
			Vehicle::Displaydata();
			cout<<"\n Speed Limits:"<<speedlimit<<endl;
			}
	};
class heavymotor:public Vehicle
	{
	protected:
		int loadcapacity;
		char permit[length];
	public:
		void getdata()
			{
			Vehicle::getdata();
			cout<<"\n Load Carrying Capacity:";
			cin>>loadcapacity;
			cout<<"\n permit Type:";
			cin>>permit;
			}
		void Displaydata()
			{
			Vehicle::Displaydata();
			cout<<"\n Load Capacity:"<<loadcapacity<<endl;
			cout<<"\n Permit :"<<permit<<endl;
			}
	};
class Gearmotor:public lightmotor
	{
	protected:
		int gearcount;
	public:
		void getdata()
			{
			lightmotor::getdata();
			cout<<"\n No Of Gears:";
			cin>>gearcount;
			}
		void Displaydata()
			{
			lightmotor::Displaydata();
			cout<<" Gear:"<<gearcount<<endl;
			}
	};
class NonGearmotor:public lightmotor
	{
	public:
		void getdata()
			{
			lightmotor::getdata();
			}
		void Displaydata()
			{
			lightmotor::Displaydata();
			}
	};
class passenger:public heavymotor
	{
	protected:
		int sitting;
		int standing;
	public:
		void getdata()
			{
			heavymotor::getdata();
			cout<<"\n Maximum Seat:";
			cin>>sitting;
			cout<<"\n Maximum Standing:";
			cin>>standing;
			}
		void Displaydata()
			{
			heavymotor::Displaydata();
			cout<<"\n Maximum Seats:"<<sitting<<endl;
			cout<<"\n Maximum Standing:"<<standing<<endl;
			}
	};
class Goods:public heavymotor
	{
	public:
		void getdata()
			{
			heavymotor::getdata();
			}
		void Displaydata()
			{
			heavymotor::Displaydata();
			}
	};
int main()
	{
	Gearmotor vehi1;
	passenger vehi2;
	clrscr();
	cout<<"\n Enter the data for Gear Motor Vehicle:";
	vehi1.getdata();
	cout<<"\n Enter the data for passenger Motor Vehicle:";
	vehi2.getdata();
	cout<<" Data for Gear Motor Vehicle:"<<endl;
	vehi1.Displaydata();
	cout<<" Data for Passenger Motor Vehicle:"<<endl;
	vehi2.Displaydata();

	getch();
	return 0;
	}
