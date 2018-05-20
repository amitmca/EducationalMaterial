#include<stdlib.h>
#include<stdio.h>
main()
	{
	setenv("JAVA_HOME","/usr/java/jdk1.5.0_01",1);
	system("/opt/tomcat/bin/startup.sh");	
	}
