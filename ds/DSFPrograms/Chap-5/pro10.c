/*Program 5.10 :Program to illustrate the use of structure pointer.*/
#include<stdlib.h>
#include<stdio.h>
struct student
{
	char name[30];
	int roll_no;
};
void main()
{
	struct student a[10],*p;
	int n;
	p=a;
	printf("\nEnter no. of students :");
	scanf("%d",&n);
	for(p=a;p<a+n;p++)
	{
		printf("\nEnter name and roll number :");
		scanf("\n%s\t%d",p->name,&p->roll_no);
	}
	printf("\nOutput");
	p=a;
	while(p<a+n)
	{
		printf("\n%s\t%d",p->name,p->roll_no);
		p=p+1;
	}
}

/*  
           *** OUTPUT ***
Enter no. of students :5

Enter name and roll number :Rohan 105

Enter name and roll number :Sohan 111

Enter name and roll number :Mohan 132

Enter name and roll number :Anil 145

Enter name and roll number :Sunil 155

Output
Rohan   105
Sohan   111
Mohan   132
Anil    145
Sunil   155
*/
