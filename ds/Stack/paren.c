// Program for finding whether the parenthesis mathces or not

#include<stdio.h>
#include "conio.h"
#define ALLOC (struct node *)malloc(sizeof(struct node))

typedef struct node
	{
	char data;
	struct node *next;
	}*STACK;

char tmp[20],*str;

STACK Push(STACK top)
	{
	STACK newnode;
	
	top=NULL;
	printf("\nEnter the expression:");
	gets(tmp);
	str=tmp;
	while(*str!='\0')
		{
		newnode=ALLOC;
		newnode->next=NULL;
		newnode->data=*str;
		if(top==NULL)
			top=newnode;
		else
			{
			newnode->next=top;
			top=newnode;
			}
		str++;
		}
	return(top);
	}
void Display(STACK top)
	{
	int b=25;
	printf("\n");
	while(top!=NULL)
		{
		printf("top");
		printf("--->");
		printf("\t%c\n",top->data);
		printf("\t %c\n",b);
		top=top->next;
		}
	printf("\tNULL\n\n");
	}

STACK Pop(STACK top)
	{
	int o,c,bo,bc,co,cc,sum=0,s1,s2,s3;

	o=c=bo=bc=co=cc=0;

	while(top!=NULL)
	{
	switch(top->data)
		{
		case '(': 	o++;	break;
		case ')':	c++;	break;
		case '[':	bo++;	break;
		case ']':	bc++;	break;
		case '{':	co++;	break;
		case '}':	cc++;	break;
		}
	top=top->next;
	}
	clrscr();
	printf("\n o:%d",o);
	printf("\t c:%d",c);
	printf("\t bo:%d",bo);
	printf("\t bc:%d",bc);
	printf("\t co:%d",co);
	printf("\t cc:%d",cc);
		
	sum=sum+o+c+bo+bc+co+cc;

	s1=o-c;		s2=bo-bc;	s3=co-cc;

	if(s1==0 && s2==0 && s3==0)
		printf("\n\n No Bracket is remained\n");
	else
		{
		printf("\n\nERROR:Some brackets are missing\n");
		printf("\n ( %d ) \t [ %d ] \t { %d } \n",s1,s2,s3);	
		printf("\n\tNote: Numbers in coressponding bracket represents the missing bracket \n");
		printf("\n\t 0 : Indicates no error\n\t 1 : that bracket is remained\n");
		}

	printf("\n\n Total brackets are:%d\n",sum);

	return(top);
	}
int main()
	{
	STACK top;
	clrscr();
	top=Push(top);
	Display(top);
	top=Pop(top);
	
	getch();
	}
