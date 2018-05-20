#include<stdio.h>
#include<conio.h>
char stack[10];
int top=-1;
void main()
{
int choice;
clrscr();
do
{
printf("\n 1:push() \n 2:pop() \n 3:exit");
printf("\n enter your choise");
scanf("%d",&choice);
switch(choice)
 {
case 1:push();
	   break;
case 2:printf("%d",pop());
	   break;
}
}
while(choice!=3);
getch();
}
push ()
{
char c;
if(top==9)
printf("\n stack is full");
else
{
printf("\n enter the character for push operation");
scanf("%c",&c);
stack[++top]=c;
getchar();
}
}
pop()
{
if(top==-1)
printf("\n stack is empty");
else
{
printf("%c",stack[top]);
 top--;
}
}