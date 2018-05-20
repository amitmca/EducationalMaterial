//Program to demonstrate the string library functions
#include<stdio.h>
#include<conio.h>
#include<string.h>
main()
	{
	char *str1,*str2,*str3,*str4,*rev,*lower,*upper,ch='i',*p,*q;
	int l,c;
	clrscr();
	printf("\nEnter the first string:");
	scanf("%s",str1);
	printf("\nEnter the second string:");
	scanf("%s",str2);
	printf("\nThe entered Strings are:%s \t %s \n",str1,str2);
	q=strstr(str1,str2);
	printf("\nThe substring is:%s\n",q);
	p=strchr(str1,ch);
	printf("\nThe Character %c is at position %d\n",ch,p-str1);
	c=strcmp(str1,str2);
	if(c==0)
		{
		printf("\nThe string %s and %s are equal\n",str1,str2);
		}
	else
		{
		printf("\nThe string %s and %s are not equal\n",str1,str2);
		}
	l=strlen(str1);
	printf("\nThe Reverse of %s is : \t",str1);
	rev=strrev(str1);
	printf(" %s\n",rev);
	printf("\nThe Length of string %s is: %d\n",str1,l);
	printf("\nThe Concatenation of string %s and %s is : ",str1,str2);
	str3=strcat(str1,str2);
	printf("\t%s\n ",str3);
	printf("\nThe string %s in lower case is:\t",str3);
	lower=strlwr(str3);
	printf("%s\n",lower);
	printf("\nThe string %s in upper case is:\t",str3);
	upper=strupr(str3);
	printf("%s\n",upper);
	strcpy(str4,str1);
	printf("\nThe Copied String is:%s",str4);
	getch();
	return 0;
	}