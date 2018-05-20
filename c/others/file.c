#include<stdio.h>
#include<fcntl.h>

struct emp
{
   char ename[10];
   int eid,sal;
   char city[10];
}e;

main()
{
    int ch,i,j;
    int fd,fd2;
    
    do
    {
    printf("\n\tMenu \n");
    printf("\n\t1 : Insert ");
    printf("\n\t2 : Display ");
    printf("\n\t3 : Delete ");
    printf("\n\t4 : Modify ");
    printf("\n\t5 : Search ");
    printf("\n\t6 : Exit ");

    printf("\n\n\tEnter the choice : ");
    scanf("%d",&ch);	
    switch(ch)
    {
       case 1 :
            fd=open("empDb1.dat",O_WRONLY);
            if(fd==-1)
                printf("\n\tFile opening Error.........");
            else
            {
                printf("\n\tFile opened successfully.......\n");
                printf("\n\tEnter the ID : ");
                scanf("%d",&e.eid);
                printf("\n\tEnter the name : ");
                scanf("%s",&e.ename);
                printf("\n\tEnter the city : ");
                scanf("%s",&e.city);
                printf("\n\tEnter the salary : ");
                scanf("%d",&e.sal);
                lseek(fd,0L,2);
                write(fd,&e,sizeof(e));
                close(fd);

            }
            break ;
       case 2 :
            fd=open("empDb1.dat",O_RDONLY);
            if(fd==-1)
                printf("\n\tFile opening Error.........");
            else
            {
               printf("\n\tFile opened successfully.......\n");
               printf("\n\tId :  \tName :  \t City :  \t Salary : \n");
               while(read(fd,&e,sizeof(e)))
               {

                   printf("\t%d \t%s \t%s \t%d\n ",e.eid,e.ename,e.city,e.sal);
               }
           }
           close(fd);

            break ;
    /*  case 3 :
           dispe();
           break ;
      case 4 :
           deletee();
           break ;
      case 5 :
           modifye();
           break ;
      case 6 :
           searche();
           break ;
     */
    }
    }while(ch<6);
}
