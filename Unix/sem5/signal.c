#include<stdio.h>
#include<signal.h>

static void sig_usr(int);

int main(void)
	{
	if(signal(SIGUSR1,sig_usr)==SIG_ERR)
		printf("\n can't catch SIGUSR1");
	if(signal(SIGUSR2,sig_usr)==SIG_ERR)
		printf("\n can't catch SIGUSR2");
	for(; ;)
		pause();
	return(0);
	}

static void sig_usr(int signo)
	{
	if(signo==SIGUSR1)
		printf("\n received SIGUSR1");
	else if(signo==SIGUSR2)
		printf("\n received SIGUSR2");
	else
		printf("\n received signal %d",signo);
	return;
	}
