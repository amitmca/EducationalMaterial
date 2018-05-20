// sprintf() ==> write output to an array of characters
// sscanf()  ==> read characters from a string and convert it and store them in C varibales according to specified formats
#include<stdio.h>
main()
	{
	int i=5;
	float f=2.3;
	char ch='A';
	char str[20];
	system("clear");
	sprintf(str,"%d %f %c",i,f,ch);
	printf("\n%s\n",str);
	}
