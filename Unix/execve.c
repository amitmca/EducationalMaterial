#include<stdio.h>
int main(int argc, char *argv[], char *envp[])
	{
	execve("javac pgtest.java");
	execve("java pgtest.java");
	}
