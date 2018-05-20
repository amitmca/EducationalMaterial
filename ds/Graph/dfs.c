// Program for DFS of Graph

#include<stdio.h>
#include<conio.h>

struct stack
	{
	int data[20];
	int top;
	}s;

void push(int n)
	{
	s.data[++s.top]=n;
	}
int pop()
	{
	return(s.data[s.top--]);
	}
void init()
	{
	s.top=-1;
	}
int isempty()
	{
	return(s.top==-1);
	}
void NonRecDFS(int m[20][20],int n)
	{
	int v,w;
	int visited[20]={0};
	init();
	v=0;
	visited[v]=1;
	push(v);
	delay(500);
	printf("\nV%d\t",v+1);
	while(1)
		{
		for(w=0;w<n;w++)
			{
			if((m[v][w]==1) && (visited[w]==0))
				{
				push(w);
				delay(500);
				printf("V%d\t",w+1);
				visited[w]=1;
				}
			}
		if(isempty())
			break;
		else
			v=pop();
		}
	printf("\n");
	}
void RecDFS(int m[20][20],int n,int v)
	{
	int w;
	static int visited[20]={0};
	visited[v]=1;
	delay(500);
	printf("V%d\t",v+1);
	for(w=0;w<n;w++)
		{
		if((m[v][w]==1) && (visited[w]==0))
			{
			RecDFS(m,n,w);
			}
		}
	printf("\n");
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
	printf("\nThe Non Recursive Depth First Search is......\n");
	NonRecDFS(m,n);
	printf("\n\nThe Recursive Depth First Search is......\n\n");
	RecDFS(m,n,0);
	getch();
	}