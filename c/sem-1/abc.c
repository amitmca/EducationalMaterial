#include<stdio.h>
#include<conio.h>
void main(void)
	{
	int A=65,i,j,temp,n,sp=-1;
	clrscr();
	printf("\nHow many lines:");
	scanf("%d",&n);
	temp=n;
	for(i=1;i<=n;i++)
		{
		if(i==1)
			{
			for(j=temp;j>0;j--)
				{
				printf("%c",A++);
				}
			A=A-2;
			for(j=temp-1;j>0;j--)
				{
				printf("%c",A--);
				}
			printf("\n");
			}
		else
			{
			A=65;
			for(j=temp-1;j>0;j--)
				{
				printf("%c",A++);
				}
			A--;
			sp=sp+2;
			for(j=1;j<=sp;j++)
				printf(" ");
			for(j=temp-1;j>0;j--)
				{
				printf("%c",A--);
				}
			printf("\n");
			temp--;
			}
		}
	getch();
	}