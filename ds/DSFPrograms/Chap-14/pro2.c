/*Program 14.2 :Program to compute the indegree and outdegree of every vertex of a directed graph when the graph is represented by an adjacency matrix.*/
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct node
{
	struct node *next;
	int vertex;
}node;
node * G[20];
/* An array of pointers G[i] is the head of the list of adjencency
   vertices of node i represented using a linked list */
int n;
void read_graph();
int in_degree(int v);
int out_degree(int v);
void insert(int vi,int vj);
void main()
{
	int i_degree,o_degree,i;
	read_graph();
	for(i=0;i<n;i++)
	{
		i_degree=in_degree(i);
		o_degree=out_degree(i);
		printf("\nNode No=%d\tindegree=%d\toutdegree=%d",i,i_degree,o_degree);
	}
}
void read_graph()
{
	int i,vi,vj,no_of_edges;
	printf("\nEnter no of vertices : ");
	scanf("%d",&n);
	// initialise G[] with a null
	for(i=0;i<n;i++)
	{
		G[i]=NULL;
		// read edges and insert them in G[]
		printf("\nEnter no of edges : ");
		scanf("%d",&no_of_edges);
		for(i=0;i<no_of_edges;i++)
		{
			printf("\nEnter an edge (u,v) :");
			scanf("%d%d",&vi,&vj);
			insert(vi,vj);
		}
	}
}
void insert(int vi,int vj)
{
	node *p,*q;
	// acquire memory for the new node
	q=(node *)malloc(sizeof(node));
	q->vertex=vj;
	q->next=NULL;
	//insert the node in the linked list number vi
	if(G[vi]==NULL)
		G[vi]=q;
	else
	{
		// go to end of linked list
		p=G[vi];
		while(p->next!=NULL)
			p=p->next;
		p->next=q;
	}
}
int out_degree(int v)
{
	node *p;
	int o_degree=0;
	p=G[v];
	//count number of nodes in the linked list p
	while(p!=NULL)
	{
		o_degree++;
		p=p->next;
	}
	return(o_degree);
}
int in_degree(int v)
{
	node *p;
	int in_degree,i;
	//all linked list must be searched for the vertex
	in_degree=0;
	for(i=0;i<n;i++)
	{
		p=G[i];
		while(p!=NULL)
		{
			if(p->vertex==v)
				in_degree++;
			p=p->next;
		}
	}
	return(in_degree);
}

/*
             *** OUTPUT ***

Enter no of nodes : 6
Enter adjecency matrix of the ghaph :0 0 1 0 1 0
0 0 1 1 0 0
0 0 0 0 0 0
0 0 0 0 0 1
0 1 0 1 0 0
1 0 0 0 0 0
node number 0  indegree=1      outdegree=2
node number 1  indegree=1      outdegree=2
node number 2  indegree=2      outdegree=0
node number 3  indegree=2      outdegree=1
node number 4  indegree=1      outdegree=2
node number 5  indegree=1      outdegree=1
*/
