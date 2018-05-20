/*BSF and DSF on a graph represented using adjacency matrix*/
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
void DFS(int);
int G[MAX][MAX];
int n=0;
int visited[MAX];
void main()
{
	int i,j,v,op;
	printf("\nEnter no of vertices : ");
	scanf("%d",&n);
	printf("\nEnter the adjecendy matrix of  graph : ");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&G[i][j]);

	do{
	   printf("\n\n1)DFS\n2)BFS\n3)QUIT");
	   printf("\nEnter Your choice : ");
	   scanf("%d",&op);
	   switch(op)
	    { case 1:printf("\nEnter the starting vertex for DFS : ");
		     scanf("%d",&v);
		     for(i=0;i<n;i++)
		       visited[i]=0;
		     DFS(v);break;
	      case 2:printf("\nEnter the starting vertex for BFS : ");
		     scanf("%d",&v);
		     BFS(v);break;
	    }
	  }while(op!=3);

}

void BFS(int v)
{
	int visited[MAX],i;
	Q q;
	q.R=q.F=-1;
	for(i=0;i<n;i++)
	  visited[i]=0;
	enqueue(&q,v);
	printf("\n visit\n",v);
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
				printf("\n%d",i);
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

void DFS(int i)
{
	int j;
	printf("\n%d",i);
	visited[i]=1;
	for(j=0;j<n;j++)
		if(!visited[j] && G[i][j]==1)
			DFS(j);
}

/*
                *** OUTPUT ***
Enter no of vertices : 4

Enter the adjecendy matrix of  graph :
0 1 0 1
0 0 0 1
0 1 0 1
0 0 0 0

1)DFS
2)BFS
3)QUIT
Enter Your choice : 1

Enter the starting vertex for DFS : 2

2
1
3

1)DFS
2)BFS
3)QUIT
Enter Your choice : 2

Enter the starting vertex for BFS : 2

 visit

1
3

1)DFS
2)BFS
3)QUIT
Enter Your choice :3
*/
