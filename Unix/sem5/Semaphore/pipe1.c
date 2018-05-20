#include<unistd.h>
#include<fcntl.h>
#include<stdio.h>
#include<sys/types.h>

char string[]="Hello";

int main(int argc,char *argv[])
	{
	int fd;
	char buf[256];
	system("clear");
	mknod("fifo",010777,0);
	if(argc==2)
		fd=open("fifo",O_RDONLY);
	else
		fd=open("fifo",O_WRONLY);	
	for(; ;)
		if(argc==2)
			write(fd,string,6);
		else
			read(fd,buf,6);
	exit(0);
	return 0;
	}
