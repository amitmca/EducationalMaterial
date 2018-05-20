  /*program for doubly linked   list*/
#include<iostream.h>
#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<process.h>
#include<malloc.h>
#include<graphics.h>
#include<ctype.h>
#include<dos.h>

#define NODEALLOC (struct node *)malloc(sizeof(struct node))
void author();
void display();
void delet();
char menu();
void insert();
struct node
{
int data;
struct node *next;
}*temp,*newnode,*start,*temp1;

int n,i,i1,j1,i2=0,j2=0;

void author()
{
outtextxy(500,10,"s/w by Amit Pendse");
}

void create()
{
  clrscr();
  setfillstyle(1,1);
  bar(0,400,640,500);

/*  setcolor(6);
  i1=getmaxx();
  j1=getmaxy();
  bar(0,0,i1,j1);*/
 cout<<"enter the number of nodes to be created";
 cin>>n;
  start=NULL;
  for(i=0;i<n;i++)
  {
  newnode=NODEALLOC;
  newnode->next=NULL;
  //newnode->prev=NULL;
  cout<<" enter the data";
  cin>>newnode->data;
  if(start==NULL)
  start=temp=newnode;
  else
  {
  temp->next=newnode;
  //newnode->prev=temp;
  temp=newnode;
  }
  }
display();
author();
   }

void main()
{
int gd=DETECT,gm;
clrscr();
initgraph(&gd,&gm,"");
while(1)
{
author();
switch(toupper(menu()))
{
case 'C':create();
break;
case 'D':display();
break;
case 'I':insert();
break;
case 'T':delet();
break;
case 'E':exit(0);
}

}
}
void display()
{
author();
/*for(temp=start;temp!=NULL;temp=temp->next)
cout<<temp->data;
getch();*/
i=0;
for(temp=start;temp!=NULL;temp=temp->next)
  {
  i2=i*30;
  j2=i2+20;
  setcolor(4);
  rectangle(i2,450,j2,470);
  setfillstyle(1,4);
  bar(i2,450,j2,470);
  setcolor(7);
  char c[10];
  itoa(temp->data,c,10);
  outtextxy(i2+2,460,c);
  line(j2,455,j2+10,455);
  setcolor(i);
  outtextxy(2,360,"node created");
  delay(1000);
  i++;
  }
}
			/*to insert a node at start*/
insertft()
{
newnode=NODEALLOC;
newnode->next=NULL;//newnode->prev=NULL;
cout<<"enter the newnode data";
cin>>newnode->data;
newnode->next=start;
//start->prev=newnode;
start=newnode;
display();
return 0;
}
			/*insert at end*/
 insered()
{
  newnode=NODEALLOC;
  newnode->next=NULL;//newnode->prev=NULL;
 cout<<"\n enter the newnode data";
 cin>>newnode->data;
  for(temp=start;temp->next!=NULL;temp=temp->next);
  temp->next=newnode;
 // newnode->prev=temp;
 display();
  return 0;
  }
		    /*program to insert a node in between*/
  insertbet()
  {
  int p,i;
  newnode=NODEALLOC;
  newnode->next=NULL;
 // newnode->prev=NULL;
  cout<<"\n enter  the newnode data";
  cin>>newnode->data;
  cout<<"\n enter the position to insert the newnode";
  cin>>p;
  temp=start;
  for(i=1;i<p-1 && temp!=NULL;i++)
  temp=temp->next;
//  newnode->next=temp->next;
  temp->next=newnode;
  //temp->next->prev=newnode;
  //newnode->prev=temp;
  display();
  return 0;
  }

		     /*TO DELETE A NODE*/

	      /*TO DELETE THE FIRST NODE*/

 delfirst()
 {
 temp=start;
 start=temp->next;
// start->prev=NULL;
 free(temp);
 display();
 return 0;
 }
		       /*TO DELETE THE LAST NODE*/
dellast()
{
for(temp=start;temp->next->next!=NULL;temp=temp->next);
free(temp->next);
temp->next=NULL;
display();
return 0;
}
		     /*TO DELETE THE NODE IN BETWEEN TWO NODES*/
void  delbet()
{
int p,i;
cout<<"\n\n enter the position to delete a node";
cin>>p;
for(i=1,temp=start;i<p-1 && temp!=NULL;i++,temp=temp->next);
temp1=temp->next;
temp->next=temp1->next;
//temp1->next->prev=temp;
free(temp1);
display();
}

char menu()
{
char ch;
author();
cout<<"\n C: FOR CREATING A DOUBLY LINKED LIST"
       "\n T:DELETE  A  NODE"
       "\n D:DISPLAY A  NODE"
       "\n I:INSERT  A  NODE"
       "\n E:EXIT";
cout<<"\n enter your choice";
flushall();
cin>>ch;
return(toupper(ch));
}
submenu()
{
char ch;
author();
cout<<"\n S:\tfor inserting at start"
       "\n N:\tfor inserting at end"
       "\n B:\tinsert at between"
       "\n E:main menu";
       cout<<"\n enter your choice";
       flushall();
       cin>>ch;
       return(toupper (ch));
       }
       void insert()
      {
      clrscr();
      while(1)
      {
      switch(submenu())
{
case 'S':insertft();
break;
case 'D':display();
break;
case 'B':insertbet();
break;
case 'N':insered();
break;
case'E':main();
       }}}
submenu1()
{
char ch;
author();
cout<<"\n S:\tfor deleting at start"
       "\n N:\tfor deleting at end"
       "\n B:\tdeleting at between"
       "\n E:main menu";
       cout<<"\n enter your choice";
       flushall();
       cin>>ch;
       return(toupper (ch));
       }
       void delet()
      {
      clrscr();
      while(1)
      {
      switch(submenu1())
{
case 'S':delfirst();
break;
case 'D':display();
break;
case 'B':delbet();
break;
case 'N':dellast();
break;
case 'E':main();
       }}}
