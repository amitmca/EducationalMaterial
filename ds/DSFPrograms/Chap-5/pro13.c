/*Program 5.13 :Write a program to concatenate two strings. Program should use a function for concatenation and the function should return the final string.*/
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
char *concatinate(char *s1,char *s3);
void main()
{
	char s1[30],s2[30],*s3;
	// Pointer s3 will store the address of concatinated string
	printf("\nEnter the 1'st string :");
	gets(s1);
	printf("\nEnter the 2'nd string :");
	gets(s2);
	s3=concatinate(s1,s2);
	printf("concatinate string is : %s",s3);
}
char *concatinate(char *p1,char *p2)
{
	int l1,l2,i,j;
	char *p;
	l1=strlen(p1);  // function strlen() gives the length of string
	l2=strlen(p2);
	/* Dynamic array of the size l1+l2+1 is created. One extra
	   character is for the NULL character at the end */
	   p=(char *)malloc((l1+l2+1)*sizeof(char));
	   // copying string p1 to p
	   for(i=0;p1[i]!='\0';i++)
		p[i]=p1[i];
	   for(j=0;p2[j]!='\0';j++,i++)
		p[i]=p2[j];
	   p[i]='\0';   // NULL character is added to string p
	   return(p);
}

/*
         *** OUTPUT ***
Enter the 1'st string :AME

Enter the 2'nd string :RICA
concatinate string is : AMERICA
*/
