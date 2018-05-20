#include<stdio.h>
#include<string.h>
void search(char *c,char *s,char *p)
{
	FILE *fp;char str[20];
	fp=fopen(s,"r");
	int flag=0,cnt=0;
	while(fscanf(fp,"%s",str)!=EOF)
	{
		if(strcmp(str,p)==0)
		{
			flag=1;
			cnt++;
			if(strcmp(c,"f")==0)
            		{
				printf("first occurence%s\n",str);
				cnt++;
				break;	
			}
			if(strcmp(c,"a")==0)
			{	
				printf("no of all occurences=%s\n",str);
				cnt++;
			}
				
		}
			
	}
	if(strcmp(c,"c")==0)
	{			
		printf("count=%d",cnt);
	}	
}

main()
{
	char cmd[20],t1[20],t2[20],t3[20],t4[20];
	while(1)
	{
		printf("\nMyShell$]");
           	gets(cmd);
           	sscanf(cmd,"%s%s%s%s",t1,t2,t3,t4);
           	if(strcmp(t1,"search")==0)
              	search(t2,t3,t4);
           	else if(strcmp(t1,"q")==0)
               	exit(0);
        }
}
