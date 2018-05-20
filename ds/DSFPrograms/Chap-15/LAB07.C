/*heading : Binary Search */
/*Details : Program to search for a record from a given list
	    of records using binary search*/

#include <stdio.h>
#include <conio.h>
#include <string.h>
typedef struct student
 { int rollno;
   char name[20];
   int  marks;
 }student;
int  search(student st[],int rollno,int n);
void print(student st[],int n);
void read(student st[],int n);

 void main()
  { student st[30];
    int n,i,op,position,rollno;
    clrscr();
    do{
       flushall();
       printf("\n\n1)create\n2)search\n3)print\n4)quit");
       printf("\nEnter Your Choice:");
       scanf("%d",&op);
       switch(op)
	{ case 1: printf("\nEnter No. of student:");
		  scanf("%d",&n);
		  read(st,n);
		  break;
	  case 2: printf("\nenter rollno:");
		  scanf("%d",&rollno);
		  position=search(st,rollno,n);
		  if(position==-1)
		    printf("\nnot found");
		  else
		   { printf("\n found at location=%d",position+1);
		     printf("\n %s\t%d\t%d",st[position].name,st[position].rollno,st[position].marks);
		   }
		 break;
	  case 3: print(st,n);
		  break;
	}
    }while(op!=4);
  }

int   search(student st[],int rollno,int n)
       { int i,j,c;
	 i=0;j=n-1;
	 c=(i+j)/2;
	while(i<=j)
	 { if(rollno==st[c].rollno)
	     return(c);
	   if(rollno>st[c].rollno)
	     i=c+1;
	   else
	     j=c-1;
	   c=(i+j)/2;
	 }
	 return(-1);
       }

void print(student st[],int n)
       { int i;
	  for(i=0;i<n;i++)
	    printf("\n%20s%5d%5d",st[i].name,st[i].rollno,st[i].marks);
       }

void read(student st[],int n)
   { int i;
       printf("\n****** records to be entered should be sorted on rol no.***");
       for(i=0;i<n;i++)
	 {  printf("\n enter data(name(single word) rollno marks:");
	    scanf("%s%d%d",st[i].name,&st[i].rollno,&st[i].marks);
	 }
    }

/*
                 *** OUTPUT ***
1)create
2)search
3)print
4)quit
Enter Your Choice:1

Enter No. of student:2

****** records to be entered should be sorted on rol no.***
 enter data(name(single word) rollno marks:Abhi 1 80

 enter data(name(single word) rollno marks:Rahul 2 85


1)create
2)search
3)print
4)quit
Enter Your Choice:3

                Abhi    1   80
               Rahul    2   85

1)create
2)search
3)print
4)quit
Enter Your Choice:2

enter rollno:1

 found at location=1
 Abhi   1       80

1)create
2)search
3)print
4)quit
Enter Your Choice:2

enter rollno:3

not found

1)create
2)search
3)print
4)quit
Enter Your Choice:4
*/
