main()
	{
	int pid;
	pid=fork();
	if(pid==0)
		{
		printf("\nI am the child,my process ID is %d\n",getpid());
		printf("\nThe child's parent process ID is %d\n",getppid());
		}
	else
		{
		printf("\nI am the parent,my process ID is %d\n",getpid());
		printf("\nThe parent's process parent ID is %d\n",getppid());
		}
	}
