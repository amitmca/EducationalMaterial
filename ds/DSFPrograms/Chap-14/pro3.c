/*Program 14.3 :Program to implement DFS traversal on a graph represented using an adjacency matrix.*/
#include<conio.h>
#include<stdio.h>
void DFS(int);
int G[10][10],visited[10],n;
// n->no of vertices
// graph is stored in array G[10][10]
void main()
{
	int i,j;
	printf("\nEnter no of vertices: ");
	scanf("%d",&n);
	// read the adjecency matrix
	printf("\nEnter adjecency matrix of the ghaph :");
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&G[i][j]);

	// visited is initialise to zero
	for(i=0;i<n;i++)
		visited[i]=0;
	DFS(0);
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
Enter no of vertices: 8

Enter adjecency matrix of the ghaph :0 1 1 1 1 0 0 0
1 0 0 0 0 1 0 0
1 0 0 0 0 1 0 0
1 0 0 0 0 0 1 0
1 0 0 0 0 0 1 0
0 1 1 0 0 0 0 1
0 0 0 1 1 0 0 1
0 0 0 0 0 1 1 0

0
1
5
2
7
6
3
4
*/
