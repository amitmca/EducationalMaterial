#include<stdio.h>
#include<conio.h>
main()
	{
	int p,l,i,j,sum=0;
	char str[20],*s;
	clrscr();
	printf("\nEnter Your String:");
	scanf("%s",str);
	s=str;
	l=0;
	while(*s!='\0')
		{
		l++;
		s++;
		printf("\n%d",*s);
		}
	p=1;
	for(i=0;i<l;i++)
		{
		for(j=0;j<p;j++)
			{
			printf("%c",str[j]);
			}
		printf("\n");
		p++;
		}
	printf("\n\nSum is:%d",sum);
	getch();
	return 0;
	}