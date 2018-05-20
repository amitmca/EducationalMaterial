#include<sys/types.h>
#include<stdio.h>
#include<sys/wait.h>

static void charatatime(char *);
int main()
	{	
	pid_t pid;
	TELL_WAIT();
	if((pid==fork())<0)
		printf("\n fork error");
	else if(pid==0)		/* Child */
		{
		WAIT_PARENT();
		charatatime("Output from Child\n");		
		}
	else
		{
		charatatime("Output from Parent\n");		
		TELL_CHILD(pid);
		}
	exit(0);
	}

static void charatatime(char *str)
	{
	char *ptr;
	int c;
	setbuf(stdout,NULL);
	for(ptr=str;c=*ptr++;)
		putc(c,stdout);
	}
