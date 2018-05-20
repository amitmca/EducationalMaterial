#include<stdio.h>
#include<stdlib.h>

struct line
{
	char ln[100];
	struct line *next,*prev;
}*start=NULL,*end,*newn,*temp;
char fname[30];

void load()
{
	FILE *fp;
	fp=fopen(fname,"r");
	while(!feof(fp))
	{
	newn=(struct line *)malloc(sizeof(struct line));
	fgets(newn->ln,80,fp);
	newn->next=NULL;
	newn->prev=NULL;
	if(start==NULL)
	{
		start=end=newn;
	}
	else
	{
		end->next=newn;
		newn->prev=end;
		end=newn;
	}
	}
}

void display()
{
	temp=start;
	while(temp!=NULL)
	{
		printf("%s\n",temp->ln);
		temp=temp->next;
	}
}
void append()
{
	char s[40];
	gets(s);
	newn=(struct line *)malloc(sizeof(struct line));
	strcpy(newn->ln,s);
	newn->next=NULL;
	newn->prev=NULL;
	end->next=newn;
	newn->prev=end;
	end=newn;
}
void display1(int m,int n)
{
	int cnt=0;
	temp=start;
	while(temp!=NULL)
	{
		cnt++;
		if(cnt==m)
			break;
		temp=temp->next;
	}
	while(temp!=NULL)
	{
		printf("%s\n",temp->ln);
		cnt++;
		if(cnt==n)
			break;
		temp=temp->next;
	}
}

void del(int n)
{
  struct line *temp1;
  int c=0;
  temp=start;
  while(temp!=NULL)
  {
    c++;
    if(n==c)
     break;
    temp=temp->next;
  }
  temp1=temp->next;
  temp->next=temp1->next;
  temp1->next->prev=temp;
  free(temp1);
  printf("%dth line is deleted\n",n);
}


main(int argc,char *argv[])
{
	int m,n,o,p;
	char cmd[10],t1[10],t2[10],t3[10];

	if(argc!=2)
	
		printf("\n Enter Correct Parameters");
	else
	{
		fflush(stdin);
		strcpy(fname,argv[1]);
		load();
		while(1)
		{
			printf("\n$");

			strcpy(t1,"\0");			
			strcpy(t2,"\0");
			strcpy(t3,"\0");
			gets(cmd);
			sscanf(cmd,"%s%s%s",t1,t2,t3);


			if(strcmp(t1,"e")==0)
			{
				exit(0);
			}

			else if(strcmp(t1,"p")==0)
			{
				if(strcmp(t2,"\0")!=0)
				{
					m=atoi(t2);
					n=atoi(t3);
					display1(m,n);
				}
				else 
				{
					display();
				}
			}
			
			else if(strcmp(t1,"a")==0)
			{
				append();
			}
			else if(strcmp(t1,"d")==0)
          		{
             			if(strcmp(t2,"\0")!=0)
            			{
              			m=atoi(t2);
              			del(m);
            			}
          		}
	
          
	
			
		}
	}
}
