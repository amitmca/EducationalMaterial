//Program for writting and reading the contents of the Binary file using write() and read()
#include<stdio.h>
//#include<conio.h>
struct stud
	{
	int rno;
	char name[20];
	float per;
	}s;
long int recsize;
char sname[20];
main()
	{
	FILE *fp,*ft;
	int c,n,i,r;
	//clrscr();
	recsize=sizeof(s);
	do
		{
		printf("\n **** MENU ****\n\n");
		printf("\n 1) Write a Record To a File\n");
		printf("\n 2) Read a Record From a File\n");
		printf("\n 3) Modify the Record\n");
		printf("\n 4) Delete the Record\n");
		printf("\n 5) Insert a Record\n");
		printf("\n 6) Exit\n");
		printf("\n Select Your Choice...");
		scanf("%d",&c);
		switch(c)
			{
			case 1:
				fp=fopen("stud1.dat","wb+");
				printf("\nHow many records do you want to write:");
				scanf("%d",&n);
				for(i=0;i<n;i++)
					{
					printf("\nRoll Number:");
					scanf("%d",&s.rno);
					printf("\nName:");
					scanf("%s",s.name);
					printf("\nPercentage:");
					scanf("%f",&s.per);
					fwrite(&s,sizeof(s),1,fp);
					fflush(fp);
					}
				fclose(fp);
				break;

			case 2:
				fp=fopen("stud1.dat","rb+");
				printf("\nRNO\tName\tPercetage\n");
				while(fread(&s,sizeof(s),1,fp)==1)
					{
					printf("\n%d\t%s\t%f\n",s.rno,s.name,s.per);
					}
				fclose(fp);
				break;

			case 3:
				fp=fopen("stud1.dat","rb+");
				printf("\nEnter the name of the student to modify:");
				scanf("%s",sname);
				rewind(fp);
				while(fread(&s,recsize,1,fp)==1)
					{
					if(strcmp(s.name,sname)==0)
						{
						printf("\nRoll Number:");
						scanf("%d",&s.rno);
						printf("\nName:");
						scanf("%s",s.name);
						printf("\nPercentage:");
						scanf("%f",&s.per);
						fseek(fp,-recsize,SEEK_CUR);
						fwrite(&s,recsize,1,fp);
						break;
						}
					}
					fclose(fp);
					printf("\n1 record is modified sucessfully\n");
					break;
			case 4:
				fp=fopen("stud1.dat","rb+");
				printf("\nEnter the name of the student to delete:");
				scanf("%s",sname);
				rewind(fp);
				ft=fopen("temp.dat","wb");
				while(fread(&s,recsize,1,fp)==1)
					{
					if(strcmp(s.name,sname)!=0)
					fwrite(&s,recsize,1,ft);
					}
				fclose(fp);
				fclose(ft);
				remove("stud1.dat");
				rename("temp.dat","stud1.dat");
				printf("\n1 record is deleted sucessfully\n");
				break;

			case 5:
				fp=fopen("stud1.dat","a+b");
				fseek(fp,0,SEEK_END);
				printf("\nRoll Number:");
				scanf("%d",&s.rno);
				printf("\nName:");
				scanf("%s",s.name);
				printf("\nPercentage:");
				scanf("%f",&s.per);
				fwrite(&s,recsize,1,fp);
				fflush(fp);
				printf("\n1 record is inserted sucessfully\n");
				break;

			case 6:
				exit(0);
				break;
			}
		}while(c!=6);
	 getch();
	 return 0;
	}
