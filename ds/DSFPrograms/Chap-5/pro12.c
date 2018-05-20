/*Program 5.12 :Structure manipulation (for student database) with pointers to structure*/
/*Handling of student record with pointer*/
#include <stdio.h>
#include <conio.h>
#include <string.h>
typedef struct student
 { int rollno;
   char name[20];
   int  marks;
 }student;
void  insert( student *st,int position,int n);
void  Delete(student *st,int position,int n);
int   search(student *st,int rollno,int n);
void print(student *st,int n);
void read(student *st,int n);

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
				                       printf("\n%s\t%d\t%d",st[position].name,st[position].rollno,st[position].marks);
		   }
		 break;
	  case 5: print(st,n);
		  break;
	  default:break;
	}
    }while(op!=6);
  }
void  insert( student *st,int position,int n)
	{ student *i;
	  printf("\n enter data(name rollno marks):");
	  for(i=st+n-1;i>=st+position-1;i--) /*index is 1 less than position*/
	    *(i+1)=*(i);
	  i=st+position-1;
	  scanf("%s%d%d",i->name,&(i->rollno),&(i->marks));
	}

void  Delete(student st[],int position,int n)
      { student *i;
	for(i=st+position;i<st+n;i++)
	  *(i-1)=*(i);
      }
int   search(student st[],int rollno,int n)
       { student *i;
	 for(i=st;i<st+n;i++)
	   if(rollno==i->rollno)
	     return(i-st);
	 return(-1);
       }
void print(student st[],int n)
       { student *i;
	  for(i=st;i<st+n;i++)
	    printf("\n%20s%5d%5d",i->name,i->rollno,i->marks);
       }
void read(student st[],int n)
   { student *i;
	  printf("\n enter data(name rollno marks):");
	  for(i=st;i<st+n;i++)
	    scanf("%s%d%d",i->name,&(i->rollno),&(i->marks));
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

Enter No. of student:3

 enter data(name rollno marks):
Mohan 1 90
Rohan 2 89
Soham 5 78
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

               Mohan    1   90
               Rohan    2   89
               Soham    5   78
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:2

 enter the position(no of records=3):3

 enter data(name rollno marks):Mayur 3 98

1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

               Mohan    1   90
               Rohan    2   89
               Mayur    3   98
               Soham    5   78
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:3

 enter the position(no of records=4):4

1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:4
enter rollno:3

 found at location=3
Mayur   3       98
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:5

               Mohan    1   90
               Rohan    2   89
               Mayur    3   98
1)create
2)insert
3)delete
4)search
5)print
6)quit
Enter Your Choice:6
*/
