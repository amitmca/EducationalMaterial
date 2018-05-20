#include<stdio.h>

struct process
{
	char name[20];
	int at,bt,tat,wt,st,ft;
}p[10],t[10];

int nop,sotat=0,sowt=0,time=0;
float aotat=0.0,aowt=0.0;

void input()
{
	int i,j;
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

void sjf()
{
	int i,j,lft;
	int b[20];	
	
	sortarival();
	for(i=0;i<nop;i++)
	{
		b[i]=p[i].bt;
	}
	p[0].st=0;
	p[0].ft=p[0].st+1;
	p[0].bt=p[0].bt-1;
	time=p[0].ft;
	i=0;

	p[0].wt=p[0].st-p[0].at;


	while(i<nop)
	{
		j=selection();
		lft=p[j].ft	;	
		p[j].st=time;
		p[j].ft=p[j].st+1;
		p[j].bt=p[j].bt-1;
		time=p[j].ft;
		if(p[j].bt==b[j]-1)
		p[j].wt=p[j].st-p[j].at;
		else 
		p[j].wt+=p[j].st-lft;
		
		if(p[j].bt==0)
		i++;
		printf("i=%d\tj=%d\tst=%d\tft=%d\t wt=%d\tname=%s\n",i,j,p[j].st,p[j].ft,p[j].wt,p[j].name);
	}	
	for(i=0;i<nop;i++)
	{
		p[i].tat=p[i].ft-p[i].at;
		printf("\nWT=%d TAT=%d",p[i].wt,p[i].tat);
		sotat+=p[i].tat;
		sowt+=p[i].wt;
	}
	aotat=sotat/nop;
	printf("\nAVG TAT=%f",aotat);
	
	aowt=sowt/nop;
	printf("\nAVG WT=%f",aowt);

}

int selection()
{
	int i,k,min=1000;
	for(i=0;i<nop;i++)
	{
		if(time>=p[i].at && min>p[i].bt && p[i].bt!=0)
		{
			min=p[i].bt;
			k=i;
		}
	}
	return k;
}

main()
{
	input();
	display();
	sjf();
}
