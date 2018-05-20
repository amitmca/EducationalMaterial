main(int argc,char *argv[])
	{	
	if(fork()==0)
		execl("copy","copy",argv[1],argv[2],0);
	wait((int *)0);	
	printf("\nCopy Done\n");	
	}
