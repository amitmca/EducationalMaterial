//SJF nonpre-emptive algorithm
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct process
{
char pname[30];
int at,bt,tat,ft,st,wt,prio;
}p[10],temp;

int nop=0,sum_of_tat=0,sum_of_wt=0,avg_of_tat=0,avg_of_wt=0,pr;



void input()
{
	int i;
	printf("enter how many process\n");
	scanf("%d",&nop);

	for(i=0;i<nop;i++)
	 {
		printf("enter process name,burst time and arrival time,priority\n");
		scanf("%s%d%d%d",p[i].pname,&p[i].bt,&p[i].at,&p[i].prio);
	}
	printf("enter priority 1 for highest and 0 for lowest\n");
	scanf("%d",&pr);
}
	
void display()
{
	int i;
	printf("***********PROCESS INFO**************\n");	
	printf("\nprocess name\tburst time\tarrival time\tpriority\n");
	for(i=0;i<nop;i++)
	 {
		printf("%s\t\t%d\t\t%d\t\t%d\n",p[i].pname,p[i].bt,p[i].at,p[i].prio);
	 }
}


void priority()
{
	sortbyp();

	int time=0,i;
	
	for(i=0;i<nop;i++)
	 {
	   if(p[i].at==0)
	    {
	   p[i].st=time;
	   p[i].ft=p[i].bt+p[i].st;
	   p[i].wt=p[i].st-p[i].at;
	   p[i].tat=p[i].ft-p[i].at;
	   time=p[i].ft;
	   sum_of_wt=sum_of_wt+p[i].wt;
	   sum_of_tat=sum_of_tat+p[i].tat;
	    }
	}

	for(i=0;i<nop;i++)
	 {
	   if(p[i].at!=0)
	   {
	   p[i].st=time;
	   p[i].ft=p[i].bt+p[i].st;
	   p[i].wt=p[i].st-p[i].at;
	   p[i].tat=p[i].ft-p[i].at;
	   time=p[i].ft;
	   sum_of_wt=sum_of_wt+p[i].wt;
	   sum_of_tat=sum_of_tat+p[i].tat;
	  }
	}

	avg_of_wt=(sum_of_wt)/nop;
	avg_of_tat=(sum_of_tat)/nop;

}

void output()
{
	int i=0;

	printf("*********PROCESS INFO*************\n");
	printf("\nprocess name\tburst time\tarrival time\twaiting time\tturn around time\n");
	for(i=0;i<nop;i++)
	 {
		printf("%s\t\t%d\t\t%d\t\t%d\t\t%d\n",p[i].pname,p[i].bt,p[i].at,p[i].wt,p[i].tat);
	 }
	
	printf("sum of waiting time=%d\n",sum_of_wt);
	printf("sum of turn around time=%d\n",sum_of_tat);  
	printf("average of waiting time=%d\n",avg_of_wt);
	printf("average of waiting time=%d\n",avg_of_tat);
}
	 

void sortbyp()
{
	int i,j;

	if(pr==0)
         {
	for(i=0;i<nop-1;i++)
	{
	for(j=i+1;j<nop;j++)
	{
		if(p[i].prio>p[j].prio)
		 {
			temp=p[i];
			p[i]=p[j];
			p[j]=temp;
		 }
       	}
         }
	}

	else if(pr==1)
	{
	for(i=nop;i>nop-1;i--)
	{
	for(j=i+1;j<nop;j++)
	{
		if(p[i].bt>p[j].bt)
		{
			temp=p[i];
			p[i]=p[j];
			p[j]=temp;
		 }
       	}
         }
	}
	display();
}

main()
{
	input();
	display();
	priority();
	output();
	
}
