// Program for BFS of Graph

#include<stdio.h>
#include<conio.h>

struct queue
	{
	int data[20];
	int front,rear;
	}q;

void add(int n)
	{
	q.rear++;
	q.data[q.rear]=n;
	}
int del()
	{
	q.front++;
	return(q.data[q.front]);
	}
void init()
	{
	q.rear=q.front=-1;
	}
int isempty()
	{
	return(q.front==q.rear);
	}
void BFS(int m[20][20],int n)
	{
	int i,j,v,w;
	int visited[20];
	init();
	for(i=0;i<n;i++)
		visited[i]=0;
	v=0;
	visited[v]=1;
	add(v);
	while(!isempty())
		{
		v=del();
		printf("V%d\t",v+1);
		for(w=0;w<n;w++)
			{
			if( (m[v][w]==1) && (visited[w]==0))
				{
				add(w);
				visited[w]=1;
				}
			}
		}
	}
void Create(int m[20][20],int n)
	{
	int r,c;
	for(r=0;r<n;r++)
		{
		for(c=0;c<n;c++)
			{
			m[r][c]=0;
			if(r!=c)
				{
				printf("\n Is there an edge between vertex %d and %d (1/0):",r+1,c+1);
				scanf("%d",&m[r][c]);
				delay(100);
				}
			}
		}
	}
void Print(int m[20][20],int n)
	{
	int r,c;
	printf("\nThe Adjucency Matrix is.....\n\n");
	for(r=0;r<n;r++)
		{
		for(c=0;c<n;c++)
			{
			printf("%d\t",m[r][c]);
			delay(500);
			}
		printf("\n\n");
		}
	}
void main()
	{
	int n,m[20][20];
	clrscr();
	printf("\nHow many vertices:");
	scanf("%d",&n);
	Create(m,n);
	clrscr();
	Print(m,n);
	printf("\nThe Breadth First Search is......\n\n");
	BFS(m,n);
	getch();
	}