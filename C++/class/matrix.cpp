//Program to overload + and == operator

#include<iostream.h>
#include<conio.h>

class matrix
	{
	private:
		int m,n,a[20][20],b[20][20];
	public:
		void get(void);
		void put(void);
		void operator +();
	};

void matrix::get(void)
	{
	cout<<"\n How many Rows:";
	cin>>m;
	cout<<"\n How many columns:";
	cin>>n;
	for(int i=0;i<m;i++)
		{
		for(int j=0;j<n;j++)
			{
			cin>>a[i][j];
			}
		}
	}
void matrix::put(void)
	{
	cout<<"\n Matrix Elements are...\n";
	for(int i=0;i<m;i++)
		{
		for(int j=0;j<n;j++)
			{
			cout<<"\t"<<a[i][j];
			}
		cout<<"\n";
		}
	}
void matrix::operator +()
	{
	int c[20][20];
	for(int i=0;i<m;i++)
		{
		for(int j=0;j<n;j++)
			{
			c[i][j]=a[i][j]+b[i][j];
			}
		}
	cout<<"\n Matrix Elements after addition are...\n";
	for(i=0;i<m;i++)
		{
		for(int j=0;j<n;j++)
			{
			cout<<"\t"<<c[i][j];
			}
		cout<<"\n";
		}
	}
int main()
	{
	matrix m;
	clrscr();
	cout<<"\n Enter Elements Of First Matrix:\n";
	m.get();
	m.put();
	cout<<"\n Enter Elements Of First Matrix:\n";
	m.get();
	m.put();
	+m;
	getch();
	return 0;
	}