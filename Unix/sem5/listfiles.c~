#include<sys/types.h>
#include<dirent.h>
#include<stdio.h>


int main(int argc,char *argv[])
	{
	DIR *dp;
	int a;
	struct dirent *dirp;
	system("clear");
	if(argc!=2)
		printf("Please enter a cmd line argument");
	if((dp=opendir(argv[1]))==NULL)			
		printf("can't open %s",argv[1]);
	while((dirp=readdir(dp))!=NULL)
		printf("%d     %s\n",dirp->d_ino,dirp->d_name); 

	a=mkdir("/mnt/D:/Programs/Unix/sem5/amit");
	if(a==0)
		printf("\nDirectory Created");
	else
		printf("\nDirectory Creation failed");

	a=rmdir("/mnt/D:/Programs/Unix/sem5/amit");
	if(a==0)
		printf("\nDirectory Removed");
	else
		printf("\nDirectory Removal failed\n");
	printf("\n Process Id is:%d\n",getpid());
	exit(0);
	}
