/*linked list */
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
typedef struct node
   { int data;
     struct node *next;
   }node;

node *create();
node *insert(node *head);
node *Delete(node *head);
void search(node *head);
void print(node *head);

void main()
{ int op;
  node *head=NULL;
  clrscr();
  do
    {
      printf("\n\n1)create\n2)Insert\n3)Delete\n4)Search");
      printf("\n5)Print\n6)Quit");
      printf("\nEnter your Choice:");
      scanf("%d",&op);
      switch(op)
       { case 1:head=create();break;
	 case 2:head=insert(head);break;
	 case 3:head=Delete(head);break;
	 case 4:search(head);break;
	 case 5:print(head);break;
       }
    }while(op!=6);
}

node *create()
{ node *head,*p;
  int i,n;
  head=NULL;
  printf("\n Enter no of data:");
  scanf("%d",&n);
  printf("\nEnter the data:");
  for(i=0;i<n;i++)
   { if(head==NULL)
	p=head=(node*)malloc(sizeof(node));
     else
       {p->next=(node*)malloc(sizeof(node));
	p=p->next;
       }
       p->next=NULL;
       scanf("%d",&(p->data));
   }
 return(head);
}

node *insert(node *head)
{ node *p,*q;
  int loc,i;
  printf("\nEnter the location:");
  scanf("%d",&loc);
  p=(node*)malloc(sizeof(node));
  printf("\nenter a data:");
   scanf("%d",&(p->data));
  if(loc==1)
   { p->next=head;
     head=p;
     return(head);
   }
   i=1;q=head;
   while(i<loc-1)
    {if(q->next==NULL)
      {printf("\nUnderflow!!!!!");
       return(head);
      }
     q=q->next;
     i++;
    }
   p->next=q->next;
   q->next=p;
   return(head);
}

node *Delete(node *head)
{node *p,*q;
  int loc,i;
  if(head==NULL)
    {printf("\nEmpty Linked List");
      return(head);
    }
  printf("\nEnter the location:");
  scanf("%d",&loc);
  if(loc==1)
   { p=head;
     head=head->next;
     free(p);
     return(head);
   }
   i=1;q=head;
   while(i<loc-1)
    {if(q->next==NULL)
      {printf("\nUnderflow!!!!!");
       return(head);
      }
     q=q->next;
     i++;
    }
   p=q->next;
   q->next=p->next;
   free(p);
   return(head);
}

void search(node *head)
{ node *p;
  int data,loc=1;
  printf("\nEnter the data to be searched: ");
  scanf("%d",&data);
  p=head;
  while(p!=NULL && p->data != data)
   { loc++;
     p=p->next;
   }

  if(p==NULL)
   printf("\nNot found:");
  else
   printf("\nFound at location=%d",loc);
}
void print(node *head)
{ node *p;
 printf("\n\n");
 for(p=head;p!=NULL;p=p->next)
  printf("%d  ",p->data);
}

/*
              *** OUTPUT ***
1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:1

 Enter no of data:3

Enter the data:1 2 3

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:5


1  2  3

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:2

Enter the location:1

enter a data:4

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:5


4  1  2  3

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:3

Enter the location:1


1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:5


1  2  3

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:4

Enter the data to be searched: 1

Found at location=1

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:4

Enter the data to be searched: 4

Not found:

1)create
2)Insert
3)Delete
4)Search
5)Print
6)Quit
Enter your Choice:6
*/


