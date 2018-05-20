//Program to Create Adjucency matrix and calculation of In degree and out degree

#include<stdio.h>
#include<conio.h>

void Create(int m[20][20],int n)
	{
	int r,c;
	for(r=0;r<n;r++)
		{
		for(c=0;c<n;c++)
			{
			m[r][c]=0;
			if(r!=c)
				{
				printf("\n Is there an edge between vertex %d and %d (1/0):",r+1,c+1);
				scanf("%d",&m[r][c]);
				}
			}
		}
	}
void Print(int m[20][20],int n)
	{
	int r,c;
	printf("\nThe Adjucency Matrix is.....\n\n");
	for(r=0;r<n;r++)
		{
		for(c=0;c<n;c++)
			{
			printf("%d\t",m[r][c]);
			}
		printf("\n\n");
		}
	}
void Degree(int m[20][20],int n)
	{
	int r,c,in,out,v;
	printf("\nVertex\t\tIn\t\tOut\t\tTotal\n\n");
	for(v=0;v<n;v++)
		{
		in=0;
		for(r=0;r<n;r++)
			in=in+m[r][v];
		out=0;
		for(c=0;c<n;c++)
			out=out+m[v][c];
		printf("\n%d\t\t%d\t\t%d\t\t%d\n\n",v+1,in,out,in+out);
		delay(800);
		}
	}
void main()
	{
	int n,m[20][20];
	clrscr();
	printf("\nHow many vertices:");
	scanf("%d",&n);
	Create(m,n);
	clrscr();
	Print(m,n);
	Degree(m,n);
	getch();
	}
