//Program to Concatenate two strings
//Date :- 4-3-2008	Day:- Tuesday		Time:- 9 to 10.30
#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
struct node
	{
	char data;
	struct node *next;
	};
typedef struct node *NODE;

NODE CreateList(NODE r)
	{
	NODE p,newnode;
	char *str;
	p=r=NULL;
	printf("\nEnter your String:");
	gets(str);
	while(*str!='\0')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=*str;
		str++;
			if(r==NULL)
				r=p=newnode;
			else
				{
				p->next=newnode;
				p=newnode;
				}
		}
	return(r);
	}
NODE Concatenate(NODE fr,NODE sr)
	{
	NODE temp,first;
	if(fr==NULL)
		first=sr;
	else
		{
		first=fr;
		if(sr!=NULL)
			{
			temp=fr;
			while(temp->next!=NULL)
				temp=temp->next;
			temp->next=sr;
			}
		}
	return(fr);
	}
void DisplayList(NODE r)
	{
	NODE p;
	for(p=r;p!=NULL;p=p->next)
		{
		printf("%c",p->data);
		}
	printf("\n");
	}
void main()
	{
	NODE r,r1;
	clrscr();
	r=CreateList(r);
//	DisplayList(r);
	r1=CreateList(r1);
//	DisplayList(r1);
	r=Concatenate(r,r1);
	DisplayList(r);
	getch();
	}