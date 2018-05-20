//Program for maintainance of book records
#include<stdio.h>
#include<conio.h>
struct book
	{
	int bno;
	char bname[20],aname[20];
	float price;
	}b;
char bname1[20];
long recsize;
void main()
	{
	FILE *fp,*ft;
	int n,i,choice;
	char ch='y';
	clrscr();
	recsize=sizeof(b);
	do
		{
		printf("\n\n1)Add a book information:\n");
		printf("\n2)Modify a book information:\n");
		printf("\n3)Display a book information:\n");
		printf("\n4)Exit:\n");
		printf("\nSelect Your Choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
			fp=fopen("book.dat","a+b");
			fseek(fp,0,SEEK_END);
			while(ch=='y')
				{
				printf("\n\nBook Number:");
				scanf("%d",&b.bno);
				printf("\nBook Name:");
				scanf("%s",b.bname);
				printf("\nPrice:");
				scanf("%f",&b.price);
				printf("\nAuthor Name:");
				scanf("%s",b.aname);
				fwrite(&b,recsize,1,fp);
				fflush(fp);
				printf("\nDo you want to add another record:");
				ch=getche();
				}
				fclose(fp);
				break;
			case 2:
				fp=fopen("book.dat","rb+");
				printf("\nEnter the name of the book to modify:");
				scanf("%s",bname1);
				rewind(fp);
				while(fread(&b,recsize,1,fp)==1)
					{
					if(strcmp(b.bname,bname1)==0)
						{
						printf("\n\nBook Number:");
						scanf("%d",&b.bno);
						printf("\nBook Name:");
						scanf("%s",b.bname);
						printf("\nPrice:");
						scanf("%f",&b.price);
						printf("\nAuthor Name:");
						scanf("%s",b.aname);
						fseek(fp,-recsize,SEEK_CUR);
						fwrite(&b,recsize,1,fp);
						break;
						}
					}
					fclose(fp);
					printf("\n1 record is modified sucessfully\n");
				break;
			case 3:
				fp=fopen("book.dat","rb+");
				printf("\nBNO\tBname\tPrice\t\tAname\n");
				while(fread(&b,sizeof(b),1,fp)==1)
					{
					printf("\n%d\t%s\t%f\t%s\n",b.bno,b.bname,b.price,b.aname);
					}
				fclose(fp);
				break;
			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}
