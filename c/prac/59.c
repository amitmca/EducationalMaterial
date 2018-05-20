#include<stdio.h>
#include<conio.h>
#define ALLOC (struct stud *)malloc(sizeof(struct stud))
struct stud
	{
	int rno;
	char name[20],dept[20],course[20];
	}*s[20];
main()
	{
	int i,n;
	clrscr();
	printf("\nHow many Records ? :");
	scanf("%d",&n);

	for(i=0;i<n;i++)
		{
		s[i]=ALLOC;
		printf("\n\t\tAllocating memory to %d record........\n",i+1);
		printf("\nRoll Number:");
		scanf("%d",&s[i]->rno);
		printf("\nName:");
		scanf("%s",s[i]->name);
		printf("\nDepartment:");
		scanf("%s",s[i]->dept);
		printf("\nCousrse Name(In Capital):");
		scanf("%s",s[i]->course);
		}	
	printf("\n==========================");
	printf("\nRollNo \t Name\tDepartment\n");
	printf("==========================\n");
		for(i=0;i<n;i++)
		{
		if(strcmp(s[i]->course,"MCA"))
			{
			printf("\n%d\t%s\t%s\n",s[i]->rno,s[i]->name,s[i]->dept);
			}
		}	
	printf("==========================\n");
	free(s[i]);
	printf("\nMemory is freed.......\n\n");
	getch();
	return 0;
	}
