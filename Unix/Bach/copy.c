#include<fcntl.h>

char buffer[2048];
int version=1;

main(int argc,char *argv[])
	{
	int fold,fnew;
	if(argc!=3)
		{
		printf("Please suplly 3 arguments");
		exit(1);
		}	
	fold=open(argv[1],O_RDONLY);
	if(fold==-1)
		{
		printf("\nCan't open source file %s\n",argv[1]);
		exit(1); 
		}
	fnew=creat(argv[2],0666);
	if(fnew==-1)
		{
		printf("\nCan't open Destination file %s\n",argv[2]);
		exit(1); 
		}
	copy(fold,fnew);
	exit(0);
	}
copy(int old,int new)
	{
	int count;
	while((count=read(old,buffer,sizeof(buffer)))>0)	
		write(new,buffer,count);
	}
