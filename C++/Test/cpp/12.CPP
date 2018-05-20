//PROGRAM FOR THE PURE VIRTUAL CLASS FUNCTION

#include<stdio.h>
#include<conio.h>
#include<iostream.h>
class shape
{
			public:
					virtual void show();
				};
void shape::show()
{
		cout<<"\n\n\n\tThe Circle And Rectangle Area are :";
}

class circle
{
		int r;
			public:
					virtual float area_circle(float a)
					{
							r=a;
							return(3.14*r*r);
					}
};
class rect
{
		float a,b;
			public:
					virtual float area_rect(float h,float l)
					{
							a=h;
							b=l;
							return(a*b);
					}
};
int main()
{
		shape s;
		circle c;
		rect rec;
		float r,a,b;
		clrscr();
		cout<<"\n\nEnetr the redius of the circle:=>";
		cin>>r;
		cout<<"\n\nEnter the height and width of the rectangle:=>";
		cin>>a>>b;
		s.show();
		cout<<"\n\nThe Area of the circle is:"<<c.area_circle(r);
		cout<<"\n\nThe Area of the rectangle is:"<<rec.area_rect(a,b);
		getch();
		return 0;
}
