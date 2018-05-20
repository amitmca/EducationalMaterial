#include<sys/types.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>

int main()
	{
	int a,b;
	a=open("/mnt/D:/Programs/Unix/sem5/cmd.c",O_RDONLY);
	if(a!=-1)
		printf("\n File Opened For reading...%d\n",a);
	else
		printf("\n Error \n");
	b=open("/mnt/D:/Programs/Unix/sem5/open.c",O_RDONLY);
	printf("\n File Opened For reading...%d\n",b);
	close(a);
	close(b);
	exit(0);
	}
