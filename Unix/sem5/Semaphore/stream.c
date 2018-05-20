#include<sys/types.h>
#include<sys/fcntl.h>

int main(int argc,char *argv[])
	{	
	int i,fd;
	for(i=1;i<argc;i++)
		{
		printf("%s",argv[i]);
		if((fd=open(argv[i],O_RDONLY))<0)
			{
			printf("\n can't open ",argv[i]);
			continue;
			}
		if(isastream(fd)==0)
			printf(":    %s is not a stream\n ",argv[i]);
		else	
			printf("%s is a stream\n",argv[i]);
		}
	return 0;
	}
