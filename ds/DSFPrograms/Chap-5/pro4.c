/*Program 5.4 : Program to add elements of an array.*/
#include<stdio.h>
int sum(int *p,int n);
void main()
{
	int a[30],n,s,*p;
	printf("\nNo. of elements :");
	scanf("%d",&n);
	for(p=a;p<a+n;p++)
	{
		printf("\nEnter next element :");
		scanf("%d",p);
	}
	s=sum(a,n);
	printf("\nsum=%d",s);

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
No. of elements :4

Enter next element :4

Enter next element :3

Enter next element :2

Enter next element :1

sum=10
*/
