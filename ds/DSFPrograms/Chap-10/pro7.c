/*Program 10.7 : A sample program for counting nodes in generalised linked list.*/
#define MAX 20
#include<stdio.h>
#include<conio.h>
typedef struct node
{
	int flag;
	union
	{
		int data;
		int head;
	}data_head;
	int next;
}node;
int count(int);
node GL[MAX];
void main()
{
	int n,i,field1,field2,field3;
	printf("\nEnter no of triples :");
	scanf("%d",&n);
	printf("\nEnter the triple(flag,data_head,next) :");
	for(i=0;i<n;i++)
	{
		scanf("%d%d%d",&field1,&field2,&field3);
		GL[i].flag=field1;

		GL[i].data_head.data=field2;
		GL[i].next=field3;
	}
	n=count(GL[0].next);
	printf("\nNo. of nodes = %d",n);
	getch();
}
int count(int p)
{         printf("\n%d",p);
	if(p==0)
		return(0);
	if(GL[p].flag==0)
		return(1+count(GL[p].next));
	return(1+count(GL[p].next)+count(GL[p].data_head.head));
}
/*
         *** OUTPUT ***
Enter no of triples : 9
Enter the triple(flag,data_head,next) :0 0 1
0 1 2
0 2 3
1 5 4
0 6 0
0 3 6
1 7 0
0 4 8
0 5 0
No. of nodes = 8
*/
