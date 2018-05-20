//Program to Create Adjucency List

#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
struct node
	{
	int vertex;
	struct node *next;
	}*v[10];

typedef struct node *GRAPH;
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
			}
		printf("\n\n");
		}
	}
void CreateList(int m[20][20],int n)
	{
	int i,j;
	GRAPH temp,newnode;
	for(i=0;i<n;i++)
		{
		v[i]=NULL;
		for(j=0;j<n;j++)
			{
			if(m[i][j]==1)
				{
				newnode=ALLOC;
				newnode->next=NULL;
				newnode->vertex=j+1;
				if(v[i]==NULL)
					v[i]=temp=newnode;
				else
					{
					temp->next=newnode;
					temp=newnode;
					}
				}
			}
		}
	}
void DisplayList(int n)
	{
	GRAPH temp;
	int i;
	printf("\nAdjucency List is.....\n\n");
	for(i=0;i<n;i++)
		{
		printf("V%d-->",i+1);
		temp=v[i];
		while(temp)
			{
			printf("V%d -->",temp->vertex);
			temp=temp->next;
			}
		printf("NULL\n\n");
		delay(1500);
		}
	printf("\n");
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
	CreateList(m,n);
	DisplayList(n);
	getch();
	}
