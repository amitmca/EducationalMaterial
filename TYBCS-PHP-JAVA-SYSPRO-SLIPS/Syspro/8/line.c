/*line*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

char fname[20];
     
struct node
{
      char line[80];
      struct node *prev,*next;
}*start,*cur,*temp,*newn;
FILE *fp;
int arg=0,flag=0;
char ch;

void load()
{
	if(arg==1)
	{
	 fp=fopen(fname,"w");
	   if(fp==NULL)
	   {
		   printf("\n error in opening file\n\n");
		   return;
	   }
	   start=NULL;
	}
	else
	{
	fp=fopen(fname,"r");
	if(fp==NULL)
	  {
		  printf("Error in opening file");
		  return;
	  }
	     while(!feof(fp))
	      {
		      newn=(struct node *)malloc(sizeof(struct node));
		      fgets(newn->line,80,fp);
		      newn->next=NULL;
		      if(start==NULL)
		       start=cur=newn;
		      else
		       {
		         cur->next=newn;
		         newn->prev=cur;
		         cur=cur->next;
	               }
		      flag++; 
	    }
	}
fclose(fp);
}

void append()
{
	int y;
	newn=NULL;
	newn=(struct node *)malloc(sizeof(struct node));
	y=0;
	do
	{
		ch=getc(stdin);
		newn->line[y]=ch;
		y++;
	}while(ch!='\n');
	newn->next=NULL;
	if(start==NULL)
    	start=newn;
 	else
   	{
   		temp=start;
    		while(temp->next!=NULL)
        	temp=temp->next;
        	temp->next=newn;
        	newn->prev=temp;
   	}
  flag++;
}

void save()
{
	printf("\n enter file name to save \n");
	scanf("%s",fname);
	fp=fopen(fname,"w");
	 if(fp==NULL)
	   {
	    printf("\n error in file opening");
	     return;
	   }
	 else
   	{
      		temp=start;
    	 	while(temp!=NULL)
      		{
      			fputs(temp->line,fp);
       			temp=temp->next;        
      		}
   	}
}

void mndelete(int m,int n)
{   
	int c;
	   struct node *r=NULL,*t=NULL;  
	   cur=temp=NULL;
   		
    
    	c=1;
    	for(temp=start;c<m-1;temp=temp->next)
     	c++;
    	c--;
    	cur=temp->next;
    	do
      	{
       		r=cur->next;
       		t=cur;
       		cur=cur->next;
       		t->next=NULL;
       		t=NULL;
       		free(t);
       		c++;
       		flag--;
      	}while(c<n-1);
    	temp->next=r;
    	r->prev=temp;
 
}

int main(int argc,char *argv[])
{
 	char cmd[15],t[4][10];
 	int i,j,k;
 	strcpy(t[0],"\0");
 	strcpy(t[1],"\0");
 	strcpy(t[2],"\0");
 	strcpy(t[3],"\0");
 	arg=argc;
 	if(argc>1)
 	strcpy(fname,argv[1]);
 	else
 	strcpy(fname,"ok.txt");
 	load();
 	while(1)
 	{
 	printf("\n$");
 	gets(cmd);
 	i=j=k=0;
 	fflush(stdin);
 	fflush(stdout);
 
 	strcpy(t[0],"\0");
 	strcpy(t[1],"\0");
 	strcpy(t[2],"\0");
 	strcpy(t[3],"\0");
 	
 	sscanf(cmd,"%s%s%s%s",t[0],t[1],t[2],t[3]);
 	i=atoi(t[1]);
 	j=atoi(t[2]);
 	k=atoi(t[3]);
 	
 	if(strcmp(t[0],"e")==0)break;
 	else
 	if(strcmp(t[0],"s")==0)
 	save();
 	
 	else
 	if(strcmp(t[0],"a")==0)
 	append();
 	else
 	
 	if(strcmp(t[0],"d")==0)
 	       {
 	         mndelete(i,j); 
 	       }
	}	
return(0);
}
