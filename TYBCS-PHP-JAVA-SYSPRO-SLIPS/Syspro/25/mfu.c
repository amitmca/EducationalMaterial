#include<stdio.h>

int nor,nof,ref[30],frame[10]={-1},pf;
void accept()
{
       int i,j;
       printf("\nEnter the no of Reference strings:");
       scanf("%d",&nor);
       printf("\nEnter the actual reference string:");
       for( i=0;i<nor;i++)
       {
              scanf("%d",&ref[i]);
       }
       printf("\nEnter the frame size:");
       scanf("%d",&nof);
}
int check(int n)
{
       int i,flag=0;
       for(i=0;i<nof;i++)
       {
              if(n==frame[i])
              {
                     flag=1;
                     break;
              }
       }       
              if(flag==0)
                     return 1;
               else
                     return 0;
}
void display()
{
       int i;
       printf("\nFrame::");
       for(i=0;i<nof;i++)
       {
              printf("%d\t",frame[i]);
       }      
}
int replace(int n)
{
       int i,j,k=0,pos[10],max=-1;
       for(i=0;i<nof;i++)
       {
		int c=0;
              for(j=n-1;j>=0;j--)
              {
                     if(frame[i]==ref[j])
                     {
                            c++;
                     }
              }
				pos[k]=c;
				k++;
       }
       for(i=0;i<nof;i++)
       {
              if(max<pos[i])
              {
                     max=pos[i];
                     k=i;
              }
       }
       return k;
}
void mfu()
{
       int i,count=0,k,j;
       for(i=0;i<nof;i++)
              frame[i]=-1;
      for(i=0;i<nor;i++)
      {
              j=check(ref[i]);
              if(j==1)
              {
                     if(count==nof)
                     {
                            k=replace(i);
                            frame[k]=ref[i];
                            pf++;
                            display();
                     }
                     else
                     {
                            frame[count]=ref[i];
                            count++;
                            pf++;
                            display();
                     }
              }
      } 
      printf("\nNo of Pagefaults::%d",pf);       
}

void main()
{
       accept();
       mfu();
}
