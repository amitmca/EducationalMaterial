/*Program 4.17 :  Program to compare two strings.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	char s1[50],s2[50];
	int i;
	//reading a string and finding its length
	printf("\n Enter two strings :");
	gets(s1);
	gets(s2);
	//loop for comparison
	i=0;
	while(s1[i]==s2[i] && s1[i]!='\0')
		i++;
	if(s1[i] > s2[i])
		printf("\ns1 > s2");
	else
		if(s1[i] < s2[i])
			printf("\ns1 < s2");
			else
				printf("\ns1 = s2");
	getch();
}

/*
          *** OUTPUT ***
Enter two strings :India
India
s1 = s2
-------------------
Enter two strings :maharashtra
maha
s1 > s2
*/
