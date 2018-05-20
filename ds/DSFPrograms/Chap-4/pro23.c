/*Program 4.23 : Defining and assigning values to structure members*/
#include<stdio.h>
struct person
{
	char first_name[30];
	char second_name[30];
};
void main()
{
	struct person p;
	printf("\n Enter first name and second name :");
	scanf("%s %s",p.first_name,p.second_name);
	printf("\n %s \n%s",p.first_name,p.second_name);
}

/*
     *** OUTPUT ***
 Enter first name and second name :MOHAN KUMAR

 MOHAN
KUMAR
*/
