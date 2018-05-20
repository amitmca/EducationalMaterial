//Program for writting and reading the contents of the Binary file using fscanf() and fprintf() 
#include<stdio.h>
#include<curses.h>
struct stud
	{
	int rno;
	char name[20];
	float per;
	}s;
main()
	{
	FILE *fp;
	char ch[20];
	int c,n,i;
	system("clear");
	do
		{
		printf("\n **** MENU ****\n\n");
		printf("\n 1) Write Data To a File\n");
		printf("\n 2) Read Data From a File\n");
		printf("\n 3) Exit\n");
		printf("\n Select Your Choice...\n");
		scanf("%d",&c);
		switch(c)
			{  
			case 1:
				fp=fopen("stud.dat","w");
				/*printf("\nHow many records do you want to write:");
				scanf("%d",&n);*/
				while(ch=="yes")
					{
					printf("\nRoll Number:");
					scanf("%d",&s.rno);
					printf("\nName:");
					scanf("%s",s.name);
					printf("\nPercentage:");
					scanf("%f",&s.per);
					fprintf(fp,"%d %s %f",s.rno,s.name,s.per);
					//fflush(fp);
					printf("\nDo you want to write more records:(yes)");
					scanf("%s",ch);
					}	
				fclose(fp);
				break;

			case 2:
				fp=fopen("stud.dat","r");
				printf("\nRNO\tName\tPercetage\n");
				while(!fscanf(fp,"%d %s %f",&s.rno,s.name,&s.per))
					{
					
					printf("\n%d\t%s\t%f\n",s.rno,s.name,s.per);
					}
				fclose(fp);
				break;
	
			case 3:
				exit(0);
				break;
			}
		}while(c!=3);

	}
