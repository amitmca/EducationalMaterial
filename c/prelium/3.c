#include<stdio.h>
main()
	{
	int i=2;
	system("clear");
	#ifdef DEF
		i=i*2;
	#else
		printf("%d\n",i);
	#endif
	}
