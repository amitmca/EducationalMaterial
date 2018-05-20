/*Heading : Program to implement primitive operations on sequential file */

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
typedef struct student
 { int rollno;
   char name[20];
   float  marks;
 }student;
void search();
void insert();
void Delete();
void print();
void modify();
FILE *master,*temp;
void main()
 { int  op,rollno;
   student x;
   clrscr();
   if(!(master=fopen("master.txt","r+")))
    /* if the file master does not exist then create master.txt */
      master=fopen("master.txt","w+");
   do
    {  printf("\n\n1)Insert a Record");
       printf("\n2)Delete a Record");
       printf("\n3)Modify a Record");
       printf("\n4)Search ");
       printf("\n5)Display the File");
       printf("\n6)Quit");
       printf("\nEnter Your Choice : ");
       scanf("%d",&op);
	 switch(op)
	 {  case 1 : insert();break;
	    case 2 : Delete();break;
	    case 3 : modify();break;
	    case 4 : search();break;
	    case 5 : print();break;
	 }
   } while(op!=6);
 }
void insert()
  {  student st;
     fseek(master,0,2);/*go to the end of file */
     printf("\nenter rollno ,name(single word),marks :\n");
     scanf("%d%s%f",&st.rollno,st.name,&st.marks);
     fprintf(master,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
     fclose(master);
     master=fopen("master.txt","r+");
  }
void search()
{ student st;
  int rollno;
  printf("\n Enter the Roll no. to be searched:");
  scanf("%d",&rollno);
   rewind(master);
  while(!feof(master))
   {fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    if(st.rollno==rollno)
     { printf("\n record is found :\n" );
       printf("\n%d  %s  %6.3f",st.rollno,st.name,st.marks);
       return;
     }

  }
  printf("\n Record not found :");
}
void Delete()
{ student st;
  int recno,i;
  printf("\n Enter the Record no. to Delete:");
  scanf("%d",&recno);
  temp=fopen("temp.txt","w+");
  rewind(master);
  for(i=1;i<recno && !feof(master);i++)
   {fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    fprintf(temp,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
  }
 if(feof(master))
  printf("\n Record No. out of range :");
 else
  { /*skip the current record to be deleted from master master */
    fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    while(!feof(master))
    { fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
      fprintf(temp,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
    }
    fclose(master);
    fclose(temp);
    /*copy records from temp to master*/
    master=fopen("master.txt","w+");
    temp=fopen("temp.txt","r+");
    while(!feof(temp))
    { fscanf(temp,"%d%s%f\n",&st.rollno,st.name,&st.marks);
      fprintf(master,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
    }
 }
close(temp);
}
void print()
{student st;
 rewind(master);
 while(!feof(master))
  { fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    printf("\n%d  %s  %6.3f",st.rollno,st.name,st.marks);
  }
}
void modify()
{ student st;
  int recno,i;
  printf("\n Enter the Record no. to modify:");
  scanf("%d",&recno);
  temp=fopen("temp.txt","w+");
  rewind(master);
  for(i=1;i<recno && !feof(master);i++)
   {fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    fprintf(temp,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
  }
 if(feof(master))
  printf("\n Record No. out of range :");
 else
  { /*skip the current record of master */
    fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
    /* Read a new record to be written */
    printf("\nenter rollno ,name(single word),marks :\n");
    scanf("%d%s%f",&st.rollno,st.name,&st.marks);
    fprintf(temp,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
    while(!feof(master))
    { fscanf(master,"%d%s%f\n",&st.rollno,st.name,&st.marks);
      fprintf(temp,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
    }
    fclose(master);
    fclose(temp);
    /*copy records from temp to master*/
    master=fopen("master.txt","w+");
    temp=fopen("temp.txt","r+");
    while(!feof(temp))
    { fscanf(temp,"%d%s%f\n",&st.rollno,st.name,&st.marks);
      fprintf(master,"%d %s %6.2f\n",st.rollno,st.name,st.marks);
    }
 }
close(temp);
}

/*
Create master.txt file first
            *** OUTPUT ***

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 1

enter rollno ,name(single word),marks :
1 Abhi 80

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 1

enter rollno ,name(single word),marks :
2 Rahul 90

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 1

enter rollno ,name(single word),marks :
3 Akash 55

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 5

1  Abhi  80.000
2  Rahul  90.000
3  Akash  55.000

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 2

 Enter the Record no. to Delete:3

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 5

1  Abhi  80.000
2  Rahul  90.000

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 3

 Enter the Record no. to modify:1

enter rollno ,name(single word),marks :
1 Abhijit 88
1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 5

1  Abhijit  88.000
2  Rahul  90.000
1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 4

 Enter the Roll no. to be searched:2

 record is found :

2  Rahul  90.000
1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice : 4

 Enter the Roll no. to be searched:3

 Record not found :

1)Insert a Record
2)Delete a Record
3)Modify a Record
4)Search
5)Display the File
6)Quit
Enter Your Choice :6
*/
