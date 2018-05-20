/*   Program for menudriven of static implementation of stack  */
#include<stdio.h>
#include<conio.h>
#define MAX 20
struct stack
{
int top;
int item[MAX];
};  /* declaring the stack  */
void initstack(struct stack *ps)
{
ps->top=-1;
}  /* initialising the stack */
void push(struct stack *ps,int no)
{
if(isfull(ps))
{
printf("\n stack is full");

}
else
{
ps->item[++(ps->top)]=no;
}  /* push operation  */
void pop(struct stack *ps)
{
return(ps->item[ps->top--]);
}  /* pop operation  */
int isempty(struct stack *ps);
{
return(ps->top==-1);
}  /* check the stack is empty  */
int isfull(struct stack *ps)
{
return(ps->top==MAX-1);
}  /* check the stack is full  */
main()
{
int n,ch;
struct stack s1;
initstack(&s1);  /*  creating a stack */
do
{
clrscr();
printf("\n1:PUSH \n2:POP \n3:EXIT");
printf("\n\n enter your choice:");
scanf("%d",&ch);
switch(ch);
{
case 1:/* push */
printf("enter the element tobe pushed:+>");
scanf("%d",&n);
push(&s1,n);
break;
case 2: /* pop */
if(isempty(&s1)==1)
printf("the stack is empty");
else
printf(" the poped element is%d",pop(&s1));
break;
}
}
while(ch!=3);
getch();
return(0);
}