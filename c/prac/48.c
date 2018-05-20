#include<stdio.h>
main()
{
	char name[20],name1[20],k,str[20];
	clrscr();
	printf("\n\nEnter the first name:");
	scanf("%s",name);
	printf("\nEnetr the secoond name:");
	scanf("%s",name1);
	printf("\n\nEnter the pos:");
	scanf("%d",&k);
	str=Xstuff(name,k,name1);

}
void Xstuff(char *name,int k,char *name1)
{
	int i=0;
	while(*name!='\0')
	{
		i++;
		if(i==k)
		{
			while(*name1!='\0')
			{
				printf("%c",*name1);
				name1++;
			}
		}
		printf("%c",*name);
		name++;
	}
}
