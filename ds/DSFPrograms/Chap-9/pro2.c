/*Program 9.2 : Program showing sorting of strings using insertion sort.*/
#include<conio.h>
#include<stdio.h>
#include<string.h>
void insertion_sort(char[][20],int);
void main()
{
	char a[10][20];
	int i,n;
	printf("\n Enter no of strings :");
	scanf("%d",&n);
	printf("\nEnter strings :");
	for(i=0;i<n;i++)
		scanf("%s",a[i]);
	insertion_sort(a,n);
	printf("\n Sorted strings :\n");
	for(i=0;i<n;i++)
		printf("%s\t",a[i]);
	getch();
}
void insertion_sort(char a[][20],int n)
{
	int i,j;
	char temp[20];
	for(i=0;i<n;i++)
	{
		strcpy(temp,a[i]);
		for(j=i-1;j>=0 && strcmp(a[j],temp)>0;j--)
			strcpy(a[j+1],a[j]);
		strcpy(a[j+1],temp);
	}
}
/*
         *** OUTPUT ***
 Enter no of strings :5

Enter strings :abc xyz aaa bbb ccc

 Sorted strings :
aaa     abc     bbb     ccc     xyz

*/
