#include<fcntl.h>
int main(int argc,char *argv[])
	{
	int fd,skval;
	char c;
	if(argc!=2)
		exit(1);
	fd=open(argv[1],O_RDONLY);
	if(fd==-1)
		exit(1);
	while((skval=read(fd,&c,1))==1)
		{
		printf(" char %c \n",c);
		skval=lseek(fd,1023,1);
		printf("new seek val %d\n",skval);
		printf(" char %c \n",c);
		}
	}