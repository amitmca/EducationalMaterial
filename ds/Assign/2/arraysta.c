//Stack Using Array

#include<stdio.h>
#include "conio.h"

int stk[100],top=-1,ele,i,size;
void push(int ele)
	{
	stk[top++]=ele;
	}
int pop()
	{
	return(stk[top--]);
	}
void display()
	{
	i=1;
	printf("\n\n");
	while(i<=size)
		{
		printf("%d\t",stk[i]);
		i++;
		}
	printf("\n\n");
	}
void main()
	{
	int choice;
	clrscr();
	do
		{
		printf("\n1.PUSH\t\t2.POP\t\t3.DISPLAY\t\t4.EXIT\n\n");
		printf("\n\nWhat do you want to do ? :");
		scanf("%d",&choice);
		switch(choice)
			{
			case 1:
				printf("\nSize:");
				scanf("%d",&size);
				i=1;
				while(i<=size)
					{
					printf("\nEnter the element to push:");
					scanf("%d",&ele);
					push(ele);
					i++;
					}
				clrscr();
				break;

			case 2:
				ele=pop();
				clrscr();
				break;

			case 3:
				display();
				break;

			case 4:
				exit(0);
				break;
			}
		}while(choice!=4);
	getch();
	}