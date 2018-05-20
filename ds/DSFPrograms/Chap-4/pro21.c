/*Program 4.21 : Program to convert a decimal number from string format to integer format.*/
#include<conio.h>
#include<stdio.h>
void main()
{
	char s1[30];
	int x,i;
	printf("\nEnter the number :");
	gets(s1);    //number stored in string format
	x=0;
	for(i=0;s1[i]!='\0';i++)
		x=x*10+s1[i]-48;
	printf("\nnumber in integer format is :%d",x);
	getch();
}

/*
        *** OUTPUT ***
Enter the number :543

number in integer format is :543
*/
