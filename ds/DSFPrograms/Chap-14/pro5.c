/*Program 14.5 :Program to implement BFS traversal on a graph represented using adjacency matrix.*/
#include<conio.h>
#include<stdio.h>
#define MAX 10
typedef struct Q
{
	int R,F;
	int data[MAX];
}Q;
int empty(Q *P);
int full(Q *P);
void enqueue(Q *P,int x);
int dequeue(Q *P);
void BFS(int);
int G[MAX][MAX];
int n;
void main()
{
	int i,j,v;
	printf("\nEnter no of vertices : ");
	scanf("%d",&n);
	printf("\nEnter the adjecendy matrix of  graph : ");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&G[i][j]);
	printf("\nEnter the starting vertex for BFS");
	scanf("%d",&v);
	BFS(v);
	getch();
}
void BFS(int v)
{
	int visited[MAX],i;
	Q q;
	q.R=q.F=-1;
	for(i=0;i<n;i++)
		visited[i]=0;
	enqueue(&q,v);
	printf("\n visit\t%d",v);
	visited[v]=1;
	while(!empty(&q))
	{
		v=dequeue(&q);
		// visit and add adjecency vertices
		for(i=0;i<n;i++)
			if(visited[i]==0 && G[v][i]!=0)
			{
				enqueue(&q,i);
				visited[i]=1;
				printf("\nvisit\t%d",i);
			}
	}
}
int empty(Q *P)
{
	if(P->R==-1)
		return(1);
	return(0);
}

int full(Q *P)
{
	if(P->R==MAX-1)
		return(1);
	return(0);
}
void enqueue(Q *P,int x)
{
	if(P->R==-1)
	{
		P->R=P->F=0;
		P->data[P->R]=x;
	}
	else
	{
		P->R=P->R+1;
		P->data[P->R]=x;
	}
}
int dequeue(Q *P)
{
	int x;
	x=P->data[P->F];
	if(P->R==P->F)
	{
		P->R=-1;
		P->F=-1;
	}
	else
		P->F=P->F+1;
	return(x);
}

/*
           *** OUTPUT ***
Enter no of vertices : 8
Enter no of vertices : 8

Enter the adjecendy matrix of  graph :
0 1 1 1 1 0 0 0
1 0 0 0 0 1 0 0
1 0 0 0 0 1 0 0
1 0 0 0 0 0 1 0
1 0 0 0 0 0 1 0
0 1 1 0 0 0 0 1
0 0 0 1 1 0 0 1
0 0 0 0 0 1 1 0

Enter the starting vertex for BFS 0

 visit  0
visit   1
visit   2
visit   3
visit   4
visit   5
visit   6
visit   7
*/
