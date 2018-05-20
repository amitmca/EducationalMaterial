#include<stdio.h>

struct process
{
	char name[20];
	int at,bt,tat,wt,st,ft;
}p[10],t[10];

int nop,sotat=0,sowt=0,i,j,time;
float aotat=0.0,aowt=0.0;

void input()
{
	printf("\nEnter No of Process:");
	scanf("%d",&nop);
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
	printf("\nName of Process\tArival Time\tBurst Time");
	for(i=0;i<nop;i++)
		printf("\n%s\t\t%d\t\t%d\n",p[i].name,p[i].at,p[i].bt);
}

void fcfs()
{
	time=0;
	sortarival();
	display();
	for(i=0;i<nop;i++)
	{
		p[i].st=time;
		p[i].ft=p[i].bt+p[i].st;
		p[i].wt=p[i].st-p[i].at;
		p[i].tat=p[i].ft-p[i].at;
		time=p[i].ft;
		sotat+=p[i].tat;
		sowt+=p[i].wt;
	}
	aotat=sotat/(float)nop;
	aowt=sowt/(float)nop;
}

void output()
{
	for(i=0;i<nop;i++)
	{
		printf("\nName of Process:%s",p[i].name);
		printf("\nTurn Around Time:%d",p[i].tat);
		printf("\nWaiting Time:%d",p[i].wt);
	}
	printf("\nAverage Of Turn Around Time:%f",aotat);
	printf("\nAverage Of Waiting Time:%f\n",aowt);
}

void sortarival()
{
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
}

main()
{
	input();
	display();
	fcfs();
	output();
}
