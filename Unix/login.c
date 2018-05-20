#include<unistd.h>
#include<time.h>

main()
	{
	char *str;
	int id;
	long a;
	time_t *t,*t1;
	system("clear");
	str=getlogin();
	while(*str!='\0')
		{
		printf("%c",*str);
		str++;
		}
	id=geteuid();
	a=alarm(15);
	printf("\n%d",id);
	printf("\n\n");
	printf("%d",time(t));
	}	
