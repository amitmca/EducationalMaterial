#include<stdio.h>
int nos,nosym,nof,i,j,ch;
char insym[10],str[20];
int f[10],transition[10][10];
void accept()
{
	printf("Enter how many states you want\n");
	scanf("%d",&nos);
	printf("Enter one by one states");
	for(i=0;i<nos;i++)
	{
		scanf("%d",&transition[i]);
	}
	printf("Enter how many symbol you want\n");
	scanf("%d",&nosym);
	printf("Enter one by one symbols");
	for(i=0;i<nosym;i++)
	{
		scanf("%c",&insym[i]);
		scanf("%c",&insym[i]);
	}
	printf("Enter how many final states\n");
	scanf("%d",&nof);
	printf("Enter one by one final states");
	for(i=0;i<nof;i++)
	{
		scanf("%d",&f[i]);
	}
	for(i=0;i<nos;i++)
	{
		for(j=0;j<nosym;j++)
		{
			printf("\nEnter transition from q%d for input symbol %c",i,insym[j]);
			scanf("%d",&transition[i][j]);
		}
	}
}
void display()
{
	printf("The transition table is as follows\n"); 	
	for(i=0;i<nos;i++)
	{
		for(j=0;j<nosym;j++)
		{
			printf("q%d\t",transition[i][j]);
		}
		printf("\n  ");
	}	
}
void execute()
{
	int curr,flag;
	do{
	int flag=0,curr=0;
	printf("Enter string to check\n");
	scanf("%s",str);
	for(i=0;str[i]!='\0';i++)
	{
		for(j=0;j<nosym;j++)
		{
			if(str[i]==insym[j])
			{
				curr=transition[curr][j];
			}
		}
	}
	for(i=0;i<nof;i++)
	{
		if(f[i]==curr)
		flag=1;
	}
	if(flag==1)
	printf("Entered string is correct\n");
	else
	printf("Entered string is incorrect");
	printf("Do you want to continue...press(1/0)\n");
	scanf("%d",&ch); 
	}while(ch==1);
	
}

main()
{
	accept();
	display();
	execute();
}
