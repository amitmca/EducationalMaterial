#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
	float num,a,result;
	int b,c,p;
	clrscr();
	printf("\n\nEnter the float value:");
	scanf("%f",&num);
	printf("\n\nEnter the pos :");
	scanf("%d",&p);
	a=num*pow(10,p);
	b=a*10;
	c=b%10;
	if(c>=5)
	{
		b=b+10;
		result=b/(pow(10,p+1));
	}

	else
		result=b/(pow(10,p+1));

	  printf("\n\n%6.2f",result);
		getch();
}
