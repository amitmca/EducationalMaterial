#include<stdio.h>
#include<conio.h>
void main()
	{
	char *str,*temp;
	int len[20],i,l,n,max;
	clrscr();
	i=0;
	while(strcmp(str,"stop")!=0)
		{
		gets(str);
		/*if(strcmp(str,"stop")!=0)
			{
			strcpy(temp,str);
			}*/
		if(strcmp(str,"stop")!=0)
			{
			l=0;
			while(*str!='\0')
				{
				str++;
				l++;
				len[i]=l;
				}
			}
		i++;
		}
	n=i;
/*	for(i=0;i<n;i++)
	printf("%d\n",len[i]);
	*/
	max=len[0];
	for(i=0;i<n;i++)
		{
		if(len[i]>max)
			{
			max=len[i];
			}
		}
	printf("\nThe maximum length is:%d",max);
	getch();
	}
