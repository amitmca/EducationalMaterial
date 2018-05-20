#include<sys/time.h>
#include<sys/resource.h>
main()
	{
	int p;
	p=getpriority(PRIO_USER,0);
	printf("\nPrority is:%d",p);
	}
