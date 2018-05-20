#include<iostream.h>
#include<conio.h>
const size=1;
class player
	{
	private:
		int pcode;
		char name[20];
		int runs;
		int iplayed;
		int ntnot;
	public:
		void Accept(void);  		//Function Declaration
		void Print(void);
		void Average(int code);
		void Averageruns(void);

	};
void player::Accept(void)
	{
	cout<<"\n Player Code:";
	cin>>pcode;
	cout<<"\n Player Name:";
	cin>>name;
	cout<<"\n Runs :";
	cin>>runs;
	cout<<"\n Innings Played:";
	cin>>iplayed;
	cout<<"\n No Of Time Not Out:";
	cin>>ntnot;
	}
void player::Average(int c)
	{
	player p[size];
	float avg;
	for(int i=0;i<size;i++)
		{
		if(p[i].pcode==c)
			{
			avg=p[i].runs/p[i].iplayed;
			}
		}
	cout<<"\n Average Runs are :\t"<<avg<<"\n";
	}
void player::Print(void)
	{
	cout<<pcode<<"\t"<<name<<"\t"<<runs<<"\t"<<iplayed<<"\t"<<ntnot<<"\n\n";
	}
int main()
	{
	int code;
	player p[size];
	clrscr();
	cout<<"\nEnter the Player Details:\n";
	for(int i=0;i<size;i++)
		{
		p[i].Accept();
		}
	cout<<"\n Player Details:\n";
	cout<<"\nCode"<<"\t"<<"Name"<<"\t"<<"Runs"<<"\t"<<"Innings"<<"\t"<<"Not out\n\n";
	for(i=0;i<size;i++)
		{
		p[i].Print();
		}
	cout<<"\n Enter the Code of player to calculate Average Runs:";
	cin>>code;
	for(i=0;i<size;i++)
		{
		p[i].Average(code);
		}
	getch();
	return 0;
	}