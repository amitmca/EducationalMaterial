#include<stdio.h>

#define NEWNODE  (struct dfile *) malloc (sizeof(struct dfile))

int fdata=0;
int ffree=0;


struct dfile
 {  
   int fdata,ffree;  
    int status; 
    struct dfile *u_prev,*u_next,*f_prev,*f_next;
 }*head= NULL,*uf=NULL;

struct dfile *ff=NULL;

int init(int dsize)
{
   struct dfile *temp=NULL,*temp1=NULL;
   int i,j;
    for(i=0;i<dsize;i++)
     {
      temp = NEWNODE ;

      temp->u_next=NULL;
      temp->u_prev=NULL;
      temp->f_next=NULL;
      temp->f_prev=NULL;

      temp->status=0;

      temp->fdata=-1;
      temp->ffree=i;
     
     if(head==NULL)
       {
	head=temp1=temp;
       }
       else
       {
          temp1->u_next=temp;
		  temp->u_prev=temp1;      
  		  temp1->f_next=temp;
		  temp->f_prev=temp1;
          temp1=temp; 
       }
     }
}


void alloc()
{
         struct dfile *temp=NULL,*temp1;
         static int da=0;
          da=da + 1; 
             if(uf==NULL)
             {
              uf=temp=head;
               temp->status=1; 
             } 
             else
             {
               for(temp=uf;temp!=NULL,temp->status!=0;temp=temp->u_next);
               temp->status=1; 
             }        
            printf("\n Allocate the Block\n");    
}      

void disp_free()
{
        int df=0;
	struct dfile *temp=NULL;
	temp=head;

       	if(temp!=NULL)
        {
          printf("\nFree space File \n");
          while(temp!=NULL)
	   {
	     if(temp->status==0)
	     printf("| %d |",temp->ffree);
	     temp=temp->f_next; 
            }
        }
        
}

void dalloc(int d)
{
	  struct dfile *temp=NULL;
	  temp=head;
 	   while(temp!=NULL)
	      {
	       if(temp->ffree==d)
		 {
                  temp->status=0;
	         }
                  temp=temp->u_next; 
	      }
         printf("\n  File delete Successfully . . .! \n");    
}

int main()
 {
   int s,ch,fd,d;
   printf("\nEnter disk size");
   scanf("%d",&s); 

   init(s);
   while(1)
    {
     
     
     printf("\n 1: Create new file");
     printf("\n 2: Show Directory"); 
     printf("\n 3: Delete File");
     printf("\n 4:Exit");
     
     printf("\n Enter Your choice");
     scanf("%d",&ch);
   
 switch(ch)
       {
	 case 1: alloc();
		 break;
	 case 2: disp_free();
		 break;
	 case 3: printf("\n Enter block no\n");
                 scanf("%d",&d);  
                 dalloc(d);
		 break;
	 case 4 :exit(0);

       }
     }     
 return 0; 
 }
