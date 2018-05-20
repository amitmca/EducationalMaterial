/*Program 14.1 :Program to compute the indegree and outdegree of every vertex of a directed graph when the graph is represent by an adjacency matrix.*/
#include<conio.h>
#include<stdio.h>
void main()
{
	int G[10][10],n,i,j,i_degree,o_degree;
	printf("\nEnter no of nodes : ");
	scanf("%d",&n);
	// read the adjecency matrix
	printf("\nEnter adjecency matrix of the ghaph :");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			scanf("%d",&G[i][j]);
		}
	// indegree of node i=no. of 1's in i'th column
	// outdegree if node i=no. of 1's in i'th row
	for(i=0;i<n;i++)
	{
		i_degree=0;
		for(j=0;j<n;j++)
			if(G[j][i]!=0)
				i_degree++;
		o_degree=0;
		for(j=0;j<n;j++)
			if(G[i][j]!=0)
				o_degree++;
		printf("\n node number %d\tindegree=%d\toutdegree=%d",i,i_degree,o_degree);
	}
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
