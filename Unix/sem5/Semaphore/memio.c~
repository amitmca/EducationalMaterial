#include<sys/types.h>
#include<sys/stat.h>
#include<sys/mman.h>
#include<fcntl.h>

#ifndef MAP_FILE 
#define MAP_FILE 0
#endif

int main(int argc,char *argv[])
	{
	int fdin,fdout;
	char *src,*dest;
	struct stat statbuf;
	system("clear");

	if(argc!=3)
		printf("\n Please enter 3 cmd line arguments");
	if((fdin=open(argv[1],O_RDONLY))<0)
		printf("\n Error Opening Source File\n");
	if((fdout=open(argv[2],O_WRONLY | O_CREAT |O_TRUNC,"w"))<0)
		printf("\n Error Opening Destination File\n");
	if(fstat(fdin,&statbuf)<0)
		printf("\n fstat error");
	if(lseek(fdout,statbuf.st_size-1,2)==-1)
		printf("\n lseek error");
	if(write(fdout,"",1)!=1)
		printf("\nwrite error");
	if((src=mmap(0,statbuf.st_size,PROT_READ,MAP_FILE | MAP_SHARED,fdin,0))==(caddr_t)-1)
		printf("\nmmap error for input");
	if((dest=mmap(0,statbuf.st_size,PROT_READ | PROT_WRITE,MAP_FILE | MAP_SHARED,fdout,0))==(caddr_t)-1)
		printf("\nmmap error for output");
	memcpy(dest,src,statbuf.st_size);
	return 0;
	}
