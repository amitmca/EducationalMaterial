#include<sys/types.h>
#include<sys/stat.h>
#include<unistd.h>
#include<fcntl.h>

int main()
	{
	int a,skval;
	char c;
	a=open("/mnt/D:/Programs/Unix/sem5/cmd.c",O_RDONLY);

	if(a!=-1)
		{
		while((skval=read(a,&c,1))==1)
			{
			printf("%c\n",c);
			skval=lseek(a,1023L,0);
			printf("%d\n",skval);
			}
		}
	else
		printf("\n Error \n");
	close(a);
	exit(0);
	}