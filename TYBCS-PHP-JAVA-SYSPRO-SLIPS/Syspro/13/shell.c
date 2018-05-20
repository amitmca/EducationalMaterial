#include<stdio.h>
#include<string.h>

char f[10],ch,cmd[20],t1[10],t2[10],t3[10];

void count(char *g,char *f)
{
	int w=0,l=0,c=0;
	FILE *fp;
	fp= fopen(f,"r");
	if(f==NULL)
		printf("--ERROR--");
	else
	{
		while((ch=getc(fp))!=EOF)
		{
			c++;
			if(ch== ' ')
			{	
				w++;
			}		
			if(ch=='\n')
			{
				l++;
				w++;
			}
						
		}
		fclose(fp);	
	}	
		if(strcmp(g,"c")==0)
		{	
		printf("No.of chareceter %d ",c);
		}	
		else if(strcmp(g,"w")==0)
		{
		printf("\n No.of Words %d ",w);
		} 
		else if(strcmp(g,"l")==0)
		{
		printf("\n No.of Lines %d \n",l);
		}
			
	     
}

void main()
{
	while(1)
	{
		printf("\nMyShell $]");

		gets(cmd);
		sscanf(cmd,"%s %s %s",t1,t2,t3);
		if(strcmp(t1,"count")==0)
		{
			count(t2,t3);		
		}
		else if(strcmp(t1,"q")==0)
		{
			exit(0);
		}

	}
	
	
}
