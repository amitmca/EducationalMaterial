/*Program 4.19 : Program to find substring.*/
#include<stdio.h>
#include<string.h>
int search(char[],char[]);
void main()
{
	char a[100],b[40];
	int loc;
	printf("\n Enter the main string :");
	gets(a);
	printf("\n Enter the search string :");
	gets(b);
	loc = search(a,b);
	if(loc==-1)
		printf("\nnot found");
	else
	printf("\nfound at location %d",loc+1);
	getch();
}
int search(char a[],char b[])
{
	int i,j,k;
	i=0,j=0;
	while(a[i]!='\0')
	{
		while(a[i]!=b[0] && a[i]!='\0')
			i++;
		if(a[i]=='\0')
			return(-1);            //search can not continue
		k=i;
		while(a[i]==b[j] && a[i]!='\0' && b[j]!='\0')
		{
			i++;
			j++;
		}
		if(b[j]=='\0')
			return(k);
		if(a[i]=='\0')
			return(-1);
		i=k+1;
		j=0;
	}
}

/*
         *** OUTPUT ***
 Enter the main string :India

 Enter the search string :di

found at location 3
*/
