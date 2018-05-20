main()
	{
	int pid;	
	pid=fork();
	if(pid<0)
		printf("\nFork failed");
	else
	if(pid==0)
		printf("\nFork succeeded");
	}
