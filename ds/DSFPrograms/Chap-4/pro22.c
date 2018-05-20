/*Program 4.22 : Accept a string and count number of characters, words and special characters in string.*/
#include<stdio.h>
#include<ctype.h>
void main()
{
	char a[80];
	int words,special,characters,i;
	words=special=characters=0;
	printf("\n Enter the string :");
	gets(a);
	for(i=0;a[i]!='\0';i++)
	{
		characters++;
		if(isalnum(a[i]) && (i==0 || ! isalnum(a[i-1])))
			words++;
		if(!isspace(a[i]) && !isalnum(a[i]))
			special++;
	}
	printf("\n No of characters = %d",characters);
	printf("\n No of words = %d",words);
	printf("\n No of special characters = %d",special);
}

/*
       *** OUTPUT ***
 Enter the string :India,China and USA are big countries.

 No of characters = 38
 No of words = 7
 No of special characters = 2
*/
