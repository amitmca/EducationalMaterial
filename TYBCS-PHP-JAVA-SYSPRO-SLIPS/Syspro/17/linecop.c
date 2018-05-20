#include<stdio.h>
#include<string.h>
#include<stdlib.h>
char fname[20];
struct line
{
    char ln[80];
    struct line *next,*prev;
}*start=NULL,*temp,*end,*newn;
void load()
	{
		FILE *fp;
		int l;
        	fp=fopen(fname,"r");
      		if(fp==NULL)
       		{
       		printf("Can't open the file");
       		}
      		else
      		{ 
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
	printf("enter line");
   	newn=(struct line*)malloc(sizeof(struct line));
   	gets(newn->ln);
   	newn->next=NULL;
   	newn->prev=NULL;
   	end->next=newn;
   	newn->prev=end;
   	end=newn;
}
void display1(int a,int b)
{
	int c=0;
  	temp=start;
   	while(temp!=NULL)
   	{
    		c++;
    		if(c==a)
    		break;
    		temp=temp->next;
   	}
   		while(temp!=NULL)
   		{
    		printf("%s\n",temp->ln);
    		c++;
    		if(c==b)
    		break;
    		temp=temp->next;
   		}
}	
void copy(int m,int n)
{
	struct line *temp1,*newn;
   	int c=0;
        temp=start;
    	while(temp!=NULL)
   	{
    	c++;
    	if(c==m)
    	break;
    	temp=temp->next;
   	}
   	temp1=temp;
    	while(temp!=NULL)
   	{
    	if(c==n)
    	break;
    	temp=temp->next;
    	c++;
   	}
   	newn=(struct line*)malloc(sizeof(struct line));
   	strcpy(newn->ln,temp1->ln);
   	newn->next=NULL;
   	newn->prev=NULL;
   	temp->prev->next=newn;
   	newn->prev=temp->prev;
   	newn->next=temp;
   	temp->prev=newn;
}
main(int argc,char *argv[])
{
	char cmd[20],t1[10],t2[10],t3[10],t4[10];
   	char m,n;
   	if(argc!=2)
   	printf("\nIncorrect\n");
   	else
    	{
       		strcpy(fname,argv[1]);
       		load();       
     		while(1)
     		{
       		strcpy(t1,"\0");
       		strcpy(t2,"\0");
       		strcpy(t3,"\0");
       		strcpy(t4,"\0");
       		printf("\n$");
       		gets(cmd);
       		sscanf(cmd,"%s%s%s%s%s",t1,t2,t3,t4);
       		if(strcmp(t1,"e")==0)
       		exit(0);
       		else if(strcmp(t1,"p")==0)
       		{
       			if(strcmp(t2,"\0")==0)
           		display();      
        		else
       			{
        		m=atoi(t2);
        		n=atoi(t3);
        		display1(m,n);   
       			}
       		}
       		else if(strcmp(t1,"a")==0)
       		append();    
       		else if(strcmp(t1,"s")==0)
       		{
       			if(strcmp(t2,"\0")==0)
       			save();
       		}
       		else if(strcmp(t1,"c")==0)
       		{
        		if(strcmp(t2,"\0")!=0 && strcmp(t3,"\0")!=0)
        		{
        		m=atoi(t2);
        		n=atoi(t3);
        		copy(m,n);
        		}
        	}
  	}
 }
}
