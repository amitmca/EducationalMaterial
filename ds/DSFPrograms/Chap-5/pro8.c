/*Program 5.8 :	A sample program showing usage of a function pointer. In the example given below, the program 5.4 is re-written using function pointer.*/
#include<stdio.h>
int sum(int *p,int n);
int (*fp)(int *p,int n);
void main()
{
	int a[30],n,s,*p;
	printf("\nNo. of Elements :");
	scanf("%d",&n);
	for(p=a;p<a+n;p++)
	{
		printf("\nEnter next element :");
		scanf("%d",p);
	}
	fp=sum; // function pointer is initialised
	s=(*fp)(a,n);
	printf("\nSum=%d",s);
}

int sum(int *p,int n)
{
	int *q,s;
	s=0;
	for(q=p;q<p+n;q++)
		s+=*q;
	return(s);
}

/*
        *** OUTPUT ***
No. of Elements :5

Enter next element :5

Enter next element :4

Enter next element :3

Enter next element :2

Enter next element :1

Sum=15
*/
