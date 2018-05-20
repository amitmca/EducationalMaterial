#include<stdio.h>

main()
{
	char cmd[50],t1[20],t2[20],t3[20];
	int d;
	while(1)
	{
		printf("\nMyshell$]");
		gets(cmd);
		sscanf(cmd,"%s%s%s",t1,t2,t3);
		d=atoi(t2);
		if(strcmp(t1,"q")==0)
		exit(0);
		 if(strcmp(t1,"typeline")==0)
		typeline(d,t3);
		else if(fork())
		{
			execlp(t1,t1,t2,t3,NULL);
			perror(t1);	
		}
		
	}	

}

void typeline(int n,char *f)
{
	FILE *fp;
	int c=0,cnt=0;
	char str[80];
	fp=fopen(f,"r");
	if(n>0)
	{	printf("The line are:\n");
		while(fgets(str,80,fp))
		{
			printf("%s\n",str);
			c++;
			if(c==n)
			break;
		}
	}
	else if(n<0)
	{
		while(fgets(str,80,fp))
		{
			c++;
		}
			
			fclose(fp);
			fp=fopen(f,"r");
			while(fgets(str,80,fp))
			{
			 	cnt++;
				if(cnt==(c+n))
				break;
			}
			printf("The lines are:\n");
			while(fgets(str,80,fp))
			{
				printf("%s\n",str);
			}
	}
	else if(n==0)
	{	
		printf("All Lines are:\n");
		while(fgets(str,80,fp))
		{
			printf("%s\n",str);
		}
		
	}

	
	fclose(fp);
}

