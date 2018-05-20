#include<stdio.h>
#include<stdlib.h>

int nor,nof,ref[20],frame[10]={-1},pg=0;

void accept()
{
	int i,j;
	printf("\n Enter the no of reference \n");
	scanf("%d",&nor);

	printf("\n Enter actual reference string \n");
	for(i=0;i<nor;i++)
	{
		scanf("%d",&ref[i]);
	}

	printf("\n Enter the frame size \n");
	scanf("%d",&nof);

}

int check(int n)
{
	int i;
	int flag=0;
	for(i=0;i<nof;i++)
	{
		if(n==frame[i])
		{
			flag=1;
			break;
		}
		
	}
	if(flag==0)
		return 1;
	else
		return 0;
}


void fifo()
{
	int i,j,count=0;
for(i=0;i<nof;i++)
{
	frame[i]=-1;
}	

	for(i=0;i<nor;i++)
	{
		j=check(ref[i]);
		if(j==1)
		{
			frame[count]=ref[i];
			count++;
			pg++;
			display();
		}
		if(count==nof)
			count=0;
	}
	printf(" \n page fault is= %d \n",pg);
}	

void display()
{
	int i;
	printf("\n Frame:");
	for(i=0;i<nof;i++)
	{
		printf("%d \t  ",frame[i]);
	}
}
void main()
{
	accept();
	fifo();
}
