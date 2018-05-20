/*  Program for Hashing using linear probing   */
#include<stdio.h>
#include<conio.h>
int hashfunc(int i)
{
return i%10;
}
void add(int ht[],int id)
{
int posi,i;
clrscr();
posi=hashfunc(id);
if(ht[posi]==-1)
{
ht[posi]=id;
return(0);
}
else
for(i=posi+1;i!=posi;i=(i+1)%10)
{
if(ht[posi]==-1)
{
ht[posi]=id;
return(0);
}
}
if(i==posi)
printf("Hash table is full");
}
void delete(int ht[],int id)
{
