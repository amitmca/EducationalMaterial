#include<stdio.h>
#include<conio.h>
struct queue
	{
	int data[10];
	int front,rear;
	}q[10];
void addq(int n,int i)
	{
	q[i].data[++q[i].rear]=n;
	}
int delq(int i)
	{
	return (q[i].data[++q[i].front]);
	}
void initq()
	{
	int i;
	for(i=0;i<10;i++)
		q[i].front=q[i].rear=-1;
	}
int isempty(int i)
	{
	return q[i].rear==q[i].front;
	}
void print(int x[],int n)
	{
	int i;
	for(i=0;i<n;i++)
		{
		printf("%d\t",x[i]);
		}
	}
void main()
	{
	int a[20],b[20],i,n,j,count,num,k;
	clrscr();
	initq();
	printf("\nHow many numbers:");
	scanf("%d",&n);
	printf("\nEnter the Numbers:");
	for(i=0;i<n;i++)
		{
		scanf("%d",&a[i]);
		b[i]=a[i];
		}
	num=a[0];
	for(count=0;num>0;count++)
		num=num/10;
	for(k=1;k<=count;k++)
		{
		for(i=0;i<n;i++)
			{
			for(j=1;j<k;j++)
				a[i]=a[i]/10;
			addq(b[i],a[i]%10);
			}
		j=0;
		for(i=0;i<10;i++)
			while(!isempty(i))
				b[j++]=delq(i);
		for(i=0;i<n;i++)
			a[i]=b[i];
/*		for(i=0;i<n;i++)
			printf("%d\n",b[i]);*/
		}
	printf("\nThe Sorted Elements are:\n\n");
	print(b,n);
	getch();
	}
