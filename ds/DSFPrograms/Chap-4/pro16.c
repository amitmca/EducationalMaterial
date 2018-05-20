/*Program 4.16 : Program to copy a string.*/
#include<stdio.h>
#include<conio.h>
void main()
{
	char s1[100],s2[100];
	int i;
	//reading a string and finding its length
	printf("\n Enter the string :");
	gets(s1);
	/* array is scanned from left to right and while scanning s1,each character is  copied  to  the array s2  */
	i=0;
	while(s1[i]!='\0')
	{
		s2[i]=s1[i];
		i++;
	}
	//since the '\0' is not copied
	s2[i]='\0';
	printf("\n result is %s ",s2);
	getch();
}
/*
        *** OUTPUT ***
 Enter the string :data-structure
 result is data-structure
*/

