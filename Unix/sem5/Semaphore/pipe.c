#include<unistd.h>
#include<stdio.h>
#include<sys/types.h>

int main(void)
	{
	int n,fd[2];
	pid_t pid;
	char line[80];
	FILE *fp;
	system("clear");
	if(pipe(fd)<0)
		printf("pipe error");
	if((pid=fork())<0)
		printf("fork error");
	else if(pid > 0)
		{
		close(fd[0]);
		write(fd[1],"Hello World\n",12);
		fp=fopen("amit.c","w");
		}
	else
		{
		close(fd[1]);
		n=read(fd[0],line,80);
		write(STDOUT_FILENO,line,n);
		}
	return 0;	
	}
