/*Program 4.15 : Program to find length of string.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	char s[100];
	int l;
	//reading a string and finding its length
	printf("\n Enter the string :");
	gets(s);
	l=0;
	while(s[l]!='\0')
	l++;
	printf("\n length of '%s' is=%d",s,l);
	getch();
}

/*
       *** OUTPUT ***
Enter the string :It is India

length of 'It is India' is=11
*/
