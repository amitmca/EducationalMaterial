/*Program 14.6 :Program to implement BFS traversal on a graph implemented through adjacency list.*/
#include<conio.h>
#include<stdio.h>
#include<stdlib.h>
#define MAX 20
typedef struct Q
{
	int data[MAX];
	int R,F;
}Q;
typedef struct node
{
	struct node *next;
	int vertex;
}node;
void enqueue(Q *,int);
int dequque(Q *);
int empty(Q *);
int full(Q *);
void BFS(int);
node *G[20];        		//heads of the linked list
int n;               			// no of nodes
void readgraph();    		//create an adjecency list
void insert(int vi,int vj);     //insert an edge (vi,vj)in adj.list
void main()
{
	int i;
	readgraph();
	BFS(0);
}
void BFS(int v)
{
	int i,visited[MAX],w;
	Q q;
	node *p;
	q.R=q.F=-1;              //initialise
	for(i=0;i<n;i++)
		visited[i]=0;
	enqueue(&q,v);
	printf("\n Visit\t%d",v);
	visited[v]=1;
	while(!empty(&q))
	{
		v=dequeue(&q);
		//insert all unvisited,adjacent vertices of v into queue
		for(p=G[v];p!=NULL;p=p->next)
		{
			w=p->vertex;
			if(visited[w]==0)
			{
				enqueue(&q,w);
				visited[w]=1;
				printf("\nvisit\t%d",w);
			}
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
void readgraph()
{
	int i,vi,vj,no_of_edges;
	printf("\nEnter no. of vertices :");
	scanf("%d",&n);
	//initialise G[] with NULL
	for(i=0;i<n;i++)
		G[i]=NULL;
	//read edges and insert them in G[]
	printf("\nEnter no of edges :");
	scanf("%d",&no_of_edges);
	for(i=0;i<no_of_edges;i++)
	{
		printf("\nEnter an edge (u,v)  :");
		scanf("%d%d",&vi,&vj);
		insert(vi,vj);
		insert(vj,vi);
	}
}
void insert(int vi,int vj)
{
	node *p,*q;
	//acquire memory for the new node
	q=(node *)malloc(sizeof(node));
	q->vertex=vj;
	q->next=NULL;
	//insert the node in the linked list for the vertex no. vi
	if(G[vi]==NULL)
		G[vi]=q;
	else
	{
		// go to the end of linked list
		p=G[vi];
		while(p->next!=NULL)
			p=p->next;
		p->next=q;
	}
}

/*
      *** OUTPUT ***
Enter no. of vertices :8
Enter no of edges :10
Enter an edge (u,v)  :0 1
Enter an edge (u,v)  :0 2
Enter an edge (u,v)  :0 3
Enter an edge (u,v)  :0 4
Enter an edge (u,v)  :1 5
Enter an edge (u,v)  :2 5
Enter an edge (u,v)  :3 6
Enter an edge (u,v)  :4 6
Enter an edge (u,v)  :5 7
Enter an edge (u,v)  :6 7


 visit  0
visit   1
visit   2
visit   3
visit   4
visit   5
visit   6
visit   7
*/
