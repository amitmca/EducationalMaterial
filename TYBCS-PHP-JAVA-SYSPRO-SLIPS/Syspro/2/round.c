#include<stdio.h>

struct process
{
	char name[20];
	int at,bt,tat,wt,st,ft;
}p[10],t[10];

int tq,nop,sotat=0,sowt=0,time=0;
float aotat=0.0,aowt=0.0;

void input()
{
	int i,j;
	printf("\nEnter No of Process:");
	scanf("%d",&nop);
	
	printf("\nEnter the timeQuqntam :");
	scanf("%d",&tq);		

	for(i=0;i<nop;i++)
	{
		printf("\nEnter Name of Process %d:",i+1);
		scanf("%s",p[i].name);
		printf("\nEnter Arrival Time of %d:",i+1);
		scanf("%d",&p[i].at);
		printf("\nEnter Burst Time of %d:",i+1);
		scanf("%d",&p[i].bt);		
	}
}
void display()
{
	int i,j;
	printf("\nName of Process\tArival Time\tBurst Time");
	for(i=0;i<nop;i++)
		printf("\n%s\t\t%d\t\t%d\n",p[i].name,p[i].at,p[i].bt);
}

void sortarival()
{
	int i,j;
	printf("\nAfter Sorting\n");
	for(i=0;i<nop;i++)
	{
		for(j=i+1;j<nop;j++)
		{
			if(p[i].at>p[j].at)
			{
				t[i]=p[i];
				p[i]=p[j];
				p[j]=t[i];
			}
		}
	}
	display();
}

void output()
{
	int i;
	printf("\n-No of P--\t--TAT--\t\t\t--WT--\t\n");
	for(i=0;i<nop;i++)
	{
		printf("\n %s \t\t %f \t\t %f \t \n",p[i].name,p[i].tat,p[i].wt);
	}
	printf("\nAverage Of Turn Around Time:%f",aotat);
	printf("\nAverage Of Waiting Time:%f\n",aowt);
}
void round1()
{
	sortarival();
	int i=0,j=0;
	while(j<nop)
	{
		if(p[i].bt<tq)
		{
			p[i].st=time;
			p[i].ft=p[i].st+p[i].bt;
			time=p[i].ft;
			p[i].bt=0;
		}
		else
		{
			p[i].st=time;
			p[i].ft=p[i].st+tq;
			time=p[i].ft;
			p[i].bt-=tq;
		}
		i++;
		if(p[i].bt==0)
		j++;
		if(i==nop)
		i=0;	
	}	
}
main()
{
	input();
	display();
	round1();
	output();
}
