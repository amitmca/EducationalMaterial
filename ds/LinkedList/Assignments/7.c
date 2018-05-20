//Program to Perform the operations on strings using Doubly linked list
//Date :- 4-3-2008	Day:- Tuesday		Time:- 9 to 10.30
#include<stdio.h>
#include<conio.h>
#define ALLOC (struct node *)malloc(sizeof(struct node))
struct node
	{
	char data;
	struct node *next,*prev;
	};
typedef struct node *NODE;

NODE CreateList(NODE r)
	{
	NODE p,newnode;
	char *str;
	p=r=NULL;
	printf("\nEnter your main String:");
	gets(str);
	while(*str!='\0')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->prev=NULL;
		newnode->data=*str;
		str++;
			if(r==NULL)
				r=p=newnode;
			else
				{
				p->next=newnode;
				newnode->prev=p;
				p=newnode;
				}
		}
	return(r);
	}
void DisplayList(NODE r)
	{
	NODE p;
	printf("\nROOT-->");
	for(p=r;p!=NULL;p=p->next)
		{
		printf("%c-->",p->data);
		}
	printf("NULL\n\n");
	}
void Substring(NODE r)
	{
	NODE p=r;
	int f=0,len;
	char *sub;
	printf("\nEnter the string to find:");
	scanf("%s",sub);
	len=strlen(sub);
	while(*sub!='\0')
		{
		printf("\n%c",*sub);
		while(p!=NULL)
			{
			printf("%c",p->data);
			p=p->next;
			}
		sub++;
		}
	printf("\nValue of f:%d",f);
	if(f==len)
		printf("\nSubstring finded\n");
	else
		printf("\nSubstring not finded\n");
	}
int FindVowels(NODE r)
	{
	NODE p;
	int v=0;
	for(p=r;p!=NULL;p=p->next)
		{
		if(p->data=='a' || p->data=='A' || p->data=='e' || p->data=='E' || p->data=='i' || p->data=='I' || p->data=='o' || p->data=='O' || p->data=='u' || p->data=='U')
			v++;
		}
	return v;
	}
NODE Reverse(NODE r)
	{
	NODE p=r,curr=NULL,back;
	while(p)
		{
		back=curr;
		curr=p;
		p=p->next;
		curr->next=back;
		}
	r=curr;
	return(r);
	}
void main()
	{
	NODE r;
	int choice;
	char *str1;
	int ans;
	clrscr();
	r=CreateList(r);
	DisplayList(r);
	do
		{
		printf("\n ************ MENU **************\n\n");
		printf("\n 1) Find given substring:\n");
		printf("\n 2) Find number of vowels:\n");
		printf("\n 3) Reverse given string:\n");
		printf("\n 4) Find similar characters in a given string:\n");
		printf("\n 5) Exit:\n");
		printf("\nEnter your choice:");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				Substring(r);
				break;

			case 2:
				ans=FindVowels(r);
				printf("\nNumber Of Vowels:%d\n\n",ans);
				break;
			case 3:
				r=Reverse(r);
				DisplayList(r);
				break;
			case 4:
				break;
			case 5:
				exit(0);
				break;
			}
		}while(choice!=5);
	getch();
	}