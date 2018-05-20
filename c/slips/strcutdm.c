#include<stdio.h>
#include<conio.h>
#include<alloc.h>
struct stud
	{
	int rno;
	char name[20];
	};
main()
	{
	int n,*p;
	struct stud *s1;
	clrscr();
	printf("\nHow many students ?:");
	scanf("%d",&n);
	s1=(struct )malloc(n);
	if(p==NULL)
		{
		printf("\nMemory was not allocated\n");
		exit(0);
		}
	else
		{
		}
	getch();
	return 0;
	}