#include<stdio.h>
#include<string.h>
#include<stdlib.h>
struct line
{
   char ln[80];
   struct line *next,*prev;
}*start=NULL,*end,*newn,*temp;
char fname[30];

void load()
{
  FILE *fp;
  int ln;
  fp=fopen(fname,"r");
  if(fp==NULL)
  {
    printf("Can't open the file\n");
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
        start=end=newn;
       else
       {
         end->next=newn;
         newn->prev=end;
         end=newn;
       }
    }
  }
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

void append()
{
  printf("Enter the string:");
  newn=(struct line *)malloc(sizeof(struct line));
  gets(newn->ln);
  newn->next=NULL;
  newn->prev=NULL;
  end->next=newn;
  newn->prev=end;
  end=newn;
}

void insert(int n)
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
  newn=(struct line *)malloc(sizeof(struct line));
  newn->next=NULL;
  newn->prev=NULL;
  printf("Enter line:");
  gets(newn->ln);
  temp1=temp->next;
  temp->next=newn;
  newn->prev=temp;
  newn->next=temp1;
  temp1->prev=newn;
}





main(int argc,char *argv[])
{
     char cmd[10],t1[10],t2[10],t3[10],t4[10];
     int m,n;
     if(argc!=2)
      printf("Please enter correct file name\n");
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
	        printf("$");
	        gets(cmd);
	
	        sscanf(cmd,"%s%s%s%s",t1,t2,t3,t4);
	        if(strcmp(t1,"e")==0)
	          exit(0);
	        else
	        {
	          if(strcmp(t1,"p")==0)
	          {
	            
	             m=atoi(t2);
	             n=atoi(t3);
	             display1(m,n);
	            
	          }
	          else if(strcmp(t1,"a")==0)
	          append();
	          
	          else if(strcmp(t1,"i")==0)
	          {
		            if(strcmp(t2,"\0")!=0)
		            {
			              n=atoi(t2);
			              insert(n);
		            }
	          }
        	  
        	}//else
       	  }//while	
     }	//else
}//main

