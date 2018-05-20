/*Program 4.14 : Program showing usage of string handling functions.*/
#include<string.h>
#include<stdio.h>
#include<conio.h>
void main()
{
	char s1[30],s2[30];
	int l1,l2;
	//reading a string and finding its length
	printf("\n Enter the string :");
	gets(s1);
	l1=strlen(s1);
	printf("\n length of\t%s=%d",s1,l1);
	//usage of string copying function
	strcpy(s2,s1);
	printf("\n1st string=%s",s1);
	printf("\n2nd string=%s",s2);
	//usage of string compare function
	l1=strcmp(s1,s2);
	if(l1==0)
		printf("\ns1=s2");
	else
		if(l1>0)
			printf("\ns1>s2");
		else
			printf("\ns1<s2");
	/*string concatenation function*/
	strcat(s1,s2);
	printf("\nfinal string after concatination=%s",s1);
}

/*
           *** OUTPUT ***
 Enter the string :India

 length of      India=5
1st string=India
2nd string=India
s1=s2
final string after concatination=IndiaIndia
*/
