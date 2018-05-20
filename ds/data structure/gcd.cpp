/*program for find g.c.d  */
#include<iostream.h>
#include<conio.h>

int  main(void)
{
int u=5; int v=2.5;
int temp;
clrscr();
cout<<"\nu="<<u;
cout<<"\nv="<<v;
cin>>u;
while(v!=0)
{
temp=u%v;
u=v;
v=temp;
}
cout<<"\ngcd is="<<u;
return(0);
}

