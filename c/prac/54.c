#include<stdio.h>
#include<conio.h>
char a[20],*ptr;
int i=0,j,k;
void main()
{
	char name[20];
	clrscr();
	printf("\n\nEnter the string:");
	gets(name);
	CommonCharcter(name);
	getch();
}
CommonCharcter(char *ptr)
{
	while(*ptr!='\0')
	{
		a[i]=*ptr;
		ptr=ptr+1;
		i++;
	}
	printf("\n\nThe common charcter in the string is:");
	for(j=0;j<=i-1;j++)
	{
		for(k=0;k<=i-1;k++)
		{
			if(j==k)
			break;
			if(a[j]==a[k])
				printf("%c",a[j]);
		}
	}

return 0;
}
