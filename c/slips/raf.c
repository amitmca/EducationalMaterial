#include<stdio.h>
#include<conio.h>
struct stud
	{
	int rno;
	char name[20];
	float per;
	}s;
main()
	{
	FILE *fp;
	char ch='y';
	int c;
	clrscr();
	do
	{
	printf("\n 1) Write Data to file\n");
	printf("\n 2) Read Data from file\n");
	printf("\n 3) Exit\n\n");
	printf("\n Select Your Choice: ");
	scanf("%d",&c);
	switch(c)
		{
		case 1:
		fp=fopen("stud.dat","w");
		if(!fp)
			{
			printf("\nUnable to open file\n");
			exit(1);
			}
		while(ch=='y')
		{
		printf("\nEnter Student Information:\n\n");
		printf("\nRoll Number:");
		scanf("%d",&s.rno);
		printf("\nName :");
		scanf("%s",s.name);
		printf("\nPercentage :");
		scanf("%f",&s.per);
		fprintf(fp,"%d %s %f",s.rno,s.name,s.per);
		fflush(stdin);
		printf("\nYou want to add more records press y:\n");
		ch=getch();
		}
		fclose(fp);
		break;

		case 2:
		fp=fopen("stud.dat","r");
		if(!fp)
			{
			printf("\nUnable to read from file");
			exit(1);
			}
		printf("\nRoll No\tName\tPercentage\n");
		while(!feof(fp))
			{
			fscanf(fp,"%d%s %f",&s.rno,s.name,&s.per);
			printf("\n%d\t%s\t%f",s.rno,s.name,s.per);
			}
		printf("\n");
		fclose(fp);
			break;
		case 3:
			exit(0);
			break;
		}
	}while(c!=3);
	clrscr();
	getch();
	return 0;
	}
