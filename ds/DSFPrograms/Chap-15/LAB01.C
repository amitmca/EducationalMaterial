/*Heading : Program to Create  & Manipulate Database using structures */
/* Program details:
 Various operations like read,insert,delete,print for student database
*/

#include <stdio.h>
#include <conio.h>
#include <string.h>
typedef struct student
 { int rollno;
   char name[20];
   int  marks;
 }student;
void insert( student st[],int position,int n);
void Delete(student st[],int position,int n);
int  search(student st[],int rollno,int n);
void print(student st[],int n);
void read(student st[],int n);

 void main()
  { student st[30];
    int n,i,op,position,rollno;
    clrscr();
    do{
       flushall();
       printf("\n1)create\n2)insert\n3)delete\n4)search\n5)print\n6)quit");
       printf("\nEnter Your Choice:");
       scanf("%d",&op);
       switch(op)
	{ case 1: printf("\nEnter No. of student:");
		  scanf("%d",&n);
		  read(st,n);
		  break;
	  case 2: printf("\n enter the position(no of records=%d):",n);
		   scanf("%d",&position);
		  if(position<=n+1)
		   {
		     insert(st,position,n);
		     n++;
		   }
		  else
		   printf("\n can not insert");
		  break;
	  case 3:printf("\n enter the position(no of records=%d):",n);
		 scanf("%d",&position);
		 if(position<=n)
		  {
		    Delete(st,position,n);
		    n--;
		  }
		else
		 printf("\n can not delete ");
		 break;
	  case 4: printf("\nenter rollno:");
		  scanf("%d",&rollno);
		  position=search(st,rollno,n);
		  if(position==-1)
		    printf("\nnot found");
		  else
		   { printf("\n found at location=%d",position+1);
		     printf("\n %s\t%d\t%d",st[position].name,st[position].rollno,st[position].marks);
		   }
		 break;
	  case 5: print(st,n);
		  break;
	  default:break;
	}
    }while(op!=6);
  }


void  insert( student st[],int position,int n)
	{ int i;
	  printf("\n enter data(name rollno marks:");
	  for(i=n-1;i>=position-1;i--) /*index is 1 less than position*/
	    st[i+1]=st[i];
	  scanf("%s%d%d",st[position-1].name,&st[position-1].rollno,&st[position-1].marks);
	}

void  Delete(student st[],int position,int n)
      { int i;
	for(i=position;i<n;i++)
	  st[i-1]=st[i];
      }
int   search(student st[],int rollno,int n)
       { int i;
	 for(i=0;i<n;i++)
	   if(rollno==st[i].rollno)
	     return(i);
	 return(-1);
       }
void print(student st[],int n)
       { int i;
	  for(i=0;i<n;i++)
	    printf("\n%20s%5d%5d",st[i].name,st[i].rollno,st[i].marks);
       }
void read(student st[],int n)
   { int i;
	  printf("\n enter data(name rollno marks:");
	  for(i=0;i<n;i++)
	    scanf("%s%d%d",st[i].name,&st[i].rollno,&st[i].marks);
    }

/*
             *** OUTPUT ***
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:1

Enter No. of student:2

 enter data(name rollno marks:   Abhi 1 80
                                 Rahul 3 90

1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

                Abhi    1   80
               Rahul    3   90
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:2

 enter the position(no of records=2):2

 enter data(name rollno marks:Akash 2 90

1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

                Abhi    1   80
               Akash    2   90
               Rahul    3   90
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:3

 enter the position(no of records=3):3
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

                Abhi    1   80
               Akash    2   90
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:4

enter rollno:1

 found at location=1
 Abhi   1       80
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:6
*/
