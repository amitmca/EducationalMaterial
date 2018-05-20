#include<stdio.h>
#include<conio.h>
main(int argc,char *argv[])
	{
	int n[10],i,max,min,c,j,t;
	clrscr();
	c=0;
	for(i=1;i<argc;i++)
		{
		n[i]=atoi(argv[i]);
		c++;
		}
	max=n[0];
	for(i=1;i<=c;i++)
		{
		if(max>n[i])
			{
			printf("\nMaximum elements is:%d\n",max);
			break;
			}
		else
			{
			max=n[i];
			}
		}
	min=n[0];
	for(i=1;i<=c;i++)
		{
		if(min<n[i])
			{
			printf("\nMinimum elements is:%d\n",min);
			break;
			}
		else
			{
			min=n[i];
			}
		}
	for(i=1;i<=c;i++)
		{
		for(j=1;j<=c;j++)
			{
			if(n[i]<n[j])
				{
				t=n[i];
				n[i]=n[j];
				n[j]=t;
				}
			}
		}
	printf("\nThe Sorted Elements are:\n");
	for(i=1;i<=c;i++)
		{
		printf("\n%d\n",n[i]);
		}
	getch();
	return 0;
	}
