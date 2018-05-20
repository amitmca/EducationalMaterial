#include<stdio.h>
#define MAX 100

int queue[MAX];
int front=0,rear=0,c=0;


void Add(int n)
	{
		if(rear==MAX-1)
			printf("\n Queue is full");
		else	
			{
			queue[rear++]=n;
			front++;
			c++;			
			}
	}
	
int Delete()
	{
		int t;
		if(front==0)
			printf("\n Queue is empty");
		else	
			t=queue[front--];
			return(t);			
	}
int main()
	{
		char ch='y';
		int value,i,d;
		do
			{
				printf("\n Enter the element to add:");
				scanf("%d",&value);
				Add(value);
				printf("\n Another(y/n):");
				ch=getche();
			}while(ch=='y');
			
		for(front=0;front<rear;front++)
			printf("\n%d\n",queue[front]);	
		d=Delete();
		for(front=0;front<rear;front++)
			printf("\n%d\n",queue[front]);				
		return 0;
	}
