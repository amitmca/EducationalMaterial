#include<sys/types.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>

int main()
	{
	int a,n,size=1000,b;
	char buf[size];
	a=open("/mnt/D:/Programs/Unix/sem5/cmd.c",O_RDONLY);
	b=open("/mnt/D:/Programs/Unix/sem5/cmd1.c",O_WRONLY);
	if(a!=-1)
		{
		printf("\n File Opened For reading...%d\n",a);
		while((n=read(a,buf,size))>0)
			{
			write(b,buf,size);
			}
		}
	else
		printf("\n Error \n");
	close(a);
	exit(0);
	}
