#include<stdio.h>
#include<conio.h>
strupper();
void main()
{
char str[20];
clrscr();
printf("\n enter the string");
gets(str);
strupper(str);
printf("\n The uppercase string=%s",str);
getch();
}
strupper(char s[])
{
int i;
for(i=0;s[i]!='\0';i++)
s[i]=toupper(s[i]);
}