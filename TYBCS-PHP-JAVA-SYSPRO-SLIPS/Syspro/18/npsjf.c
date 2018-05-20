#include<stdio.h>
struct process
{
	char pname[20];
	float at,bt,tat,wt,st,ft;
}p[10];
int n,sumt=0,sumw=0,i;
float avgwt,avgtat,idle;

void input()
{
	printf("Enter no. of process:");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		printf("Enter name of process,arrival time and burst time:");
		scanf("%s\t%f\t%f",&p[i].pname,&p[i].at,&p[i].bt);
	}
}

void display()
{
	printf("Name\tArrivaltime\t\tBursttime\n");
	for(i=0;i<n;i++)
	{
		printf("%s\t%f\t\t%f\n",p[i].pname,p[i].at,p[i].bt);
	}
}

void sort_by_burst()
{
	struct process temp;
	int j;
	for(i=0;i<n;i++)
	{
		for(j=i+1;j<n;j++)
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

void sjf()
{
	float time=0.0;
	sort_by_burst();
	for(i=0;i<n;i++)
	{
		if(p[i].at==0)
		{
			p[i].st=time;
			p[i].ft=p[i].bt+p[i].st;
			p[i].wt=p[i].st-p[i].at;
			p[i].tat=p[i].ft-p[i].at;
			sumw=p[i].wt+sumw;
			sumt=p[i].tat+sumt;
			time=p[i].ft;

		}
	}
	for(i=0;i<n;)
	{
		if(p[i].at!=0)
		{
			if(time>=p[i].at)
			{
				p[i].st=time;
				p[i].ft=p[i].bt+p[i].st;
				p[i].wt=p[i].st-p[i].at;
				p[i].tat=p[i].ft-p[i].at;
				sumw=p[i].wt+sumw;
				sumt=p[i].tat+sumt;
				time=p[i].ft;
				i++;
			}
			else
			{
				idle=p[i].at-time;
				time=p[i].at;
				printf("CPU is idle for %f time\n",idle);
			}
		}
		else
		{
			i++;
		}
	}
}

void output()
{
	printf("Name\tWt\t\ttat\n");
	for(i=0;i<n;i++)
	{
		printf("%s\t%f\t%f\n",p[i].pname,p[i].wt,p[i].tat);
	}
	avgwt=sumw/n;
	avgtat=sumt/n;
	printf("Average of waitng time is:%f\n",avgwt);
	printf("Average of turn around time:%f\n",avgtat);
}

main()
{
	input();
	display();
	sjf();
	display();
	output();
}
